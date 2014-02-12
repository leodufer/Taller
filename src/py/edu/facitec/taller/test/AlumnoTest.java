package py.edu.facitec.taller.test;

import java.util.List;

import org.junit.Test;

import py.edu.facitec.taller.dao.AlumnoDao;
import py.edu.facitec.taller.modelo.Alumno;
import py.edu.facitec.taller.modelo.Materia;

public class AlumnoTest {
	
	@Test
	public void insertar(){
		Alumno a = new Alumno();
		a.setNombre("Oscar Leonardo");
		a.setApellido("Duarte Fernandez");	
		AlumnoDao adao = new AlumnoDao();
		adao.insertar(a);
	}
	
	@Test
	public void actualizar(){
		Alumno a = new Alumno();
		a.setId(2);
		a.setNombre("Juan");
		a.setApellido("Perez");
		
		AlumnoDao adao = new AlumnoDao();
		adao.actualizar(a);
	}
	
	@Test
	public void listarAlumnos(){
		List<Alumno> alumnos;
		AlumnoDao adao = new AlumnoDao();
		alumnos = adao.obtenerAlumnos();
		
		for(Alumno a:alumnos){
			System.out.println(a.getNombre());
		}
	}
	
	@Test
	public void imprimirListaDeAlumnosConMaterias(){
			AlumnoDao adao = new AlumnoDao();
			List<Alumno> alumnos = adao.obtenerAlumnos();
			for(Alumno a:alumnos){
				System.out.println("Nombre y Apellido: "+a.getNombre()+" "+a.getApellido());
				System.out.println("-------------------------------------");
				for(Materia m:a.getMaterias()){
					System.out.println(m.getId()+"-"+m.getNombre()+"-"+m.getHora());
				}
				System.out.println("-------------------------------------");
			}
			adao.close();
	}
	
	
	@Test
	public void anhadirMateria(){
		Alumno a = new Alumno();
		a.setId(4);
		AlumnoDao adao = new AlumnoDao();
		
		a = adao.obtener(a);
		
		Materia m = new Materia();
		m.setId(2);
		
		a.getMaterias().add(m);
		adao.actualizar(a);
		adao.close();
		
	}
	
	@Test(expected=Exception.class)
	public void matricularAlumnoMasdeUnaVezEnUnaMateria(){
		
	}
	
	
}
