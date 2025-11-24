package standardprograms;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MaximumOccuringCharacter {
	
	public static void main(String[] args) {
		
		System.out.println(MaximumOccuringCharacterCount("aabbccccde"));
		
	}
	
	public static HashMap <Character,Integer> MaximumOccuringCharacterCount(String inputString) {
		HashMap <Character,Integer> hm = new HashMap<>();
		int MaxCount=0;char charcount=0;
		//Replacing All the spaces with null or space will show maximum count
		char [] carr =inputString.replaceAll("\\s"," ").toCharArray();
		
		for(char c:carr) {
			
			if(hm.containsKey(c)) {
				hm.put(c, hm.get(c)+1);
			}else {
				hm.put(c,1);
			}
			
			Set<Entry<Character,Integer>> entrySet =hm.entrySet();
			
			
			
			for(Entry<Character,Integer> entry:entrySet) {
				if(entry.getValue()>MaxCount) {
					MaxCount=entry.getValue();
					charcount=entry.getKey();
				}
				
				
			}
			//System.out.println(c+":"+hm.get(c));
			
			
		}
		System.out.println(charcount+":"+MaxCount);
		System.out.println(hm.entrySet());
		
		return hm;
	}

}
