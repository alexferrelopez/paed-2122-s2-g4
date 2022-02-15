import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Graph graph = new GraphDAO().readFile("graphS.paed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
