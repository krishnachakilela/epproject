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
<head>
<style>
header
{
padding: 5px;
font-size:15px;
color:black;
}
ul
{
list-style-type: none;
margin=0;
padding=0;
overflow: hidden;
background-color:yellow;
}
li
{
float: left;
}
li a
{
display: inline-block;
color: black;
text-align: center;
padding: 14px 16px;
text-decoration: none;
}
.active
{
background-color: red;
}
</style>
</head>

                <center>
                <img src="logo.jpg" alt="founder" width="500" height="150"></img>
                </center><br><br>
		<body background="b1.jpg">
  <ul>
  <li><a href="leadashboard.html" class="active">Leader Dahboard</a></li>
</ul>

			<center>
			<table border=1 cellspacing=0 cellpadidng=5>
				<tr>									
                            <th>User Name</th><th>From_Date</th><th>To_Date</th><th>Reason</th>
			
				</tr>
		<%
    	while(rs.next()){
			%>
			<tr>
                        <td><%=rs.getString(1) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(3)%></td>
                        <td><%=rs.getString(4)%></td>
                           	
                     </tr>
			<%	
		}
		%>
		</table>
<br><br><br><br><br><br>
<form action="set" method="post">
Username :<input type="text" name="uname"><br><br>
Reason of leave:<br><br>
<textarea rows="4" cols="50" name="comment"  placeholder="Enter Reason Here">
</textarea><br><br>

<input type="submit" value="SUBMIT">


</body>




</html>
		<%
		con.close();
	}catch(Exception e){
		out.println(e.getMessage());
                 }
%>