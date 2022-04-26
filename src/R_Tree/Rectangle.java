package R_Tree;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Figura{
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private List<Figura> nodes;

    public Rectangle(double x1, double y1, double x2, double y2, List<Figura> nodes) {
        this.nodes = nodes;
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

    public Rectangle(double[] center) {
        this.nodes = new ArrayList<>();

        this.x1 = center[0];
        this.y1 = center[1];
        this.x2 = center[0];
        this.y2 = center[1];
    }

    public double calcPerimeter() {
        return (x2 - x1) * 2 + (y2 - y1) * 2 ;
    }

    public boolean isCercleInside(Cercle cercle) {
        double delta_x = x2 - x1, delta_y = y2 - y1;
        return ((cercle.getX() - x1) >= 0 && (cercle.getX() - x1) <= delta_x) && ((cercle.getY() - y1) >= 0 && (cercle.getY() - y1) <= delta_y);
    }

    public double newPerimeter(Figura figura) {
        Rectangle temp = new Rectangle(x1, y1, x2, y2, null);

        temp.x1 = figura.calcMinX(x1);
        temp.y1 = figura.calcMinY(y1);
        temp.x2 = figura.calcMaxX(x2);
        temp.y2 = figura.calcMaxY(y2);

        return Math.abs(calcPerimeter() - temp.calcPerimeter());
    }

    public void updateArea() {
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        for (Figura node : nodes) {
                minX = node.calcMinX(minX);
                minY = node.calcMinY(minY);
                maxX = node.calcMaxX(maxX);
                maxY = node.calcMaxY(maxY);
        }

        x1 = minX;
        x2 = maxX;
        y1 = minY;
        y2 = maxY;
    }

    public List<Figura> getNodes() {
        return nodes;
    }

    public void setNodes(List<Figura> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Figura newNode) {
        newNode.setParent(this);
        nodes.add(newNode);

        updateArea();
    }

    public int[] calcFurthestFigures() {
        int[] indexes = new int[2];

        double min = Double.MIN_VALUE;

        for (Figura node : nodes) {
            double[] center = node.getCenter();

            for (Figura figura : nodes) {
                double[] point = figura.getCenter();
                double distance = distance(point[0], point[1], center[0], center[1]);
                if (distance > min) {
                    min = distance;
                    indexes[0] = getNodes().indexOf(node);
                    indexes[1] = getNodes().indexOf(figura);
                }
            }
        }
        return indexes;
    }

    private double distance(double x1, double y1, double x2, double y2) {
        double x = x1 - x2;
        double y = y1 - y2;

        return x * x + y * y;
    }

    @Override
    public double calcMaxX(Double x) {
        return Math.max(x2, x);
    }

    @Override
    public double calcMaxY(Double y) {
        return Math.max(y2, y);
    }

    @Override
    public double calcMinX(Double x) {
        return Math.min(x1,x);
    }

    @Override
    public double calcMinY(Double y) {
        return Math.min(y1, y);
    }

    @Override
    public double[] getCenter() {
        double[] coords = new double[2];

        coords[0] = (x1 + x2) / 2;
        coords[1] = (y1 + y2) / 2;

        return coords;
    }

    @Override
    public String toString() {
        return "R: " + nodes.size() +
                " nodes= \n" + nodes +
                "\n";
    }
}