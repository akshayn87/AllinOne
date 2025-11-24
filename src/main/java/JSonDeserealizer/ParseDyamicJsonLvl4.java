/**
 * 
 */
package JSonDeserealizer;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Akshay
 *
 */
public class ParseDyamicJsonLvl4 {
	
	public static void parseObject(JSONObject json,String key) {
		//System.out.println(json.has(key));
		System.out.println(json.get(key));
		
	}
	
	public static void getKey(JSONObject json,String key) {
		boolean exists =json.has(key);
		Iterator<?> keys;
		String nextKeys;
		
		
		
		if(!exists) {
			keys =json.keys();
			while (keys.hasNext()) {
				nextKeys =(String)keys.next();
				try {
					if(json.get(nextKeys) instanceof JSONObject) {
						if(exists==false) {
							getKey(json.getJSONObject(nextKeys),key);
						}
					}else if ((json.get(nextKeys) instanceof JSONArray)) {
						JSONArray jsonarray =json.getJSONArray(nextKeys);
						for(int i=0;i<jsonarray.length();i++) {
						String stringjsonarray =jsonarray.get(i).toString();
						JSONObject innerJSON = new JSONObject(stringjsonarray);
						
						
						if(exists==false) {
							getKey(innerJSON,key);
						}
						}
					}
				}catch(Exception e) {
					
				}
			}
			
			
		}else {
			parseObject(json,key);
		}
		
	}


public static void main(String[] args) {
	String inputJson ="{ \"name\"   : \"John Smith\",\r\n"
			+ "  \"sku\"    : \"20223\",\r\n"
			+ "  \"price\"  : 23.95,\r\n"
			+ "  \"shipTo\" : { \"name\" : \"Jane Smith\",\r\n"
			+ "               \"address\" : \"123 Maple Street\",\r\n"
			+ "               \"city\" : \"Pretendville\",\r\n"
			+ "               \"state\" : \"NY\",\r\n"
			+ "               \"zip\"   : \"12345\" },\r\n"
			+ "  \"billTo\" : { \"name\" : \"John Smith\",\r\n"
			+ "               \"address\" : \"123 Maple Street\",\r\n"
			+ "               \"city\" : \"Pretendville\",\r\n"
			+ "               \"state\" : \"NY\",\r\n"
			+ "               \"zip\"   : \"78990\" }\r\n"
			+ "}";
	
	JSONObject inputJSONObject = new JSONObject(inputJson);
	getKey(inputJSONObject,"address");
	getKey(inputJSONObject,"zip");
	getKey(inputJSONObject,"sku");
}
}

