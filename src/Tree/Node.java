package Tree;

public class Node {

    private int height;
    private long id;
    private String name;
    private String language;
    private String cost;
    private long timestamp;

    private Node parent;
    private Node right;
    private Node left;

    /**
     *
     * Constructor of the Node class with all the necessary attributes.
     *
     * @param id of the algorithm
     * @param name of the algorithm
     * @param language of the algorithm
     * @param cost of the algorithm
     * @param timestamp of the algorithm
     *
     */

    public Node (long id, String name, String language, String cost, long timestamp) {
        this.id        = id;
        this.name      = name;
        this.language  = language;
        this.cost      = cost;
        this.timestamp = timestamp;
    }

    /**
     *
     * Method to get the height of the node.
     *
     * @return the height of the node.
     *
     */

    public int getHeight() {
        return this.height;
    }

    /**
     *
     * Method to set the height of the node.
     *
     * @param height integer number to set to the height.
     *
     */

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * Method to get the parent of the node.
     *
     * @return the parent of the node
     *
     */

    public Node getParent() {
        return parent;
    }

    /**
     *
     * Method to set the parent of the node.
     *
     * @param parent of the node to set.
     *
     */

    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     *
     * Method to get the right node.
     *
     * @return the right node.
     *
     */

    public Node getRight() {
        return right;
    }

    /**
     *
     * Method to set the right node.
     *
     * @param right node to set to the right.
     *
     */

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     *
     * Method to set the left node.
     *
     * @return the left node.
     *
     */

    public Node getLeft() {
        return left;
    }

    /**
     *
     * Method to set the left node.
     *
     * @param left node to set to the left.
     *
     */

    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     *
     * Method to get the id of the node.
     *
     * @return long number of the id.
     *
     */

    public long getId() {
        return id;
    }

    /**
     *
     * Method to get the name of the node.
     *
     * @return string of the name of the node.
     *
     */

    public String getName() {
        return name;
    }

    /**
     *
     * Method to get the language of the node.
     *
     * @return the language of the node.
     *
     */

    public String getLanguage() {
        return language;
    }

    /**
     *
     * Method to set the language of the node.
     *
     * @param language string to set as the language of the node.
     *
     */

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     *
     * Method to get the cost of the node.
     *
     * @return string of the cost of the node.
     *
     */

    public String getCost() {
        return cost;
    }

    /**
     *
     * Method to set the cost of the node.
     *
     * @param cost string of the cost of the node.
     *
     */

    public void setCost(String cost) {
        this.cost = cost;
    }

    /**
     *
     * Method to get the timestamp.
     *
     * @return long number of the timestamp.
     *
     */

    public long getTimestamp() {
        return timestamp;
    }

    /**
     *
     * Method to set the timestamp of the node.
     *
     * @param timestamp long number for timestamp.
     *
     */

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     *
     * Method to print the node as required.
     *
     * @return string with all the information.
     *
     */

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", height=" + height +
                ", name='" + name + '\'' +
                ", timestamp=" + (timestamp /*/ 1000000L*/) +
                '}';
    }
}
