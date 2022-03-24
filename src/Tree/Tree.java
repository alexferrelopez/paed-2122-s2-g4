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
                System.out.println();
                //node.setBf(node.getBf() - 1);
            } else {
                insert (parent.getLeft(), node);
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(node);
                node.setParent(parent);
                System.out.println();
                //node.setBf(node.getBf() + 1);
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
        Node k1 = nodeToRotate.getLeft();
        if (k1 != null) {
            nodeToRotate.setLeft(k1.getRight());
            k1.setRight(nodeToRotate);
        }
    }

    public void rotateRight (Node nodeToRotate) {
        Node k2 = nodeToRotate.getRight();
        if (k2 != null) {
            nodeToRotate.setRight(k2.getLeft());
            k2.setLeft(nodeToRotate);
        }
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

    public void AVL (Node nodeToRotate) {
    }

    public void inOrderAVL (Node root) {
        if (root == null)
            return;

        inOrderAVL(root.getLeft());
        inOrderAVL(root.getRight());

        System.out.println(root.getId());
        if (root.getLeft() != null && root.getRight() == null) {
            root.setBf(root.getBf() - 1);
        } else if (root.getLeft() == null && root.getRight() != null) {
            root.setBf(root.getBf() + 1);
        } else if (root.getLeft() != null && root.getRight() != null){
            if (root.getLeft().getBf() == 0 && root.getRight().getBf() == 0) {
                root.setBf(root.getBf());
            } else if (root.getLeft().getBf() != 0 && root.getRight().getBf() == 0) {
                if (root.getLeft().getBf() > 0) {
                    root.setBf(root.getRight().getBf() - root.getLeft().getBf());
                } else {
                    root.setBf(root.getLeft().getBf()-1);
                }
            } else if (root.getLeft().getBf() == 0 && root.getRight().getBf() != 0) {
                if (root.getRight().getBf() > 0) {
                    root.setBf(root.getLeft().getBf() - root.getRight().getBf());
                } else {
                    root.setBf(root.getRight().getBf()-1);
                }
            } else {
                root.setBf(+1);
            }
        } else {
            root.setBf(root.getBf());
        }
    }

    /*public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }*/
}
