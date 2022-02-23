public class Adjacency {
    private int adjacentUser;
    private long timestamp;
    private int interactions;

    public Adjacency(int adjacentUser, long timestamp, int interactions) {
        this.adjacentUser = adjacentUser;
        this.timestamp = timestamp;
        this.interactions = interactions;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getInteractions() {
        return interactions;
    }

    public void setInteractions(int interactions) {
        this.interactions = interactions;
    }

    public int getAdjacentUser() {
        return adjacentUser;
    }

    public void setAdjacentUser(int adjacentUser) {
        this.adjacentUser = adjacentUser;
    }
}
