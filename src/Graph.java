import java.util.List;

public class Graph {
    private List<User> userLists;

    public Graph(List<User> userLists) {
        this.userLists = userLists;
    }

    public List<User> getUserLists() {
        return userLists;
    }

    public void setUserLists(List<User> userLists) {
        this.userLists = userLists;
    }
}
