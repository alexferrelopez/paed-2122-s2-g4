package Graph;

import Graph.MenuEnum.MenuOptionsFollowers;
import Graph.MenuEnum.MenuOptionsLinkedTree;

import java.util.Scanner;

public class UIManager {

    private final Scanner scanner;

    public UIManager () {
        scanner = new Scanner(System.in);
    }

    public MenuOptionsLinkedTree showLinkedTreeMenu () {
        do {
            System.out.println("""
                    .* LinkedTree *.
                                   
                    1. Seguidors (Grafs)
                    2. Feed (Arbres)
                    3. A ESPECIFICAR
                    4. A ESPECIFICAR
                                
                    5. Sortir
                    """);
            System.out.print("Escull una opció: ");

            try {
                int linkedTreeOption = Integer.parseInt(scanner.nextLine());
                switch (linkedTreeOption) {
                    case 1:
                        return MenuOptionsLinkedTree.SEGUIDORS;
                    case 2:
                        return MenuOptionsLinkedTree.FEED;
                    case 5:
                        return MenuOptionsLinkedTree.SORTIR;
                    default:
                        System.out.println("\nError, l'opció introduïda no és una opció vàlida.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nError, l'opció introduïda no és una opció vàlida.\n");
            }
        } while (true);
    }

    public MenuOptionsFollowers showFollowersMenu () {
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
                        return MenuOptionsFollowers.EXPLORAR;
                    case 'B':
                        return MenuOptionsFollowers.RECOMANAR;
                    case 'C':
                        return MenuOptionsFollowers.CONTEXTUALIZAR;
                    case 'D':
                        return MenuOptionsFollowers.NETWORKING;
                    case 'E':
                        return MenuOptionsFollowers.ENRERE;
                    default:
                        System.out.println("\nError, l'opció introduïda no és una opció vàlida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nError, l'opció introduïda no és una opció vàlida.");
            }
        } while (true);
    }

    public int getUserID () {
        System.out.print("\nEntra el teu identificador: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void wrongUserID () {
        System.out.println("\tL'identificador d'usuari introduït no existeix, proveu-ne un altre.");
    }

    public void showUserInformation (User u) {
        System.out.println (u);
    }

    public void showIfUserFollow () {
        System.out.println("\tMotius: Et seguiex");
    }

    public void showIfUserHasSameInterests (int num) {
        System.out.println("\tMotius: Compartiu " + num + " interessos");
    }

    public void showIfUserHasSameInterestsAndFollow (int num) {
        System.out.println("\tMotius: Compartiu " + num + " interessos i et seguiex");
    }

    public void motiusMsgUserFollowedByUserYouFollow (int num) {
        System.out.println("\tMotius: Seguit per " + num);
    }

    public void showUserFollowedByUserYouFollow (User u) {
        System.out.println(" - " + u.getName() + " ( " + u.getAlias() + " )");
    }

    public void showUserFollowAndUserFollowedByUserYouFollow () {
        System.out.println("\tMotius: Et segueix i es seguit per: " + " - ");
    }

    public void showInterestsAndUserFollowedByUserYouFollow (int num) {
        System.out.println("\tMotius: Compartiu: " + num + " i es seguit per: " + " - ");
    }

    public void showInterestsFollowedByUserYouFollowAndFollow (int num) {
        System.out.println("\tMotius: Compartiu: " + num + " i es seguit per: " + " - " + " i et segueix");
    }

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
                }
                else System.out.println("\n L'ID no existeix.");
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
                }
                else System.out.println("\n L'ID no existeix.");
            } catch (NumberFormatException e) {
                System.out.println("\nError, l'opció introduïda no és una opció vàlida. Introdueixi un nombre enter.\n");
            }
        } while (!done);

        return ids;
    }
}
