public class Controller {

    private final UIManager     uiManager;
    private final BFSController bfsController;
    private final Graph         graph;
    private final RecommendUser recommendUser;

    public Controller (Graph graph, UIManager uiManager, BFSController bfsController, RecommendUser recommendUser) {
        this.graph         = graph;
        this.uiManager     = uiManager;
        this.bfsController = bfsController;
        this.recommendUser = recommendUser;
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
                case EXPLORAR       -> bfsController.BreadthFirstSearch (graph, graph.getIndexOfMostFollowingUser());
                case RECOMANAR      -> recommendUser.recommendUser      ();
                case CONTEXTUALIZAR -> System.out.println("Contextualiza");
                case NETWORKING     -> System.out.println("Networking");
                case ENRERE         -> back = true;
            }
        }
    }
}
