package Graph;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String alias;
    private String interests;
    private List<Adjacency> followers;
    private List<Adjacency> following;

    public User(int id, String name, String alias, String interests, List<Adjacency> followers, List<Adjacency> following) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.interests = interests;
        this.followers = followers;
        this.following = following;
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

    public List<Adjacency> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Adjacency> followers) {
        this.followers = followers;
    }

    public List<Adjacency> getFollowing() {
        return following;
    }

    public void setFollowing(List<Adjacency> following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return "\n\t" + id + " - " + name + " (" + alias + ")\n" +
                "\tInteressos: " + interests;
    }
}
