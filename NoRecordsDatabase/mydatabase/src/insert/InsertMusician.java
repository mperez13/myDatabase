package insert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertMusician")
public class InsertMusician extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String mid = null;
    public InsertMusician() { super(); }
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Connection c = null;
		int maxMus = 0;
		try {
			String url="jdbc:mysql://localhost:3306/mydatabase";
			c = DriverManager.getConnection(url,"root","");
						
			String sql="SELECT MAX(mid) FROM MUSICIAN;";
			
			PreparedStatement st = c.prepareStatement(sql);		
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				maxMus = rs.getInt(1) + 1;
			}
			mid = Integer.toString(maxMus);
		}catch(SQLException e) {
			throw new ServletException(e);
		}finally {
			try{
				if(c!=null) {
					System.out.println("Connection CLOSED");
					c.close();	
				}
			} catch(SQLException e) {
				throw new ServletException(e);
			}
		}
		request.getRequestDispatcher("insert/insertMusician.jsp").forward(request,response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ssn = request.getParameter("ssn"); 
		String name = request.getParameter("name");
		String phone_no = request.getParameter("phone_no");
		Connection c = null;
		try {
			String sql = "INSERT INTO Musician(MID, SSN, NAME, PHONE_NO) VALUES ('" + 
					mid + "','" + 
					ssn + "','" + 
					name + "','" + 
					phone_no + "');";
			System.out.println(sql);
			String url="jdbc:mysql://localhost/mydatabase";
			c = DriverManager.getConnection(url,"root","");
	
			Statement st = c.createStatement();
			st.executeUpdate(sql);
		}catch(SQLException e) {
			throw new ServletException(e);
		}finally {
			try {
				if(c!=null)	{
					c.close();
					System.out.println("Connection Closed: Insert Musician");
				}
			}catch(SQLException e) {
				throw new ServletException(e);
			}
		}
		//response.sendRedirect("selectMusician.java");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
