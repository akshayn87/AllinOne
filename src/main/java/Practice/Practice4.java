package Practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Practice4 {
	private static String JsonValue;
	
	public static JSONObject parseJSONFile(String filename) throws  IOException, ParseException {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        JSONParser parser = new JSONParser(); 
        JSONObject json = (JSONObject) parser.parse(content);
        
        return new JSONObject(json);
    }

    public static void main(String[] args) throws IOException, ParseException {
//        String filename = "C:/Users/Akshay/Desktop/sample2.json";
//        JSONObject jsonObject = parseJSONFile(filename);
//        JSONArray jsonarray =(JSONArray) jsonObject.get("data");
//        JSONObject jsonObjectinner =(JSONObject) jsonarray.get(0);
//        JSONObject jsonObjectinner2 =(JSONObject) jsonarray.get(1);
//       
//        System.out.println(jsonObject.get("data"));
//        System.out.println(jsonarray.get(0));
//        System.out.println(jsonObjectinner.get("name"));
//        System.out.println(jsonObjectinner2.get("name"));
//        System.out.println(jsonObjectinner.get("age"));
//        jsonObject.entrySet().forEach( k-> {
//        	System.out.println(k);
//        });
//        
//        jsonObjectinner.forEach((k,v) -> {
//        	if(k.equals("name"))
//        	System.out.println(v);
//        });
//        
//       String val= JSONNodeValueFinder(filename,"name");
//        System.out.println(val);
//        	
        }

	private static String JSONNodeValueFinder(String filename,String parameter) throws IOException, ParseException {
		String val = null;
		String content = new String(Files.readAllBytes(Paths.get(filename)));
        JSONParser parser = new JSONParser(); 
        JSONObject json = (JSONObject) parser.parse(content);
        
		json.forEach((data,array) -> {
        ((JSONArray) array).forEach(k ->{
        	((HashMap) k).forEach((k1,v1) ->{
        		//System.out.println("values: "+v1);
        		if(parameter.equalsIgnoreCase(k1.toString())) {
        		 //System.out.println(parameter);
        		 JsonValue =v1.toString();	
        		}
        	});
        });
        
        });
 return JsonValue;
	}
       
        
	
    
}
