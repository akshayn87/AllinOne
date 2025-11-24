package JsonSerealizer;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class JsonObjectFromMap {

    public static void main(String[] args) {
	var data = new HashMap<String, String>();
    data.put("name", "John Doe");
    data.put("occupation", "gardener");
    data.put("siblings", "2");
    data.put("height", "172.35");
    data.put("married", "true");

    var user = new JSONObject(data);
    var userJson = user.toString();

    System.out.println(userJson);
}

}
