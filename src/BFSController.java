import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BFSController {

    private int numberOfVertices;

    private final boolean[] visited;

    private LinkedList<User> queue = new LinkedList<>(); // LinkedList with the visited Users
    private LinkedList<User> adj = new LinkedList<>();       // LinkedList with the adjacent Users

    public BFSController (int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        visited = new boolean[numberOfVertices];
    }

    /*public void Graph (int numberOfVertices) {
        adj = new LinkedList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int numberOfVertices, int line) {
        adj[numberOfVertices].add(line);
    }*/

    /**
     * BFS (Breadth First Search), Function to visit all
     * the adjacent of a vertex before expand it
     *
     * @param graph Graph with all the users
     * @param searchedUser searchedUser that we are checking
     *
     */

    public void BFS (Graph graph, int searchedUser) {
        LinkedList<User> users = new LinkedList<>(graph.getUserList());

        visited[searchedUser] = true;
        queue.add(users.get(searchedUser));

        while (queue.size() != 0) {
            int userIndex = graph.findUserIndex(queue.poll().getId());
            System.out.println(users.get(userIndex).toString());
            List<User> adjacent = graph.findAdjacent(userIndex);
            adj.addAll(adjacent);

            for (User user : adj) {
                int n = graph.findUserIndex(user.getId());
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(users.get(n));
                }
            }
        }
        Arrays.fill(visited, false);
    }
}
