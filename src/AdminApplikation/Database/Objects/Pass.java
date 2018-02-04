package AdminApplikation.Database.Objects;

public class Pass {

	private int ID;
	private boolean PTPass;
	private int LedareID;
	private int Tr�ningsTypID;
	
	public Pass(int ID, boolean PTPass, int LedareID, int Tr�ningsTypID){
		this.ID = ID;
		this.PTPass = PTPass;
		this.LedareID = LedareID;
		this.Tr�ningsTypID = Tr�ningsTypID;
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

	public int getTr�ningsTypID() {
		return Tr�ningsTypID;
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

	public void setTr�ningsTypID(int tr�ningsTypID) {
		Tr�ningsTypID = tr�ningsTypID;
	}
	
}
