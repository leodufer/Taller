package py.edu.facitec.taller.dao;

import java.util.ArrayList;
import java.util.List;

import py.edu.facitec.taller.modelo.Materia;

public class MateriaDao extends GenericDao {
	
	public MateriaDao() {
		super(Materia.class);
	}
	public List<Materia> obtenerMaterias(){
		List<Materia> Materias = new ArrayList<Materia>();
		em.getTransaction().begin();
		Materias = em.createQuery("From Materia", Materia.class).getResultList();
		em.getTransaction().commit();
		return Materias;
	}
}
