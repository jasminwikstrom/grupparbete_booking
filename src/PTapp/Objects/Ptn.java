package PTapp.Objects;

public class Ptn {

    private int ID;
    private String Notis;
    private int MedlemID;
    private int AnställdID;
    private Medlem medlem;


    public Ptn(int ID, String notis, int medlemID, int anställdID, Medlem medlem) {
        this.ID = ID;
        Notis = notis;
        MedlemID = medlemID;
        AnställdID = anställdID;
        this.medlem = medlem;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNotis() {
        return Notis;
    }

    public void setNotis(String notis) {
        Notis = notis;
    }

    public int getMedlemID() {
        return MedlemID;
    }

    public void setMedlemID(int medlemID) {
        MedlemID = medlemID;
    }

    public int getAnställdID() {
        return AnställdID;
    }

    public void setAnställdID(int anställdID) {
        AnställdID = anställdID;
    }

    public Medlem getMedlem() {
        return medlem;
    }

    public void setMedlem(Medlem medlem) {
        this.medlem = medlem;
    }

    @Override
    public String toString() {
        return "Ptn{" +
                "ID=" + ID +
                ", Notis='" + Notis + '\'' +
                ", MedlemID=" + MedlemID +
                ", AnställdID=" + AnställdID +
                ", medlem=" + medlem +
                '}';
    }
}
