package Tree;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tree {

    /**
     *
     * Method that insert a node into the tree.
     * In order to sort the nodes in the correct position we check the
     * timestamp of each node that we want to add.
     *
     * @param parent Parent node where we want to add the node
     * @param node Node that we want to insert
     *
     */

    public void insert (Node parent, Node node) {
        if (node.getTimestamp() < parent.getTimestamp()) {
            if (parent.getLeft() == null) {
                parent.setLeft(node);
            } else {
                insert (parent.getLeft(), node);
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(node);
            } else {
                insert (parent.getRight(), node);
            }
        }
    }

    public String timestampToDate (Node root) {
        Date d = new Date(root.getTimestamp() * 1000L);
        SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return jdf.format(d);
    }
}
