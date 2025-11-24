/**
 * 
 */
package JSonDeserealizer;

import org.json.JSONObject;

/**
 * @author Akshay
 *
 */
public class ParseDyamicJson {
	
	public static void parseObject(JSONObject json,String key) {
		//System.out.println(json.has(key));
		System.out.println(json.get(key));
		
	}
	
	public static void getKey(JSONObject json,String key) {
		boolean exists =json.has(key);
		if(!exists) {
			
		}else {
			parseObject(json,key);
		}
		
	}


public static void main(String[] args) {
	String inputJson ="{\r\n"
			+ "    \"fruit\": \"Apple\",\r\n"
			+ "    \"size\": \"Large\",\r\n"
			+ "    \"color\": \"Red\"\r\n"
			+ "}";
	
	JSONObject inputJSONObject = new JSONObject(inputJson);
	getKey(inputJSONObject,"fruit");
	getKey(inputJSONObject,"color");
}
}

