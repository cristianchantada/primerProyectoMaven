<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.iesVda.TestMongo.imdb"%>
<%@ page import="com.iesVda.TestMongo.movies"%>
<%@ page import="java.lang.reflect.*"%>

<html>
<body>
	Bye bye! The system time is now
	<%=new java.util.Date()%>

	<%
	movies newFilm = new movies();
	Field[] classFields = newFilm.studyAClass(imdb.class);
	int fieldSize = classFields.length;

	int fieldCounter = 0;
	while (fieldCounter < fieldSize) {
		out.println("Field Name: " + classFields[fieldCounter].getName() + " Field Type: "
		+ classFields[fieldCounter].getType() + "<br>");
		fieldCounter++;
	}
	%>
</body>
</html>
