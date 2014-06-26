/**
 * 
 */
package saiwei.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.bean.PostBean;
import saiwei.bean.UserBean;
import saiwei.dao.IUserDAO;
import saiwei.model.Photo;
import saiwei.model.Post;
import saiwei.model.Profile;
import saiwei.model.RelationShip;
import saiwei.model.User;
import saiwei.service.IUserService;
import common.AbstractTemplateService;
import common.factory.MD5Factory;

/**
 * @author sai
 *
 */
@Service("userService")
public class UserServiceImpl extends AbstractTemplateService<IUserDAO, User>
		implements IUserService {

//	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	@Resource(name="userDAO")
	public void setDao(IUserDAO dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}
	
	@SuppressWarnings("unchecked")
	public User login(String idNum, String password){
		Map<String, Object> params = new HashMap<String, Object>();
		User user ;
		params.put("IdNumber", idNum);
		//change to MD5
		params.put("password", MD5Factory.getMD5(password.getBytes()));
		List<User> list = (List<User>)this.findByProperties(params, User.class);
		if(list.isEmpty() || list == null){
			return null;
		}else{
			user = list.get(0);
			user.getProfile().getHead_photo().getId();
		}
		return user;
	}
	
	
	public Profile saveOrupdateProfile(String email,String name,
			String location,String company,Photo photo,User user){
		user = dao.merge(user);
		Photo oldPhoto = user.getProfile().getHead_photo();
		if(oldPhoto != null && photo != null){
			String OriginalPhotoURL = oldPhoto.getOriginalPhotoURL();
			String modifyPhotoURL = oldPhoto.getAutomodifyPhotoURL();
			if(OriginalPhotoURL != null){
				File originalphoto = new File(OriginalPhotoURL);
				originalphoto.delete();
				File modifyPhoto = new File(modifyPhotoURL);
				modifyPhoto.delete();
			}
		}
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("e_mail", email);
		params.put("name", name);
		params.put("location", location);
		params.put("company", company);
		params.put("head_photo", photo);

		return dao.updateProfileByUser(params, user);
	}
	
	/**
	 * 
	 * 获取自己的post，一次最多能拿十个post
	 * 
	 * @param userId
	 * @return
	 */
	public List<PostBean> getOwnPosts(String userId){
		User user = dao.findById(userId, User.class);
		List<PostBean> postbeans = new ArrayList<PostBean>();
		Iterator<Post> posts = user.getOwn_posts().iterator();
		int i = 0;
		while(i < 10 && posts.hasNext()){
			PostBean bean = new PostBean(posts.next());
			postbeans.add(bean);
			i++;
		}
		return postbeans;
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public List<PostBean> getOwnPosts(User user){
		user = dao.merge(user);
		List<PostBean> postbeans = new ArrayList<PostBean>();
		Set<Post> postlist = user.getOwn_posts();
		if(postlist == null)
			return null;
		Iterator<Post> posts = postlist.iterator();
		int i = 0;
		while(i < 10 && posts.hasNext()){
			PostBean bean = new PostBean(posts.next());
			postbeans.add(bean);
			i++;
		}
		return postbeans;
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	public List<UserBean> searchUser(String usernameKey,User searcher){
		searcher = dao.merge(searcher);
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("name", usernameKey);
		List<User> users = dao.userFindLikeprofile(params);
		List<UserBean> beans = new ArrayList<UserBean>();
		for(User user : users){
			UserBean bean = new UserBean(user);
			Set<RelationShip> relationships = user.getLinked_relationship();
			for(RelationShip relationship : relationships){
				if(relationship.getFounder().equals(searcher)){
					bean.setFollowingBewteenYour(true);
					break;
				}
			}
			beans.add(bean);
		}
		return beans;
	}
}
