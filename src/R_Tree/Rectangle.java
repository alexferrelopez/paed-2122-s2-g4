package R_Tree;

import java.util.List;

public class Rectangle {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private List<Rectangle> nodes;
    private List<Cercle> fulles;
    public Rectangle(double x1, double y1, double x2, double y2, List<Rectangle> nodes, List<Cercle> fulles) {

        this.nodes = nodes;
        this.fulles = fulles;
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

    public double newArea(Double x1, Double y1) {
        Rectangle temp = new Rectangle(x1, y1, x2, y2, null, null);
        if (x1 < this.x1) {
            temp.x1 = x1;
        } else if (x1 > this.x2) {
            temp.x2 = x1;
        }

        if (y1 < this.y1) {
            temp.y1 = y1;
        } else if (y1 > this.y2) {
            temp.y2 = y1;
        }
        return Math.abs(calcArea() - temp.calcArea());
    }

    public List<Cercle> getFulles() {
        return fulles;
    }

    public void setFulles(List<Cercle> fulles) {
        this.fulles = fulles;
    }

    public List<Rectangle> getNodes() {
        return nodes;
    }

    public void setNodes(List<Rectangle> nodes) {
        this.nodes = nodes;
    }

    public void updateArea() {

        double minX = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double minY = Double.MAX_VALUE;
        double maxY = Double.MIN_VALUE;

        if (fulles.isEmpty() && !nodes.isEmpty()) {
            for (Rectangle node : nodes) {
                if (node.x1 < minX) {
                    minX = node.x1;
                }
                if (node.x2 > maxX) {
                    maxX = node.x2;
                }
                if (node.y1 < minY) {
                    minY = node.y1;
                }
                if (node.y2 > maxY) {
                    maxY = node.y2;
                }
            }
        }
        else {
            for (Cercle fulla : fulles) {
                if (fulla.getX() < minX) {
                    minX = fulla.getX();
                }
                if (fulla.getX() > maxX) {
                    maxX = fulla.getX();
                }
                if (fulla.getY() < minY) {
                    minY = fulla.getY();
                }
                if (fulla.getY() > maxY) {
                    maxY = fulla.getY();
                }
            }
        }
        x1 = minX;
        x2 = maxX;
        y1 = minY;
        y2 = maxY;
    }
}