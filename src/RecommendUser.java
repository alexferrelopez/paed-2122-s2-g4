import java.util.LinkedList;

public class RecommendUser {

    private final Graph graph;
    private final UIManager uiManager;

    private LinkedList<User> usersYouFollow                = new LinkedList<>();

    private LinkedList<User> usersFollowingByUserYouFollow = new LinkedList<>();
    private LinkedList<User> usersThatFollowYou            = new LinkedList<>();
    private LinkedList<User> usersWithSameInterests        = new LinkedList<>();

    private final LinkedList<User> union = new LinkedList<>();
    private int userID;

    /**
     *
     * Constructs the recommendUser with the graph of all the users
     * and the uiManager to show and get information.
     *
     * @param graph has all the users that are in the file.
     * @param uiManager has all the messages to show and to get information.
     *
     */

    public RecommendUser (Graph graph, UIManager uiManager) {
        this.graph     = graph;
        this.uiManager = uiManager;
    }

    /**
     *
     * Method to show all the recommended users which are users that
     * follow you, users that are following by a user you follow
     * and finally the users with the same interests of you.
     * Of course the users recommended can't be a user you already follow.
     *
     * @param userID number of the userID that you want to look for.
     *
     */

    public void recommendUser () {

        /* Check the userID inserted */
        checkUserIDInserted();

        /* Accounts that follow the user must be prioritized. */
        getUserFollowers(userID);

        /* Priority should be given to users that are tracked by someone the user is already following. */
        getUsersYouFollow(userID);

        /* Priority should be given to accounts that share interests with the user. The more the better. */
        getUsersWithSameInterests(userID);
        getUsersFollowingByUserYouFollow();

        // Remove all the users that you already follow
        usersThatFollowYou.removeIf(u -> usersYouFollow.contains(u));
        usersFollowingByUserYouFollow.removeIf(u -> usersYouFollow.contains(u));
        usersWithSameInterests.removeIf(u -> usersYouFollow.contains(u));

        // Union of all the users with priority
        addUsersToList(usersThatFollowYou,            union);
        addUsersToList(usersFollowingByUserYouFollow, union);
        addUsersToList(usersWithSameInterests,        union);

        // Print all the information
        for (User u : union) {
            uiManager.showUserInformation (u);

            if (usersThatFollowYou.contains(u) && !usersFollowingByUserYouFollow.contains(u) && !usersWithSameInterests.contains(u)) {
                uiManager.showIfUserFollow();
            } else if (!usersThatFollowYou.contains(u) && !usersFollowingByUserYouFollow.contains(u) && usersWithSameInterests.contains(u)) {
                uiManager.showIfUserHasSameInterests (getNumberOfInterests(userID, u));
            } else if (usersThatFollowYou.contains(u) && !usersFollowingByUserYouFollow.contains(u) && usersWithSameInterests.contains(u)) {
                uiManager.showIfUserHasSameInterestsAndFollow (getNumberOfInterests(userID, u));
            }
        }

        // Reset all the lists
        usersYouFollow                = new LinkedList<>();
        usersThatFollowYou            = new LinkedList<>();
        usersWithSameInterests        = new LinkedList<>();
        usersFollowingByUserYouFollow = new LinkedList<>();
    }

    /**
     *
     * Method to check if the user ID inserted exist and is in the file
     * Else show an error message and ask again the user ID.
     *
     */

    private void checkUserIDInserted () {
        do {
            userID = uiManager.getUserID ();
            userID = getUserID  (userID);

            if (userID == -1) {
                uiManager.wrongUserID();
            }

        } while (userID == -1);
    }

    private void addUsersToList (LinkedList<User> users, LinkedList<User> list) {
        for (User u : users) {
            if (!list.contains(u)) {
                list.add(u);
            }
        }
    }

    private int getNumberOfInterests (int userID, User u) {
        int numberOfSameInterests = 0;

        String[] interestsUserInserted = graph.getUserList().get(userID).getInterests().split(",");
        String[] interestsUserSearched = u.getInterests().split(",");

        for (String string1 : interestsUserInserted) {
            for (String string2 : interestsUserSearched) {
                if (string1.equals(string2)) {
                    numberOfSameInterests++;
                }
            }
        }

        return numberOfSameInterests;
    }

    private void getUsersYouFollow (int userID) {
        for (Adjacency adj : graph.getUserList().get(userID).getFollowing()) {
            for (User user : graph.getUserList()) {
                if (user.getId() == adj.getAdjacentUser()) {
                    usersYouFollow.add(user);
                }
            }
        }
    }

    private void getUserFollowers (int userID) {
        for (Adjacency adj : graph.getUserList().get(userID).getFollowers()) {      // Search all the users that follow a user
            for (User user : graph.getUserList()) {                                 // From the graph of all the users
                if (user.getId() == adj.getAdjacentUser()) {                        // We look for the same userID to search the users that follow him.
                    usersThatFollowYou.add(user);
                }
            }
        }
    }

    private void getUsersWithSameInterests (int userID) {
        String[] interests = graph.getUserList().get(userID).getInterests().split(",");

        for (String interest : interests) {                                         // Compare all the user interests
            for (User user : graph.getUserList()) {                                 // with the interests of the others users
                if (user.getInterests() != null &&                                  // if the interests are not null
                        user.getInterests().contains(interest) &&                   // if contains someone of the interests
                        user.getId() != graph.getUserList().get(userID).getId() &&  // if is not the interest of the user we are searching
                        !usersWithSameInterests.contains(user)
                ) {
                    usersWithSameInterests.add(user);
                }
            }
        }
    }

    private void getUsersFollowingByUserYouFollow () {
        for (User user : usersYouFollow) {
            for (Adjacency adj : graph.getUserList().get (getUserID (user.getId())).getFollowing()) {
                for (User user2 : graph.getUserList()) {
                    if (user2.getId() == adj.getAdjacentUser() && !usersFollowingByUserYouFollow.contains(user2)) {
                        usersFollowingByUserYouFollow.add(user2);
                    }
                }
            }
        }
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
        return -1;
    }
}
