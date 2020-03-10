<%@page import="java.sql.*" %>

<%
int count=0;
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
Statement st=con.createStatement();
count=0;
int i=st.executeUpdate("insert into employee_request(status) values('"+count+"')");
out.println("Response was sent to the employeee successfuly!");
}
catch(Exception e)
{
System.out.print(e);

}
%>