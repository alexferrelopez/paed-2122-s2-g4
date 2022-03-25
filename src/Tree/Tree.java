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
    public Node insert (Node parent, Node node) {

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


        parent.setHeight(1 + max(height(parent.getLeft()),
                height(parent.getRight())));

        int balance = getBalanceFactor(parent);

        // If this node becomes unbalanced, then there
        if (balance > 1 && node.getTimestamp() < parent.getLeft().getTimestamp()) {
            Node left = rotateLeft(parent);
            left.setParent(parent);
            return left;
        }

        if (balance < -1 && node.getTimestamp() > parent.getRight().getTimestamp()) {
            Node right = rotateRight(parent);
            right.setParent(parent);
            return right;
        }

        if (balance > 1 && node.getTimestamp() > parent.getLeft().getTimestamp()) {
            parent.setRight(rotateRight(parent.getRight()));
            Node left = rotateLeft(parent);
            left.setParent(parent);
            return left;
        }

        if (balance < -1 && node.getTimestamp() < parent.getRight().getTimestamp()) {
            parent.setLeft(rotateLeft(parent.getLeft()));
            Node right = rotateRight(parent);
            right.setParent(parent);
            return right;
        }
        return parent;
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


    public Node rotateLeft (Node A) {
        Node D = A.getRight();
        Node N = D.getLeft();

        D.setLeft(A);
        A.setRight(N);

        A.setParent(D);
        if (N != null) N.setParent(A);

        D.setHeight(max(height(D.getLeft()), height(D.getRight())) + 1);
        A.setHeight(max(height(A.getLeft()), height(A.getRight())) + 1);

        return D;
    }

    public Node rotateRight (Node C) {
        Node D = C.getLeft();
        Node E = D.getRight();

        D.setRight(C);
        C.setLeft(E);

        if (E != null) E.setParent(C);
        C.setParent(D);

        D.setHeight(max(height(D.getLeft()), height(D.getRight())) + 1);
        C.setHeight(max(height(C.getLeft()), height(C.getRight())) + 1);

        return D;
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