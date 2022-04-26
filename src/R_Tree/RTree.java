package R_Tree;

import java.util.ArrayList;
import java.util.List;

public class RTree {

    private Rectangle root = new Rectangle(0, 0, 0, 0, new ArrayList<>());
    private final int listSize = 5;

    public void setRoot(Rectangle root) {
        this.root = root;
    }

    public Rectangle getRoot() {
        return root;
    }

    public Rectangle insert (Rectangle parent, Figura newNode){

        parent.updateArea();

        if (!parent.getNodes().isEmpty() && parent.getNodes().get(0) instanceof Rectangle) {
            if (((Rectangle) parent.getNodes().get(0)).getNodes().get(0) instanceof Cercle && newNode instanceof Rectangle) {
                parent.addNode(newNode);
            }
            else {
                double minPerimeter = Double.MAX_VALUE;
                int minIndex = 0;
                for (int i = 0; i < parent.getNodes().size(); i++) {
                    Rectangle rectangle = (Rectangle) parent.getNodes().get(i);
                    double newPerimeter = rectangle.newPerimeter(newNode);

                    if (newPerimeter <= minPerimeter) {
                        minPerimeter = newPerimeter;
                        minIndex = i;
                    }
                }
                Figura figura = parent.getNodes().get(minIndex);
                insert((Rectangle) figura, newNode);
            }
        }
        else {
            parent.addNode(newNode);
        }

        if (parent.getNodes().size() > listSize) {
            int[] indexes = parent.calcFurthestFigures();

            Figura furthestFigure1 = parent.getNodes().get(indexes[0]);
            Figura furthestFigure2 = parent.getNodes().get(indexes[1]);

            if (parent.getParent() == null) {
                List<Figura> nodes = new ArrayList<>(parent.getNodes());

                parent.getNodes().clear();

                Rectangle newBranch1 = new Rectangle(furthestFigure1.getCenter());
                newBranch1.addNode(furthestFigure1);
                parent.addNode(newBranch1);

                Rectangle newBranch2 = new Rectangle(furthestFigure2.getCenter());
                newBranch2.addNode(furthestFigure2);
                parent.addNode(newBranch2);

                nodes.remove(furthestFigure1);
                nodes.remove(furthestFigure2);

                for (Figura node : nodes) {
                    insert(parent,node);
                }
            }
            else {
                Rectangle grandParent = parent.getParent();

                Rectangle newRectangle = new Rectangle(furthestFigure1.getCenter());
                newRectangle.addNode(furthestFigure1);
                grandParent.addNode(newRectangle);

                List<Figura> nodes = new ArrayList<>(parent.getNodes());

                nodes.remove(furthestFigure1);
                nodes.remove(furthestFigure2);

                parent.getNodes().clear();

                parent.addNode(furthestFigure2);

                parent.updateArea();

                for (Figura node : nodes) {
                    insert(grandParent, node);
                }
            }
        }

        parent.updateArea();
        return parent;
    }
}
