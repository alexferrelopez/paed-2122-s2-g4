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
                    default:
                        System.out.println("\nError, l'opció introduïda no és una opció vàlida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nError, l'opció introduïda no és una opció vàlida.");
            }
        } while (true);
    }
}
