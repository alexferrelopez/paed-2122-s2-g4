package R_Tree;

public abstract class Figura {

    private Rectangle parent;

    public Rectangle getParent() {
        return parent;
    }

    public void setParent(Rectangle parent) {
        this.parent = parent;
    }

    public abstract double calcMaxX(Double x);
    public abstract double calcMaxY(Double y);
    public abstract double calcMinX(Double x);
    public abstract double calcMinY(Double y);
    public abstract double[] getCenter();

    @Override
    public String toString() {
        return super.toString();
    }
}
