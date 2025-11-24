package Practice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonArray;

public class Practice3 {

	
	public static void main(String[] args) {
		
		JSONObject jsonobject1 = new JSONObject();
		jsonobject1.put("name" , "Tom Cruise");
		jsonobject1.put("age", 56);
		jsonobject1.put("Born", "Syracuse, NY");
		jsonobject1.put("Birthdate", "July 3,1962");
		

		JSONObject jsonobject2 = new JSONObject();
		jsonobject2.put("name" , "Robert Downey Jr.");
		jsonobject2.put("age", 56);
		jsonobject2.put("Born", "New York City, NY");
		jsonobject2.put("Birthdate", "April 4.1965");
		
		
		JSONArray jsonarray = new JSONArray();
		jsonarray.add(jsonobject1);
		jsonarray.add(jsonobject2);
		
		JSONObject jsonobject3 = new JSONObject();
		jsonobject3.put("data", jsonarray);
		
//		{
//		      "name": "Tom Cruise",
//		      "age": 56,
//		      "Born At": "Syracuse, NY",
//		      "Birthdate": "July 3, 1962",
//		      "photo": "https://jsonformatter.org/img/tom-cruise.jpg"
//		    },
//		    {
//		      "name": "Robert Downey Jr.",
//		      "age": 53,
//		      "Born At": "New York City, NY",
//		      "Birthdate": "April 4, 1965",
//		      "photo": "https://jsonformatter.org/img/Robert-Downey-Jr.jpg"
//		    }
//		
		//}
		  try {
		         FileWriter file = new FileWriter("C:/Users/Akshay/Desktop/sample2.json");
		         //file.write(jsonObject.toJSONString());
		         file.write(jsonobject3.toJSONString());
		         file.close();
		      } catch (IOException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
		      System.out.println("JSON file created: "+jsonobject3);
		      System.out.println("JSON file created: "+jsonobject3.get("data"));
		      System.out.println("JSON file created: "+jsonobject3.get("data"));
		   
			
		}
	
	
}
