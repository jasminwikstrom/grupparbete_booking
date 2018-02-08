package reception;

import java.util.Scanner;

public class GetUserInput 
{
	Scanner userInput = new Scanner(System.in);
	public String askMemberName()
	{
		String name = "";
		
		while(name.equalsIgnoreCase(""))
		{
			System.out.println("Ange medlemens namn: ");
			name = userInput.nextLine();
		}
		
		
		return name;
	}
	
	public int getInt()
	{
		int num = userInput.nextInt();
		
		return num;
	}
	
	 

}
