package AdminApplikation.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import AdminApplikation.BestBookingAppEver;
import AdminApplikation.Database.Objects.Anställd;
import AdminApplikation.Database.Objects.Pass;
import AdminApplikation.Database.Objects.Person;
import AdminApplikation.Database.Objects.Pos;
import AdminApplikation.Database.Objects.Sal;
import AdminApplikation.Database.Objects.Salbokning;
import AdminApplikation.Database.Objects.Träning;
import AdminApplikation.Database.Objects.Utrymme;

public class DataQuerys {

	private Database DB;
	private BestBookingAppEver BBAE;

	public DataQuerys(BestBookingAppEver BBAE, Database DB){
		this.BBAE = BBAE;
		this.DB = DB;
	}

	public void GetLists() {
		ResultSet GetAnställda = DB.SelectQuery("SELECT * FROM Anställd");
		ResultSet GetPersoner = DB.SelectQuery("SELECT * FROM Person");
		ResultSet GetSalar = DB.SelectQuery("SELECT * FROM Sal");
		ResultSet GetTräningsTyper = DB.SelectQuery("SELECT * FROM Träning");
		ResultSet GetUtrymme = DB.SelectQuery("SELECT * FROM Utrymme");
		ResultSet GetSalbokning = DB.SelectQuery("SELECT * FROM Salbokning");
		ResultSet GetPos = DB.SelectQuery("SELECT * FROM Pos");
		ResultSet GetPass = DB.SelectQuery("SELECT * FROM Pass");
		ArrayList<Anställd> anställda = new ArrayList<>();
		ArrayList<Person> personer = new ArrayList<>();
		ArrayList<Sal> salar = new ArrayList<>();
		ArrayList<Träning> Träningar = new ArrayList<>();
		ArrayList<Utrymme> Utrymmen = new ArrayList<>();
		ArrayList<Salbokning> Salbokningar = new ArrayList<>();
		ArrayList<Pos> positioner = new ArrayList<>();
		ArrayList<Pass> pass = new ArrayList<>();
		try {
			while(GetAnställda.next()){	anställda.add(new Anställd(GetAnställda.getInt("ID"), GetAnställda.getInt("PersonID"), GetAnställda.getInt("PositionID")));	}
			while(GetPersoner.next()){	personer.add(new Person(GetPersoner.getInt("ID"), GetPersoner.getString("namn")));	}
			while(GetSalar.next()){	salar.add(new Sal(GetSalar.getInt("ID"), GetSalar.getInt("UtrymmeID"), GetSalar.getString("namn")));	}
			while(GetTräningsTyper.next()){	Träningar.add(new Träning(GetTräningsTyper.getInt("ID"), GetTräningsTyper.getString("namn")));	}
			while(GetUtrymme.next()){	Utrymmen.add(new Utrymme(GetUtrymme.getInt("ID"), GetUtrymme.getInt("Antal")));	}
			while(GetSalbokning.next()){	Salbokningar.add(new Salbokning(GetSalbokning.getInt("ID"), GetSalbokning.getTimestamp("StartTid"), GetSalbokning.getTimestamp("SlutTid"), GetSalbokning.getInt("PassID"), GetSalbokning.getInt("SalID")));	}
			while(GetPos.next()){	positioner.add(new Pos(GetPos.getInt("ID"), GetPos.getString("Position"), GetPos.getString("Behörighet")));	}
			while(GetPass.next()){	pass.add(new Pass(GetPass.getInt("ID"), GetPass.getBoolean("PTPass"), GetPass.getInt("LedareID"), GetPass.getInt("TräningsTypID")));	}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		BBAE.setAnställda(anställda);
		BBAE.setPass(pass);
		BBAE.setPersoner(personer);
		BBAE.setPositioner(positioner);
		BBAE.setSalar(salar);
		BBAE.setSalbokningar(Salbokningar);
		BBAE.setTräningar(Träningar);
		BBAE.setUtrymmen(Utrymmen);
	}

	public void addMember(String namn){
		if(namn.equals("") || namn.equals(" ")){
			JOptionPane.showMessageDialog(null, "Fältet får inte vara tomt!");
		} else {
			DB.updateQuery("call bestbookingever.LäggTillMedlem('" + namn + "')");
			JOptionPane.showMessageDialog(null, "Medlemen har lagts till!");
		}
	}

	public void addEmployee(String namn, int Behörighet) {
		if(namn.equals("") || namn.equals(" ")){
			JOptionPane.showMessageDialog(null, "Fältet får inte vara tomt!");
		} else {
			DB.updateQuery("call bestbookingever.LäggTillAnställd('" + namn + "', " + Behörighet + ")");
			JOptionPane.showMessageDialog(null, "Anställda har lagts till!");
		}
	}

	public void addPass(int PT, int Ledare, int Träning, int Sal, String string, String string2) {
		DB.AddPass("call bestbookingever.LäggTillPass(" + PT + ", " + Ledare + ", " + Träning + ", " + Sal + ", '" + string + "', '" + string2 + "')");
	}

}
