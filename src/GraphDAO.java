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

        quicksort(users,0,users.size()-1);

        return users;
    }

    public static void quicksort(List<User> users, int izq, int der) {

        User pivote=users.get(izq); // el primer User como pivote
        int i=izq;                  // i corresponde al extremo izquierdo de la lista.
        int j=der;                  // j corresponde al extremo derecho de la lista.
        User aux;

        while(i < j){               // mientras no se crucen los punteros
            while(users.get(i).getId() <= pivote.getId() && i < j) i++; // busca ID mayor que el ID del pivote
            while(users.get(j).getId() > pivote.getId()) j--;           // busca ID menor que el ID del pivote
            if (i < j) {                                 // si no se han cruzado
                aux = users.get(i);                      // los intercambia
                users.set(i,users.get(j));
                users.set(j,aux);
            }
        }

        users.set(izq,users.get(j));      // se coloca el pivote en su lugar de forma que tendremos
        users.set(j,pivote);              // los menores a su izquierda y los mayores a su derecha

        if(izq < j-1)
            quicksort(users,izq,j-1);          // ordenamos subarray izquierdo
        if(j+1 < der)
            quicksort(users,j+1,der);          // ordenamos subarray derecho
    }
}
