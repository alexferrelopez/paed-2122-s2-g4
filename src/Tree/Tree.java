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
     * //@param parent Parent node where we want to add the node
     * @param node Node that we want to insert
     *
     */
    public Node insert (Node parent, Node node) {
        /*if (parent == null) {
            return node;
        }

        if (node.getTimestamp() < parent.getTimestamp()) {
            parent.setLeft(insertNode(parent.getLeft(), node));
        }
        else if (node.getTimestamp() > parent.getTimestamp()) {
            parent.setRight(insertNode(parent.getRight(), node));
        }
        else {
            return parent;
        }*/


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

        // Update the balance factor of each node
        // And, balance the tree
        parent.setHeight(1 + max(height(parent.getLeft()), height(parent.getRight())));
        int balanceFactor = getBalanceFactor(parent);
        if (balanceFactor > 1) {
            if (node.getTimestamp() > parent.getRight().getTimestamp()) {
                return leftRotate(parent);
            } else if (node.getTimestamp() < parent.getRight().getTimestamp()) {
                parent.setRight(rightRotate(parent.getRight()));
                return leftRotate(parent);
            }
        }
        if (balanceFactor < -1) {
            if (node.getTimestamp() < parent.getLeft().getTimestamp()) {
                return rightRotate(parent);
            } else if (node.getTimestamp() > parent.getLeft().getTimestamp()) {
                parent.setLeft(leftRotate(parent.getLeft()));
                return rightRotate(parent);
            }


        }
        return parent;

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

    public void AVL (Node nodeToRotate) {

    }

    public void inOrderAVL (Node root) {
        if (root == null) return;

        inOrderAVL(root.getLeft());
        inOrderAVL(root.getRight());

        if (root.getLeft() != null && root.getRight() == null) {
            root.setHeight(root.getHeight() - 1);
        } else if (root.getLeft() == null && root.getRight() != null) {
            root.setHeight(root.getHeight() + 1);
        } else if (root.getLeft() != null && root.getRight() != null){
            if (root.getLeft().getHeight() == 0 && root.getRight().getHeight() == 0) {
                root.setHeight(root.getHeight());
            } else if (root.getLeft().getHeight() != 0 && root.getRight().getHeight() == 0) {
                if (root.getLeft().getHeight() > 0) {
                    root.setHeight(root.getRight().getHeight() - root.getLeft().getHeight());
                } else {
                    root.setHeight(root.getLeft().getHeight()-1);
                }
            } else if (root.getLeft().getHeight() == 0 && root.getRight().getHeight() != 0) {
                if (root.getRight().getHeight() > 0) {
                    root.setHeight(root.getLeft().getHeight() - root.getRight().getHeight());
                } else {
                    root.setHeight(root.getRight().getHeight()-1);
                }
            } else {
                root.setHeight(+1);
            }
        } else {
            root.setHeight(root.getHeight());
        }
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

    Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();
        x.setRight(y);
        y.setLeft(T2);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        return x;
    }
    Node leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();
        y.setLeft(x);
        x.setRight(T2);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        return y;
    }

    // Get balance factor of a node
    int getBalanceFactor(Node N) {
        if (N == null)
            return 0;
        return height(N.getRight()) - height(N.getLeft());
    }
    // Insert a node
    public Node insertNode(Node parent, Node node) {
        // Find the position and insert the node
        if (parent == null)
            return node;

        if (node.getTimestamp() < parent.getTimestamp())
            parent.setLeft(insertNode(parent.getLeft(), node));
        else if (node.getTimestamp() > parent.getTimestamp())
            parent.setRight(insertNode(parent.getRight(), node));
        else
            return node;

        // Update the balance factor of each node
        // And, balance the tree
        parent.setHeight(1 + max(height(parent.getLeft()), height(parent.getRight())));
        int balanceFactor = getBalanceFactor(parent);
        if (balanceFactor > 1) {
            if (node.getTimestamp() < parent.getLeft().getTimestamp()) {
                return rightRotate(parent);
            } else if (node.getTimestamp() > parent.getLeft().getTimestamp()) {
                parent.setLeft(leftRotate(parent.getLeft()));
                return rightRotate(parent);
            }
        }
        if (balanceFactor < -1) {
            if (node.getTimestamp() > parent.getRight().getTimestamp()) {
                return leftRotate(parent);
            } else if (node.getTimestamp() < parent.getRight().getTimestamp()) {
                parent.setRight(rightRotate(parent.getRight()));
                return leftRotate(parent);
            }
        }
        return parent;
    }

    /*public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }*/
}
