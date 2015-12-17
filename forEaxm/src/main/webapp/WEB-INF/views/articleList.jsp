<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.util.*"%>
<%@ page import="server.spring.test.Article"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>나의 게시판</title>
</head>
<body>
	<h1>
		<b>My Articles</b>
	</h1>
	<form action = 'notice' method = 'get' accept-charset="UTF-8">
		<select name = "search_type">
			<option value="subject">제목</option>
			<option value="name">글쓴이</option>
		</select>
		<input type = "text" name = "search">
		<input type = "submit" value = "search">
	</form>
	<p align="right">총 개시글 &nbsp${articleCount}&nbsp
		${currPage}/${pageCount }
	<table>
		<tr>
			<th width="200" align="center">번호</th>
			<th width="400" align="center">제목</th>
			<th width="200" align="center">글쓴이</th>
			<th width="250" align="center">작성일</th>
			<th width="200" align="center">조회수</th>
		</tr>
		<%
			ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("articles");
			int articleCount = (Integer) request.getAttribute("articleCount");
			int currPage = (Integer) request.getAttribute("currPage") - 1;
			int startNumber = articleCount - (currPage * 10);
			for(int i = (currPage * 10) ; i < (currPage * 10) + 10 ; i++){
				out.print("<tr>");
				out.print("<td align = 'center'>" + (startNumber - i) + "</td>");
				out.print("<td> <a href='contents?id=" +articles.get(i).getArticleID() + "'>"+
													articles.get(i).getArticleTitle()+ "</td>");
				out.print("<td align = 'center'>" + articles.get(i).getArticleDate()+ "</td>");
				out.print("<td align = 'center'>" + articles.get(i).getArticleAuthor()+ "</td>");
				out.print("<td align = 'center'>" + articles.get(i).getArticleHit()+ "</td>");
				out.print("</tr>");
			}
				
			%>

	</table>



	<h3>Database Open : ${pError}</h3>
</body>
</html>