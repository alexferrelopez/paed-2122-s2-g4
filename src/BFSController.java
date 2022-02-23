import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BFSController {

    private final boolean[] visited;

    private LinkedList<User> queue = new LinkedList<>(); // LinkedList with the visited Users
    private LinkedList<User> adj = new LinkedList<>();       // LinkedList with the adjacent Users

    public BFSController (int numberOfVertices) {
        visited = new boolean[numberOfVertices];
    }

    /**
     *
     * BFS (Breadth First Search), Function to visit all
     * the adjacent of a vertex before expand it
     *
     * @param graph Graph with all the users
     * @param searchedUser searchedUser that we are checking
     *
     */

    public void BreadthFirstSearch (Graph graph, int searchedUser) {
        LinkedList<User> users = new LinkedList<>(graph.getUserList());

        visited[searchedUser] = true;
        queue.add(users.get(searchedUser));

        while (queue.size() != 0) {
            int userIndex = graph.findUserIndex(queue.poll().getId());
            System.out.println(users.get(userIndex).toString());
            //System.out.println(users.get(userIndex).getId());
            List<User> adjacent = graph.findAdjacent(userIndex);
            adj.addAll(adjacent);


            for (User user : adj) {
                int n = graph.findUserIndex(user.getId());
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(users.get(n));
                }
            }
            adj.clear();
        }

        int visitedIsFalse = visitedIsFalse();

        while (visitedIsFalse != -1) {
            BreadthFirstSearch(graph, visitedIsFalse);
            visitedIsFalse = visitedIsFalse();
        }
    }

    private int visitedIsFalse () {
        for (int i = 0; i < visited.length; i++) {
            boolean b = visited[i];
            if (!b) {
                return i;
            }

            adj.clear();
        }

        return -1;
    }

    public void exploreTheWeb (Graph graph, int searchedUser) {
        BreadthFirstSearch(graph, searchedUser);
        Arrays.fill(visited, false);
    }
}
