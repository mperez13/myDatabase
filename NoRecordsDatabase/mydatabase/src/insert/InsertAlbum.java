
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

@WebServlet("/InsertAlbum")
public class InsertAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String aId = null;
    public InsertAlbum() { super(); }
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
		int maxAlb = 0;
		try {
			String url="jdbc:mysql://localhost:3306/mydatabase";
			c = DriverManager.getConnection(url,"root","");
						
			String sql="SELECT MAX(id) FROM ALBUM;";
			PreparedStatement st = c.prepareStatement(sql);		
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				maxAlb = rs.getInt(1) + 1;
			}
			aId = Integer.toString(maxAlb);
			System.out.println("aId" + aId);
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
		request.getRequestDispatcher("insert/insertAlbum.jsp").forward(request,response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String album_id = request.getParameter("album_id");
		String title = request.getParameter("title");
		String copyright_dt = request.getParameter("copyright_dt");
		String format = request.getParameter("format");
		String m_ssn = request.getParameter("m_ssn");
		
		Connection c = null;
		try {
			System.out.println("AID1" + aId);
			String sql = "INSERT INTO Album(ID,ALBUM_ID,TITLE,COPYRIGHT_DT,FORMAT,M_SSN) VALUES ('" + 
					aId + "','" + 
					album_id + "','" + 
					title + "','" + 
					copyright_dt + "','" +
					format + "','" +
					m_ssn + "');";
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
					System.out.println("Connection Closed: Insert Album");
				}
			}catch(SQLException e) {
				throw new ServletException(e);
			}
		}
		//response.sendRedirect("selectMusician.java");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
