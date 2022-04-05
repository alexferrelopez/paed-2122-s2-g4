package R_Tree;

public class Rectangle {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;

    public Rectangle(double x1, double y1, double x2, double y2) {

        double tmp;

        if (x1 > x2) {
            tmp = x1;
            x1 = x2;
            x2 = tmp;
        }
        if (y1 > y2) {
            tmp = y1;
            y1 = y2;
            y2 = tmp;
        }

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double calcArea() {
        return (x2 - x1) * (y2 - y1);
    }

    public boolean isCercleInside(Cercle cercle) {
        double delta_x = x2 - x1, delta_y = y2 - y1;
        return ((cercle.getX() - x1) >= 0 && (cercle.getX() - x1) <= delta_x) && ((cercle.getY() - y1) >= 0 && (cercle.getY() - y1) <= delta_y);
    }
}