import java.io.IOException;

public class Controller {

    private UIManager uiManager;
    private BFSController bfsController;
    private Graph graph;

    public void run () {
        try {
            graph = new Graph(new GraphDAO().readFile("graphL.paed"));
            uiManager       = new UIManager();
            bfsController   = new BFSController(graph.findListSize());
        } catch (
                IOException e) {
            e.printStackTrace();
        }

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
                case EXPLORAR       -> bfsController.exploreTheWeb(graph, graph.getIndexOfMostFollowingUser());
                case RECOMANAR      -> System.out.println("Recomana");
                case CONTEXTUALIZAR -> System.out.println("Contextualiza");
                case NETWORKING     -> System.out.println("Networking");
                case ENRERE         -> back = true;
            }
        }
    }
}
