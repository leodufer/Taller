<%@page import="py.edu.facitec.taller.modelo.Materia"%>
<%@page import="java.util.List"%>
<%@page import="py.edu.facitec.taller.dao.MateriaDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Materias</title>
</head>
<body>
<h4>Gestion de Materias</h4>
<hr>
<% MateriaDao mdao = new MateriaDao(); 
   List<Materia> materias = mdao.obtenerTodos(); %>
   
<ul>
	<% for(Materia m:materias){ %>
				
		<li><%=m.getId()+"-"+m.getNombre()+"-"+m.getHora() %></li>
				
	<%}
		
	%>
</ul>
<hr>
<h6>Agregar Materias</h6>
<form action="materias" method="post">
	<input type="text" required name="nombre">
	<input type="number" min="1" max="99" required name="hora">
	<input type="submit">
</form>
</body>
</html>