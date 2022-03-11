package Tree.Options;

import Tree.*;

public class SearchTimestamp {

    private UIManagerTree uiManagerTree;
    private Tree tree;

    public SearchTimestamp (UIManagerTree uiManagerTree, Tree tree) {
        this.uiManagerTree = uiManagerTree;
        this.tree = tree;
    }

    public void searchExactTimestamp (Node root, long time) {
        if (root == null)
            return;

        searchExactTimestamp (root.getLeft(), time);

        if (root.getTimestamp() == time) {
            uiManagerTree.printExactTimestampAlgorithm(root.getName(), root.getLanguage(), root.getCost());
        }

        searchExactTimestamp (root.getRight(), time);
    }

    public void searchRangTimestamp (Node root, long timeStart, long timeEnd) {
        if (root == null)
            return;

        searchRangTimestamp (root.getLeft(), timeStart, timeEnd);

        if (root.getTimestamp() > timeStart && root.getTimestamp() < timeEnd) {
            uiManagerTree.printRangTimestampAlgorithm(root.getName(), root.getLanguage(), root.getCost(), tree.timestampToDate(root));
        }

        searchRangTimestamp (root.getRight(), timeStart, timeEnd);
    }
}
