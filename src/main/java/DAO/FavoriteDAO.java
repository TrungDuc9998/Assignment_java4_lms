package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.Favorite;
import Entity.User;
import Entity.Video;
import utils.JpaUtils;

public class FavoriteDAO {
	private EntityManager em;
	public FavoriteDAO() {
		this.em=JpaUtils.getEntityManager();
	}
	
	
	
	public List<Favorite> commentById(int id){
		String jpql="SELECT o FROM Favorite o where o.user.id=:uid";
		TypedQuery<Favorite>query=em.createQuery(jpql,Favorite.class);
		System.out.println(query);
		query.setParameter("uid", id);
		List<Favorite>list=query.getResultList();
		System.out.println("mang:"+list);
		return list;
	}
	public Favorite insert(Favorite favorite) {
		System.out.println("mã user:"+favorite.getUserId());
		try {
			this.em.getTransaction().begin();
			this.em.persist(favorite);
			this.em.getTransaction().commit();
			return favorite;
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Favorite> findAll(){
		String jpql="SELECT user FROM Favorite user";
		TypedQuery<Favorite> query=this.em.createQuery(jpql,Favorite.class);
		List<Favorite> list=query.getResultList();
		return list;
	}
	
	
	public List<Favorite> findVideoByUser(){
//		System.out.println("mã:"+id);
		String jpql="SELECT obj FROM Favorite obj";
		TypedQuery<Favorite> query=em.createNamedQuery(jpql, Favorite.class);
		System.out.println(jpql);
//		query.setParameter("uid", id);
//		List<Favorite>list=query.getResultList();
		return null;
	}
}
