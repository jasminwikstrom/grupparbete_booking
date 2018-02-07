package reception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AutomaticRegistration 
{
	public AutomaticRegistration()
	{
		String name = askMemberName();
		registerPresence(name);
	}

	
	
	public String askMemberName()
	{
		Scanner userInput = new Scanner(System.in);
		String name = "";
		
		while(name.equalsIgnoreCase(""))
		{
			System.out.println("Ange medlemens namn: ");
			name = userInput.nextLine();
		}
		
		userInput.close();
		return name;
	}
	
	public void registerPresence(String name)
	{
		int id = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		
		
		
		try 
		{
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bestbookingever", "root", "root");
						
			
			stmt = con.prepareStatement("select bokning.id\r\n" + 
					"from Person \r\n" + 
					"inner join medlem on medlem.PersonID = person.id\r\n" + 
					"inner join bokning on bokning.MedlemID = medlem.id\r\n" + 
					"inner join salbokning on bokning.PassID = salbokning.passid\r\n" + 
					"where now() between salbokning.startTid - interval 5 minute and salbokning.SlutTid\r\n" + 
					"and person.namn = ?;"); 
				
			stmt.setString(1, name);				
			
			 
			rs = stmt.executeQuery();

			
			while (rs.next()) 
			{ 
				id = rs.getInt("bokning.id");
			}
			
			if(id == 0)
			
				System.out.println("Denna medlem har inte bokat någon pågående pass");
			
			
			else
			{
				stmt2 = con.prepareStatement("update bokning \r\n" + 
						"set närvarat = 1\r\n" + 
						"where id = ?;");
				
				stmt2.setInt(1, id);
				
				
				stmt2.executeUpdate();
				System.out.println("närvaro registrerad");
			}
			
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		
		finally
		{
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		AutomaticRegistration ar = new AutomaticRegistration();
	}
}
