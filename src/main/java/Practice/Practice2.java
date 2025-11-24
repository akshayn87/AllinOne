package Practice;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Practice2 {
	
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		
		JSONArray array1 = new JSONArray();
	      //Inserting key-value pairs into the json object
	      jsonObject.put("ID", "1");
	      jsonObject.put("First_Name", "Krishna Kasyap");
	      jsonObject.put("Last_Name", "Bhagavatula");
	      jsonObject.put("Date_Of_Birth", "1989-09-26");
	      jsonObject.put("Place_Of_Birth", "Vishakhapatnam");
	      jsonObject.put("Country", "India");
	      //Creating a json array
	      array1.add(jsonObject);
	      array1.add(jsonObject);	      try {
	         FileWriter file = new FileWriter("C:/Users/Akshay/Desktop/sample.json");
	         //file.write(jsonObject.toJSONString());
	         file.write(array1.toJSONString());
	         file.close();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      System.out.println("JSON file created: "+array1);
	   
		
	}
	}
