import Graph.Graph;
import Graph.UIManager;
import Graph.Options.BFSController;
import Graph.Options.RecommendUser;
import Graph.Options.*;
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

    private final Tree tree;
    private final BasicFunctions basicFunctions;
    private final UIManagerTree uiManagerTree;
    private final Feed feed;
    private final SearchTimestamp searchTimestamp;

    /**
     *
     * Constructor of the controller where we initialize all the necessary classes
     * to control all the program execution.
     *
     * @param graph                   to read the graph file.
     * @param uiManager               to manage the messages of the graph.
     * @param bfsController           to do the search.
     * @param recommendUser           to manage the recommendation of the user.
     * @param dijkstraController      to manage the dijkstra.
     * @param topologicalArrangement  to manage the topological arrangement.
     *
     * @param tree                    to read the tree file.
     * @param basicFunctions          to do the basic functions, add or eliminate node
     * @param uiManagerTree           to manage the messages of the tree.
     * @param feed                    to list all the nodes of the tree.
     * @param searchTimestamp         to do the searches of the timestamps.
     */

    public Controller(Graph graph, UIManager uiManager,
                      BFSController bfsController, RecommendUser recommendUser,
                      DijkstraController dijkstraController, TopologicalArrangement topologicalArrangement,

                      Tree tree, BasicFunctions basicFunctions, UIManagerTree uiManagerTree, Feed feed, SearchTimestamp searchTimestamp
    ) {
        this.graph         = graph;
        this.uiManager     = uiManager;
        this.bfsController = bfsController;
        this.recommendUser = recommendUser;
        this.dijkstraController = dijkstraController;
        this.topologicalArrangement = topologicalArrangement;

        this.tree = tree;
        this.basicFunctions = basicFunctions;
        this.uiManagerTree = uiManagerTree;
        this.feed = feed;
        this.searchTimestamp = searchTimestamp;
    }

    /**
     *
     * Method with the initial menu
     *
     * @throws IOException if there is some error reading the files.
     *
     */

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

    /**
     *
     * Method to manage the menu of the followers. (Graphs)
     *
     * @throws IOException if there is some error reading the files.
     *
     */

    private void menuFollowers () throws IOException {
        boolean back = false;

        while (!back) {
            switch (uiManager.showFollowersMenu()) {
                case EXPLORAR       -> bfsController.exploreTheWeb (graph, graph.getIndexOfMostFollowingUser());
                case RECOMANAR      -> recommendUser.recommendUser ();
                case CONTEXTUALIZAR -> topologicalArrangement.view ();
                case NETWORKING     -> {
                    int[] Ids = uiManager.requestUsersNetworking(graph);
                    dijkstraController.networking(graph.getUserList().get(graph.findUserIndex(Ids[0])),graph.getUserList().get(graph.findUserIndex(Ids[1])));
                }
                case ENRERE         -> back = true;
            }
        }
    }

    /**
     *
     * Method to manage the tree menu (Tree)
     *
     */

    private void menuTree () {
        boolean back = false;

        while (!back) {
            switch (uiManagerTree.showTreeMenu()) {
                case AFEGIR       -> basicFunctions.addAlgorithm (tree.getRoot());
                case ELIMINAR     -> basicFunctions.deleteAlgorithm();
                case LISTAR       -> feed.inOrder (tree.getRoot());
                case CERCA_EXACTA -> searchTimestamp.searchExactTimestamp (tree.getRoot(), uiManagerTree.getExactTimestamp());
                case CERCA_RANG   -> {
                    long minim = uiManagerTree.getMinimTimestamp();
                    long maxim = uiManagerTree.getMaximTimestamp();

                    uiManagerTree.algorithmFoundMessage (3);
                    searchTimestamp.searchRangTimestamp (tree.getRoot(), minim, maxim);
                }
                case BACK         -> back = true;
            }
        }
    }
}
