package py.edu.facitec.taller.dao;

import java.util.ArrayList;
import java.util.List;

import py.edu.facitec.taller.modelo.Alumno;

public class AlumnoDao extends GenericDao {

	public AlumnoDao() {
		super(Alumno.class);
	}

	public List<Alumno> obtenerAlumnos(){
		List<Alumno> alumnos = new ArrayList<Alumno>();
		em.getTransaction().begin();
		alumnos = em.createQuery("From Alumno", Alumno.class).getResultList();
		em.getTransaction().commit();
		return alumnos;
	}
}
