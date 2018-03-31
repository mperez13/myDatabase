package functions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tables.Album;

@WebServlet("/TotalSongsInAlbum")
public class TotalSongsInAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TotalSongsInAlbum() { super(); }
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int albID = Integer.parseInt(request.getParameter("aid"));
		System.out.println("total alb ID" + albID);
		
		int countS = 0;
		String cs = null;
		Connection c = null;
		try {
			String url="jdbc:mysql://localhost:3306/mydatabase";
			c = DriverManager.getConnection(url,"root","");
			/* Get # of songs on the  */
			String sql="SELECT Count(*) FROM Song WHERE Album_id=" + albID + ";";
			PreparedStatement st = c.prepareStatement(sql);	
			ResultSet rs=st.executeQuery();
			
			if(rs.next()) {
				countS = rs.getInt(1);
			}
			cs = Integer.toString(countS);
			System.out.println(cs);
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
		getServletContext().setAttribute("cs", cs);
		request.getRequestDispatcher("select/selectAlbum.jsp").forward(request, response);
		//request.getRequestDispatcher("select/songsInAlbum.jsp").forward(request, response);
	}
}
