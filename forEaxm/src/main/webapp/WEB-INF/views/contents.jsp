<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import = "java.util.*" %>
<%@ page import = "server.spring.test.Article" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խù� ����</title>
</head>
<body>
<%
	int articleID = Integer.parseInt(request.getParameter("id"));
	ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("articles");
	for(Article article:articles){
		if(article.getArticleID() == articleID){
			out.print("<p><b>���� : </b>");
			out.print(article.getArticleTitle() + "</p>");
			out.print("<p><b>�۾��� : </b>");
			out.print(article.getArticleAuthor() + "</p>");
			out.print("<p><b>�ۼ��� : </b>");
			out.print(article.getArticleDate() + "</p>");
			out.print("<p><b>���� : </b>");
			out.print(article.getArticleContent());
			
			break;
		}
	}
%>
<p><a href='list'>�ڷΰ���</a></p>

</body>
</html>