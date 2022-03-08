package Tree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeDAO {

    private static final String path = "files/";
    private final String DELIMETER_CHARACTER = ";";

    public List<Algorithm> readFile (String filename) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path + filename));

        List<Algorithm> nodes = new ArrayList<>();

        int numberOfAlgorithms = Integer.parseInt(lines.get(0));
        int lineNum = 1;

        for (int i = 0; i < numberOfAlgorithms; i++) {
            String line = lines.get(i + lineNum);
            String[] split = line.split(DELIMETER_CHARACTER);

            Algorithm node = new Algorithm (
                    Long.parseLong(split[0]),
                    split[1],
                    split[2],
                    split[3],
                    Long.parseLong(split[4])
            );

            nodes.add(node);
        }

        for (int i = 0; i < nodes.size(); i++) {
            Algorithm node = nodes.get(i);

            if (i != 0) {
                node.setParent(nodes.get(i - 1));
            }

            if (i < nodes.size() - 1) {
                node.setLeft(nodes.get(i + 1));
            }

            if (i < nodes.size() - 2) {
                node.setRight(nodes.get(i + 2));
            }
        }

        return nodes;
    }
}
