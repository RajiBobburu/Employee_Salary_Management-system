import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/emp")
public class ReadEmpData extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException {
		String name=req.getParameter("n");
		int age=Integer.parseInt(req.getParameter("a"));
		int sal=Integer.parseInt(req.getParameter("s"));
		int bonus=Integer.parseInt(req.getParameter("b"));
		int total=(bonus)+(sal);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_registration?user=root&password=root");
			String sql="INSERT INTO register(name,age,sal,bonus) values(? ,? ,? ,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setInt(2,age);
			ps.setInt(3,sal);
			ps.setInt(4,bonus);
			ps.execute();
			con.close();
		}catch(Exception e)
		{
			System.out.println("JDBC issue");
		}
		
	}

}
