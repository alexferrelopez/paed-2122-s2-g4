import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Graph graph = new Graph(new GraphDAO().readFile("graphS.paed"));
            UIManager      uiManager       = new UIManager();
            BFSController  bfsController   = new BFSController(4);
            Controller     controller      = new Controller     (uiManager, bfsController, graph);
            controller.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*try {
            Graph graph = new Graph(new GraphDAO().readFile("graphXXL.paed"));

            List<User> userLists = graph.getUserLists();

            int sum1 = 0;
            int sum2 = 0;

            for (User userList : userLists) {
                sum1 += userList.getFollowing().size();
            }

            for (User userList : userLists) {
                sum2 += userList.getFollowers().size();
            }

            System.out.println(sum1);
            System.out.println(sum2);

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
