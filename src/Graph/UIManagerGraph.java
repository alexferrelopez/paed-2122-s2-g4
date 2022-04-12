package Graph;

import java.util.Scanner;

import static Graph.MenuOptionsFollowers.*;

public class UIManagerGraph {

    private final Scanner scanner;

    /**
     *
     * Constructor of the class where we initialize the scanner to get inputs.
     *
     */

    public UIManagerGraph() {
        scanner = new Scanner(System.in);
    }

    /**
     *
     * Method to show the options for the graph menu.
     *
     * @return the options of the graph menu.
     *
     */

    public MenuOptionsFollowers showFollowersMenu() {
        do {
            System.out.println("""
                                   
                    \tA. Explorar la xarxa
                    \tB. Recomanar usuaris
                    \tC. Contextualizar drama
                    \tD. Networking
                                
                    \tE. Tornar enrere
                    """);
            System.out.print("Quina funcionalitat vols executar? ");

            try {
                char option = scanner.next().charAt(0);
                scanner.nextLine();

                switch (option) {
                    case 'A':
                        return EXPLORAR;
                    case 'B':
                        return RECOMANAR;
                    case 'C':
                        return CONTEXTUALIZAR;
                    case 'D':
                        return NETWORKING;
                    case 'E':
                        return ENRERE;
                    default:
                        System.out.println("\nError, l'opció introduïda no és una opció vàlida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nError, l'opció introduïda no és una opció vàlida.");
            }
        } while (true);
    }

    /**
     *
     * Method to get as input the id of the user.
     *
     * @return the is of the user as integer.
     *
     */

    public int getUserID() {
        System.out.print("\nEntra el teu identificador: ");
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     *
     * Method to show an error message if the id is wrong.
     *
     */

    public void wrongUserID() {
        System.out.println("\tL'identificador d'usuari introduït no existeix, proveu-ne un altre.");
    }

    /**
     *
     * Method to show the user information.
     *
     * @param u the user.
     *
     */

    public void showUserInformation(User u) {
        System.out.println(u);
    }

    /**
     *
     * Method to show a message if a user follow you.
     *
     */

    public void showIfUserFollow() {
        System.out.println("\tMotius: Et seguiex");
    }

    /**
     *
     * Method to show if a user has the same interests of another user.
     *
     * @param num number of interests.
     *
     */

    public void showIfUserHasSameInterests(int num) {
        System.out.println("\tMotius: Compartiu " + num + " interessos");
    }

    /**
     *
     * Method to show a message if the user has same interests and follow him.
     *
     * @param num number of interests.
     *
     */

    public void showIfUserHasSameInterestsAndFollow(int num) {
        System.out.println("\tMotius: Compartiu " + num + " interessos i et seguiex");
    }

    /**
     *
     * Method to show a message the users followed by user you follow
     *
     * @param num number of users that follow you.
     *
     */

    public void motiusMsgUserFollowedByUserYouFollow(int num) {
        System.out.println("\tMotius: Seguit per " + num);
    }

    /**
     *
     * Method to print each user that is followed by user you follow.
     *
     * @param u User to get the users.
     *
     */

    public void showUserFollowedByUserYouFollow(User u) {
        System.out.println(" - " + u.getName() + " ( " + u.getAlias() + " )");
    }

    /**
     *
     * Method to show a message that a user follow you and is followed by other users.
     *
     */

    public void showUserFollowAndUserFollowedByUserYouFollow() {
        System.out.println("\tMotius: Et segueix i es seguit per: " + " - ");
    }

    /**
     *
     * Method to show a message if you have the same interests of another user and if the
     * user is followed by other users.
     *
     * @param num number of interests.
     *
     */

    public void showInterestsAndUserFollowedByUserYouFollow(int num) {
        System.out.println("\tMotius: Compartiu: " + num + " i es seguit per: " + " - ");
    }

    /**
     *
     * Method to show a message if users has same interests, is followed and follow other users.
     *
     * @param num number of interests.
     *
     */

    public void showInterestsFollowedByUserYouFollowAndFollow(int num) {
        System.out.println("\tMotius: Compartiu: " + num + " i es seguit per: " + " - " + " i et segueix");
    }

    /**
     *
     * Method to request to the user the id to do the networking function.
     *
     * @param graph all the users that are in the graph.
     *
     * @return the array with the id numbers of the users.
     *
     */

    public int[] requestUsersNetworking(Graph graph) {
        boolean done = false;
        int[] ids = new int[2];

        do {
            System.out.print("\nEntra el teu identificador: ");
            try {
                ids[0] = Integer.parseInt(scanner.nextLine());
                boolean idExists = graph.idExists(ids[0]);
                if (idExists) {
                    done = true;
                } else System.out.println("\n L'ID no existeix.");
            } catch (NumberFormatException e) {
                System.out.println("\nError, l'opció introduïda no és una opció vàlida. Introdueixi un nombre enter.");
            }
        } while (!done);

        done = false;

        do {
            System.out.print("\nEntra l'identificador de l'altre usuari: ");
            try {
                ids[1] = Integer.parseInt(scanner.nextLine());
                boolean idExists = graph.idExists(ids[1]);
                if (idExists) {
                    done = true;
                } else System.out.println("\n L'ID no existeix.");
            } catch (NumberFormatException e) {
                System.out.println("\nError, l'opció introduïda no és una opció vàlida. Introdueixi un nombre enter.\n");
            }
        } while (!done);

        return ids;
    }
}
