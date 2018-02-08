package reception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnectQuery 
{
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	String hostAddress = "jdbc:mysql://localhost:3306/BestBookingEver"
			+ "?verifyServerCertificate=false"
            + "&useSSL=false"
            + "&requireSSL=false";
	String username = "root";
	String password = "root";
	
	public Connection connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(hostAddress, username, password);
		}
		catch(Exception e)
		{
			System.out.println("något gick fel!");
		}
		return con;
	}
	
	public ResultSet queryDB(String statement, String name)
	{
		con = connect();
		try 
		{
			stmt = con.prepareStatement(statement);
			stmt.setString(1, name);				
			rs = stmt.executeQuery();
			
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Något gick fel!");
		}
		return rs;
	}
	
	public void updateQuery(String statement, int id)
	{
		try 
		{
			stmt = con.prepareStatement(statement);
			stmt.setInt(1, id);				
			stmt.executeUpdate();
		}
		catch (SQLException e) 
		{
			
			System.out.println("Kunde inte uppdatera");
		}
	}
	public void disconnect()
	{
	    try { if (rs != null) rs.close(); } catch (Exception e) {};
	    try { if (stmt != null) stmt.close(); } catch (Exception e) {};
	    try { if (con != null) con.close(); } catch (Exception e) {};
	}
	
	
	
	

}
