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
import tables.Place;

@WebServlet("/SelectPlace")
public class SelectPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelectPlace() { super(); }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Place> pl = new ArrayList<Place>();
		Connection c = null;
		try {
			String url="jdbc:mysql://localhost:3306/mydatabase";
			c = DriverManager.getConnection(url,"root","");
						
			String sql="SELECT * from Place ORDER BY PLACE_ID ASC;";
			PreparedStatement st = c.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			
			
			while(rs.next()) {
				Place a = new Place();
				a.setPlace_id(rs.getInt("place_id"));
				a.setAddress(rs.getString("address"));
				a.setPhone_no(rs.getString("phone_no"));		
				pl.add(a);
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
		getServletContext().setAttribute("pl", pl);


		request.getRequestDispatcher("select/selectPlace.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
