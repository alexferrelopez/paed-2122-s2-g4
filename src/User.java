import java.util.Collections;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String alias;
    private List<String> interests;

    public User(int id, String name, String alias, List<String> interests) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.interests = interests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
}
