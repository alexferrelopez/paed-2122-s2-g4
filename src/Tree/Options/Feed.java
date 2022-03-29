package Tree.Options;

import Tree.*;

public class Feed {

    private final UIManagerTree uiManagerTree;

    /**
     *
     * Constructor of the class feed to show all the nodes of the tree
     *
     * @param uiManagerTree class with all the messages and inputs to show.
     * @param tree class with all the functions of the tree.
     *
     */

    public Feed (UIManagerTree uiManagerTree, Tree tree) {
        this.uiManagerTree = uiManagerTree;
    }

    public void inOrder (Node root) {
        if (root == null)
            return;

        inOrder(root.getRight());
        uiManagerTree.printAlgorithm (root.getName(), root.getLanguage(), root.getCost(), tree.timestampToDate(root));
        inOrder(root.getLeft());
    }
}
