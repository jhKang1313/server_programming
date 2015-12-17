<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.util.*"%>
<%@ page import="server.spring.test.Article"%>
<%@ page import="java.net.*" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
		String search = URLDecoder.decode((String)request.getParameter("search"), "UTF-8");
		String type = URLDecoder.decode((String)request.getParameter("search_type"), "UTF-8");
		ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("articles");
		if(type.equals("subject")){
			for(Article article:articles){
				if(article.getArticleTitle().contains(search)){
					out.print("<p>" + article.getArticleTitle() + "</p>");
				}
			}
		}
		else if(type.equals("name")){
			for(Article article:articles){
				if(article.getArticleAuthor().contains(search)){
					out.print("<p>" + article.getArticleTitle() + "</p>");
				}
			}
		}
	%>
</body>
</html>