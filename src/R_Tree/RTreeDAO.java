package R_Tree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class RTreeDAO {

    private final String path = "files/";
    private final RTree rTree;

    public RTreeDAO(RTree rTree) {
        this.rTree = rTree;
    }

    public Rectangle readFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path + filename));

        int numberOfCircles = Integer.parseInt(lines.get(0));

        for (int i = 0; i < numberOfCircles; i++) {
            String line = lines.get(i + 1);
            String[] split = line.split(";");

            Cercle cercle = new Cercle(
                    Double.parseDouble(split[0]),
                    Double.parseDouble(split[1]),
                    Double.parseDouble(split[2]),
                    split[3]
            );

            rTree.insert(rTree.getRoot(),cercle);
        }

        return rTree.getRoot();
    }

}
