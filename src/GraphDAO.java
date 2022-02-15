import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphDAO {

    private static final String path = "files/";
    private final String DELIMETER_CHARACTER = ";";

    public Graph readFile (String filename) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path + filename));
        List<String> interestList = new ArrayList<>();

        List<User> users = new LinkedList<>();
        List<Relationship> relationships = new LinkedList<>();

        int numberOfUsers = Integer.parseInt(lines.get(0));
        int lineNum = 1;

        for (int i = 0; i < numberOfUsers; i++) {
            String line = lines.get(i+lineNum);
            String[] split = line.split(DELIMETER_CHARACTER);

            if (split.length > 2) {
                interestList = List.of(line.split(","));
            }

            User user = new User (
                    Integer.parseInt(split[0]),
                    split[1],
                    split[2],
                    interestList
            );
            users.add(user);
        }

        lineNum = numberOfUsers+1;
        int numberOfRelations = Integer.parseInt(lines.get(lineNum));
        lineNum++;

        for (int i = 0; i < numberOfRelations; i++) {
            String line = lines.get(i+lineNum);
            String[] split = line.split(DELIMETER_CHARACTER);

            Relationship relationship = new Relationship (
                    Integer.parseInt(split[0]),
                    Integer.parseInt(split[1]),
                    Integer.parseInt(split[2]),
                    Integer.parseInt(split[3])
            );

            relationships.add(relationship);
        }

        return new Graph(users, relationships);
    }
}
