package Graph;

public class Adjacency {
    private int adjacentUser;
    private long timestamp;
    private int interactions;

    /**
     *
     * Constructor to add a new adjacency
     *
     * @param adjacentUser for the adjacency
     * @param timestamp for the adjacency
     * @param interactions for the adjacency
     *
     */

    public Adjacency (int adjacentUser, long timestamp, int interactions) {
        this.adjacentUser = adjacentUser;
        this.timestamp = timestamp;
        this.interactions = interactions;
    }

    /**
     *
     * Method to get the timestamp of the adjacency.
     *
     * @return the timestamp as long number.
     *
     */

    public long getTimestamp() {
        return timestamp;
    }

    /**
     *
     * Method to get the number of interactions.
     *
     * @return integer number with the number of interactions.
     *
     */

    public int getInteractions() {
        return interactions;
    }

    /**
     *
     * Method to set the number of interactions.
     *
     */

    public void setInteractions(int interactions) {
        this.interactions = interactions;
    }

    /**
     *
     * Method to get the adjacent of a user.
     *
     * @return adjacency of the user
     *
     */

    public int getAdjacentUser() {
        return adjacentUser;
    }
}
