package Tree.Options;

import Tree.*;

public class SearchTimestamp {

    private final UIManagerTree uiManagerTree;
    private int countNodes;

    /**
     *
     * Constructor of the search timestamp to do the exact search and the range search.
     *
     * @param uiManagerTree class with all the messages and inputs to show.
     *
     */

    public SearchTimestamp (UIManagerTree uiManagerTree) {
        this.uiManagerTree = uiManagerTree;
    }

    /**
     *
     * Method to search the exact timestamp of a node.
     *
     * @param root tree with all the nodes.
     * @param time timestamp that user want to search.
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
     * Method to search the timestamp that is in a specific range.
     *
     * @param node tree with all the nodes.
     * @param min minimum timestamp to search
     * @param max maximum timestamp to search
     *
     */

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

    /**
     *
     * Method to count nodes that are in the range of the timestamp.
     *
     * @param node tree with all the nodes.
     * @param min minimum number of the timestamp.
     * @param max maximum number of the timestamp.
     *
     * @return the number of nodes.
     *
     */

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
