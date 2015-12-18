<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	My Articles
</h1>
	
	<form action = "list" method = "get" accept-charset="UTF-8">
		<select name="article_count">
			<option value="five">5</option>
			<option value="ten">10</option>
			<option value="fif">15</option>
		</select>
		<input type="text" name = page>
		<input type="submit" value = "Search"> 
	</form>

<P> Database Open : ${Error}. </P>
</body>
</html>
