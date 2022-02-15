import java.util.List;

public class Graph {
    private List<User> userLists;
    private List<Relationship> listRelationships;

    public Graph(List<User> userLists, List<Relationship> listRelationships) {
        this.userLists = userLists;
        this.listRelationships = listRelationships;
    }

    public List<User> getUserLists() {
        return userLists;
    }

    public void setUserLists(List<User> userLists) {
        this.userLists = userLists;
    }

    public List<Relationship> getListRelationships() {
        return listRelationships;
    }

    public void setListRelationships(List<Relationship> listRelationships) {
        this.listRelationships = listRelationships;
    }
}
