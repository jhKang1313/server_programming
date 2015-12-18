<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.util.*"%>
<%@ page import="server.spring.finalexam.Article"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>페이지 탐색</title>
</head>
<body>
	<table>
		<tr>
			<th width="200" align="center">번호</th>
			<th width="450" align="center">제목</th>
			<th width="200" align="center">글쓴이</th>
			<th width="250" align="center">작성일</th>
			<th width="200" align="center">조회수</th>
		</tr>
		<%
			int count = 10;
			String showCount = request.getParameter("article_count");
			if(showCount.equals("five"))
				count = 5;
			else if(showCount.equals("ten"))
				count = 10;
			else if(showCount.equals("fif"))
				count = 15;
			int currPage = 0;
			ArrayList<Article> articles = (ArrayList<Article>) request.getAttribute("articles");
			if (request.getParameter("page").equals(""))
				currPage = 0;
			else
				currPage = Integer.parseInt(request.getParameter("page")) - 1;
			int totalArticleCount = (Integer) request.getAttribute("articleCount");
			int number = totalArticleCount - (count * currPage);
			int pageCount = (Integer) request.getAttribute("pageCount");
	
			if (currPage == pageCount - 1) {
				for (int i = (count * currPage); i < articles.size(); i++) {
					out.print("<tr>");
					out.print("<td align = 'center'>" + (number) + "</td>");
					out.print("<td>" + articles.get(i).getArticleTitle() + "</td>");
					out.print("<td align = 'center'>" + articles.get(i).getArticleAuthor() + "</td>");
					out.print("<td align = 'center'>" + articles.get(i).getArticleDate() + "</td>");
					out.print("<td align = 'center'>" + articles.get(i).getArticleHit() + "</td>");
					out.print("</tr>");
					number--;
				}
			} else {
				for (int i = (count * currPage); (i < (count * currPage) + count); i++) {
					out.print("<tr>");
					out.print("<td align = 'center'>" + (number) + "</td>");
					out.print("<td>" + articles.get(i).getArticleTitle() + "</td>");
					out.print("<td align = 'center'>" + articles.get(i).getArticleAuthor() + "</td>");
					out.print("<td align = 'center'>" + articles.get(i).getArticleDate() + "</td>");
					out.print("<td align = 'center'>" + articles.get(i).getArticleHit() + "</td>");
					out.print("</tr>");
					number--;
				}
			}
		%>

	</table>

</body>
</html>