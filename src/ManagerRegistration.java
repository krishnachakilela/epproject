import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ManagerRegistration extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
               {
  PrintWriter out=res.getWriter();
                    res.setContentType("text/html");
                    
                try{

                    String first_name=req.getParameter("uname");
                   String last_name=req.getParameter("lname");
                   String pwd=req.getParameter("pwd");
                   String address=req.getParameter("address");
                   String date_of_birth=req.getParameter("bday");
                   String email=req.getParameter("email");
                   String contact=req.getParameter("num");
               
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");

                       

PreparedStatement pstmt=con.prepareStatement("insert into manager values(?,?,?,?,?,?,?)");
                         pstmt.setString(1,first_name);
                         pstmt.setString(2,last_name);
                         pstmt.setString(3,pwd);
                         pstmt.setString(4,address);
                         pstmt.setString(5,date_of_birth);
                         pstmt.setString(6,email);
                         pstmt.setString(7,contact);
                       int i=  pstmt.executeUpdate();
                         
                           if(i!=0)
                                   {
                      out.println("You are successfully registered!!!");
                    RequestDispatcher rd=req.getRequestDispatcher("logindemo.html");          
                   rd.include(req, res);      
                           
                                   }
                           else
                           {
                           out.println("You failed to register!!!");
                         RequestDispatcher rd=req.getRequestDispatcher("managerreg.html");          
                           rd.include(req, res);      
                           
                           }
                           }

                         catch(Exception e)
                         {
                         out.println(e);
                          }
}
}

