package py.edu.facitec.taller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import py.edu.facitec.taller.dao.AlumnoDao;
import py.edu.facitec.taller.modelo.Alumno;
import py.edu.facitec.taller.modelo.Materia;

/**
 * Servlet implementation class IncribirAlumnoServlet
 */
@WebServlet(name = "inscribir", urlPatterns = { "/inscribir" })
public class MatricularAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Materia m = new Materia(); 
		m.setId(Integer.parseInt(request.getParameter("materia")));
		Alumno a = new Alumno();
		AlumnoDao adao = new AlumnoDao();
		a.setId(Integer.parseInt(request.getParameter("alumno")));
		a = adao.obtener(a);
		a.getMaterias().add(m);
		adao.actualizar(a);
		adao.close();
		response.sendRedirect("index.jsp");
	}

}
