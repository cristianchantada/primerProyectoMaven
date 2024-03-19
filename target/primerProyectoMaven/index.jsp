<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="org.bson.Document"%>
<%@ page import="com.iesVda.TestMongo.Util"%>
<%@ page import="com.iesVda.TestMongo.FilmDao"%>
<%@ page import="com.iesVda.TestMongo.movies"%>
<%@ page import="com.iesVda.TestMongo.imdb"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.lang.reflect.Field"%>


<html>
<body>

	<%
	int fieldSize = 0;
	int fieldCounter = 0;
	Field[] classFields;

	movies newFilm = new movies();
	imdb filmImdb = new imdb();
	FilmDao aFilmDao = new FilmDao();

	List<String> theDirectorsGroup = new ArrayList<>();
	List<String> filmLanguages = new ArrayList<>();
	List<String> filmGenres = new ArrayList<>();
	List<String> filmCast = new ArrayList<>();

	filmGenres.add("drama");
	filmGenres.add("ecologism");
	filmCast.add("Amador Arias");
	filmCast.add("Benedicta");
	filmCast.add("Alfredo García");
	filmCast.add("Alcalde");
	newFilm.setCast(filmCast);
	
	newFilm.setTitle("Lo que echa fuego");
	newFilm.setPlot("A película transcorre na montaña luguesa");
	newFilm.setRuntime(135);
	
	theDirectorsGroup.add("Oliver Laxe");
	theDirectorsGroup.add("Amador Arias");
	theDirectorsGroup.add("Tony Scott");
	theDirectorsGroup.add("Juanito Valderrama");
	newFilm.setDirectors(theDirectorsGroup);
	
	newFilm.setPoster("http://iesvaldoasma.edu.xunta/images");
	newFilm.setFullplot("Benedicta e a nai de Amador, un pirómano");
	
	filmLanguages.add("Galego");
	newFilm.setLanguages(filmLanguages);
	
	filmGenres.add("drama");
	filmGenres.add("ecologism");
	newFilm.setGenres(filmGenres);

	filmImdb.setRating(4.5);
	filmImdb.setVotes(758);
	filmImdb.setId(9999);
	newFilm.setImdbReference(filmImdb);

	aFilmDao.save(newFilm);
	
	%>
</body>
</html>
