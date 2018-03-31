package functions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import tables.Album;

public class SongsInAlbum {

	public static void main(String[] args) {
		Connection c = null;
		try {
			String url="jdbc:mysql://localhost:3306/mydatabase";
			c = DriverManager.getConnection(url,"root","");

			String sql ="{call total_songs()}";
			CallableStatement cst = c.prepareCall(sql);
			
			//cst.setInt(Types.Integer);
			
			ResultSet rs=cst.executeQuery();

			while(rs.next()) {
				System.out.println("album" + rs.getInt(1));
			}
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
	}

}
