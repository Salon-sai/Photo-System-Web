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
		User poster = (User)session.createQuery("from User as model where model.IdNumber=:IdNumber")
			.setParameter("IdNumber", posterId).uniqueResult();
		post.setPoster(poster);
		session.save(post);
	}
	
}
