package Tree.Options;

import Tree.Node;
import Tree.Tree;
import Tree.UIManagerTree;

public class BasicFunctions {

    private final UIManagerTree uiManagerTree;
    private final Tree tree;
    private long timestamp;

    /**
     * Constructor of the basic function method
     *
     * @param uiManagerTree class with all the texts and inputs that needs.
     * @param tree          class of the tree with all the node.
     */

    public BasicFunctions(UIManagerTree uiManagerTree, Tree tree) {
        this.uiManagerTree = uiManagerTree;
        this.tree = tree;
    }

    /**
     * Method to add a new algorithm to the tree
     *
     * @param root node with all the nodes (the tree)
     */

    public void addAlgorithm(Node root) {
        Node node = uiManagerTree.createNode();
        tree.setRoot(tree.insert(root, node));
    }

    /**
     * Method to search the timestamp by receiving the id
     *
     * @param root with all the nodes of the tree.
     * @param id   of the node that we want to search.
     */

    public void searchIdTimestamp(Node root, long id) {
        if (root == null)
            return;

        searchIdTimestamp(root.getLeft(), id);
        searchIdTimestamp(root.getRight(), id);
        if (id == root.getId()) {
            System.out.println();
            tree.setRoot(tree.delete(tree.getRoot(), root.getTimestamp()));
            //Tree.print2DUtil(tree.getRoot(), 0);
        }
    }

    /**
     * Method to delete an algorithm from the tree
     */

    public void deleteAlgorithm() {
        long id = uiManagerTree.deleteNode();
        searchIdTimestamp(tree.getRoot(), id);
    }
}
