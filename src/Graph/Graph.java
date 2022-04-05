package Graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final List<User> userList;

    public Graph(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public int findUserIndex(int id) {
        return binarySearch(id, 0, userList.size());
    }

    /*
    public int findUserIndex (int index) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == index) {
                return i;
            }
        }
        return 0;
    }*/

    public int binarySearch(int ID, int left, int right) {
        while (left <= right) {
            int pointerActual = left + (right - left) / 2;
            int idActual = userList.get(pointerActual).getId();

            // Check if ID is present at mid
            if (idActual == ID)
                return pointerActual;

            // If ID greater, ignore left half
            if (idActual < ID)
                left = pointerActual + 1;

            // If ID is smaller, ignore right half
            else
                right = pointerActual - 1;
        }

        return -1;
    }

    public int findListSize() {
        return userList.size();
    }

    public List<User> findAdjacent(int index) {
        LinkedList<Adjacency> adjacents = new LinkedList<>(userList.get(index).getFollowing());
        LinkedList<User> users = new LinkedList<>();

        for (Adjacency adjacency : adjacents) {
            int userIndex = findUserIndex(adjacency.getAdjacentUser());
            users.add(userList.get(userIndex));
        }
        return users;
    }

    public int getIndexOfMostFollowingUser() {
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

    public Long getTimestampBetweenUsers(int idA, int idB) {
        User user = userList.get(findUserIndex(idA));
        List<Adjacency> following = user.getFollowing();

        for (Adjacency adjacency : following) {
            if (adjacency.getAdjacentUser() == idB) {
                return adjacency.getTimestamp();
            }
        }
        return 0L;
    }

    public boolean idExists(int id) {
        int i = binarySearch(id, 0, userList.size() - 1);

        return i != -1;
    }
}
