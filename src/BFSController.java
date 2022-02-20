import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class BFSController {

    private int numberOfVertices;

    private boolean visited[] = new boolean[numberOfVertices];

    private LinkedList<User> queue; // LinkedList with the visited Users
    private LinkedList<User> adj;       // LinkedList with the adjacent Users

    public BFSController (int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
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
     * @param g Graph with all the users
     * @param node Node that we are checking
     *
     */

    public void BFS (LinkedList<User> g, int node) {
        visited[node] = true;
        queue.add(g.get(node));

        while (queue.size() != 0) {
            g.get(node) = queue.poll();
            System.out.println(user.getName());

            Iterator<Integer> i = adj[algo].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(user);
                }
            }
        }
    }
}
