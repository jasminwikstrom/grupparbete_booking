package PTapp.Objects;

public class Träning {

    private int ID;
    private String namn;

    public Träning(int ID, String namn) {
        this.ID = ID;
        this.namn = namn;
    }

    public int getID() {
        return ID;
    }



    public void setID(int iD) {
        ID = iD;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    @Override
    public String toString() {
        return "Träning{" +
                "ID=" + ID +
                ", namn='" + namn + '\'' +
                '}';
    }

    public String getNamn() {
        return namn;
    }

}