<%@page import="java.sql.*" %>

<%
int count=0;
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
Statement st=con.createStatement();
<%= request.getParameter("name") %>  


count=count+1;
int i=st.executeUpdate("insert into employee_request(status) values('"+count+"')");
out.println("Aceptance Request was sent to the Manager successfuly!");
}
catch(Exception e)
{
System.out.print(e);

}
%>