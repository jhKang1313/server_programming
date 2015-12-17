<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.util.*"%>
<%@ page import="server.spring.exam.Article"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>나의 게시판</title>
</head>
<body>
	<form action = "notice" method = "get">
		<select name="search_type">
			<option value="subject">제목</option>
			<option value="name">글쓴이</option>
		</select>
		<input type="text" name = search>
		<input type="submit" value = "검색"> 
	</form>
	<%
		int currPage = (Integer) request.getAttribute("currPage");
		int totalArticleCount = (Integer) request.getAttribute("totalArticleCount");
	%>
	<p align="right">
		총 글수 &nbsp
		<%
		out.print(totalArticleCount);
	%>
		페이지
		<%
		out.print(currPage+1);
	%>/${totalPageCount}
	</p>
	<table>
		<tr>
			<th width="130">번호 </tb>
			<th width="400">제목 </tb>
			<th width="100">글쓴이 </tb>
			<th width="140">게시일 </tb>
			<th width="80">조회수</tb>
		</tr>
		<%
			ArrayList<Article> articles = (ArrayList<Article>) request.getAttribute("articles");
			int number = totalArticleCount - (10 * currPage);
			for (int i = (10 * currPage); i < (10 * currPage) + 10; i++) {
				out.print("<tr>");
				out.print("<td>" + (number) + "</td>");
				out.print("<td><a href='content?index="+articles.get(i).getArticleID()+"'>" + articles.get(i).getArticleTitle() + "</a></td>");
				out.print("<td>" + articles.get(i).getArticleAuthor() + "</td>");
				out.print("<td>" + articles.get(i).getArticleDate() + "</td>");
				out.print("<td>" + articles.get(i).getArticleHit() + "</td>");
				out.print("</tr>");
				number--;
			}
		%>
	</table>
	<h4>Database Open : ${dbError}</h4>
</body>
</html>