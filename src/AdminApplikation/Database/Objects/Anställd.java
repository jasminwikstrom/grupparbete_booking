package AdminApplikation.Database.Objects;

public class Anställd {

	private int ID;
	private int PersonID;
	private int PositionID;

	public Anställd(int ID, int PersonID, int PositionID){
		this.ID = ID;
		this.PersonID = PersonID;
		this.PositionID = PositionID;
	}

	public int getID() {
		return ID;
	}

	public int getPersonID() {
		return PersonID;
	}

	public int getPositionID() {
		return PositionID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setPersonID(int personID) {
		PersonID = personID;
	}

	public void setPositionID(int positionID) {
		PositionID = positionID;
	}

}
