package Tree;


import java.util.Scanner;

public class UIManagerTree {
    private final Scanner scanner;

    public UIManagerTree () {
        scanner = new Scanner(System.in);
    }

    public MenuOptionsTree showTreeMenu () {
        do {
            System.out.println("""
                                   
                    \tA. Afegir algorisme
                    \tB. Eliminar algorisme
                    \tC. Llistar algorismes
                    \tD. Cerca per timestamp (exacta)
                    \tE. Cerca per timestamp (rang)
                    
                    \tF. Tornar enrere
                    """);
            System.out.print("Quina funcionalitat vols executar? ");

            try {
                char option = scanner.next().charAt(0);
                scanner.nextLine();

                System.out.println();

                switch (option) {
                    case 'A':
                        return MenuOptionsTree.AFEGIR;
                    case 'B':
                        return MenuOptionsTree.ELIMINAR;
                    case 'C':
                        return MenuOptionsTree.LISTAR;
                    case 'D':
                        return MenuOptionsTree.CERCA_EXACTA;
                    case 'E':
                        return MenuOptionsTree.CERCA_RANG;
                    case 'F':
                        return MenuOptionsTree.BACK;
                    default:
                        System.out.println("\nError, l'opció introduïda no és una opció vàlida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nError, l'opció introduïda no és una opció vàlida.");
            }
        } while (true);
    }

    //-------------------------------------- ADD ALGORITHM -----------------------------------------------//

    public Node createNode () {
        long id, timestamp;
        String name, algorithm, cost;

        System.out.print ("Identificador de l'algorisme: ");
        id = Long.parseLong(scanner.nextLine());

        System.out.print ("Nom de l'algorisme: ");
        name = scanner.nextLine();

        System.out.print ("Llenguatge de l'algorisme: ");
        algorithm = scanner.nextLine();

        System.out.print ("Cost de l'algorisme: ");
        cost = scanner.nextLine();

        System.out.print ("Timestamp de l'algorisme: ");
        timestamp = Long.parseLong(scanner.nextLine());

        System.out.println("\nL'algorisme ha estat correctament afegit al feed.");

        return new Node (id, name, algorithm, cost, timestamp);
    }

    //-------------------------------------- LIST ALGORITHM -----------------------------------------------//

    public void printAlgorithm (String name, String lang, String cost, String time) {
        System.out.println(name + ": " + lang + ", " + cost + " - " + time);
    }

    //---------------------------------- EXACT TIMESTAMP ALGORITHM ---------------------------------------//

    public long getExactTimestamp () {
        System.out.print ("Timestamp a cercar: ");
        return Long.parseLong(scanner.nextLine());
    }

    public void printExactTimestampAlgorithm (String name, String lang, String cost) {
        System.out.println ("\nS'ha trobat un algorisme... " + name + ": " + lang + ", " + cost);
    }

    //---------------------------------- RANG TIMESTAMP ALGORITHM ---------------------------------------//

    public long getMinimTimestamp () {
        System.out.print ("Timestamp mínim a cercar: ");
        return Long.parseLong(scanner.nextLine());
    }

    public long getMaximTimestamp () {
        System.out.print ("Timestamp màxim a cercar: ");
        return Long.parseLong(scanner.nextLine());
    }

    public void algorithmFoundMessage (int num) {
        System.out.println("\nS'han trobat " + num + " algorismes en aquest rang...\n");
    }

    public void printRangTimestampAlgorithm (String name, String lang, String cost, String time) {
        System.out.println ("\t" + name + ": " + lang + ", " + cost + " - " + time);
    }

}
