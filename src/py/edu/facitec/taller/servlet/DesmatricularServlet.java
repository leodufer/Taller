package py.edu.facitec.taller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import py.edu.facitec.taller.dao.AlumnoDao;
import py.edu.facitec.taller.dao.MateriaDao;
import py.edu.facitec.taller.modelo.Alumno;
import py.edu.facitec.taller.modelo.Materia;

/**
 * Servlet implementation class DesmatricularServlet
 */
@WebServlet(name = "desmatricular", urlPatterns = { "/desmatricular" })
public class DesmatricularServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Materia m = new Materia();
		m.setId(Integer.parseInt(request.getParameter("m")));
		MateriaDao mdao = new MateriaDao();
		m = mdao.obtener(m);
		mdao.close();
		Alumno a = new Alumno();
		a.setId(Integer.parseInt(request.getParameter("a")));
		AlumnoDao adao = new AlumnoDao();
		a = adao.obtener(a);
		List<Materia> materias = a.getMaterias();
		boolean b = materias.remove(m);
		
		a.setMaterias(materias);
		adao.actualizar(a);
		adao.close();
		System.out.println(b);
		response.sendRedirect("index.jsp");
	}

}
