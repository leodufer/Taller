package py.edu.facitec.taller.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDao {
	public EntityManagerFactory emf;
	
	
	public EntityManager em;
	
	public GenericDao(){
		this.emf = Persistence.createEntityManagerFactory("Taller");
		this.em = emf.createEntityManager();
	}
	
	public void close(){
		em.close();
	}
}
