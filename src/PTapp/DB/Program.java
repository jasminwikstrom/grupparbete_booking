package PTapp.DB;

import PTapp.Objects.Ptn;
import PTapp.Objects.Salbokning;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String args[]) throws SQLException {

        Repository r = new Repository();
        Scanner scanner = new Scanner(System.in);
        boolean keepAlive = true;
        while (keepAlive) {
            List<Salbokning> medlemmarLista = new ArrayList<>();
            List<Ptn> notisLista = new ArrayList<>();
            new ArrayList();
            new ArrayList();




            System.out.println("\n");
            System.out.println("Välj ditt alternativ");
            System.out.println("===============================");
            System.out.println("1: Söka medlem");
            System.out.println("2: söka Notis");
            System.out.println("3: Gör notis");
            System.out.println(("4: Avsluta"));

            String input = scanner.next();
            String inputNotis;


            if (input.equalsIgnoreCase("1")) {
                System.out.println("ange id");
                input = scanner.next();
                 medlemmarLista= r.getAllMedlemmar(input);
                medlemmarLista.forEach(salbokning -> System.out.println("Person: " + salbokning.getMedlem().getPerson()+ "\n Datum: " + salbokning.getSlutTid() + "\n Träningstyp: " + salbokning.getTräning().getNamn().toString() + "\n================================"));

            } else if (input.equalsIgnoreCase("2")) {
                System.out.println("ange id för medlem du vill se");
                inputNotis = scanner.next();
                notisLista= r.getNotis(inputNotis);
                notisLista.forEach(notis -> System.out.println("Person: " + notis.getMedlem().getPerson() + "\nNotis: " + notis.getNotis().toString() + "\n================================"));

            }
            else if (input.equalsIgnoreCase("3")) {

                Scanner sc = new Scanner(System.in);

                System.out.println("Skriv en notis");
                String notisen = sc.nextLine().trim();

                System.out.println("Skriv medlemsid");
                String medlem = sc.nextLine();

                System.out.println("Skriv anställdid");
                String anstalld = sc.nextLine();

                r.setNotis(notisen, medlem, anstalld);

                System.out.println("Notis sparad");
            }

            else if (input.equalsIgnoreCase("4")) {
                keepAlive = false;

            }

            }
        }


    }






