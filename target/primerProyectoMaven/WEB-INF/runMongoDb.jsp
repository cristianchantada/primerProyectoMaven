<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="org.bson.Document"%>
<%@ page import="com.iesVda.TestMongo.Util"%>
<%@ page import="com.iesVda.TestMongo.FilmDao"%>
<%@ page import="com.iesVda.TestMongo.movies"%>
<%@ page import="java.util.Date"%>


<HTML>
<BODY>
	Bye bye! The system time is now
	<%=new java.util.Date()%>

	<%
	// Inicializar la clase del controlador
	FilmDao filmDao = new FilmDao();
	movies newFilm = new movies();
	movies result = filmDao.get("The Italian");
	out.println("<BR>" + "Film " + result.getPlot() + "<BR>");
	%>
</BODY>
</HTML>
