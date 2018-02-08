package reception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManualRegistration 
{
	public ManualRegistration()
	{
		chooseAndChangeAttendance();
	}
	
	public void chooseAndChangeAttendance()
	{
		int id = 0;
		String statement = "";
		String name = "";
		
		ResultSet rs = null;
		
		List<Integer> idList = new ArrayList<Integer>();
		List<String> memberInfoList = new ArrayList<String>();
		
		DatabaseConnectQuery dbc = new DatabaseConnectQuery();
		GetUserInput getui = new GetUserInput();
		
		name = getui.askMemberName();
		
		
		
		
		try 
		{
			dbc.connect();
			
			statement = "select bokning.id as id, person.namn as name, salbokning.StartTid as start, salbokning.SlutTid as finish \r\n" + 
					"from person \r\n" + 
					"inner join medlem\r\n" + 
					"on medlem.personId = person.id\r\n" + 
					"inner join bokning \r\n" + 
					"on bokning.MedlemID = medlem.id \r\n" + 
					"inner join salbokning\r\n" + 
					"on salbokning.passid = bokning.passid\r\n" + 
					"where person.namn = ?\r\n" + 
					"and startTid between NOW() - interval 30 minute and NOW() + interval 4 hour\r\n" + 
					"and bokning.närvarat = 0\r\n" + 
					"order by start;";
			
			rs = dbc.queryDB(statement, name);

			
			while (rs.next()) 
			{ 
				id = rs.getInt("id");
				idList.add(id);
				
				String info = rs.getString("name")+"\t"+rs.getTimestamp("start")+"\t"+rs.getTime("finish");
				memberInfoList.add(info);
			}
			
			if(id == 0)
			
				System.out.println("Det finns ingen bokning för denna medlem");
			
			
			else
			{
				System.out.println("Välj önskade bokning: ");
				for(int i=0; i<memberInfoList.size(); i++)
				{
					System.out.println(i+"\t"+memberInfoList.get(i));
				}
				
				int choice = getui.getInt();
				
				id = idList.get(choice);
				
				statement = "update bokning \r\n" + 
						"set närvarat = 1\r\n" + 
						"where id = ?;";
				dbc.updateQuery(statement, id);
				
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
	
	public static void main(String[] something)
	{
		ManualRegistration mr = new ManualRegistration();
	}
}
