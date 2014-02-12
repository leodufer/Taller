package py.edu.facitec.taller.dao;

import java.util.ArrayList;
import java.util.List;

import py.edu.facitec.taller.modelo.Materia;

public class MateriaDao extends GenericDao {
	
	public void insertar(Materia m){
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		
	}
	
	public void actualizar(Materia a){
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		
	}
	public void eliminar(Materia m){
		em.getTransaction().begin();
		m = em.find(Materia.class, m.getId());
		if(m!=null)
			em.remove(m);
		em.getTransaction().commit();
		
	}
	
	public Materia obtener(Materia m){
		em.getTransaction().begin();
		Materia Materia = em.find(Materia.class, m.getId());
		em.getTransaction().commit();
		return Materia;
	}
	
	public List<Materia> obtenerMaterias(){
		List<Materia> Materias = new ArrayList<Materia>();
		em.getTransaction().begin();
		Materias = em.createQuery("From Materia", Materia.class).getResultList();
		em.getTransaction().commit();
		return Materias;
	}
}
