import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Leader_Accept extends HttpServlet
{
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
 String username = request.getParameter("uname");
StringBuffer Reason = new StringBuffer(request.getParameter("comment"));
        try
     {

      Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
PreparedStatement pst = con.prepareStatement("insert into leader_accept values(?,?)");
      pst.setString(1,username);
   int loc = (new String(Reason)).indexOf('\n');
        while(loc > 0)
        {
            Reason.replace(loc, loc+1, "<BR>");
            loc = (new String(Reason)).indexOf('\n');
       }
                String str = Reason.toString();
                     pst.setString(2,str);





      int i = pst.executeUpdate();
      if(i!=0)
{
        out.println("Employee request was sent to the manager successfully");
       out.println("<html><body><a href='leadashboard.html'>Click here to go to Leader dashboard</a>"
                        + "</body></html>"); 
      }
      else
{
        out.println("Employee requetst was rejected by leader");
      }
    }
    catch (Exception e){
      out.println(e);
    }
  }
}
