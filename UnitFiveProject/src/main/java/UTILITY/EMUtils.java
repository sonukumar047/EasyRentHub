package UTILITY;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtils {

	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("PropertyProject");
	}
	
	public static EntityManager getEntityManager() {
		
		 return emf.createEntityManager();
	}
}