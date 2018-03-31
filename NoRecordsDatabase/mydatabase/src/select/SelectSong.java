package select;

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

import tables.Song;

@WebServlet("/SelectSong")
public class SelectSong extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SelectSong() { super(); }
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Song> song = new ArrayList<Song>();
		Connection c = null;
		try {
			String url="jdbc:mysql://localhost:3306/mydatabase";
			c = DriverManager.getConnection(url,"root","");
						
			String sql="SELECT * from SONG ORDER BY SONG_ID ASC;";
			PreparedStatement st = c.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				Song a = new Song();
				a.setSong_id(rs.getInt("song_id"));
				a.setTitle(rs.getString("title"));
				a.setAuthor(rs.getString("author"));
				a.setAlbum_id(rs.getInt("album_id"));
				song.add(a);
			}
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
		getServletContext().setAttribute("song", song);


		request.getRequestDispatcher("select/selectSong.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
