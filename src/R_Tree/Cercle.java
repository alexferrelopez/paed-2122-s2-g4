package R_Tree;

import java.awt.*;

/**
 * Representa una fulla de la nostra estructura de l'arbre R.
 */
public class Cercle extends Figura{
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public double calcMaxX(Double x) {
        return Math.max(this.x, x);
    }

    @Override
    public double calcMaxY(Double y) {
        return Math.max(this.y, y);
    }

    @Override
    public double calcMinX(Double x) {
        return Math.min(this.x, x);
    }

    @Override
    public double calcMinY(Double y) {
        return Math.min(this.y, y);
    }

    @Override
    public double[] getCenter() {
        return new double[] {x,y};
    }
}