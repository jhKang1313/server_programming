<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import = "java.util.*" %>	<!-- �ڹ� ��Ű�� ����Ʈ -->
<%@ page import = "server.spring.chapter3.Article" %>		<!-- ������ Article class import -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>��������</h1>
		<hr>
		<form action="notice.jsp" method="get">
			<div class="center">
				<select name="search_type">
					<option value="subject">����</option selected>
					<option value="name">�ۼ���</option>
					<option value="contents">����</option>
				</select> <input type="search" name="search_text" /> <input type="hidden"
					name="first" value="1"> <input type="submit" id="bt"
					value="search"> <a href="notice.jsp?page=11">�˻�</a>
			</div>
		</form>
	</div>
	<div>
		<p align="right">�ѱۼ� ${noTotalArticles} &nbsp;&nbsp;������
			1/${noPages}</p>
	</div>
	<table>
		<tr>
			<th width="120">��ȣ</th>
			<th width="600">����</th>
			<th width="160">�ۼ���</th>
			<th width="160">�����</th>
			<th width="160">��ȸ��</th>
		</tr>
		<!--  �Խù��� ����ִ� ���� jsp �� -->
		<%
			//ArrayList<Article> articles = ${articleList}; HTML �������� ${} �̰ɷ� �ϸ� �ȵ� -> model ���� request�� �Ѱ��־�� ������.
			ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("articleList");
			for(Article article : articles){
				out.print("<tr>") ;
				out.print("<td>" + article.getArticleNumber() + "</td>") ;
				out.print("<td>" + article.getArticleTitle() + "</td>") ;
				out.print("<td>" + article.getArticleAuthor() + "</td>") ;
				out.print("<td>" + article.getArticleDate() + "</td>") ;
				out.print("<td>" + article.getHitCount() + "</td>") ;
				out.print("</tr>") ;
			}
		%>
	</table>
	<br> DB Open Result : ${strError}
	</br>
	<div class="center"></div>

</body>
</html>