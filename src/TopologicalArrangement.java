import java.io.IOException;
import java.util.*;

public class TopologicalArrangement {

    private Graph graph;

    private final boolean [] visited;
    private LinkedList<User> pil1 = new LinkedList<>();     // LinkedList with the visited Users
    private LinkedList<User> adj = new LinkedList<>();       // LinkedList with the adjacent Users

    public TopologicalArrangement (int numberOfVertices) {
        visited = new boolean[numberOfVertices];
    }


    public LinkedList<User> topoSort () throws IOException {
        graph = new Graph(new GraphDAO().readFile("dagS.paed"));

        LinkedList<User> pila = new LinkedList<>();

        for (User u: graph.getUserList()) {
            visita (graph, u, pila);
        }

        /*for (User u: graph.getUserList()) {
            if (!visited.get(u.getId())) {
            }
        }*/

        return pila;

    }

    public void visita (Graph g, User user, LinkedList<User> pila) {
        for (int i = 0; i < g.findListSize(); i++) {
            if (!visited[i]) {
                visita(g, user, pila);
                visited[i] = true;
            }
        }

        //queue.add(users.get(n));

        pila.add(user);
    }
}
