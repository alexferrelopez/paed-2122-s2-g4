package Graph.Options;

import Graph.Graph;
import Graph.User;

import java.util.*;

public class DijkstraController {

    private boolean[] visited;
    private List<User> camins;
    private final Graph graph;
    Long[] distancies;

    public DijkstraController(Graph graph) {
        this.graph = graph;
    }

    public List<User> dijkstra(User initial, User ending) {
        List<User> userList = graph.getUserList();
        visited = new boolean[userList.size()];
        camins = new ArrayList<>(userList.size());

        for (int i = 0; i < userList.size(); i++) {
            camins.add(null);
        }

        distancies = new Long[userList.size()];

        Arrays.fill(distancies, Long.MAX_VALUE);

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
        List<User> answer = createAnswerPath(initial, ending);

        if (answer.get(0).getId() != initial.getId() || answer.get(0).getId() == answer.get(answer.size() - 1).getId()) {
            return new ArrayList<>();
        }

        return answer;
    }

    private List<User> createAnswerPath(User initial, User ending) {
        User actual = ending;
        List<User> answer = new LinkedList<>();
        User successor = camins.get(graph.findUserIndex(ending.getId()));
        answer.add(actual);

        while (successor != null && successor.getId() != initial.getId()) {
            actual = successor;
            successor = camins.get(graph.findUserIndex(actual.getId()));
            answer.add(actual);
        }

        if (successor == null) {
            return Collections.singletonList(initial);
        }
        answer.add(successor);

        Collections.reverse(answer);
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

    private boolean allVisited() {
        for (boolean nodeVisited : visited) {
            if (!nodeVisited) {
                return false;
            }
        }
        return true;
    }

    private void actualitzaCamins(User actual, User adjacent) {
        int adjacentIndex = graph.findUserIndex(adjacent.getId());

        camins.set(adjacentIndex, actual);
    }

    public void networking(User initial, User ending) {
        List<User> network = dijkstra(initial, ending);
        System.out.println();

        for (User user : network) {
            System.out.println("\t" + user.getId() + ": " + user.getName());
            if (network.get(network.size() - 1).getId() != user.getId()) {
                System.out.println("\t" + "↓");
            }
        }

        if (network.size() == 0) {
            System.out.println("Els usuaris no tenen relació entre seguits.");
        }
    }
}