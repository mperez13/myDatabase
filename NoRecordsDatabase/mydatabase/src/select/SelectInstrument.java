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

import tables.Instrument;

@WebServlet("/SelectInstrument")
public class SelectInstrument extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelectInstrument() { super(); }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Instrument> instr = new ArrayList<Instrument>();
		Connection c = null;
		try {
			String url="jdbc:mysql://localhost:3306/mydatabase";
			c = DriverManager.getConnection(url,"root","");
						
			String sql="SELECT * from INSTRUMENT ORDER BY INSTRUMENT_ID ASC;";
			
			PreparedStatement st = c.prepareStatement(sql);
			
			ResultSet rs=st.executeQuery();
			
			
			while(rs.next()) {
				Instrument tab = new Instrument();
				tab.setInstrument_id(rs.getInt("instrument_id"));
				tab.setName(rs.getString("name"));
				tab.setMusickeys(rs.getString("musickeys"));

				instr.add(tab);
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
		getServletContext().setAttribute("instr", instr);


		request.getRequestDispatcher("select/selectInstrument.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
