package Graph;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String alias;
    private String interests;
    private List<Adjacency> followers;
    private List<Adjacency> following;

    /**
     *
     * Constructor method to instantiate a new user when is needed.
     *
     * @param id of the user
     * @param name of the user
     * @param alias of the user
     * @param interests of the user
     * @param followers of the user
     * @param following of the user
     *
     */

    public User(int id, String name, String alias, String interests, List<Adjacency> followers, List<Adjacency> following) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.interests = interests;
        this.followers = followers;
        this.following = following;
    }

    /**
     *
     * Method to get the id of the user.
     *
     * @return the id as integer number.
     *
     */

    public int getId() {
        return id;
    }

    /**
     *
     * Method to get the name of the user.
     *
     * @return the name of the user as string.
     *
     */

    public String getName() {
        return name;
    }

    /**
     *
     * Method to get the alias name of the user.
     *
     * @return the alias name as string.
     *
     */

    public String getAlias() {
        return alias;
    }

    /**
     *
     * Method to set the alias name of the user.
     *
     * @param alias name that you want to set.
     *
     */

    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     *
     * Method to get the interests of a user.
     *
     * @return the interests of the user.
     *
     */

    public String getInterests() {
        return interests;
    }

    /**
     *
     * Method to set the interests of a user.
     *
     * @param interests the interests that you want to set.
     *
     */

    public void setInterests(String interests) {
        this.interests = interests;
    }

    /**
     *
     * List with all the followers that has a user.
     *
     * @return the list with all the followers.
     *
     */

    public List<Adjacency> getFollowers() {
        return followers;
    }

    /**
     *
     * List with all the users that follow a user.
     *
     * @return the list with all the users.
     *
     */

    public List<Adjacency> getFollowing() {
        return following;
    }

    /**
     *
     * Method to print as string with the requirements.
     *
     * @return the string.
     *
     */

    @Override
    public String toString() {
        return "\n\t" + id + " - " + name + " (" + alias + ")\n" +
                "\tInteressos: " + interests;
    }
}
