package AdminApplikation;

import java.util.ArrayList;

import AdminApplikation.Database.DataQuerys;
import AdminApplikation.Database.Database;
import AdminApplikation.Database.Objects.Anst�lld;
import AdminApplikation.Database.Objects.Pass;
import AdminApplikation.Database.Objects.Person;
import AdminApplikation.Database.Objects.Pos;
import AdminApplikation.Database.Objects.Sal;
import AdminApplikation.Database.Objects.Salbokning;
import AdminApplikation.Database.Objects.Tr�ning;
import AdminApplikation.Database.Objects.Utrymme;
import AdminApplikation.Gui.GUI;
import AdminApplikation.Gui.Pages;

public class BestBookingAppEver {

	private Database DB;
	private DataQuerys DBQ;
	private GUI gui;
	private Pages pages;
	
	private ArrayList<Anst�lld> anst�llda;
	private ArrayList<Person> personer;
	private ArrayList<Sal> salar;
	private ArrayList<Tr�ning> Tr�ningar;
	private ArrayList<Utrymme> Utrymmen;
	private ArrayList<Salbokning> Salbokningar;
	private ArrayList<Pos> Positioner;
	private ArrayList<Pass> pass;
	
	public BestBookingAppEver(){
		this.DB = new Database();
		this.DBQ = new DataQuerys(this, DB);
		this.gui = new GUI(this);
		this.pages = new Pages(this, DBQ, gui);
		gui.initPages();
	}
	
	public Pages getPages(){
		return pages;
	}
	
	public static void main(String[] args){
		new BestBookingAppEver();
	}

	public ArrayList<Anst�lld> getAnst�llda() {
		return anst�llda;
	}

	public ArrayList<Person> getPersoner() {
		return personer;
	}

	public ArrayList<Sal> getSalar() {
		return salar;
	}

	public ArrayList<Tr�ning> getTr�ningar() {
		return Tr�ningar;
	}

	public ArrayList<Utrymme> getUtrymmen() {
		return Utrymmen;
	}

	public ArrayList<Salbokning> getSalbokningar() {
		return Salbokningar;
	}

	public ArrayList<Pos> getPositioner() {
		return Positioner;
	}

	public ArrayList<Pass> getPass() {
		return pass;
	}

	public void setAnst�llda(ArrayList<Anst�lld> anst�llda) {
		this.anst�llda = anst�llda;
	}

	public void setPersoner(ArrayList<Person> personer) {
		this.personer = personer;
	}

	public void setSalar(ArrayList<Sal> salar) {
		this.salar = salar;
	}

	public void setTr�ningar(ArrayList<Tr�ning> tr�ningar) {
		Tr�ningar = tr�ningar;
	}

	public void setUtrymmen(ArrayList<Utrymme> utrymmen) {
		Utrymmen = utrymmen;
	}

	public void setSalbokningar(ArrayList<Salbokning> salbokningar) {
		Salbokningar = salbokningar;
	}

	public void setPositioner(ArrayList<Pos> positioner) {
		Positioner = positioner;
	}

	public void setPass(ArrayList<Pass> pass) {
		this.pass = pass;
	}
	
}
