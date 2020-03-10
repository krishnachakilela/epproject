<%@page import="java.sql.*" %>
<%
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		String vsql = "select * from Employee_Request";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(vsql);
		%>
		<html>
		<body bgcolor=red>
			<center>
			<table border=1>
				<tr>									
                            <th>From_Date</th><th>To_Date</th><th>Reason</th>
			
				</tr>
		<%
		while(rs.next()){
			%>
			<tr>
			<td><%=rs.getString(1) %></td>
			<td><%=rs.getString(2)%></td>
                        <td><%=rs.getString(3)%></td>
			</tr>
			<%	
		}
		%>
		</table></body></html>
		<%
		con.close();
	}catch(Exception e){
		out.println(e.getMessage());
                 }
%>