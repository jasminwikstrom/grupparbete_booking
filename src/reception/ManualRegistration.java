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
		chooseAndChangeAttendance(askMemberName());
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
		
	
		return name;
	}
	
	public void chooseAndChangeAttendance(String name)
	{
		int id = 0;
		Connection con = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		List<Integer> idList = new ArrayList<Integer>();
		List<String> memberInfoList = new ArrayList<String>();
		Scanner userInput = new Scanner(System.in);
		
		
		
		try 
		{
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bestbookingever", "root", "root");
						
			
			stmt = con.prepareStatement("select bokning.id as id, person.namn as name, "
					+ "salbokning.StartTid as start, salbokning.SlutTid as finish\r\n" + 
					"from person\r\n" + 
					"inner join medlem \r\n" + 
					"on medlem.personId = person.id\r\n" + 
					"inner join bokning\r\n" + 
					"on bokning.MedlemID = medlem.id\r\n" + 
					"inner join salbokning\r\n" + 
					"on salbokning.passid = bokning.passid\r\n" + 
					"where person.namn = ?"
					+ "group by start;"); 
				
			stmt.setString(1, name);				
			
			 
			rs = stmt.executeQuery();

			
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
				
				int choice = userInput.nextInt();
				
				id = idList.get(choice);
				
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
			try 
			{
				userInput.close();
				rs.close();
				stmt.close();
				con.close();
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] something)
	{
		ManualRegistration mr = new ManualRegistration();
	}
}
