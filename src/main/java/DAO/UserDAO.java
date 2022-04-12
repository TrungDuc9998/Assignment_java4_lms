package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import Entity.Favorite;
import Entity.User;
import utils.JpaUtils;

public class UserDAO {
	private EntityManager em;

	public UserDAO() {
		this.em = JpaUtils.getEntityManager();
	}
	
	public User insert(User user) {
		System.out.println(user.getEmail());
		try {
			this.em.getTransaction().begin();
			this.em.persist(user);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
		
		return user;
	}
	
	public void update(User user) {
		try {
			this.em.getTransaction().begin();
			this.em.merge(user);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void delete(User user) {
		try {
			this.em.getTransaction().begin();
			this.em.remove(user);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public List<User> findAll(){
		String jpql="SELECT user FROM User user";
		TypedQuery<User> query=this.em.createQuery(jpql,User.class);
		List<User> list=query.getResultList();
		return list;
	}
	
	public User login(String email,String password) {
		String hql = "SELECT u FROM User u "
				+ "WHERE u.email = :email AND u.password = :pwd";
			
			TypedQuery<User> query = this.em.createQuery(hql, User.class);
			System.out.println("login:"+query);
			query.setParameter("email", email);
			query.setParameter("pwd", password);
			
			try {
				User u = query.getSingleResult();
				return u;
			} catch (NoResultException e) {
				e.printStackTrace();
			}

			return null;
	}
	
	public User findByEmail(String email) {
		String hql="SELECT u FROM User u WHERE u.email=:email";
		TypedQuery<User> query=this.em.createQuery(hql,User.class);
		query.setParameter("email", email);
		try {
			User u=query.getSingleResult();
			return u;
		} catch (NoResultException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return null;
	}
	
	public List<User> commentById(int id){
		String jpql="SELECT  o.comments FROM Favorite o where o.user.id=:uid";
		TypedQuery<User>query=em.createQuery(jpql,User.class);
		System.out.println(query);
//		query.setParameter("uid", id);
//		List<Favorite>list=query.getResultList();
		return null;
	}
	
	public List<User> favoriteUser(String title){
		String jpql="SELECT o.user FROM Favorite o where o.video.title=:vtitle";
		TypedQuery<User>query=this.em.createQuery(jpql,User.class);
		query.setParameter("vtitle", title);
		List<User>list=query.getResultList();
		
		return list;
	}
	
	public User changPassword(String email,String fullname) {
		String hql="SELECT u FROM User u WHERE u.email=:email and u.fullname=:fullname";
		TypedQuery<User> query=this.em.createQuery(hql,User.class);
		query.setParameter("email", email);
		query.setParameter("fullname", fullname);
		try {
			User u=query.getSingleResult();
			return u;
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public User findById(int id) {
		User user=this.em.find(User.class, id);
		return user;
	}
	
	public User findEmail(String email) {
		User user=this.em.find(User.class, email);
		return user;
	}
}
