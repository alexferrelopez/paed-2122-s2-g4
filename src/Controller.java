import Graph.Graph;
import Graph.UIManager;
import Graph.BFSController;
import Graph.RecommendUser;
import Graph.DijkstraController;
import Graph.TopologicalArrangement;
import Tree.*;

import java.io.IOException;

public class Controller {

    private final UIManager uiManager;
    private final BFSController bfsController;
    private final Graph         graph;
    private final RecommendUser recommendUser;
    private final DijkstraController dijkstraController;
    private final TopologicalArrangement topologicalArrangement;
    private final Tree tree;
    private final UIManagerTree uiManagerTree;

    public Controller (Graph graph, UIManager uiManager, BFSController bfsController, RecommendUser recommendUser, DijkstraController dijkstraController, TopologicalArrangement topologicalArrangement, Tree tree, UIManagerTree uiManagerTree) {
        this.graph         = graph;
        this.uiManager     = uiManager;
        this.bfsController = bfsController;
        this.recommendUser = recommendUser;
        this.dijkstraController = dijkstraController;
        this.topologicalArrangement = topologicalArrangement;
        this.tree = tree;
        this.uiManagerTree = uiManagerTree;
    }

    public void run () throws IOException {
        boolean exit = false;

        while (!exit) {
            switch (uiManager.showLinkedTreeMenu()) {
                case SEGUIDORS -> menuFollowers();
                case FEED -> menuTree ();
                case SORTIR    -> exit = true;
            }
        }
    }

    private void menuFollowers () throws IOException {
        boolean back = false;

        while (!back) {
            switch (uiManager.showFollowersMenu()) {
                case EXPLORAR       -> bfsController.exploreTheWeb (graph, graph.getIndexOfMostFollowingUser());
                case RECOMANAR      -> recommendUser.recommendUser      ();
                case CONTEXTUALIZAR -> topologicalArrangement.view();
                case NETWORKING     -> {
                    int[] Ids = uiManager.requestUsersNetworking(graph);
                    dijkstraController.networking(graph.getUserList().get(graph.findUserIndex(Ids[0])),graph.getUserList().get(graph.findUserIndex(Ids[1])));
                }
                case ENRERE         -> back = true;
            }
        }
    }

    private void menuTree () {
        boolean back = false;

        while (!back) {
            switch (uiManagerTree.showTreeMenu()) {
                case AFEGIR ->back = true;
                case ELIMINAR ->back = true;
                case LISTAR ->back = true;
                case CERCA_EXACTA ->back = true;
                case CERCA_RANG  -> back = true;
                case BACK -> back = true;
            }
        }
    }
}
