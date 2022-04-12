package Graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final List<User> userList;

    /**
     *
     * Constructor of the Graph function with the list of users.
     *
     * @param userList list with all the users.
     *
     */

    public Graph(List<User> userList) {
        this.userList = userList;
    }

    /**
     *
     * Function to get the list of all the users.
     *
     * @return the list with all the users.
     *
     */

    public List<User> getUserList() {
        return userList;
    }

    /**
     *
     * Method to find the index of a user using binary algorithm.
     *
     * @param id of the user that you want to search.
     *
     * @return the id of the user
     *
     */

    public int findUserIndex(int id) {
        return binarySearch(id, 0, userList.size());
    }

    /**
     *
     * Method to implement the binary search algorithm.
     *
     * @param ID integer number for the id of the user.
     * @param left integer number for the left node.
     * @param right integer number for the right node.
     *
     * @return the user searched.
     *
     */

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

    /**
     *
     * Method to get the size of the list.
     *
     * @return the size of the list.
     *
     */

    public int findListSize() {
        return userList.size();
    }

    /**
     *
     * Method to find the adjacent of a user giving the user.
     *
     * @param index of the user to find in the list users.
     * @return the list of users.
     *
     */

    public List<User> findAdjacent(int index) {
        LinkedList<Adjacency> adjacents = new LinkedList<>(userList.get(index).getFollowing());
        LinkedList<User> users = new LinkedList<>();

        for (Adjacency adjacency : adjacents) {
            int userIndex = findUserIndex(adjacency.getAdjacentUser());
            users.add(userList.get(userIndex));
        }
        return users;
    }

    /**
     *
     * Get the index of the most following users.
     *
     * @return the index of the most following user.
     *
     */

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

    /**
     *
     * Method to get the timestamp
     *
     * @param idA id of the first node to calculate dimension.
     * @param idB id of the second node to calculate dimension.
     *
     * @return the timestamp of the adjacency node
     *
     */

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

    /**
     *
     * Method to check if the id exists or not.
     *
     * @param id that be checked.
     *
     * @return true if the id exists.
     *
     */

    public boolean idExists(int id) {
        int i = binarySearch(id, 0, userList.size() - 1);

        return i != -1;
    }
}
