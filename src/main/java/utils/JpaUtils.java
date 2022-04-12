package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if ( factory == null || factory.isOpen() == false ) {
			factory = Persistence.createEntityManagerFactory("SOF30111");
		}

		return factory;
	}
	
	public static EntityManager getEntityManager() {
		if (entityManager == null || entityManager.isOpen() == false) {
			entityManager = getEntityManagerFactory().createEntityManager();
		}
		
		return entityManager;
	}
}
