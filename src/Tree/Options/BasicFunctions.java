package Tree.Options;

import Tree.Node;
import Tree.Tree;
import Tree.UIManagerTree;

public class BasicFunctions {

    private final UIManagerTree uiManagerTree;
    private final Tree tree;
    private long timestamp;

    public BasicFunctions (UIManagerTree uiManagerTree, Tree tree) {
        this.uiManagerTree = uiManagerTree;
        this.tree = tree;
    }

    public void addAlgorithm (Node root) {
        Node node = uiManagerTree.createNode();
        tree.setRoot(tree.insert(root, node));
    }

    public void searchIdTimestamp (Node root, long id) {
        if (root == null)
            return;

        searchIdTimestamp (root.getLeft(), id);
        searchIdTimestamp(root.getRight(), id);
        if (id == root.getId()) {
            System.out.println();
            tree.delete(tree.getRoot(), root.getTimestamp());
        }

    }
    public void deleteAlgrithm() {
        long id = uiManagerTree.deleteNode();
        searchIdTimestamp(tree.getRoot(), id);
    }
}
