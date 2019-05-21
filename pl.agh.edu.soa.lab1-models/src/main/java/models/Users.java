package models;

import java.util.HashMap;
import java.util.Map;

public class Users {

    public Map<String, String> getUsers() {
        return users;
    }

    public void setUsers(Map<String, String> users) {
        this.users = users;
    }

    private Map<String, String> users;


    public Users() {
        users = new HashMap<>();
        users.put(new String("ppp"), new String("ppp"));
    }


}
