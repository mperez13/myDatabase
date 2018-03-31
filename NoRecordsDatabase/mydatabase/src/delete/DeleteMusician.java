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

@WebServlet("/DeleteMusician")
public class DeleteMusician extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteMusician(){ super(); }

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
		int mid = Integer.parseInt(request.getParameter("id"));
		System.out.println("DELETE MID" + mid);

		Connection c = null;
		try {
			String sql = "DELETE FROM MUSICIAN WHERE MID='" + mid + "'";
			String url = "jdbc:mysql://localhost/mydatabase";
			System.out.println("SQL" + sql);
			c = DriverManager.getConnection(url, "root", "");
			Statement st = c.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			throw new ServletException(e);
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
		//response.sendRedirect("Displayproject");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
