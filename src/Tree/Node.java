package Tree;

public class Node {

    private int bf;
    private long id;
    private String name;
    private String language;
    private String cost;
    private long timestamp;

    private Node parent;
    private Node right;
    private Node left;

    public Node(long id, String name, String language, String cost, long timestamp) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.cost = cost;
        this.timestamp = timestamp;
    }

    public int getBf() {
        return this.bf;
    }

    public void setBf(int bf) {
        this.bf = bf;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", cost='" + cost + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
