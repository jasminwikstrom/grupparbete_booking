package AdminApplikation.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import AdminApplikation.BestBookingAppEver;
import AdminApplikation.Database.Objects.Anst�lld;
import AdminApplikation.Database.Objects.Pass;
import AdminApplikation.Database.Objects.Person;
import AdminApplikation.Database.Objects.Pos;
import AdminApplikation.Database.Objects.Sal;
import AdminApplikation.Database.Objects.Salbokning;
import AdminApplikation.Database.Objects.Tr�ning;
import AdminApplikation.Database.Objects.Utrymme;

public class DataQuerys {

	private Database DB;
	private BestBookingAppEver BBAE;
	
	public DataQuerys(BestBookingAppEver BBAE, Database DB){
		this.BBAE = BBAE;
		this.DB = DB;
	}

	public void GetLists() {
		ResultSet GetAnst�llda = DB.SelectQuery("SELECT * FROM Anst�lld");
		ResultSet GetPersoner = DB.SelectQuery("SELECT * FROM Person");
		ResultSet GetSalar = DB.SelectQuery("SELECT * FROM Sal");
		ResultSet GetTr�ningsTyper = DB.SelectQuery("SELECT * FROM Tr�ning");
		ResultSet GetUtrymme = DB.SelectQuery("SELECT * FROM Utrymme");
		ResultSet GetSalbokning = DB.SelectQuery("SELECT * FROM Salbokning");
		ResultSet GetPos = DB.SelectQuery("SELECT * FROM Pos");
		ResultSet GetPass = DB.SelectQuery("SELECT * FROM Pass");
		ArrayList<Anst�lld> anst�llda = new ArrayList<>();
		ArrayList<Person> personer = new ArrayList<>();
		ArrayList<Sal> salar = new ArrayList<>();
		ArrayList<Tr�ning> Tr�ningar = new ArrayList<>();
		ArrayList<Utrymme> Utrymmen = new ArrayList<>();
		ArrayList<Salbokning> Salbokningar = new ArrayList<>();
		ArrayList<Pos> positioner = new ArrayList<>();
		ArrayList<Pass> pass = new ArrayList<>();
		try {
			while(GetAnst�llda.next()){	anst�llda.add(new Anst�lld(GetAnst�llda.getInt("ID"), GetAnst�llda.getInt("PersonID"), GetAnst�llda.getInt("PositionID")));	}
			while(GetPersoner.next()){	personer.add(new Person(GetPersoner.getInt("ID"), GetPersoner.getString("namn")));	}
			while(GetSalar.next()){	salar.add(new Sal(GetSalar.getInt("ID"), GetSalar.getInt("UtrymmeID"), GetSalar.getString("namn")));	}
			while(GetTr�ningsTyper.next()){	Tr�ningar.add(new Tr�ning(GetTr�ningsTyper.getInt("ID"), GetTr�ningsTyper.getString("namn")));	}
			while(GetUtrymme.next()){	Utrymmen.add(new Utrymme(GetUtrymme.getInt("ID"), GetUtrymme.getInt("Antal")));	}
			while(GetSalbokning.next()){	Salbokningar.add(new Salbokning(GetSalbokning.getInt("ID"), GetSalbokning.getTimestamp("StartTid"), GetSalbokning.getTimestamp("SlutTid"), GetSalbokning.getInt("PassID"), GetSalbokning.getInt("SalID")));	}
			while(GetPos.next()){	positioner.add(new Pos(GetPos.getInt("ID"), GetPos.getString("Position"), GetPos.getString("Beh�righet")));	}
			while(GetPass.next()){	pass.add(new Pass(GetPass.getInt("ID"), GetPass.getBoolean("PTPass"), GetPass.getInt("LedareID"), GetPass.getInt("Tr�ningsTypID")));	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BBAE.setAnst�llda(anst�llda);
		BBAE.setPass(pass);
		BBAE.setPersoner(personer);
		BBAE.setPositioner(positioner);
		BBAE.setSalar(salar);
		BBAE.setSalbokningar(Salbokningar);
		BBAE.setTr�ningar(Tr�ningar);
		BBAE.setUtrymmen(Utrymmen);
	}

	public void addMember(String namn){
		if(namn.equals("") || namn.equals(" ")){
			JOptionPane.showMessageDialog(null, "F�ltet f�r inte vara tomt!");
		} else {
			DB.updateQuery("call bestbookingever.L�ggTillMedlem('" + namn + "')");
			JOptionPane.showMessageDialog(null, "Medlemen har lagts till!");
		}
	}

	public void addEmployee(String namn, int Beh�righet) {
		if(namn.equals("") || namn.equals(" ")){
			JOptionPane.showMessageDialog(null, "F�ltet f�r inte vara tomt!");
		} else {
			DB.updateQuery("call bestbookingever.L�ggTillAnst�lld('" + namn + "', " + Beh�righet + ")");
			JOptionPane.showMessageDialog(null, "Anst�llda har lagts till!");
		}
	}
	
	public void addPass(int PT, int Ledare, int Tr�ning, int Sal, String string, String string2) {
		DB.AddPass("call bestbookingever.L�ggTillPass(" + PT + ", " + Ledare + ", " + Tr�ning + ", " + Sal + ", '" + string + "', '" + string2 + "')");
	}
	
}
