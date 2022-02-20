import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphDAO {

    private static final String path = "files/";
    private final String DELIMETER_CHARACTER = ";";

    public List<User> readFile (String filename) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path + filename));

        List<User> users = new LinkedList<>();
        List<Relationship> relationships = new LinkedList<>();

        int numberOfUsers = Integer.parseInt(lines.get(0));
        int lineNum = 1;

        for (int i = 0; i < numberOfUsers; i++) {
            String line = lines.get(i+lineNum);
            String[] split = line.split(DELIMETER_CHARACTER);
            String interests = null;
            
            if (split.length > 3) {
                interests = split[3];
            }
            
            User user = new User (
                    Integer.parseInt(split[0]),
                    split[1],
                    split[2],
                    interests,
                    new LinkedList<>(),
                    new LinkedList<>());
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

        for (Relationship relationship : relationships) {
            int relationshipA = relationship.getA();
            int relationshipB = relationship.getB();
            for (User user : users) {
                int userA = user.getId();
                if (relationshipA == userA) {
                    for (User follower : users) {
                        if (follower.getId() == relationshipB) {
                            Adjacency adjacency = new Adjacency(follower.getId(),relationship.getTimestamp(),relationship.getInteractions());
                            user.getFollowers().add(adjacency);
                            Adjacency adjacency1 = new Adjacency(user.getId(),relationship.getTimestamp(),relationship.getInteractions());
                            follower.getFollowing().add(adjacency1);
                            break;
                        }
                    }
                    break;
                }
            }
        }

        return users;
    }
}
