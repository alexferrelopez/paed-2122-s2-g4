import java.util.ArrayList;
import java.util.LinkedList;

public class User {
    private String nameUser;
    private ArrayList<UserList> userLists;
    private int numberRelationships;
    private ArrayList<ListRelationships> listRelationships;

    public User(String nameUser, ArrayList<UserList> userLists, int numberRelationships, ArrayList<ListRelationships> listRelationships) {
        this.nameUser = nameUser;
        this.userLists = userLists;
        this.numberRelationships = numberRelationships;
        this.listRelationships = listRelationships;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public ArrayList<UserList> getUserLists() {
        return userLists;
    }

    public void setUserLists(ArrayList<UserList> userLists) {
        this.userLists = userLists;
    }

    public int getNumberRelationships() {
        return numberRelationships;
    }

    public void setNumberRelationships(int numberRelationships) {
        this.numberRelationships = numberRelationships;
    }

    public ArrayList<ListRelationships> getListRelationships() {
        return listRelationships;
    }

    public void setListRelationships(ArrayList<ListRelationships> listRelationships) {
        this.listRelationships = listRelationships;
    }
}
