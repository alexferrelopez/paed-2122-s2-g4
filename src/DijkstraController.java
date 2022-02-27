import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DijkstraController {

    private boolean[] visited;
    private List<List<User>> camins;
    private Graph graph;
    Long[] distancies;

    public List<User> networking (Graph g, User initial, User ending) {
        graph = g;
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

        distancies[g.findUserIndex(actual.getId())] = 0L;

        while (visitedIsFalse() && !visited[graph.findUserIndex(actualId)]) {
            List<User> adjacent = graph.findAdjacent(actualId);
            for (User user : adjacent) {
                int userIndex = graph.findUserIndex(user.getId());
                if (!visited[userIndex]) {
                    long newDistance = distancies[g.findUserIndex(actual.getId())] + graph.getTimestampBewteenUsers(actualId, user.getId());

                    if (distancies[userIndex] > newDistance) {
                        distancies[userIndex] = newDistance;
                        actualitzaCamins(actual, user);
                    }
                }
            }
            visited[graph.findUserIndex(actualId)] = true;
            actual = findNonVisitedMinimumDistance(userList);
        }


        List<User> answer = camins.get(graph.findUserIndex(ending.getId()));
        return answer;
    }

    private User findNonVisitedMinimumDistance(List<User> userList) {
        Long minDistance = Long.MAX_VALUE;
        int indexMin = 0;
        for (int i = 0; i < distancies.length; i++) {
            if (distancies[i] < minDistance && !visited[i]) {
                indexMin = i;
                minDistance = distancies[i];
            }
        }
        return userList.get(indexMin);
    }

    private boolean visitedIsFalse () {
        for (boolean nodeVisited : visited) {
            if (!nodeVisited) {
                return true;
            }
        }

        return false;
    }

    //TODO
    private void actualitzaCamins (User actual, User adjacent) {
        int adjacentIndex = graph.findUserIndex(adjacent.getId());
        if (camins.get(adjacentIndex) == null || camins.get(adjacentIndex).isEmpty()) {
            List<User> cami = new ArrayList<>();
            cami.add(actual);
            camins.set(adjacentIndex, cami);
        }
        else {
            camins.get(adjacentIndex).add(actual);
        }
    }

}