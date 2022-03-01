import java.util.*;

public class DijkstraController {

    private boolean[] visited;
    private List<List<User>> camins;
    private final Graph graph;
    Long[] distancies;

    public DijkstraController (Graph graph) {
        this.graph = graph;
    }

    public List<User> dijkstra(User initial, User ending) {
        List<User> userList = graph.getUserList();
        visited = new boolean[userList.size()];
        camins = new ArrayList<>(userList.size());

        for (int i = 0; i < userList.size(); i++) {
            camins.add(new ArrayList<>());
        }

        distancies = new Long[userList.size()];

        Arrays.fill(distancies,Long.MAX_VALUE);

        User actual = initial;
        int actualId = initial.getId();

        visited[graph.findUserIndex(actual.getId())] = true;
        distancies[graph.findUserIndex(actual.getId())] = 0L;

        while (!allVisited() && !visited[graph.findUserIndex(ending.getId())]) {
            List<User> adjacent = graph.findAdjacent(graph.findUserIndex(actualId));
            for (User user : adjacent) {
                int userIndex = graph.findUserIndex(user.getId());
                if (!visited[userIndex]) {
                    long newDistance = distancies[graph.findUserIndex(actual.getId())] + graph.getTimestampBetweenUsers(actualId, user.getId());

                    if (distancies[userIndex] > newDistance) {
                        distancies[userIndex] = newDistance;
                        actualitzaCamins(actual, user);
                    }
                }
            }
            visited[graph.findUserIndex(actualId)] = true;
            actual = findNonVisitedMinimumDistance(userList);
            actualId = actual.getId();
        }
        List<User> answer = camins.get(graph.findUserIndex(ending.getId()));
        answer.add(ending);
        Collections.reverse(answer);

        if (answer.get(0).getId() != ending.getId() || answer.get(0).getId() == answer.get(answer.size()-1).getId()) {
            return new ArrayList<>();
        }

        return answer;
    }

    private User findNonVisitedMinimumDistance(List<User> userList) {
        Long minDistance = Long.MAX_VALUE;
        int indexMin = 0;
        for (int i = 0; i < distancies.length; i++) {
            if (distancies[i] <= minDistance && !visited[i]) {
                indexMin = i;
                minDistance = distancies[i];
            }
        }
        return userList.get(indexMin);
    }

    private boolean allVisited () {
        for (boolean nodeVisited : visited) {
            if (!nodeVisited) {
                return false;
            }
        }
        return true;
    }

    private void actualitzaCamins (User actual, User adjacent) {
        int adjacentIndex = graph.findUserIndex(adjacent.getId());
        int actualIndex = graph.findUserIndex(actual.getId());
        List<User> camiFinsAra = camins.get(actualIndex);

        if (camins.get(adjacentIndex) == null || camins.get(adjacentIndex).isEmpty()) {
            for (User user : camiFinsAra) {
                camins.get(adjacentIndex).add(user);
            }
        }
        else {

            camins.get(adjacentIndex).clear(); //pot ser que esborri camins bons

            for (User user : camiFinsAra) {
                camins.get(adjacentIndex).add(user);
            }
        }
        camins.get(adjacentIndex).add(actual);
    }

    public void networking(User initial, User ending) {
        List<User> dijkstra = dijkstra(initial, ending);
        System.out.println();

        for (User user : dijkstra) {
            System.out.println("\t"+user.getId());
            if (dijkstra.get(dijkstra.size()-1).getId() != user.getId()) {
                System.out.println("\t" + "↓");
            }
        }

        if (dijkstra.size() == 0) {
            System.out.println("Els usuaris no tenen relació entre seguits.");
        }
    }
}