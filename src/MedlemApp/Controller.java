package MedlemApp;

import MedlemApp.Model.Bokning;
import MedlemApp.Model.Medlem;
import MedlemApp.Model.Pass;

import javax.swing.*;
import java.util.List;

public class Controller {
    boolean ärMedlem = false;
    Medlem medlem;
    Repository db = new Repository();
    List<Pass> allaPass;

    public Controller() {}

    public boolean loggaIN()   {
        boolean ärInloggad = false;
        String angivetNamn = JOptionPane.showInputDialog("Ange ditt medlemsnamn:");
        try {
            medlem = db.getMedlemInfo(angivetNamn);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel vid kontroll av medlemsskap");
        }
        if (medlem.getmedlemID() > 0)   {
            JOptionPane.showMessageDialog(null, "Du är nu inloggad.");
            ärInloggad = true;
        }
        else {
            JOptionPane.showMessageDialog(null, "Inget medlem med det namnet. Försök igen.");
        }
        return ärInloggad;
    }

    public Object skapaJComboBox(List inLista)  {
        String[] tempStringArray = new String[inLista.size()];
        for(int i = 0; i < tempStringArray.length; i++)	{
            tempStringArray[i] = inLista.get(i).toString();
        }
        JComboBox jcb = new JComboBox(tempStringArray);
        JOptionPane.showMessageDialog(null, jcb);
        return inLista.get(jcb.getSelectedIndex());
    }

    public void visaBokningar() {
        medlem.setBokningar(db.getBokningar(medlem.getmedlemID()));
        List<Bokning> tempLista = medlem.getBokningar();
        Bokning medlemVal = (Bokning) skapaJComboBox(tempLista);
        taBortBokning(medlemVal.getPassID());
    }

    public void taBortBokning(int medlemVal) {
        db.avbokaBokning(medlemVal);
    }

    public void listaTillgängligaPassFörBokning() {
        allaPass = db.getTillgängligaPassFörBokning(medlem.getmedlemID());
        Pass medlemVal = (Pass) skapaJComboBox(allaPass);
        skapaBokning(medlemVal.getPassID());
    }

    public void skapaBokning(int passIDVal)  {
        db.skapaBokning(medlem.getmedlemID(), passIDVal);
    }
}
