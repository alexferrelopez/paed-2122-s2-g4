package Graph.Options;

import Graph.Graph;
import Graph.User;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BFSController {

    private final boolean[] visited;

    private final LinkedList<User> queue = new LinkedList<>();     // LinkedList with the visited Users
    private final LinkedList<User> adj   = new LinkedList<>();     // LinkedList with the adjacent Users

    public BFSController(int numberOfVertices) {
        visited = new boolean[numberOfVertices];
    }

    /**
     * BFS (Breadth First Search), Function to visit all
     * the adjacent of a vertex before expand it
     *
     * @param graph        Graph.Graph with all the users
     * @param searchedUser searchedUser that we are checking
     */

    public void BreadthFirstSearch(Graph graph, int searchedUser) {
        LinkedList<User> users = new LinkedList<>(graph.getUserList());

        while (searchedUser != -1) {
            visited[searchedUser] = true;
            queue.add(users.get(searchedUser));

            int cont1 = 1;
            int cont2 = 0;

            System.out.println(users.get(searchedUser));

            while (queue.size() != 0) {
                int userIndex = graph.findUserIndex(queue.poll().getId());

                //System.out.println(users.get(userIndex));

                List<User> adjacent = graph.findAdjacent(userIndex);
                cont1--;

                adj.addAll(adjacent);

                /*if (!adjacent.isEmpty())
                    System.out.println("Nueva capa");*/

                for (User user : adj) {
                    int n = graph.findUserIndex(user.getId());
                    if (!visited[n]) {
                        cont2++;
                        //System.out.println(user);

                        visited[n] = true;
                        queue.add(users.get(n));
                    }
                }
                adj.clear();

                if (cont1 == 0 && cont2 != 0) {
                    cont1 = cont2;
                    cont2 = 0;
                    System.out.println("\nAquests són els comptes que segueixen:");

                    for (User user : queue) {
                        System.out.println(user);
                    }
                }
            }
            searchedUser = visitedIsFalse();

            if (searchedUser != -1) {
                System.out.println("\nNo hi ha comptes que segueixen, aquestes són les següents comptes no relacionades:");
            }
        }
    }

    private int visitedIsFalse() {
        for (int i = 0; i < visited.length; i++) {
            boolean b = visited[i];
            if (!b) {
                return i;
            }

            adj.clear();
        }

        return -1;
    }

    public void exploreTheWeb(Graph graph, int searchedUser) {
        System.out.println("\nL'usuari que segueix més comptes és:");
        BreadthFirstSearch(graph, searchedUser);
        Arrays.fill(visited, false);
    }
}
