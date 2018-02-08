package MedlemApp.Model;

import java.sql.Timestamp;

public class Pass {

    int passID;
    boolean ärPTpass;
    String ledare;
    String träningstyp;
    String sal;
    Timestamp starttid;
    Timestamp sluttid;
    int maxAntal;
    int bokade;

    public Pass()   {}

    public Pass(int passID, boolean ärPTpass, String ledare, String träningstyp,
                String sal, Timestamp starttid, Timestamp sluttid, int maxAntal, int bokade) {
        this.passID = passID;
        this.ärPTpass = ärPTpass;
        this.ledare = ledare;
        this.träningstyp = träningstyp;
        this.sal = sal;
        this.starttid = starttid;
        this.sluttid = sluttid;
        this.maxAntal = maxAntal;
        this.bokade = bokade;
    }
    public int getPassID() { return passID; }

    public boolean isÄrPTpass() { return ärPTpass; }

    public String getLedare() { return ledare; }

    public String getTräningstyp() { return träningstyp; }

    public String getSal() { return sal; }

    public Timestamp getStarttid() { return starttid; }

    public Timestamp getSluttid() { return sluttid; }

    public void setPassID(int passID) { this.passID = passID; }

    public void setÄrPTpass(boolean ärPTpass) { this.ärPTpass = ärPTpass; }

    public void setLedare(String ledare) { this.ledare = ledare; }

    public void setTräningstyp(String träningstyp) { this.träningstyp = träningstyp; }

    public void setSal(String sal) { this.sal = sal; }

    public void setStarttid(Timestamp starttid) { this.starttid = starttid; }

    public void setSluttid(Timestamp sluttid) { this.sluttid = sluttid; }

    public int getMaxAntal() { return maxAntal; }

    public void setMaxAntal(int maxAntal) { this.maxAntal = maxAntal; }

    public int getBokade() { return bokade;}

    public void setBokade(int bokade) { this.bokade = bokade; }

    @Override
    public String toString() {
        return  "passID=" + passID +
                ", ärPTpass=" + ärPTpass +
                ", ledare='" + ledare + '\'' +
                ", träningstyp='" + träningstyp + '\'' +
                ", sal='" + sal + '\'' +
                ", starttid=" + starttid +
                ", sluttid=" + sluttid +
                ", maxAntal=" + maxAntal +
                ", bokade=" + bokade;
    }
}
