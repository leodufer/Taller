package py.edu.facitec.taller.dao;

import java.util.ArrayList;
import java.util.List;

import py.edu.facitec.taller.modelo.Alumno;

public class AlumnoDao extends GenericDao {

	
	public void insertar(Alumno a){
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		
	}
	
	public void actualizar(Alumno a){
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		
	}
	public void eliminar(Alumno a){
		em.getTransaction().begin();
		a = em.find(Alumno.class, a.getId());
		if(a!=null)
			em.remove(a);
		em.getTransaction().commit();
		
	}
	
	public Alumno obtener(Alumno a){
		em.getTransaction().begin();
		Alumno alumno = em.find(Alumno.class, a.getId());
		em.getTransaction().commit();
		return alumno;
	}
	
	public List<Alumno> obtenerAlumnos(){
		List<Alumno> alumnos = new ArrayList<Alumno>();
		em.getTransaction().begin();
		alumnos = em.createQuery("From Alumno", Alumno.class).getResultList();
		em.getTransaction().commit();
		return alumnos;
	}
}
