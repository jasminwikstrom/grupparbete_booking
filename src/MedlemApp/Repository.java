package MedlemApp;

import MedlemApp.Model.Bokning;
import MedlemApp.Model.Medlem;
import MedlemApp.Model.Pass;

import javax.swing.*;
import java.sql.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Repository {
    private Properties p = new Properties();

    public Repository() {
        try {
            p.load(new FileInputStream
                    ("/Users/ohmacbook/IdeaProjects/MedlemApplikation/src/Settings.properties"));
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Medlem getMedlemInfo(String inputNamn) {
        String query = "call getMedlemInfo(?)";
        ResultSet rs = null;
        String medlemNamn = "";
        Medlem medlem = new Medlem();
        int medlemID = 0;
        int personID= 0;

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
                PreparedStatement stmt = con.prepareStatement(query);) {
            stmt.setString(1, inputNamn);
            rs = stmt.executeQuery();

            while (rs.next())   {
                medlemID = rs.getInt(1);
                personID = rs.getInt(2);
                medlemNamn = rs.getString(3);
                medlem = new Medlem(medlemID, personID, medlemNamn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medlem;
    }

    public List<Bokning> getBokningar(int memberID) {
        List<Bokning> bokningar = new ArrayList<>();
        String query = "call getBokningar(?)";
        ResultSet rs = null;

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
                PreparedStatement stmt = con.prepareStatement(query);) {
            stmt.setInt(1, memberID);
            rs = stmt.executeQuery();

            while (rs.next())   {
                Bokning bokning = new Bokning();
                bokning.setBokningID(rs.getInt(1));
                bokning.setNärvarat(rs.getBoolean(2));
                bokning.setMedlemID(rs.getInt(3));
                bokning.setPassID(rs.getInt(4));
                bokningar.add(bokning);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bokningar;
    }

    public void avbokaBokning(int kundVal)  {
        String query = "call cancelBokning(?)";
        ResultSet rs = null;
        String db_meddelande = " ";

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
                PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, kundVal);
            rs = stmt.executeQuery();

            while (rs.next())   {
                db_meddelande = rs.getString(1);
            }
            if(!db_meddelande.equals(" "))   {
                JOptionPane.showMessageDialog(null, db_meddelande);
            }
        }
        catch(SQLException e)   {
            e.printStackTrace();
            System.out.println(e.getMessage() + " (" + e.getErrorCode() + ").");
        }
    }

    public List<Pass> getTillgängligaPassFörBokning(int medlemID)    {
        String query = "call tillgängligaPassFörBokning(?)";
        ResultSet rs = null;
        List<Pass> allaPass = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
                PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, medlemID);
            rs = stmt.executeQuery();

            while (rs.next())   {
                Pass pass = new Pass();
                pass.setPassID(rs.getInt(1));
                pass.setÄrPTpass(rs.getBoolean(2));
                pass.setLedare(rs.getString(3));
                pass.setTräningstyp(rs.getString(4));
                pass.setSal(rs.getString(5));
                pass.setStarttid(rs.getTimestamp(6));
                pass.setSluttid(rs.getTimestamp(7));
                pass.setMaxAntal(rs.getInt(8));
                pass.setBokade(rs.getInt(9));

                if(pass.getMaxAntal() > pass.getBokade()) {
                    allaPass.add(pass);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allaPass;
    }

    public void skapaBokning(int medlemID, int passIDVal) {
        String query = "call skapaBokning(?, ?)";
        ResultSet rs = null;
        String db_meddelande = " ";

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
                PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, medlemID);
            stmt.setInt(2, passIDVal);
            rs = stmt.executeQuery();

            while (rs.next())   {
                db_meddelande = rs.getString(1);
            }
            if(!db_meddelande.equals(" "))   {
                System.out.println(db_meddelande);
            }
        }
        catch(SQLException e)   {
            e.printStackTrace();
            System.out.println(e.getMessage() + " (" + e.getErrorCode() + ").");
        }
    }
}



