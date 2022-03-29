package Tree.Options;

import Tree.*;

public class Feed {

    private final UIManagerTree uiManagerTree;

    public Feed(UIManagerTree uiManagerTree) {
        this.uiManagerTree = uiManagerTree;
    }

    public void inOrder (Node root) {
        if (root == null)
            return;

        inOrder(root.getRight());
        uiManagerTree.printAlgorithm (root.getName(), root.getLanguage(), root.getCost(), Tree.timestampToDate(root));
        inOrder(root.getLeft());
    }
}
