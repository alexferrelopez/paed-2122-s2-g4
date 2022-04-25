package R_Tree;

import java.util.ArrayList;
import java.util.List;

public class RTree {

    private Rectangle root = new Rectangle(0, 0, 0, 0, new ArrayList<>());

    public void setRoot(Rectangle root) {
        this.root = root;
    }

    public Rectangle getRoot() {
        return root;
    }

    public Rectangle insert (Rectangle parent, Figura newNode){
        double minPerimeter = Double.MAX_VALUE;
        int minIndex = Integer.MIN_VALUE;

        if (!parent.getNodes().isEmpty() && parent.getNodes().get(0) instanceof Rectangle) {
            if (((Rectangle) parent.getNodes().get(0)).getNodes().get(0) instanceof Cercle && newNode instanceof Rectangle) {
                parent.addNode(newNode);
            }
            else {

                for (int i = 0; i < parent.getNodes().size(); i++) {
                    Rectangle rectangle = (Rectangle) parent.getNodes().get(i);
                    double newPerimeter = rectangle.newPerimeter(newNode);

                    if (newPerimeter <= minPerimeter) {
                        minPerimeter = newPerimeter;
                        minIndex = i;
                    }
                }
                insert((Rectangle) parent.getNodes().get(minIndex), newNode);
            }
        }
        else {
            parent.addNode(newNode);
        }

        parent.updateArea();

        if (parent.getNodes().size() > 3) {
            if (parent.getParent() == null) {
                int[] indexes = parent.calcFurthestFigures();

                Figura lowestCenter = parent.getNodes().get(indexes[0]);
                Figura highestCenter = parent.getNodes().get(indexes[1]);

                Rectangle lowestCenterBranch = new Rectangle(lowestCenter.getCenter(), new ArrayList<>() {{ add(lowestCenter);}});
                Rectangle highestCenterBranch = new Rectangle(highestCenter.getCenter(), new ArrayList<>() {{ add(highestCenter);}});

                List<Figura> nodes = new ArrayList<>(parent.getNodes());

                parent.getNodes().clear();

                parent.addNode(lowestCenterBranch);
                parent.addNode(highestCenterBranch);

                for (int index : indexes) {
                    nodes.remove(index);
                }

                for (Figura node : nodes) {
                    insert(parent,node);
                }
            }
            else {

            }
        }



        return parent;
    }
}
