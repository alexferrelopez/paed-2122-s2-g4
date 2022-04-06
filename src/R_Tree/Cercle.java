package R_Tree;

import java.awt.*;

/**
 * Representa una fulla de la nostra estructura de l'arbre R.
 */
public class Cercle {
    private final double x;
    private final double y;
    private final double radi;
    private final Color color;

    public Cercle(double x, double y, double radi, String color) {
        this.x = x;
        this.y = y;
        this.radi = radi;
        this.color = Color.decode(color);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadi() {
        return radi;
    }

    public Color getColor() {
        return color;
    }

    public boolean isSimilarColor(Color color) {
        return Math.abs((color.getRed()) - (this.color.getRed())) < 15 &&
                Math.abs((color.getGreen()) - (this.color.getGreen())) < 15 &&
                Math.abs((color.getBlue()) - (this.color.getBlue())) < 15;
    }
}