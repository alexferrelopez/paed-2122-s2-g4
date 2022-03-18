package Tree;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tree {

    private Node root;

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
                node.setParent(parent);
            } else {
                insert (parent.getLeft(), node);
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(node);
                node.setParent(parent);
            } else {
                insert (parent.getRight(), node);
            }
        }
    }

    public void deleteNode(Node node) {

    }

    public Node findNode (int id, Node node) {

        if(node != null){
            if(node.getId() == id){
                return node;
            } else {
                Node result = findNode(id, node.getLeft());
                if(result == null) {
                    result = findNode(id, node.getRight());
                }
                return result;
            }
        } else {
            return null;
        }
    }

    public void rotateLeft (Node nodeToRotate) {
        Node parent = nodeToRotate.getParent();

       Node k1 = nodeToRotate.getLeft();
        nodeToRotate.setLeft(k1.getRight());
        k1.setRight(nodeToRotate);
    }

    public void rotateRight (Node nodeToRotate) {

        Node k2 = nodeToRotate.getRight();
        nodeToRotate.setRight(k2.getLeft());
        k2.setLeft(nodeToRotate);
    }

    public void rotateLeftRight (Node nodeToRotate) {

        rotateRight(nodeToRotate.getLeft());
        rotateLeft(nodeToRotate);
    }

    public void rotateRightLeft (Node nodeToRotate) {
        rotateLeft(nodeToRotate.getRight());
        rotateRight(nodeToRotate);
    }

    public String timestampToDate (Node root) {
        Date d = new Date(root.getTimestamp() * 1000L);
        SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return jdf.format(d);
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }
}
