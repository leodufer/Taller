package py.edu.facitec.taller.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import py.edu.facitec.taller.dao.MateriaDao;
import py.edu.facitec.taller.modelo.Materia;

public class MateriaTest {

	@Test
	public void insetarMateria() {
		MateriaDao mdao = new MateriaDao();
		Materia m = new Materia();
		m.setNombre("Materia x");
		m.setHora(25);
		mdao.insertar(m);
	}
	@Test
	public void obtener(){
		MateriaDao mdao = new MateriaDao(); 
		List<Materia> materia =(List<Materia>) mdao.obtenerTodos();
		assertNotNull(materia);
	}

}
