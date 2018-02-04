package AdminApplikation.Database.Objects;

public class Pos {

	private int ID;
	private String Position;
	private String Behörighet;
	
	public Pos(int ID, String Position, String Behörighet){
		this.ID = ID;
		this.Position = Position;
		this.Behörighet = Behörighet;
	}

	public int getID() {
		return ID;
	}

	public String getPosition() {
		return Position;
	}

	public String getBehörighet() {
		return Behörighet;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public void setBehörighet(String behörighet) {
		Behörighet = behörighet;
	}
	
	public String toString(){
		return Position;
	}
	
}
