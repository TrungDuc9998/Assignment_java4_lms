package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.Comment;
import Entity.Favorite;
import Entity.User;
import utils.JpaUtils;

public class CommentDAO {
	private EntityManager em;
	
	public CommentDAO() {
		this.em=JpaUtils.getEntityManager();
	}
	
	
	
	public List<Comment> commentById(int idUser,int idVd){
		String jpql="SELECT o FROM Comment o where o.user.id=:uid and o.video.id=:vid";
		TypedQuery<Comment>query=em.createQuery(jpql,Comment.class);
		System.out.println(query);
		query.setParameter("uid", idUser);
		query.setParameter("vid", idVd);
		List<Comment>list=query.getResultList();
		return list;
	}
	
	public Comment insert(Comment comment) {
	
		try {
			this.em.getTransaction().begin();
			this.em.persist(comment);
			this.em.getTransaction().commit();
			return comment;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
		
		
	}
}
