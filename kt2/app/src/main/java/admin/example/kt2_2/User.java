package admin.example.kt2_2;

import java.util.HashMap;
import java.util.Map;

public class User {
    private int id;
    private String name;

    public User(){

    }
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Map<String , Object> toMap(){
        HashMap<String,Object> result  = new HashMap<>();
        result.put("name", name);
        return result;
    }
}
