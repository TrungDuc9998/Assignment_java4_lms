package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.Video;
import utils.JpaUtils;

public class VideoDAO {
	private EntityManager em;
	
	public VideoDAO() {
		this.em=JpaUtils.getEntityManager();
	}
	
	public Video insert(Video video) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(video);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			this.em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
		return video;
	}
	
	public void delete(Video video) {
		try {
			this.em.getTransaction().begin();
			this.em.remove(video);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			this.em.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void update(Video video) {
		try {
			this.em.getTransaction().begin();
			this.em.merge(video);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public Video findById(int id) {
		Video video=this.em.find(Video.class, id);
		return video;
	}
	

	
	
	public List<Video> findAll(){
		String hql="SELECT video FROM Video video";
		TypedQuery<Video>query=this.em.createQuery(hql,Video.class);
		List<Video>list=query.getResultList();	
		return list;
	}
	
	public List<Video> findAll1(int id){
		String hql="SELECT o.video FROM Favorite o where o.user.id=:uid";
		TypedQuery<Video>query=this.em.createQuery(hql,Video.class);
		System.out.println("favorite"+query);
		query.setParameter("uid", id);
		List<Video>list=query.getResultList();	
		return list;
	}
	
	
	
//	public List<Object[]> findFatory(){
//		String jpql="SELECT o.video.title,count(o.id),min(o.likeDate),max(o.likeDate)"
//				+"FROM Favorite o GROUP BY o.video.title";
//		TypedQuery<Object[]> query=em.createNamedQuery(jpql, Object[].class); 
//		List<Object[]>list=query.getResultList();
//		return list;
//	}
	

}
