package PTapp.Objects;

public class Sal {

    private int ID;
    private int UtrymmeID;
    private String namn;

    public Sal(int ID, int UtrymmeID, String namn){
        this.ID = ID;
        this.UtrymmeID = UtrymmeID;
        this.namn = namn;
    }

    public int getID() {
        return ID;
    }

    public int getUtrymmeID() {
        return UtrymmeID;
    }

    public String getNamn() {
        return namn;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public void setUtrymmeID(int utrymmeID) {
        UtrymmeID = utrymmeID;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    @Override
    public String toString() {
        return "Sal{" +
                "ID=" + ID +
                ", UtrymmeID=" + UtrymmeID +
                ", namn='" + namn + '\'' +
                '}';
    }
}