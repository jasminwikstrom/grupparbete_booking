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
		registerPresence();
	}

	
	public void registerPresence()
	{
		int id = 0;
		String stmt = "";
		String name = "";

		ResultSet rs = null;
		DatabaseConnectQuery dbc = new DatabaseConnectQuery();
		GetUserInput getui = new GetUserInput();
		
		name = getui.askMemberName();
		
		try 
		{
			dbc.connect();
			
			stmt = "select bokning.id\r\n" + 
					"from Person \r\n" + 
					"inner join medlem on medlem.PersonID = person.id\r\n" + 
					"inner join bokning on bokning.MedlemID = medlem.id\r\n" + 
					"inner join salbokning on bokning.PassID = salbokning.passid\r\n" + 
					"where now() between salbokning.startTid - interval 30 minute and salbokning.SlutTid\r\n" + 
					"and person.namn = ?;";
			
			rs = dbc.queryDB(stmt, name);
			
			while (rs.next()) 
			{ 
				id = rs.getInt("bokning.id");
			}
			
			if(id == 0)
			
				System.out.println("Denna medlem har inte bokat någon pågående pass");
			
			
			else
			{
				stmt = "update bokning \r\n" + 
						"set närvarat = 1\r\n" + 
						"where id = ?;";
				dbc.updateQuery(stmt, id);
				
				System.out.println("närvaro registrerad");
			}
			
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		
		finally
		{
			dbc.disconnect();
		}
	}
	
	public static void main(String[] args)
	{
		AutomaticRegistration ar = new AutomaticRegistration();
	}
}
