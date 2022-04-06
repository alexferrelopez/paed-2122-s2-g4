import java.util.Scanner;

public class UIManager {
    private final Scanner scanner;

    public UIManager() {
        scanner = new Scanner(System.in);
    }

    public MenuOptionsLinkedTree showLinkedTreeMenu() {
        do {
            System.out.println("""
                    .* LinkedTree *.
                                   
                    1. Seguidors (Grafs)
                    2. Feed (Arbres)
                    3. Canvas (Arbres R)
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
}
