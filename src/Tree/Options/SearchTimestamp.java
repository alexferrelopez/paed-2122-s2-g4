package Tree.Options;

import Tree.*;

public class SearchTimestamp {

    private final UIManagerTree uiManagerTree;
    private final Tree tree;

    public SearchTimestamp (UIManagerTree uiManagerTree, Tree tree) {
        this.uiManagerTree = uiManagerTree;
        this.tree = tree;
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
