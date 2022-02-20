public class Controller {

    private final UIManager uiManager;
    private final BFSController bfsController;
    private final Graph graph;

    public Controller (UIManager uiManager, BFSController bfsController, Graph graph) {
        this.uiManager = uiManager;
        this.bfsController = bfsController;
        this.graph = graph;
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
        User user = new User();

        while (!back) {
            switch (uiManager.showFollowersMenu()) {
                case EXPLORAR       -> bfsController.BFS(graph, user);
                case RECOMANAR      -> System.out.println("Recomana");
                case CONTEXTUALIZAR -> System.out.println("Contextualiza");
                case NETWORKING     -> System.out.println("Networking");
                case ENRERE         -> back = true;
            }
        }
    }
}
