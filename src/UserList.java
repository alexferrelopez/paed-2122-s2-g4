public class UserList {
    private int id;
    private String name;
    private String alias;
    private String interests;

    public UserList(int id, String name, String alias, String interests) {
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

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }
}
