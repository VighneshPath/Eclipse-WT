<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*, java.util.*, java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Operation</title>
</head>
<body>
	<sql:setDataSource var="selector" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/book_proj"
	user="root" password="nerf" />
	<sql:query dataSource="${selector}" var="result" >
		SELECT * FROM book;
	</sql:query>	
	<table border="1" width="100%">
		<tr>
			<td>ISBN</td>
			<td>Price</td>
			<td>Title</td>
			<td>Author</td>
		</tr>
		
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.isbn}"/></td>
				<td><c:out value="${row.price}"/></td>
				<td><c:out value="${row.title}"/></td>
				<td><c:out value="${row.author}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>