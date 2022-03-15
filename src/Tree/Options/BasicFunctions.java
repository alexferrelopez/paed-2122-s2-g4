package Tree.Options;

import Tree.Node;
import Tree.Tree;
import Tree.UIManagerTree;

public class BasicFunctions {

    private final UIManagerTree uiManagerTree;
    private final Tree tree;

    public BasicFunctions (UIManagerTree uiManagerTree, Tree tree) {
        this.uiManagerTree = uiManagerTree;
        this.tree = tree;
    }

    public void addAlgorithm (Node root) {
        Node node = uiManagerTree.createNode();
        tree.insert(root, node);
    }
}
