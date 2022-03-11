package Tree.Options;

import Tree.*;

public class Feed {

    private UIManagerTree uiManagerTree;
    private Tree tree;

    public Feed (UIManagerTree uiManagerTree, Tree tree) {
        this.uiManagerTree = uiManagerTree;
        this.tree = tree;
    }

    public void inOrder (Node root) {
        if (root == null)
            return;

        inOrder(root.getLeft());
        uiManagerTree.printAlgorithm (root.getName(), root.getLanguage(), root.getCost(), tree.timestampToDate(root));
        inOrder(root.getRight());
    }
}
