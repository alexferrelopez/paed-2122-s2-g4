public class ListRelationships {
    private int a;
    private int b;
    private int timestamp;
    private int interactions;


    public ListRelationships(int a, int b, int timestamp, int interactions) {
        this.a = a;
        this.b = b;
        this.timestamp = timestamp;
        this.interactions = interactions;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getInteractions() {
        return interactions;
    }

    public void setInteractions(int interactions) {
        this.interactions = interactions;
    }
}
