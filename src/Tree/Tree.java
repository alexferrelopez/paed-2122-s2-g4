package Tree;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tree {

    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    /**
     *
     * Method that insert a node into the tree.
     * In order to sort the nodes in the correct position we check the
     * timestamp of each node that we want to add.
     *
     * //@param parent Parent node where we want to add the node
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

        /* 2. Update height of this ancestor node */
        parent.setHeight(1 + max(height(parent.getLeft()),
                height(parent.getRight())));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalanceFactor(parent);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && node.getTimestamp() < parent.getLeft().getTimestamp()) {
            rotateRight(parent);
            return;
        }

        // Right Right Case
        if (balance < -1 && node.getTimestamp() > parent.getRight().getTimestamp()) {
            rotateLeft(parent);
            return;
        }

        // Left Right Case
        if (balance > 1 && node.getTimestamp() > parent.getLeft().getTimestamp()) {
            rotateRightLeft(parent);
            return;
        }
        // Right Left Case
        if (balance < -1 && node.getTimestamp() < parent.getRight().getTimestamp()) {
            rotateLeftRight(parent);
        }
        System.out.println();
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

    public String timestampToDate (Node root) {
        Date d = new Date(root.getTimestamp() * 1000L);
        SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return jdf.format(d);
    }


    public void rotateLeft (Node nodeToRotate) {
        Node k1 = nodeToRotate.getLeft();
        nodeToRotate.setLeft(k1.getRight());
        k1.setRight(nodeToRotate);
        k1.setHeight(max(height(k1.getLeft()), height(k1.getRight())) + 1);
        nodeToRotate.setHeight(max(height(nodeToRotate.getLeft()), height(nodeToRotate.getRight())) + 1);
    }

    public void rotateRight (Node nodeToRotate) {
        Node k2 = nodeToRotate.getRight();
        nodeToRotate.setRight(k2.getLeft());
        k2.setLeft(nodeToRotate);
        k2.setHeight(max(height(k2.getLeft()), height(k2.getRight())) + 1);
        nodeToRotate.setHeight(max(height(nodeToRotate.getLeft()), height(nodeToRotate.getRight())) + 1);
    }

    public void rotateLeftRight (Node nodeToRotate) {
        rotateRight(nodeToRotate.getLeft());
        rotateLeft(nodeToRotate);
    }

    public void rotateRightLeft (Node nodeToRotate) {
        rotateLeft(nodeToRotate.getRight());
        rotateRight(nodeToRotate);
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getId() + " ");
            System.out.print(node.getHeight() + " ");
            System.out.println();
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    int height(Node N) {
        if (N == null)
            return 0;
        return N.getHeight();
    }

    int max(int a, int b) {
        return Math.max(a, b);
    }

    // Get balance factor of a node
    int getBalanceFactor(Node N) {
        if (N == null)
            return 0;
        return height(N.getRight()) - height(N.getLeft());
    }
}
