package py.edu.facitec.taller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDao<T> {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Taller");
	
	public EntityManager em;
	private Class<T>  entity;
	
	public GenericDao(Class<T> clazz){
		this.em = emf.createEntityManager();
		this.entity = clazz;
	}
	
	public void insertar(T a){
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		
	}
	
	public void actualizar(T a){
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		
	}
	public void eliminar(T a){
		em.getTransaction().begin();
		em.remove(em.merge(a));
		em.getTransaction().commit();
		
	}
	
	public T obtener(int id){
		em.getTransaction().begin();
		T b =  em.find(this.entity, id);
		em.getTransaction().commit();
		return b;
	}
	
	public List<T> obtenerTodos(){
		List<T> list = null;
		em.getTransaction().begin();
		list = em.createQuery("From "+entity.getSimpleName(), this.entity).getResultList();
		em.getTransaction().commit();
		return list;
	}
}
