import Graph.*;
import Graph.Options.*;
import Tree.*;
import Tree.Options.BasicFunctions;
import Tree.Options.Feed;
import Tree.Options.SearchTimestamp;

import java.io.IOException;

/**
 *
 *   Created by: Àlex Ferré, Tomás Uzcudún and Sami Amin <br><br>
 *   Subject: PAED - Project S2 <br>
 *   Last Modification: 27/02/2022 <br>
 *   Version: 1.0 <br>
 *
 */

public class Main {

    /**
     *
     *  Main function where we instantiate all the classes
     *
     */

    public static void main (String[] args) {
        try {
            GraphDAO graphDAO                             = new GraphDAO();
            Graph graph                                   = new Graph(graphDAO.readFile("graphS.paed"));
            UIManager uiManager                           = new UIManager();
            BFSController bfsController                   = new BFSController(graph.findListSize());
            RecommendUser recommendUser                   = new RecommendUser(graph, uiManager);
            DijkstraController dijkstraController         = new DijkstraController(graph);
            TopologicalArrangement topologicalArrangement = new TopologicalArrangement();

            //--------------------------- TREE ALGORITHMS ------------------------------------//

            Tree tree                                     = new Tree ();
            tree.setRoot(new TreeDAO(tree).readFile("treeXXS.paed"));
            UIManagerTree uiManagerTree                   = new UIManagerTree();
            BasicFunctions basicFunctions                 = new BasicFunctions (uiManagerTree, tree);
            Feed listAlgorithms                           = new Feed(uiManagerTree, tree);
            SearchTimestamp searchTimestamp               = new SearchTimestamp(uiManagerTree, tree);

            Controller controller       = new Controller (
                    graph,
                    uiManager,
                    bfsController,
                    recommendUser,
                    dijkstraController,
                    topologicalArrangement,

                    tree,
                    basicFunctions,
                    uiManagerTree,
                    listAlgorithms,
                    searchTimestamp
            );
            controller.run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
