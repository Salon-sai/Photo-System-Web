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

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import saiwei.bean.PostBean;
import saiwei.dao.IUserDAO;
import saiwei.model.Photo;
import saiwei.model.Post;
import saiwei.model.Profile;
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
//			user.setCollect_posts(null);
//			user.setFavorite_posts(null);
//			user.setFound_relationship(null);
//			user.setLinked_relationship(null);
//			user.setOwn_posts(null);
//			user.setTags(null);
//			user.setReceive_comments(null);
//			user.setSend_comments(null);
//			user.setProfile(null);
		}
		return user;
	}
	
	
	public Profile saveOrupdateProfile(String email,String name,
			String location,String company,Photo photo,User user){
		dao.saveOrUpdate(user);
		Photo oldPhoto = user.getProfile().getHead_photo();
		if(oldPhoto != null){
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
		dao.saveOrUpdate(user);
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
}
