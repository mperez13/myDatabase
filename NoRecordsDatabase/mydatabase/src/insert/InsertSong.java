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

@WebServlet("/InsertSong")
public class InsertSong extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String sId = null;
    public InsertSong() { super(); }
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
		int maxSon = 0;
		try {
			String url="jdbc:mysql://localhost:3306/mydatabase";
			c = DriverManager.getConnection(url,"root","");
						
			String sql="SELECT MAX(song_id) FROM SONG;";
			PreparedStatement st = c.prepareStatement(sql);		
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				maxSon = rs.getInt(1) + 1;
			}
			sId = Integer.toString(maxSon);
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
		request.getRequestDispatcher("insert/insertSong.jsp").forward(request,response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String album_id = request.getParameter("album_id");
		
		Connection c = null;
		try {
			String sql = "INSERT INTO Song(SONG_ID,TITLE,AUTHOR,ALBUM_ID) VALUES ('" + 
					sId + "','" + 
					title + "','" + 
					author + "','" + 
					album_id + "');";
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
					System.out.println("Connection Closed: Insert Song");
				}
			}catch(SQLException e) {
				throw new ServletException(e);
			}
		}
		//response.sendRedirect("selectMusician.java");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
