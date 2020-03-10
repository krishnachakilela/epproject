import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class EmployeeRequest extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
               {
  PrintWriter out=res.getWriter();
                    res.setContentType("text/html");
              try{
                    String Username=req.getParameter("uname");
                    String from_date=req.getParameter("fromdate");
                   String to_date=req.getParameter("todate");
StringBuffer Reason = new StringBuffer(req.getParameter("comment"));
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
PreparedStatement pstmt=con.prepareStatement("insert into employee_request (username,fromdate,todate,reason) values (?,?,?,?)");
                         pstmt.setString(1,Username);
                         pstmt.setString(2,from_date);
                         pstmt.setString(3,to_date);
   int loc = (new String(Reason)).indexOf('\n');
        while(loc > 0)
        {
            Reason.replace(loc, loc+1, "<BR>");
            loc = (new String(Reason)).indexOf('\n');
       }
                String str = Reason.toString();
                     pstmt.setString(4,str);
                        int i=  pstmt.executeUpdate();
                         
                           if(i!=0)
                                   {

                        out.println("Request for permission sent!");
                                   }
                           else
                           {
                           out.println("You failed to send the request");
                           }
                           }

                         catch(Exception e)
                         {
                         out.println(e);
                          }
}
}

