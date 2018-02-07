package PTapp.DB;

import PTapp.Objects.*;

import java.io.FileInputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;




public class Repository {
    private Properties p = new Properties();

    public Repository() {
        try {
            this.p.load(new FileInputStream("BBE/PTapp/settings.properties"));
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }


    public List<Salbokning> getAllMedlemmar(String input) {
        List<Salbokning> bokningsLista = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery("select * from bokning\n" +
                    "inner join medlem on medlem.ID = bokning.MedlemID \n" +
                    "inner join person on person.ID = medlem.PersonID\n" +
                    "inner join pass on pass.id = bokning.PassID\n" +
                    "inner join träning on TräningsTypID = träning.ID\n" +
                    "inner join salbokning on salbokning.PassID = pass.id\n" +
                    "inner join sal on salbokning.SalID = sal.ID "+
                            " Where MedlemID =  "  + Integer.valueOf(input) +  " and  salbokning.SlutTid  < " + "'" + Timestamp.valueOf(LocalDateTime.now()) + "'" + " limit 10"


                    );

            while (rs.next()) {
                Medlem medlem = new Medlem(
                        rs.getInt("medlem.ID"),
                        rs.getInt("medlem.PersonID"),
                        new Person(
                                rs.getInt("person.ID"),
                                rs.getString("person.namn")
                        )

                );


                Pass pass = new Pass(
                        rs.getInt("pass.ID"),
                        rs.getBoolean("pass.PTPass"),
                        rs.getInt("pass.LedareID"),
                        rs.getInt("TräningsTypID")
                      );



                Sal sal = new Sal(
                        rs.getInt("sal.ID"),
                        rs.getInt("sal.UtrymmeID"),
                        rs.getString("sal.Namn")
                );

                Träning träning = new Träning(
                        rs.getInt("träning.ID"),
                rs.getString("träning.namn")
                        );

                bokningsLista.add(
                        new Salbokning(
                                rs.getInt("bokning.ID"),
                                rs.getTimestamp("salbokning.StartTid"),
                                rs.getTimestamp("salbokning.SlutTid"),

                                pass,
                                sal,
                                träning,
                                medlem



                        )

                );
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return bokningsLista;

    }







    public List<Ptn> getNotis(String inputNotis) {
        List<Ptn> notislista = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery("Select * from ptnotiser\n" +
                    "inner join Medlem on MedlemID = Medlem.id\n" +
                    "inner join person on personid = person.id\n"+
            "where medlem.ID = " + Integer.valueOf(inputNotis));

            while (rs.next()) {


                Medlem medlem = new Medlem(
                        rs.getInt("medlem.ID"),
                        rs.getInt("medlem.PersonID"),
                        new Person(
                                rs.getInt("person.ID"),
                                rs.getString("person.namn")
                        ));

                Ptn ptn = new Ptn(
                        rs.getInt("PTNotiser.ID"),
                        rs.getString("PTNotiser.Notis"),
                        rs.getInt("PTNotiser.MedlemID"),
                        rs.getInt("PTNotiser.AnställdID"),
                        medlem
                );





                notislista.add(ptn);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return notislista;
    }


    public List<Ptn> setNotis(String notis, String medlem, String anstalld) throws SQLException {
        List<Ptn> addanotislista = new ArrayList<>();

        String query = " insert into ptnotiser (Notis, MedlemID, AnställdID)"
                + " values (?, ?, ?)";

        int nynotis;

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement(query)) {


            // Detta ska man kunna ange i konsolenen som användare HUR?????
            PreparedStatement preparedStmt = con.prepareStatement(query);
            stmt.setString(1, notis);
            stmt.setInt(2, Integer.valueOf(medlem));
            stmt.setInt(3, Integer.valueOf(anstalld));

            stmt.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return addanotislista;
    }


}