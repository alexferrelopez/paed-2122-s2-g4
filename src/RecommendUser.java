import java.util.List;

public class RecommendUser {

    private final Graph graph;

    public RecommendUser (Graph graph) {
        this.graph = graph;
    }

    public void recommendUser (int userID) {
        userID = getUserID(userID);

        System.out.println(graph.getUserList().get(userID));

        /* Accounts that the user is already following cannot be recommended. */
        System.out.println("USUARIOS QUE NO SIGUE");

        for (Adjacency adj : graph.getUserList().get(userID).getFollowing()) {      // Search all the users that a user follows
            for (User user : graph.getUserList()) {                                 // From the graph of all the users
                if (user.getId() != adj.getAdjacentUser() &&                        // We look for a different userID to search the users that is not following
                        user.getId() != graph.getUserList().get(userID).getId()) {  // And we also look that don't recommend himself.
                    System.out.println(user);
                }
            }
        }

        /* Accounts that follow the user must be prioritized. */
        System.out.println("USUARIOS QUE LE SIGUEN");

        for (Adjacency adj : graph.getUserList().get(userID).getFollowers()) {      // Search all the users that follow a user
            for (User user : graph.getUserList()) {                                 // From the graph of all the users
                if (user.getId() == adj.getAdjacentUser()) {                        // We look for the same userID to search the users that follow him.
                    System.out.println(user);
                }
            }
        }

        /* Priority should be given to accounts that share interests with the user. The more the better. */

        System.out.println("USUARIOS QUE COMPARTEN INTERESES");

        String[] interests = graph.getUserList().get(userID).getInterests().split(",");

       /* for (String interest : interests) {      // Search all the users that follow a user
            for (User user : graph.getUserList()) {                                 // From the graph of all the users
                if (user.getInterests() ) {                        // We look for the same userID to search the users that follow him.
                    System.out.println(user);
                }
            }
        }*/
    }

    /**
     *
     * Method that gets the userID and search for the user position in the graph
     *
     * @param userID integer number which is the ID of the user
     * @return the user position in the graph
     *
     */

    private int getUserID (int userID) {
        for (int i = 0; i < graph.getUserList().size(); i++) {
            if (graph.getUserList().get(i).getId() == userID) {
                return i;
            }
        }
        return 0;
    }
}
