package JsonSerealizer;

import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import JsonSupportClasses.User;

public class JsonArrayEx {
	
	 public static void main(String[] args) {
		 User user = new User("John Doe", "gardener", 2, true);
		 user.setName("Akshay Nikhare");
		 ObjectMapper oMapper = new ObjectMapper();
		 	ClassUsingMap(user, oMapper);
	        ObjectMappertoStringValue(user, oMapper); 
	    }

	/**
	 * @param user
	 * @param oMapper
	 */
	public static void ObjectMappertoStringValue(User user, ObjectMapper oMapper) {
		try {
			System.out.println(oMapper.writeValueAsString(user));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param user
	 * @return
	 */
	public static ObjectMapper ClassUsingMap(User user, ObjectMapper oMapper) {
		
		Map<String, Object> map = oMapper.convertValue(user, Map.class);
		System.out.println(map);
		return oMapper;
	}
	}

