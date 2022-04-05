package Tree;


import java.util.Scanner;

public class UIManagerTree {
    private final Scanner scanner;

    /**
     * Constructor of the UIManager of the tree
     * Initializing the scanner to get inputs.
     */

    public UIManagerTree() {
        scanner = new Scanner(System.in);
    }

    /**
     * Method to manage the options of the tree menu
     * showing and asking input of the menu options.
     *
     * @return the option that user wants to execute.
     */

    public MenuOptionsTree showTreeMenu() {
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

    /**
     * Method to create a node asking the necessary information
     * to generate the new node.
     *
     * @return the new node with all the information.
     */

    public Node createNode() {
        long id, timestamp;
        String name, algorithm, cost;

        System.out.print("Identificador de l'algorisme: ");
        id = Long.parseLong(scanner.nextLine());

        System.out.print("Nom de l'algorisme: ");
        name = scanner.nextLine();

        System.out.print("Llenguatge de l'algorisme: ");
        algorithm = scanner.nextLine();

        System.out.print("Cost de l'algorisme: ");
        cost = scanner.nextLine();

        System.out.print("Timestamp de l'algorisme: ");
        timestamp = Long.parseLong(scanner.nextLine());

        System.out.println("\nL'algorisme ha estat correctament afegit al feed.");

        return new Node(id, name, algorithm, cost, timestamp);
    }

    /**
     * Method to get the id of the algorithm that
     * User wants to delete.
     *
     * @return the id of the node.
     */

    public Long deleteNode() {
        System.out.print("Identificador de l'algorisme: ");
        return Long.parseLong(scanner.nextLine());
    }

    //-------------------------------------- LIST ALGORITHM -----------------------------------------------//

    /**
     * Method to print the algorithm as it is required.
     *
     * @param name of the algorithm
     * @param lang of the algorithm
     * @param cost of the algorithm
     * @param time of the algorithm
     */

    public void printAlgorithm(String name, String lang, String cost, String time) {
        System.out.println(name + ": " + lang + ", " + cost + " - " + time);
    }

    //---------------------------------- EXACT TIMESTAMP ALGORITHM ---------------------------------------//

    /**
     * Method to get the timestamp that the user
     * want to search.
     *
     * @return the timestamp that has to be searched.
     */

    public long getExactTimestamp() {
        System.out.print("Timestamp a cercar: ");
        return Long.parseLong(scanner.nextLine());
    }

    /**
     * Method to show a message when the exact timestamp has been found.
     *
     * @param name of the algorithm
     * @param lang of the algorithm
     * @param cost of the algorithm
     */

    public void printExactTimestampAlgorithm(String name, String lang, String cost) {
        System.out.println("\nS'ha trobat un algorisme... " + name + ": " + lang + ", " + cost);
    }

    //---------------------------------- RANG TIMESTAMP ALGORITHM ---------------------------------------//

    /**
     * Method to get the minimum timestamp that user
     * insert to search the timestamp range.
     *
     * @return the minimum timestamp.
     */

    public long getMinimTimestamp() {
        System.out.print("Timestamp mínim a cercar: ");
        return Long.parseLong(scanner.nextLine());
    }

    /**
     * Method to get the maximum timestamp that user
     * insert to search the timestamp range.
     *
     * @return the maximum timestamp.
     */

    public long getMaximTimestamp() {
        System.out.print("Timestamp màxim a cercar: ");
        return Long.parseLong(scanner.nextLine());
    }

    /**
     * Method to show message when you find the number of algorithms in a certain range.
     *
     * @param num of algorithms to print.
     */

    public void algorithmFoundMessage(int num) {
        System.out.println("\nS'han trobat " + num + " algorismes en aquest rang...\n");
    }

    /**
     * Method to show the message of the algorithm when you are searching
     * timestamp in a specific range.
     *
     * @param name of the algorithm
     * @param lang of the algorithm
     * @param cost of the algorithm
     * @param time of the algorithm
     */

    public void printRangTimestampAlgorithm(String name, String lang, String cost, String time) {
        System.out.println("\t" + name + ": " + lang + ", " + cost + " - " + time);
    }

}
