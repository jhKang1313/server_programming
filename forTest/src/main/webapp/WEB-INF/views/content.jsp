<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import = "java.sql.*" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String articleID = request.getParameter("index");
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		String url = "jdbc:ucanaccess://C:/CS-Board2003.mdb";
		Connection con = DriverManager.getConnection(url);
		
		PreparedStatement ps = con.prepareStatement("select contents, id from bbs_studypds where id=(?)");
		ps.setString(1, articleID);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			String articleContent = rs.getString("contents");
			out.print(articleContent);
		}
		
		con.close();
		ps.close();
		rs.close();
	%>
	<p> &nbsp <a href='list'>돌아가기</a>

</body>
</html>