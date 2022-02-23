import java.io.IOException;

public class Controller {

    private final UIManager     uiManager;
    private final BFSController bfsController;
    private final Graph         graph;
    private final RecommendUser recommendUser;

    public Controller () throws IOException {
        this.graph         = new Graph         (new GraphDAO().readFile("graphS.paed"));;
        this.uiManager     = new UIManager     ();
        this.bfsController = new BFSController (graph.findListSize());
        this.recommendUser = new RecommendUser (graph);
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
                case RECOMANAR      -> recommendUser.recommendUser      (uiManager.getUserID (graph.findListSize()));
                case CONTEXTUALIZAR -> System.out.println("Contextualiza");
                case NETWORKING     -> System.out.println("Networking");
                case ENRERE         -> back = true;
            }
        }
    }
}
