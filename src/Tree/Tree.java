package Tree;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tree {

    private Node root;
    static final int COUNT = 10;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    /**
     * Method that insert a node into the tree.
     * In order to sort the nodes in the correct position we check the
     * timestamp of each node that we want to add.
     *
     * @param parent Parent node where we want to add the node
     * @param node   Node that we want to insert
     */

    public Node insert(Node parent, Node node) {

        // Insert the node comparing the timestamp of each node.

        // If the desired node to insert has a timestamp minor than the parent
        //        => insert the node on the left
        // Else If the desired node to insert has a timestamp greater than the parent
        //        => insert the node on the right

        // Else return the parent.

        if (parent == null) {
            return node;
        }
        if (node.getTimestamp() < parent.getTimestamp()) {
            Node left = insert(parent.getLeft(), node);
            parent.setLeft(left);
        } else if (node.getTimestamp() > parent.getTimestamp()) {
            Node right = insert(parent.getRight(), node);
            parent.setRight(right);
        } else {
            return parent;
        }

        // Update the balance factor of each node
        // And, balance the tree

        parent.setHeight(1 + Math.max(height(parent.getLeft()), height(parent.getRight())));
        int balanceFactor = getBalanceFactor(parent);

        if (balanceFactor > 1) {
            if (node.getTimestamp() < parent.getLeft().getTimestamp()) {
                return rotateRight(parent);
            } else if (node.getTimestamp() > parent.getLeft().getTimestamp()) {
                parent.setLeft(rotateLeft(parent.getLeft()));
                return rotateRight(parent);
            }
        }

        if (balanceFactor < -1) {
            if (node.getTimestamp() > parent.getRight().getTimestamp()) {
                return rotateLeft(parent);
            } else if (node.getTimestamp() < parent.getRight().getTimestamp()) {
                parent.setRight(rotateRight(parent.getRight()));
                return rotateLeft(parent);
            }
        }

        return parent;
    }

    /**
     * Method to rotate the node to the left
     *
     * @param x Node that we want to rotate
     * @return the new node rotated
     */
    public Node rotateLeft(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    /**
     * Method to rotate the node to the right
     *
     * @param y node that we want to rotate
     * @return
     */
    public Node rotateRight(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    public int height(Node N) {
        if (N == null)
            return 0;
        return N.getHeight();
    }

    // Get balance factor of a node
    public int getBalanceFactor(Node N) {
        if (N == null)
            return 0;
        return height(N.getLeft()) - height(N.getRight());
    }

    /**
     * Method to convert the timestamp to a date
     *
     * @param root with all the nodes (tree).
     * @return the date as string.
     */

    public static String timestampToDate(Node root) {
        Date d = new Date(root.getTimestamp() * 1000L);
        SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return jdf.format(d);
    }

    public Node delete(Node root, long timestamp) {
        if (root == null) {
            return null;
        }

        if (timestamp < root.getTimestamp()) {
            root.setLeft(delete(root.getLeft(), timestamp));
        } else if (timestamp > root.getTimestamp()) {
            root.setRight(delete(root.getRight(), timestamp));
        } else {
            if (root.getLeft() == null || root.getRight() == null) {
                Node temp;
                if (null == root.getLeft()) temp = root.getRight();
                else temp = root.getLeft();

                root = temp;
            } else {
                Node temp = minValueNode(root.getRight());
                root.setId(temp.getId());
                root.setName(temp.getName());
                root.setLanguage(temp.getLanguage());
                root.setCost(temp.getCost());
                root.setTimestamp(temp.getTimestamp());
                root.setRight(delete(root.getRight(), temp.getTimestamp()));
            }

        }

        if (root == null) return null;
        root.setHeight(1 + Math.max(height(root.getLeft()), height(root.getRight())));
        int balanceFactor = getBalanceFactor(root);

        if (balanceFactor > 1) {
            if (getBalanceFactor(root.getLeft()) < 0) {
                return rotateRight(root);
            } else if (getBalanceFactor(root.getLeft()) >= 0) {
                root.setLeft(rotateLeft(root.getLeft()));
                return rotateRight(root);
            }
        }

        if (balanceFactor < -1) {
            if (getBalanceFactor(root.getRight()) > 0) {
                return rotateLeft(root);
            } else if (getBalanceFactor(root.getRight()) <= 0) {
                root.setRight(rotateRight(root.getRight()));
                return rotateLeft(root);
            }
        }

        return root;
    }

    /**
     * Method to search the minimum value of the node.
     *
     * @param node to start searching the minimum.
     * @return the minimum node.
     */

    public Node minValueNode(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public void inOrdre(Node node) {
        if (node != null) {
            inOrdre(node.getLeft());
            System.out.println(node);
            inOrdre(node.getRight());
        }
    }


    ///////////////////////////  PRINT /////////////////////////////
    /**
     * Prints the tree horizontally
     * @param root root of the tree
     * @param space spacing to print
     */
    public static void print2DUtil(Node root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.getRight(), space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.getId()+ " h:" + root.getHeight() + "\n");

        // Process left child
        print2DUtil(root.getLeft(), space);
    }
}