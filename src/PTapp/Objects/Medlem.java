package PTapp.Objects;


public class Medlem {

    private int ID;
    private int PersonID;
    private Person person;


    public Medlem(int ID, int PersonID, Person person){
        this.ID = ID;
        this.PersonID = PersonID;
        this.person = person;

    }

    public int getID() {
        return ID;
    }

    public int getPersonID() {
        return PersonID;
    }



    public void setID(int iD) {
        ID = iD;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }

    public Object getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }




    @Override
    public String toString() {
        return "Medlem{" +
                "ID=" + ID +
                ", PersonID=" + PersonID +
                ", person=" + person+
                '}';
    }
}


