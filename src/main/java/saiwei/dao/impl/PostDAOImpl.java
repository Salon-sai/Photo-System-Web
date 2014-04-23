/**
 * 
 */
package saiwei.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import saiwei.dao.IPostDAO;
import saiwei.model.Post;
import saiwei.model.User;

import common.BaseDAO;

/**
 * @author sai
 *
 */
@Repository("postDAO")
public class PostDAOImpl extends BaseDAO<Post> implements IPostDAO {

	public List<Post> findPostByUserFollowingINCriteria(String userIdNum){
		Session session = sessionFactory.getCurrentSession();
		List<Post> showpost = new ArrayList<Post>();
		List<User> followings = UserDAOImpl.findfollowingINCriteria(session, userIdNum);
		
		for(User poster : followings){
			Criteria criteria = session.createCriteria(Post.class);
			criteria.add(Restrictions.eq("poster", poster));
			@SuppressWarnings("unchecked")
			List<Post> posts = criteria.setMaxResults(3).list();
			showpost.addAll(posts);
		}
		return null;
	}
	
	/**
	 * @param posterId
	 * 		poster id
	 * @param post
	 * 		service offer post which has date of posting and photos
	 */
	public void save(String posterId,Post post){
		Session session = sessionFactory.getCurrentSession();
		User poster = UserDAOImpl.findByIdNum(session, posterId);
		post.setPoster(poster);
		session.save(post);
	}
	
	/**
	 * 	To save the user like post
	 * @param userNum
	 * @param postId
	 * @return
	 */
	public boolean saveLikePost(String userNum,String postId){
		boolean flag = false;
		Session session = sessionFactory.getCurrentSession();
		try{
			Post post = (Post)session.load(Post.class, postId);
			User user = UserDAOImpl.findByIdNum(session, userNum);
			
			flag =	user.getFavorite_posts().add(post);
			
			session.saveOrUpdate(user);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("save like post fail", e);
		}
		return flag;
	}
	
	/**
	 * 
	 * @param userId
	 * @param postId
	 * @return
	 */
	public boolean removeLikePost(String userNum,String postId){
		boolean flag = false;
		Session session = sessionFactory.getCurrentSession();
		try{
			Post post = (Post)session.load(Post.class, postId);
			User user = UserDAOImpl.findByIdNum(session, userNum);
			
			user.getFavorite_posts().remove(post);
			
			session.update(user);
			flag = true;
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("remove Like Post fail", e);
		}
		return flag ;
	}
	
	/**
	 * 
	 * @param userNum
	 * @param postId
	 * @return
	 */
	public boolean saveCollectPost(String userNum,String postId){
		Session session = sessionFactory.getCurrentSession();
		boolean flag = true;
		try{
			Post post = (Post)session.load(Post.class, postId);
			User user = UserDAOImpl.findByIdNum(session, userNum);
			flag = flag && user.getCollect_posts().add(post);
			session.update(user);
			flag = flag && true;
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("save collect post fail",e);
		}
		return flag;
	}
	
	/**
	 * 
	 * @param userNum
	 * @param postId
	 * @return
	 */
	public boolean removeCollectPost(String userNum,String postId){
		boolean flag = false;
		Session session = sessionFactory.getCurrentSession();
		try{
			Post post = (Post)session.load(Post.class, postId);
			User user = UserDAOImpl.findByIdNum(session, userNum);
			
			user.getCollect_posts().remove(post);
			
			session.update(user);
			flag = true;
		}catch (Exception e) {
			// TODO: handle exception
			logger.error("remove Like Post fail", e);
		}
		return flag ;
	}
	
}
