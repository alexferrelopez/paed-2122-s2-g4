import java.util.LinkedList;
import java.util.List;

public class Graph {
    private List<User> userList;

    public Graph(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    public int findUserIndex (int index) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == index) {
                return i;
            }
        }
        return 0;
    }

    public int findListSize() {
        return userList.size();
    }

    public List<User> findAdjacent (int index) {
        LinkedList<Adjacency> adjacents = new LinkedList<>(userList.get(index).getFollowing());
        LinkedList<User> users = new LinkedList<>();

        for (Adjacency adjacency : adjacents) {
            int userIndex = findUserIndex(adjacency.getAdjacentUser());
            users.add(userList.get(userIndex));
        }

        return users;
    }

    public int getIndexOfMostFollowingUser (){
        int index = 0;
        int maxSize = 0;

        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            int size = user.getFollowing().size();
            if (size >= maxSize) {
                maxSize = size;
                index = i;
            }
        }

        return index;
    }
}
