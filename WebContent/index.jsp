<%@page import="py.edu.facitec.taller.dao.MateriaDao"%>
<%@page import="py.edu.facitec.taller.modelo.Materia"%>
<%@page import="py.edu.facitec.taller.modelo.Alumno"%>
<%@page import="java.util.List"%>
<%@page import="py.edu.facitec.taller.dao.AlumnoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Listado de Alumno</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="css/flat-ui.css" rel="stylesheet">

    <link rel="shortcut icon" href="images/favicon.ico">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="container">
<h4>Listado de Alumnos</h4>
<hr>
<% AlumnoDao adao = new AlumnoDao();
	List<Alumno> alumnos = adao.obtenerAlumnos();
%>

<ul>
	<%for(Alumno a:alumnos){ %>
			<li>
			<%=a.getId()+" "+a.getNombre()+" "+a.getApellido() %>
				<ul>
				<%for(Materia m:a.getMaterias()){ %>
					<li><%=m.getNombre()%></li>
				<%} %>
				</ul>
				<% MateriaDao mdao = new MateriaDao();
					List<Materia> materias = mdao.obtenerMaterias();
				%>
				
				<form action="inscribir" method="post">
					<select name="materia">
						<%for(Materia m:materias){ %>
						<option value="<%=m.getId()%>"><%=m.getNombre()%></option>
						
						<%} %>
					</select>
					<input type="hidden" value="<%=a.getId()%>" name="alumno">
					<input type="submit">
				</form>
			</li>
	<%} 
	adao.close();
	%>
</ul>
<hr>
<form action="alumno" method="post">
	<input type="text" placeholder="Nombre" required name="nombre">
	<input type="text" placeholder="Apellido" required name="apellido">
	<input type="submit" value="Añadir Alumno">
</form>



</body>
</html>