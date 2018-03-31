package delete;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteAlbum")
public class DeleteAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteAlbum(){ super(); }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		System.out.println("id" + id);

		Connection c = null;
		try {
			String sql = "DELETE FROM ALBUM WHERE ID='" + id + "'";
			String url = "jdbc:mysql://localhost/mydatabase";
			System.out.println("SQL" + sql);
			c = DriverManager.getConnection(url, "root", "");
			Statement st = c.createStatement();
			st.executeUpdate(sql);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (SQLException e) {
			getServletContext().setAttribute("de", "Album cannot be deleted. Album must be empty.");
			request.getRequestDispatcher("select/selectAlbum.jsp").forward(request, response);
			//throw new ServletException(e);
		} finally {
			try {
				if (c != null) {
					c.close();
					System.out.println("Connection Closed: Delete Musician");
				}
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
		//response.sendRedirect("SelectAlbum");
		
	}

}
