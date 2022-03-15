import Graph.Graph;
import Graph.UIManager;
import Graph.Options.BFSController;
import Graph.Options.RecommendUser;
import Graph.Options.DijkstraController;
import Graph.Options.TopologicalArrangement;
import Tree.*;
import Tree.Options.BasicFunctions;
import Tree.Options.Feed;
import Tree.Options.SearchTimestamp;

import java.io.IOException;

public class Controller {

    private final UIManager uiManager;
    private final BFSController bfsController;
    private final Graph         graph;
    private final RecommendUser recommendUser;
    private final DijkstraController dijkstraController;
    private final TopologicalArrangement topologicalArrangement;

    private Node root;
    private final BasicFunctions basicFunctions;
    private final UIManagerTree uiManagerTree;
    private final Feed feed;
    private final SearchTimestamp searchTimestamp;

    public Controller (Graph graph, UIManager uiManager,
                       BFSController bfsController, RecommendUser recommendUser,
                       DijkstraController dijkstraController, TopologicalArrangement topologicalArrangement,

                       Node root, BasicFunctions basicFunctions, UIManagerTree uiManagerTree, Feed feed, SearchTimestamp searchTimestamp
    ) {
        this.graph         = graph;
        this.uiManager     = uiManager;
        this.bfsController = bfsController;
        this.recommendUser = recommendUser;
        this.dijkstraController = dijkstraController;
        this.topologicalArrangement = topologicalArrangement;

        this.root = root;
        this.basicFunctions = basicFunctions;
        this.uiManagerTree = uiManagerTree;
        this.feed = feed;
        this.searchTimestamp = searchTimestamp;
    }

    public void run () throws IOException {
        boolean exit = false;

        while (!exit) {
            switch (uiManager.showLinkedTreeMenu()) {
                case SEGUIDORS -> menuFollowers();
                case FEED      -> menuTree ();
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
                case AFEGIR       -> basicFunctions.addAlgorithm (root);
                case ELIMINAR     -> back = true;
                case LISTAR       -> feed.inOrder (root);
                case CERCA_EXACTA -> searchTimestamp.searchExactTimestamp (root, uiManagerTree.getExactTimestamp());
                case CERCA_RANG   -> {
                    long minim = uiManagerTree.getMinimTimestamp();
                    long maxim = uiManagerTree.getMaximTimestamp();

                    uiManagerTree.algorithmFoundMessage (3);
                    searchTimestamp.searchRangTimestamp (root, minim, maxim);
                }
                case BACK         -> back = true;
            }
        }
    }
}
