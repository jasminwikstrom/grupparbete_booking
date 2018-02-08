package AdminApplikation.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Database {

	private Connection Conn;
	private PreparedStatement PS;
	private ResultSet RS;
	
	private String Host = 
			  "jdbc:mysql://localhost:3306/BestBookingEver"
			+ "?verifyServerCertificate=false"
            + "&useSSL=false"
            + "&requireSSL=false";
	private String User = "root";
	private String Pass = "root";
	
	public Connection Connect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Conn = DriverManager.getConnection(Host, User, Pass);
		}catch(Exception e){
			System.out.println("n�got gick fel!");
		}
		return Conn;
	}
	
	public void updateQuery(String Statement){
		Conn = Connect();
		try {
			PS = Conn.prepareStatement(Statement);
			PS.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void AddPass(String Statement){
		Conn = Connect();
		try {
			PS = Conn.prepareStatement(Statement);
			PS.executeUpdate();
			RS = PS.getResultSet();
			if(RS.next()){
				JOptionPane.showMessageDialog(null, RS.getString(1));
			} else {
				JOptionPane.showMessageDialog(null, "Passet har lagts till!");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public ResultSet SelectQuery(String Statement){
		Conn = Connect();
		try {
			PS = Conn.prepareStatement(Statement);
			RS = PS.executeQuery();
		} catch (SQLException e) {
			System.out.println("N�got gick fel!");
		}
		return RS;
	}
	
	public void Disconnect(){
	    try { if (RS != null) RS.close(); } catch (Exception e) {};
	    try { if (PS != null) PS.close(); } catch (Exception e) {};
	    try { if (Conn != null) Conn.close(); } catch (Exception e) {};
	}	
	
}
