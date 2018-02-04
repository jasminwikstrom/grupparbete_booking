package AdminApplikation.Database.Objects;

public class Pass {

	private int ID;
	private boolean PTPass;
	private int LedareID;
	private int TräningsTypID;
	
	public Pass(int ID, boolean PTPass, int LedareID, int TräningsTypID){
		this.ID = ID;
		this.PTPass = PTPass;
		this.LedareID = LedareID;
		this.TräningsTypID = TräningsTypID;
	}

	public int getID() {
		return ID;
	}

	public boolean isPTPass() {
		return PTPass;
	}

	public int getLedareID() {
		return LedareID;
	}

	public int getTräningsTypID() {
		return TräningsTypID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setPTPass(boolean pTPass) {
		PTPass = pTPass;
	}

	public void setLedareID(int ledareID) {
		LedareID = ledareID;
	}

	public void setTräningsTypID(int träningsTypID) {
		TräningsTypID = träningsTypID;
	}
	
}
