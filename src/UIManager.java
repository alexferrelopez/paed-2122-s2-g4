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
                    2. A ESPECIFICAR
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

    public int getUserID (int size) {
        int inputSize;

        //do {
            System.out.print("\nEntra el teu identificador: ");
            inputSize = Integer.parseInt(scanner.nextLine());
        //} while (inputSize > (size - 1) || inputSize < 0);

        return inputSize;
    }
}
