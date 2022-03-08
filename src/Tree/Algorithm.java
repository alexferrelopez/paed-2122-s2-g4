package Tree;

public class Algorithm {

    private long id;
    private String name;
    private String language;
    private String cost;
    private long timestamp;

    private Algorithm right;
    private Algorithm left;
    private Algorithm parent;

    public Algorithm(long id, String name, String language, String cost, long timestamp) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.cost = cost;
        this.timestamp = timestamp;
    }

    public Algorithm getRight() {
        return right;
    }

    public void setRight(Algorithm right) {
        this.right = right;
    }

    public Algorithm getLeft() {
        return left;
    }

    public void setLeft(Algorithm left) {
        this.left = left;
    }

    public Algorithm getParent() {
        return parent;
    }

    public void setParent(Algorithm parent) {
        this.parent = parent;
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
}
