import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
public class LeaderValidate extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
                    PrintWriter out=res.getWriter();
                    res.setContentType("text/html");
                    try
                     {
                   String first_name=req.getParameter("uname");
                   String pwd=req.getParameter("pwd");
               
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
  Statement stmt=con.createStatement();
  ResultSet rs=stmt.executeQuery("select * from leader");    
  int flag=0;
  while(rs.next())
   {
   if(first_name.equals(rs.getString(1)) && pwd.equals(rs.getString(3))) 
    {
       flag=1;
       break;
    }
    }
   if(flag==0)
   {
   out.println("Login Again");
    RequestDispatcher rd=req.getRequestDispatcher("logindemo.html");  
        rd.forward(req, res);  
}
else
{
out.println("Login Successfully");
 RequestDispatcher rd=req.getRequestDispatcher("leadashboard.html");  
        rd.forward(req, res);  
}
}
           catch(Exception e)
                         {
                         out.println(e);
                          }
 }
}

