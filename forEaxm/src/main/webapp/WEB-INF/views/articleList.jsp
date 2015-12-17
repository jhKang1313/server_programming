<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.util.*"%>
<%@ page import="server.spring.test.Article"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� �Խ���</title>
</head>
<body>
	<h1>
		<b>My Articles</b>
	</h1>
	<form action = 'notice' method = 'get' accept-charset="UTF-8">
		<select name = "search_type">
			<option value="subject">����</option>
			<option value="name">�۾���</option>
		</select>
		<input type = "text" name = "search">
		<input type = "submit" value = "search">
	</form>
	<p align="right">�� ���ñ� &nbsp${articleCount}&nbsp
		${currPage}/${pageCount }
	<table>
		<tr>
			<th width="200" align="center">��ȣ</th>
			<th width="400" align="center">����</th>
			<th width="200" align="center">�۾���</th>
			<th width="250" align="center">�ۼ���</th>
			<th width="200" align="center">��ȸ��</th>
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