package R_Tree;

import java.util.ArrayList;

public class RTree {

    private Rectangle root = new Rectangle(0, 0, 0, 0, new ArrayList<>() {{add(new Rectangle(0,0,1,1,new ArrayList<>(), new ArrayList<>())); add(new Rectangle(7,7,10,10, new ArrayList<>(), new ArrayList<>()));}}, new ArrayList<>());

    public void setRoot(Rectangle root) {
        this.root = root;
    }

    public Rectangle getRoot() {
        return root;
    }

    public Rectangle insert (Rectangle parent, Cercle newNode){
        double minAreaValue = Double.MAX_VALUE;
        int minIndex = -1;

        if (parent.getFulles().isEmpty() && !parent.getNodes().isEmpty()) {
            Rectangle rectangle;
            for (int i = 0; i < parent.getNodes().size(); i++) {
                rectangle = parent.getNodes().get(i);
                double newArea = rectangle.newArea(newNode.getX(), newNode.getY());
                if (newArea <= minAreaValue) {
                    minAreaValue = newArea;
                    minIndex = i;
                }
            }
            insert(parent.getNodes().get(minIndex),newNode);

        }
        else {

        }

        if (parent.getNodes().isEmpty()) {
            parent.getFulles().add(newNode);
        }
        parent.updateArea();
        //TODO OVERFLOW DE LA LLISTA DE CERCLES, CREACIO DE MÉS NODES

        return parent;
    }
}
