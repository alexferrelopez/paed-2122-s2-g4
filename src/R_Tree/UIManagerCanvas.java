package R_Tree;

import java.util.Scanner;

import static R_Tree.MenuOptionsCanvas.*;

public class UIManagerCanvas {
    private final Scanner scanner;

    public UIManagerCanvas() {
        scanner = new Scanner(System.in);
    }

    public MenuOptionsCanvas showCanvasMenu() {
        do {
            System.out.println("""
                                   
                    \tA. Afegir cercle
                    \tB. Eliminar cercle
                    \tC. Visualitzar
                    \tD. Cerca per àrea
                    \tE. Cerca especial
                      
                    \tF. Tornar enrere
                    """);
            System.out.print("Quina funcionalitat vols executar? ");

            try {
                char option = scanner.next().charAt(0);
                scanner.nextLine();

                switch (option) {
                    case 'A':
                        return AFEGIR;
                    case 'B':
                        return ELIMINAR;
                    case 'C':
                        return VISUALITZAR;
                    case 'D':
                        return CERCA_AREA;
                    case 'E':
                        return CERCA_ESPECIAL;
                    case 'F':
                        return BACK;
                    default:
                        System.out.println("\nError, l'opció introduïda no és una opció vàlida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nError, l'opció introduïda no és una opció vàlida.");
            }
        } while (true);
    }
}
