import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class GraphDAO {

    private static final String path = "files/";
    private final String DELIMETER_CHARACTER = ";";

    public List<User> readFile (String filename) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path + filename));

        List<User> users = new LinkedList<>();

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

            int relationshipA =Integer.parseInt(split[0]);
            int relationshipB = Integer.parseInt(split[1]);
            long timestamp = Long.parseLong(split[2]);
            int interactions = Integer.parseInt(split[3]);

            for (User user : users) {
                int userA = user.getId();
                if (relationshipA == userA) {
                    for (User follower : users) {
                        if (follower.getId() == relationshipB) {
                            Adjacency adjacency = new Adjacency(follower.getId(), timestamp, interactions);
                            Adjacency adjacency1 = new Adjacency(user.getId(), timestamp, interactions);

                            follower.getFollowers().add(adjacency1);
                            user.getFollowing().add(adjacency);
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
