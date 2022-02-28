public class Controller {

    private final UIManager     uiManager;
    private final BFSController bfsController;
    private final Graph         graph;
    private final RecommendUser recommendUser;
    private final DijkstraController dijkstraController;

    public Controller (Graph graph, UIManager uiManager, BFSController bfsController, RecommendUser recommendUser, DijkstraController dijkstraController) {
        this.graph         = graph;
        this.uiManager     = uiManager;
        this.bfsController = bfsController;
        this.recommendUser = recommendUser;
        this.dijkstraController = dijkstraController;
    }

    public void run () {
        boolean exit = false;

        while (!exit) {
            switch (uiManager.showLinkedTreeMenu()) {
                case SEGUIDORS -> menuFollowers();
                case SORTIR    -> exit = true;
            }
        }
    }

    private void menuFollowers () {
        boolean back = false;

        while (!back) {
            switch (uiManager.showFollowersMenu()) {
                case EXPLORAR       -> bfsController.exploreTheWeb (graph, graph.getIndexOfMostFollowingUser());
                case RECOMANAR      -> recommendUser.recommendUser      ();
                case CONTEXTUALIZAR -> System.out.println("Contextualiza");
                case NETWORKING     -> {
                    int[] Ids = uiManager.requestUsersNetworking(graph);
                    dijkstraController.networking(graph.getUserList().get(graph.findUserIndex(Ids[0])),graph.getUserList().get(graph.findUserIndex(Ids[1])));
                }
                case ENRERE         -> back = true;
            }
        }
    }
}
