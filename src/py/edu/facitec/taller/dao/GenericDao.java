package py.edu.facitec.taller.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import py.edu.facitec.taller.modelo.AbstractEntity;

public abstract class GenericDao {
	
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Taller");
	
	public EntityManager em;
	private Class<?>  entity;
	
	public GenericDao(Class<?> clazz){
		this.em = emf.createEntityManager();
		this.entity = clazz;
	}
	
	public void insertar(AbstractEntity a){
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		
	}
	
	public void actualizar(AbstractEntity a){
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		
	}
	public void eliminar(AbstractEntity a){
		em.getTransaction().begin();
		a = (AbstractEntity) em.find(this.entity, a.getId());
		if(a!=null)
			em.remove(a);
		em.getTransaction().commit();
		
	}
	
	public AbstractEntity obtener(AbstractEntity a){
		em.getTransaction().begin();
		AbstractEntity b = (AbstractEntity) em.find(this.entity, a.getId());
		em.getTransaction().commit();
		return b;
	}
	
	public void close(){
		em.close();
	}
}
