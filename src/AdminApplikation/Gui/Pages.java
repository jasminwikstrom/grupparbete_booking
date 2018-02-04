package AdminApplikation.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import AdminApplikation.BestBookingAppEver;
import AdminApplikation.Database.DataQuerys;
import AdminApplikation.Database.Objects.Anst�lld;
import AdminApplikation.Database.Objects.Person;
import AdminApplikation.Database.Objects.Sal;
import AdminApplikation.Database.Objects.Tr�ning;

public class Pages {

	private BestBookingAppEver BBAE;
	private DataQuerys DBQ;
	private GUI gui;
	
	public Pages(BestBookingAppEver BBAE, DataQuerys DBQ, GUI gui){
		this.DBQ = DBQ;
		this.BBAE = BBAE;
		this.gui = gui;
	}

	public JPanel startPage() {
		
		DBQ.GetLists();
		ArrayList<String> Admins = new ArrayList<>();
		for(Anst�lld x : BBAE.getAnst�llda()){
			if(x.getPositionID() == 1){
				for(Person a : BBAE.getPersoner()){
					if(x.getPersonID() == a.getID()){
						Admins.add(a.getNamn());
						break;
					}
				}
			}
		}
		
		JPanel Parent = new JPanel();
		Parent.setOpaque(false);
		Parent.setLayout(new GridBagLayout());
		
		JPanel Child1 = new JPanel();
		Child1.setOpaque(false);
		Child1.setLayout(new GridLayout(0,2,5,5));
		
		JComboBox AdminsBox = new JComboBox(Admins.toArray());
		JButton Login = new JButton("logga in");
		
		setTheme(Login);
		setTheme(AdminsBox);
		
		Child1.add(Login);
		Child1.add(AdminsBox);
		
		Login.addActionListener(e -> this.gui.swapPage(MenuPage()));
		
		Parent.add(Child1, new GridBagConstraints());

		return Parent;
	}
	
	public JPanel MenuPage() {
		JPanel Parent = new JPanel();
		Parent.setOpaque(false);
		Parent.setLayout(new GridBagLayout());
		
		JPanel Child1 = new JPanel();
		Child1.setOpaque(false);
		Child1.setLayout(new GridLayout(0,2,5,5));
		
		JButton AddMember = new JButton("L�gg till medlem");
		JButton AddEmployee = new JButton("L�gg till anst�lld");
		JButton AddPass = new JButton("L�gg till pass");
		
		setTheme(AddMember);
		setTheme(AddEmployee);
		setTheme(AddPass);
		
		Child1.add(AddMember);
		Child1.add(AddEmployee);
		Child1.add(AddPass);
		
		AddMember.addActionListener(e -> this.gui.swapPage(AddMember()));
		AddEmployee.addActionListener(e -> this.gui.swapPage(AddEmployee()));
		AddPass.addActionListener(e -> this.gui.swapPage(AddPass()));
		
		Parent.add(Child1, new GridBagConstraints());

		return Parent;
	}
	public JPanel AddMember() {
		JPanel Parent = new JPanel();
		Parent.setOpaque(false);
		Parent.setLayout(new GridBagLayout());
		
		JPanel Child1 = new JPanel();
		Child1.setOpaque(false);
		Child1.setLayout(new GridLayout(0,2,5,5));
		
		JButton Back = new JButton("Tillbaka");
		JTextField MemberName = new JTextField(20);
		JButton AddMember = new JButton("L�gg till medlem");
		
		setTheme(AddMember);
		setTheme(Back);
		setTheme(MemberName);
		
		Child1.add(Back);
		Child1.add(AddMember);
		Child1.add(setTheme(new JLabel("Namn: ")));
		Child1.add(MemberName);
				
		Parent.add(Child1, new GridBagConstraints());

		Back.addActionListener(e -> gui.swapPage(MenuPage()));
		AddMember.addActionListener(e -> { DBQ.addMember(MemberName.getText()); gui.swapPage(AddMember()); } );
		
		return Parent;
	}
	public JPanel AddEmployee() {
		JPanel Parent = new JPanel();
		Parent.setOpaque(false);
		Parent.setLayout(new GridBagLayout());
		
		JPanel Child1 = new JPanel();
		Child1.setOpaque(false);
		Child1.setLayout(new GridLayout(0,2,5,5));
		
		JButton Back = new JButton("Tillbaka");
		JTextField EmployeeName = new JTextField(20);
		JButton AddEmployee = new JButton("L�gg till Anst�lld");
		JComboBox positions = new JComboBox(BBAE.getPositioner().toArray());
		
		setTheme(AddEmployee);
		setTheme(Back);
		setTheme(EmployeeName);
		setTheme(positions);
		
		Child1.add(Back);
		Child1.add(AddEmployee);
		Child1.add(setTheme(new JLabel("Position: ")));
		Child1.add(positions);
		Child1.add(setTheme(new JLabel("Namn: ")));
		Child1.add(EmployeeName);
				
		Parent.add(Child1, new GridBagConstraints());

		Back.addActionListener(e -> gui.swapPage(MenuPage()));
		AddEmployee.addActionListener(e -> { DBQ.addEmployee(EmployeeName.getText(), positions.getSelectedIndex()+1); gui.swapPage(AddEmployee()); } );
		
		return Parent;
	}
	public JPanel AddPass() {
		
		DBQ.GetLists();
		ArrayList<Person> PTes = new ArrayList<>();
		for(Anst�lld x : BBAE.getAnst�llda()){
			if(x.getPositionID() == 2){
				for(Person a : BBAE.getPersoner()){
					if(x.getPersonID() == a.getID()){
						PTes.add(a);
						break;
					}
				}
			}
		}
		
		JPanel Parent = new JPanel();
		Parent.setOpaque(false);
		Parent.setLayout(new GridBagLayout());
		
		JPanel Child1 = new JPanel();
		Child1.setOpaque(false);
		Child1.setLayout(new GridLayout(0,2,5,5));
		
		JButton Back = new JButton("Tillbaka");
		JCheckBox PTPass = new JCheckBox("PT pass");
				
		
		JComboBox PTs = new JComboBox(PTes.toArray());
		JComboBox Tr�ningsTyper = new JComboBox(BBAE.getTr�ningar().toArray());
		JComboBox Salar = new JComboBox(BBAE.getSalar().toArray());
		
		JComboBox M�nader = new JComboBox(getMonth());
		JComboBox Dagar = new JComboBox(getDays(Calendar.getInstance().get(Calendar.MONTH)));
		
		JComboBox Timmar = new JComboBox(timmar());
		JComboBox Minuter = new JComboBox(minuter());
		
		JComboBox PassL�ngd = new JComboBox(L�ngd());
		
		JButton AddPass = new JButton("L�gg till Pass");
		
		M�nader.setSelectedIndex(Calendar.getInstance().get(Calendar.MONTH));
		
		setTheme(Back);
		setTheme(PTs);
		setTheme(Tr�ningsTyper);
		setTheme(Salar);
		setTheme(PTPass);
		setTheme(AddPass);
		setTheme(M�nader);
		setTheme(Dagar);
		setTheme(Timmar);
		setTheme(PassL�ngd);
		setTheme(Minuter);
		
		Child1.add(Back);
		Child1.add(PTPass);
		Child1.add(setTheme(new JLabel("PassLedare: ")));
		Child1.add(PTs);
		Child1.add(setTheme(new JLabel("Tr�ningsTyp: ")));
		Child1.add(Tr�ningsTyper);
		Child1.add(setTheme(new JLabel("Sal: ")));
		Child1.add(Salar);
		
		Child1.add(setTheme(new JLabel("V�lj M�nad: ")));
		Child1.add(M�nader);
		Child1.add(setTheme(new JLabel("V�lj Dag: ")));
		Child1.add(Dagar);
		Child1.add(setTheme(new JLabel("V�lj Timme p� dygnet: ")));
		Child1.add(Timmar);
		Child1.add(setTheme(new JLabel("V�lj Minuter p� timmen: ")));
		Child1.add(Minuter);
		Child1.add(setTheme(new JLabel("V�lj Passl�ngd(minuter): ")));
		Child1.add(PassL�ngd);
		
		Child1.add(setTheme(new JLabel()));
		Child1.add(AddPass);
				
		Parent.add(Child1, new GridBagConstraints());

		
		M�nader.addActionListener(e -> { Dagar.removeAllItems(); for(String x : getDays(M�nader.getSelectedIndex())) Dagar.addItem(x); });
		Back.addActionListener(e -> gui.swapPage(MenuPage()));
		AddPass.addActionListener(e -> {
			int ptpass = 0;
			int LedareID = 0;
			int Tr�ningID = 1;
			int SalID = 1;
			String StartTid;
			String SlutTid;
			int SlutMin;
			String newTime = "";
			
			if(PTPass.isSelected() == true){
				ptpass = 1;
				System.out.println("VAFAN " + ptpass);
			}
			
			int PersonID = getSelectedID((Person)PTs.getSelectedItem());
			for(Anst�lld x : BBAE.getAnst�llda())
			{
				if(x.getPersonID() == PersonID){
					LedareID = x.getID();
					break;
				}
			}
			StartTid = "2018-" + (M�nader.getSelectedIndex()+1) + "-" + Dagar.getSelectedItem() + " " + Timmar.getSelectedItem() + ":" + Minuter.getSelectedItem() + ":00.0";
			SlutMin = (PassL�ngd.getSelectedIndex()*15+30);
			try {
				String myTime = Timmar.getSelectedItem() + ":" + Minuter.getSelectedItem();
				SimpleDateFormat df = new SimpleDateFormat("HH:mm");
				Date d;
				d = df.parse(myTime);
				Calendar cal = Calendar.getInstance();
				cal.setTime(d);
				cal.add(Calendar.MINUTE, SlutMin);
				newTime = df.format(cal.getTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			} 
			SlutTid = "2018-" + (M�nader.getSelectedIndex()+1) + "-" + Dagar.getSelectedItem() + " " + newTime;
			Tr�ningID = getSelectedID((Tr�ning)Tr�ningsTyper.getSelectedItem());
			SalID = getSelectedID((Sal)Salar.getSelectedItem());
			DBQ.addPass(ptpass, LedareID, Tr�ningID, SalID, StartTid, SlutTid);
		});
		return Parent;
	}
	
	public String[] timmar(){
		String [] H = new String[16];
		for(int i = 6, x = 0; x<16; i++, x++){
			if(i<10)
				H[x] = "0" + i;
			else
				H[x] = i +"";
		}
		return H;
	}
	public String[] L�ngd(){
		String [] H = new String[5];
		for(int i = 30, x = 0; x<5; i+=15, x++){
				H[x] = i +"";
		}
		return H;
	}
	public String[] minuter(){
		String [] Min = new String[12];
		for(int i = 0, x = 0; x<12; i+=5, x++){
			if(i<10)
				Min[x] = "0" + i;
			else
				Min[x] = i +"";
		}
		return Min;
	}
	public String[] getMonth(){
		String[] M = new String[12];
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] Months = dfs.getMonths();
		for(int i = 0; i<12; i++){
			M[i] = Months[i];
		}

		return M;
	}
	public String[] getDays(int M){
		YearMonth yearMonthObject = YearMonth.of(2018, M+1);
		int daysInMonth = yearMonthObject.lengthOfMonth(); 
		String[] D = new String[daysInMonth];
		for(int i = 1; i <= daysInMonth; i++){
			if(i<10)
				D[i-1] = "0" + i;
			else
				D[i-1] = i + "";
		}
		return D;
	}
	
	public int getSelectedID(Tr�ning obj)
	{
		int id = obj.getID();
		return id;
	}
	public int getSelectedID(Sal obj)
	{
		int id = obj.getID();
		return id;
	}
	public int getSelectedID(Person obj)
	{
		int id = obj.getID();
		return id;
	}
	
	public void setTheme(JButton B){
		B.setBackground(GUI.BackgroundC);
		B.setForeground(GUI.ForegroundC);
		B.setFocusable(false);
	}
	public void setTheme(JComboBox B){
		B.setBackground(GUI.BackgroundC);
		B.setForeground(GUI.ForegroundC);
		B.setFocusable(false);
	}
	public void setTheme(JTextField B){
		B.setBackground(GUI.BackgroundC);
		B.setForeground(GUI.ForegroundC);
	}
	public void setTheme(JCheckBox B){
		B.setBackground(GUI.BackgroundC);
		B.setForeground(GUI.ForegroundC);
	}
	public JLabel setTheme(JLabel B){
		B.setBackground(GUI.BackgroundC);
		B.setForeground(GUI.ForegroundC);
		return B;
	}



	
}
