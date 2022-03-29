package Tree.Options;

import Tree.*;

public class SearchTimestamp {

    private final UIManagerTree uiManagerTree;
    private final Tree tree;

    /**
     *
     * Constructor of the search timestamp to do the exact search and the range search.
     *
     * @param uiManagerTree class with all the messages and inputs to show.
     * @param tree class with all functions of the tree.
     *
     */

    public SearchTimestamp (UIManagerTree uiManagerTree, Tree tree) {
        this.uiManagerTree = uiManagerTree;
        this.tree = tree;
    }

    /**
     *
     * Method to search the exact timestamp of a node
     * Using Binary Search.
     *
     * @param root all the nodes of the tree
     * @param time the input of the timestamp to search
     *
     */

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

    /**
     *
     * Method to search all the timestamps that are in the range
     * that user gives.
     *
     * @param root tree with all the nodes.
     * @param timeStart starting timestamp.
     * @param timeEnd ending timestamp.
     *
     */

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
