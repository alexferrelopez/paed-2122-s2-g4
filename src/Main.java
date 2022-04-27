import Graph.Graph;
import Graph.GraphDAO;
import Graph.Options.BFSController;
import Graph.Options.DijkstraController;
import Graph.Options.RecommendUser;
import Graph.Options.TopologicalArrangement;
import Graph.UIManagerGraph;
import R_Tree.RTree;
import R_Tree.RTreeDAO;
import R_Tree.UIManagerCanvas;
import Tree.Options.BasicFunctions;
import Tree.Options.Feed;
import Tree.Options.SearchTimestamp;
import Tree.Tree;
import Tree.TreeDAO;
import Tree.UIManagerTree;

import java.io.IOException;

/**
 * Created by: Àlex Ferré, Tomás Uzcudún and Sami Amin <br><br>
 * Subject: PAED - Project S2 <br>
 * Last Modification: 27/02/2022 <br>
 * Version: 1.0 <br>
 */

public class Main {

    /**
     * Main function where we instantiate all the classes
     */

    public static void main(String[] args) {
        try {
            UIManager uiManager                           = new UIManager();

            //--------------------------- GRAPH ALGORITHMS ------------------------------------//

            GraphDAO graphDAO                             = new GraphDAO();
            Graph graph                                   = new Graph(graphDAO.readFile("graphS.paed"));
            UIManagerGraph uiManagerGraph                 = new UIManagerGraph();
            BFSController bfsController                   = new BFSController(graph.findListSize());
            RecommendUser recommendUser                   = new RecommendUser(graph, uiManagerGraph);
            DijkstraController dijkstraController         = new DijkstraController(graph);
            TopologicalArrangement topologicalArrangement = new TopologicalArrangement();

            //--------------------------- TREE ALGORITHMS ------------------------------------//

            Tree tree                                     = new Tree ();
            tree.setRoot(new TreeDAO(tree).readFile("treeXXS.paed"));
            UIManagerTree uiManagerTree                   = new UIManagerTree();
            BasicFunctions basicFunctions                 = new BasicFunctions (uiManagerTree, tree);
            Feed listAlgorithms                           = new Feed(uiManagerTree);
            SearchTimestamp searchTimestamp               = new SearchTimestamp(uiManagerTree);

            //--------------------------- R_TREE ALGORITHMS ----------------------------------//

            RTree rTree                                   = new RTree();
            rTree.setRoot(new RTreeDAO(rTree).readFile("test.paed"));
            UIManagerCanvas uiManagerCanvas               = new UIManagerCanvas();


            Controller controller                         = new Controller (
                    uiManager,
                    graph,
                    uiManagerGraph,
                    bfsController,
                    recommendUser,
                    dijkstraController,
                    topologicalArrangement,

                    tree,
                    basicFunctions,
                    uiManagerTree,
                    listAlgorithms,
                    searchTimestamp,
                    rTree,
                    uiManagerCanvas
            );
            controller.run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
