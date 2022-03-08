import Graph.GraphDAO;
import Graph.Graph;
import Graph.UIManager;
import Graph.BFSController;
import Graph.RecommendUser;
import Graph.DijkstraController;
import Graph.TopologicalArrangement;

import java.io.IOException;

/**
 *
 *   Created by: Alex Ferré, Tomás Uzcudún and Sami Amin <br><br>
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
            GraphDAO graphDAO           = new GraphDAO();
            Graph graph                 = new Graph(graphDAO.readFile("graphS.paed"));
            UIManager uiManager         = new UIManager();
            BFSController bfsController = new BFSController(graph.findListSize());
            RecommendUser recommendUser = new RecommendUser(graph, uiManager);
            DijkstraController dijkstraController = new DijkstraController(graph);
            TopologicalArrangement topologicalArrangement = new TopologicalArrangement();

            Controller controller       = new Controller (
                    graph,
                    uiManager,
                    bfsController,
                    recommendUser,
                    dijkstraController,
                    topologicalArrangement
            );

            controller.run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
