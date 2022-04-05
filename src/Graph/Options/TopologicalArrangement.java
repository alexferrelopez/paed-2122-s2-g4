package Graph.Options;

import Graph.Graph;
import Graph.GraphDAO;
import Graph.User;

import java.io.IOException;
import java.util.LinkedList;

public class TopologicalArrangement {

    private Graph graph;

    private final LinkedList<User> pila = new LinkedList<>();     // LinkedList with the visited Users
    private boolean[] visited;

    public void topoSort() throws IOException {
        User user;
        graph = new Graph(new GraphDAO().readFile("dagS.paed"));
        visited = new boolean[graph.findListSize()];
        int visitedIsFalse = visitedIsFalse(visited);

        while (visitedIsFalse != -1) {
            user = graph.getUserList().get(visitedIsFalse);
            visita(user, pila);
            visitedIsFalse = visitedIsFalse(visited);
        }
    }

    public void visita(User user, LinkedList<User> pila) {
        for (User u : graph.findAdjacent(graph.findUserIndex(user.getId()))) {
            if (!visited[graph.findUserIndex(u.getId())]) {
                visita(u, pila);
            }
        }
        visited[graph.findUserIndex(user.getId())] = true;
        pila.add(user);
    }

    private int visitedIsFalse(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            boolean b = visited[i];
            if (!b) {
                return i;
            }
        }
        return -1;
    }

    public void view() throws IOException {
        topoSort();
        for (int i = 0; i < pila.size(); i++) {
            System.out.println(pila.get(i).getId() + " - " + pila.get(i).getName() + " (" + pila.get(i).getAlias() + ")");
            if (i == (pila.size() - 1)) {
                System.out.println();
            } else {
                System.out.println("↓");
            }
        }

    }
}
