package Tree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TreeDAO {

    private final String path = "files/";
    private final Tree tree;

    public TreeDAO (Tree tree) {
        this.tree = tree;
    }

    /**
     *
     * Method to read all the nodes what are in the file.
     *
     * @param filename string with the filename.
     *
     * @return the root node with all his children
     * @throws IOException If something go wrong with the reading of the file
     *
     */

    public Node readFile (String filename) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path + filename));

        int numberOfAlgorithms = Integer.parseInt(lines.get(0));

        Node root = null;

        for (int i = 0; i < numberOfAlgorithms; i++) {
            String line = lines.get(i + 1);
            String[] split = line.split(";");

            Node node = new Node(
                    Long.parseLong(split[0]),
                    split[1],
                    split[2],
                    split[3],
                    Long.parseLong(split[4])
            );

            if (i == 0) {
                root = node;
            } else {
                tree.insert(root, node);
            }
        }

        return root;
    }
}
