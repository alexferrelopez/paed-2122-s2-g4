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
     * @param parent Parent node where we want to add the node
     * @param node Node that we want to insert
     *
     */
   /* public Node insert (Node parent, Node node) {

        if (parent == null) {
            return node;
        }

        if (node.getTimestamp() < parent.getTimestamp()) {
            Node left = insert(parent.getLeft(), node);
            left.setParent(parent);
            parent.setLeft(left);
        } else if (node.getTimestamp() > parent.getTimestamp()){
            Node right = insert(parent.getRight(), node);
            right.setParent(parent);
            parent.setRight(right);
        }

        parent.setHeight(1 + max(height(parent.getLeft()), height(parent.getRight())));

        int balance = getBalanceFactor(parent);

        // If this node becomes unbalanced, then there
        //if (parent.getLeft() != null) {
        if (balance > 1 && node.getTimestamp() < parent.getLeft().getTimestamp()) {
            Node left = rotateLeft(parent);
            left.setParent(parent);
            return left;
        }

        if (balance > 1 && node.getTimestamp() > parent.getLeft().getTimestamp()) {
            parent.setRight(rotateRight(parent.getRight()));
            Node left = rotateLeft(parent);
            left.setParent(parent);
            return left;
        }
        //}

        //if (parent.getRight() != null) {
        System.out.println(parent.getName());
        if (balance < -1 && node.getTimestamp() > parent.getRight().getTimestamp()) {
            Node right = rotateRight(parent);
            right.setParent(parent);
            return right;
        }

        if (balance < -1 && node.getTimestamp() < parent.getRight().getTimestamp()) {
            parent.setLeft(rotateLeft(parent.getLeft()));
            Node right = rotateRight(parent);
            right.setParent(parent);
            return right;
        }
        //}

        return parent;
    }*/

    public Node insert (Node parent, Node node) {

        // Find the position and insert the node

        if (parent == null) {
            return node;
        } if (node.getTimestamp() < parent.getTimestamp()) {
            Node left = insert(parent.getLeft(), node);
            left.setParent(parent);
            parent.setLeft(left);
        } else if (node.getTimestamp() > parent.getTimestamp()) {
            Node right = insert(parent.getRight(), node);
            right.setParent(parent);
            parent.setRight(right);
        } else {
            return parent;
        }

        // Update the balance factor of each node
        // And, balance the tree

        parent.setHeight(1 + max (height (parent.getLeft()), height (parent.getRight())));
        int balanceFactor = getBalanceFactor (parent);

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

    public Node rotateLeft (Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    public Node rotateRight (Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void inOrdre(Node node) {
        if (node != null) {
            inOrdre(node.getLeft());
            System.out.println(node);
            inOrdre(node.getRight());
        }
    }

    public int height(Node N) {
        if (N == null)
            return 0;
        return N.getHeight();
    }

    public int max(int a, int b) {
        return Math.max(a, b);
    }

    // Get balance factor of a node
    public int getBalanceFactor(Node N) {
        if (N == null)
            return 0;
        return height(N.getLeft()) - height(N.getRight());
    }

    public String timestampToDate (Node root) {
        Date d = new Date(root.getTimestamp() * 1000L);
        SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return jdf.format(d);
    }

    public Node findNode (int id, Node node) {
        if (node != null) {
            if (node.getId() == id) {
                return node;
            } else {
                Node result = findNode(id, node.getLeft());
                if (result == null) {
                    result = findNode(id, node.getRight());
                }
                return result;
            }
        } else {
            return null;
        }
    }

    public Node delete (Node root, long timestamp) {
        if (root == null) {
            return root;
        }

        if (timestamp < root.getTimestamp()) {
            Node left = delete(root.getLeft(), timestamp);
            root.setLeft(left);
        } else if (timestamp > root.getTimestamp()) {
            Node right = delete(root.getRight(), timestamp);
            root.setRight(right);
        } else {
            if ((root.getLeft() == null) || (root.getRight() == null)) {
                Node temp = null;
                if (temp == root.getLeft()) {
                    temp = root.getRight();
                } else {
                    temp = root.getLeft();
                }

                root = temp;
            } else {
                Node temp = minValueNode(root.getRight());
                root.setTimestamp(temp.getTimestamp());
                root.setRight(delete(root.getRight(), temp.getTimestamp()));
            }
        }

        if (root == null) {
            return root;
        }

        root.setHeight(1 + max(height(root.getLeft()), height(root.getRight())));
        int balance = getBalanceFactor(root);

        if (balance > 1 && getBalanceFactor(root.getLeft()) < 0) {
            Node left = rotateLeft(root);
            left.setParent(root);
            return left;
        }

        if (balance < -1 && getBalanceFactor(root.getRight()) > 0) {
            Node right = rotateRight(root);
            right.setParent(root);
            return right;
        }

        if (balance > 1 && getBalanceFactor(root.getLeft()) > 0) {
            root.setRight(rotateRight(root.getRight()));
            Node left = rotateLeft(root);
            left.setParent(root);
            return left;
        }

        if (balance < -1 && getBalanceFactor(root.getRight()) < 0) {
            root.setLeft(rotateLeft(root.getLeft()));
            Node right = rotateRight(root);
            right.setParent(root);
            return right;
        }
        return root;
    }

    public Node minValueNode (Node node) {
        Node current = node;

        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

}