package AdminApplikation.Database.Objects;

public class Pos {

	private int ID;
	private String Position;
	private String Beh�righet;
	
	public Pos(int ID, String Position, String Beh�righet){
		this.ID = ID;
		this.Position = Position;
		this.Beh�righet = Beh�righet;
	}

	public int getID() {
		return ID;
	}

	public String getPosition() {
		return Position;
	}

	public String getBeh�righet() {
		return Beh�righet;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public void setBeh�righet(String beh�righet) {
		Beh�righet = beh�righet;
	}
	
	public String toString(){
		return Position;
	}
	
}
