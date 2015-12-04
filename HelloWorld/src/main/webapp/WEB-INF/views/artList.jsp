<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import = "java.util.*" %>	<!-- 자바 패키지 임폴트 -->
<%@ page import = "server.spring.chapter3.Article" %>		<!-- 정의한 Article class import -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>공지사항</h1>
		<hr>
		<form action="notice.jsp" method="get">
			<div class="center">
				<select name="search_type">
					<option value="subject">제목</option selected>
					<option value="name">작성자</option>
					<option value="contents">내용</option>
				</select> <input type="search" name="search_text" /> <input type="hidden"
					name="first" value="1"> <input type="submit" id="bt"
					value="search"> <a href="notice.jsp?page=11">검색</a>
			</div>
		</form>
	</div>
	<div>
		<p align="right">총글수 ${noTotalArticles} &nbsp;&nbsp;페이지
			1/${noPages}</p>
	</div>
	<table>
		<tr>
			<th width="120">번호</th>
			<th width="600">제목</th>
			<th width="160">작성자</th>
			<th width="160">등록일</th>
			<th width="160">조회수</th>
		</tr>
		<!--  게시물을 집어넣는 것은 jsp 로 -->
		<%
			//ArrayList<Article> articles = ${articleList}; HTML 문서에서 ${} 이걸로 하면 안됨 -> model 말고 request로 넘겨주어야 ㅏㄴ다.
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