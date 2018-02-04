package AdminApplikation.Database.Objects;

public class Utrymme {

	private int ID;
	private int Antal;
	
	public Utrymme(int ID, int Antal){
		this.ID = ID;
		this.Antal = Antal;
	}
	
	public int getID() {
		return ID;
	}

	public int getAntal() {
		return Antal;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setAntal(int antal) {
		Antal = antal;
	}	
}
