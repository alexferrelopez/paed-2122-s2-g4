package Tree.Options;

import Tree.*;

public class SearchTimestamp {

    private final UIManagerTree uiManagerTree;
    private int countNodes;

    public SearchTimestamp(UIManagerTree uiManagerTree) {
        this.uiManagerTree = uiManagerTree;
    }

    public void searchExactTimestamp (Node root, long time) {
        if (root == null)
            return;


        if (time < root.getTimestamp()) {
            searchExactTimestamp (root.getLeft(), time);
        }
        else if (time > root.getTimestamp()) {
            searchExactTimestamp(root.getRight(), time);
        }
        else {
            uiManagerTree.printExactTimestampAlgorithm(root.getName(), root.getLanguage(), root.getCost());
        }

    }

    public void searchRangTimestamp (Node node, long min, long max) {
        if (node == null)
            return;

        if (max > node.getTimestamp()) {
            searchRangTimestamp(node.getRight(), min, max);
        }

        if (node.getTimestamp() <= max && node.getTimestamp() >= min) {
            uiManagerTree.printRangTimestampAlgorithm(node.getName(), node.getLanguage(), node.getCost(), Tree.timestampToDate(node));
        }

        searchRangTimestamp(node.getLeft(), min, max);
    }

    public int countNodesInRange (Node node, long min, long max) {
        if (node == null)
            return countNodes;

        if (max > node.getTimestamp()) {
            countNodesInRange(node.getRight(), min, max);
        }

        if (node.getTimestamp() <= max && node.getTimestamp() >= min) {
            countNodes++;
        }

        countNodesInRange(node.getLeft(), min, max);
        return countNodes;
    }
}