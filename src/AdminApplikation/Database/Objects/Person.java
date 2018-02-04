package AdminApplikation.Database.Objects;

public class Person {

	private int ID;
	private String namn;
	
	public Person(int ID, String namn) {
		this.ID = ID;
		this.namn = namn;
	}

	public int getID() {
		return ID;
	}

	public String getNamn() {
		return namn;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}
	public String toString(){
		return namn;
	}
}
