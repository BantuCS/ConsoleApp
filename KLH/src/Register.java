import java.io.*;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */

@WebServlet("/Register")
public class Register extends HttpServlet {
	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("text1");
		String c=request.getParameter("text2");
		String e=request.getParameter("text3");
		String p=request.getParameter("Program");
                String cp=request.getParameter("Course");
		
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
		PreparedStatement ps=con.prepareStatement("insert into klh values(?,?,?,?,?)");
		ps.setString(1,n);
		ps.setString(2,c);
		ps.setString(3,e);
		ps.setString(4,p);
                ps.setString(5,cp);
		
		int i=ps.executeUpdate();
		if(i>0)
		{
		out.print("You are successfully registered...");
	
		}
		
			
		}catch (Exception e2) {System.out.println(e2);}
		
		out.close();
	}

}
