package MedlemApp.Model;


public class Bokning {

    private int bokningID;
    private boolean närvarat;
    private int medlemID;
    private int passID;

    public Bokning(int bokningID, boolean närvarat, int medlemID, int passID) {
        this.bokningID = bokningID;
        this.närvarat = närvarat;
        this.medlemID = medlemID;
        this.passID = passID;
    }
    public Bokning()    {}

    public int getBokningID() { return bokningID; }
    public boolean isNärvarat() { return närvarat; }
    public int getMedlemID() { return medlemID; }
    public int getPassID() { return passID; }

    public void setBokningID(int bokningID) { this.bokningID = bokningID; }
    public void setNärvarat(boolean närvarat) { this.närvarat = närvarat; }
    public void setMedlemID(int medlemID) { this.medlemID = medlemID; }
    public void setPassID(int passID) { this.passID = passID; }

    @Override
    public String toString() {
        return  "bokningID=" + bokningID +
                ", närvarat=" + närvarat +
                ", medlemID=" + medlemID +
                ", passID=" + passID;
    }
}
