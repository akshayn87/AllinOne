package standardprograms;

import java.util.HashMap;

public class DuplicateCharacters {

	public static void main(String[] args) { // TODO Auto-generated method stub 
		String str = new String("Sakkett"); 
		HashMap<Character,Integer>hm =new HashMap<>();
		int count = 0; char[] chars = str.toCharArray(); 
		System.out.println("Duplicate characters are:");
		for (int i=0; i<str.length();i++) {
			for(int j=i+1; j<str.length();j++) { 
				if (chars[i] == chars[j]) { 
					System.out.println(chars[j]);
					count++; 
					break; 
					}
				} 
			}
		System.out.println(hm.entrySet());
		}
}
