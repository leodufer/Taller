package py.edu.facitec.taller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import py.edu.facitec.taller.dao.AlumnoDao;
import py.edu.facitec.taller.modelo.Alumno;

/**
 * Servlet implementation class InsertarAlumnoServlet
 */
@WebServlet(name = "alumno", urlPatterns = { "/alumno" })
public class InsertarAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alumno a = new Alumno();
		a.setNombre(request.getParameter("nombre"));
		a.setApellido(request.getParameter("apellido"));
		AlumnoDao adao = new AlumnoDao();
		adao.insertar(a);
		response.sendRedirect("index.jsp");
	}

}
