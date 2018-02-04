package AdminApplikation.Database.Objects;

import java.sql.Timestamp;
import java.util.Date;

public class Salbokning {

	private int ID;
	private Timestamp StartTid;
	private Timestamp SlutTid;
	private int PassID;
	private int SalID;
	
	public Salbokning(int ID, Timestamp StartTid, Timestamp SlutTid, int PassID, int SalID){
		this.ID = ID;
		this.StartTid = StartTid;
		this.SlutTid = SlutTid;
		this.PassID = PassID;
		this.SalID = SalID;
	}

	public int getID() {
		return ID;
	}

	public Date getStartTid() {
		return StartTid;
	}

	public Date getSlutTid() {
		return SlutTid;
	}

	public int getPassID() {
		return PassID;
	}

	public int getSalID() {
		return SalID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setStartTid(Timestamp startTid) {
		StartTid = startTid;
	}

	public void setSlutTid(Timestamp slutTid) {
		SlutTid = slutTid;
	}

	public void setPassID(int passID) {
		PassID = passID;
	}

	public void setSalID(int salID) {
		SalID = salID;
	}
	
}
