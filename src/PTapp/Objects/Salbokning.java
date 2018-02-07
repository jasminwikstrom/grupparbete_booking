package PTapp.Objects;

import java.sql.Timestamp;

public class Salbokning {

    private int ID;
    private Timestamp StartTid;
    private Timestamp SlutTid;
    private Pass pass;
    private Sal sal;
    private Medlem medlem;



    private Träning träning;



    public Salbokning(int ID, Timestamp startTid, Timestamp slutTid, Pass pass, Sal sal, Träning träning, Medlem medlem) {
        this.ID = ID;
        StartTid = startTid;
        SlutTid = slutTid;
        this.pass = pass;
        this.sal = sal;
        this.medlem = medlem;
        this.träning = träning;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Timestamp getStartTid() {
        return StartTid;
    }

    public void setStartTid(Timestamp startTid) {
        StartTid = startTid;
    }

    public Timestamp getSlutTid() {
        return SlutTid;
    }

    public void setSlutTid(Timestamp slutTid) {
        SlutTid = slutTid;
    }

    public Pass getPass() {
        return pass;
    }

    public void setPass(Pass pass) {
        this.pass = pass;
    }

    public Sal getSal() {
        return sal;
    }

    public void setSal(Sal sal) {
        this.sal = sal;
    }

    public Medlem getMedlem() {
        return medlem;
    }
    public void setMedlem(Medlem medlem) {
        this.medlem = medlem;
    }

    public Träning getTräning() {
        return träning;
    }

    public void setTräning(Träning träning) {
        this.träning = träning;
    }



    @Override
    public String toString() {
        return "Salbokning{" +
                "ID=" + ID +
                ", StartTid=" + StartTid +
                ", SlutTid=" + SlutTid +
                ", pass=" + pass +
                ", sal=" + sal +
                ", medlem=" + medlem +
                ", träning=" + träning +
                '}';
    }


}
