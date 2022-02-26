import java.util.LinkedList;
import java.util.List;

public class DFS {

    private final boolean [] visited;

    private LinkedList<User> queue = new LinkedList<>();     // LinkedList with the visited Users
    private LinkedList<User> adj = new LinkedList<>();       // LinkedList with the adjacent Users

    public DFS (int numberOfVertices) {
        visited = new boolean [numberOfVertices];
    }

    public void depthFirstSearch (Graph graph, int searchUser) {

        LinkedList<User> users = new LinkedList<>(graph.getUserList());

        visited[searchUser] = true;
        queue.add(users.get(searchUser));
        while (queue.size() != 0) {
            int userIndex = graph.findUserIndex(queue.poll().getId());
            System.out.println(users.get(userIndex).toString());
            List<User> adjacent = graph.findAdjacent(userIndex);
            adj.addAll(adjacent);


            for (User user : adj) {
                int n = graph.findUserIndex(user.getId());
                if (!visited[n]){
                    depthFirstSearch(graph, n);
                }
            }
        }

    }
}
