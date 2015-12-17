<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.sql.*"%>
<%@ page import="java.net.*" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<th width="130">번호 </tb>
			<th width="400">제목 </tb>
			<th width="100">글쓴이 </tb>
			<th width="140">게시일 </tb>
			<th width="80">조회수</tb>
		</tr>
	<%
	String input = (String)request.getParameter("search");
	input = URLDecoder.decode(input, "UTF-8");
	String searchType = (String)request.getParameter("search_type");
	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	String url = "jdbc:ucanaccess://C:/CS-Board2003.mdb";
	Connection con = DriverManager.getConnection(url);
	out.print(input);
	if(searchType.equals("subject")){
		PreparedStatement ps = con.prepareStatement("select * from bbs_studypds where subject like '%"+input+"%'");
//		ps.setString(1, input);
		ResultSet rs = ps.executeQuery();
		
		for(int i = 0 ; rs.next(); i++){
			out.print("<tr>");
			out.print("<td>" + i + "</td>");
			out.print("<td>" + rs.getString("subject") + "</td>");
			out.print("<td>" + rs.getString("name") + "</td>");
			out.print("<td>" + rs.getString("created") + "</td>");
			out.print("<td>" + rs.getInt("hit") + "</td>");
			out.print("</tr>");
		}
		ps.close();
		rs.close();
	}
	else if(searchType.equals("name")){
		PreparedStatement ps = con.prepareStatement("select * from bbs_studypds where name like '%"+ input + "%'");
		ResultSet rs = ps.executeQuery();
		
		for(int i = 0 ; rs.next(); i++){
			out.print("<tr>");
			out.print("<td>" + i + "</td>");
			out.print("<td>" + rs.getString("subject") + "</td>");
			out.print("<td>" + rs.getString("name") + "</td>");
			out.print("<td>" + rs.getString("created") + "</td>");
			out.print("<td>" + rs.getInt("hit") + "</td>");
			out.print("</tr>");
		}
		ps.close();
		rs.close();
	}
	con.close();
	%>
	</table>
</body>
</html>