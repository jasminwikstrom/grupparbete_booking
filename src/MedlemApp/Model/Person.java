package MedlemApp.Model;

abstract public class Person {

    private int personID;
    private String namn;

    public Person(int personID, String namn) {
        this.personID = personID;
        this.namn = namn;
    }

    public Person() {
    }

    public void setpersonID(int iD) {
        personID = iD;
    }

    public int getpersonID() {
        return personID;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getNamn() {
        return namn;
    }

    public String toString() {
        return namn;
    }
}

