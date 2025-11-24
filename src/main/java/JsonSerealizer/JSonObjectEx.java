package JsonSerealizer;

import org.json.simple.JSONObject;

public class JSonObjectEx {
	public static void main(String[] args) {

        var user = new JSONObject();

        user.put("name", "John Doe");
        user.put("occupation", "gardener");
        user.put("siblings", Integer.valueOf(2));
        user.put("height", Double.valueOf(172.35));
        user.put("married", Boolean.TRUE);

        var userJson = user.toString();

        System.out.println(userJson);
    }
}

