package MedlemApp.Model;

import java.util.*;


public class Medlem extends Person{

    private int medlemID;
    private List<Bokning> bokningar;

    public Medlem(int ID, int personID, String namn) {
        super(personID, namn);
        this.medlemID = ID;
    }
    public Medlem() {}

    public void setBokningar(List<Bokning> bokningar)    {
        this.bokningar = bokningar;
    }
    public List<Bokning> getBokningar() {
        return bokningar;
    }

    public int getmedlemID() {return medlemID; }
    public void setMedlemID(int medlemID) { this.medlemID = medlemID; }

}
