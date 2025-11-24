package standardprograms;

import java.util.Arrays;

public class AnagramCheck {
	 /* * 
	  * What is Anagram ? 
	  * A word, phrase, or name formed by rearranging the letters of another, such as spar, formed from rasp.
	  * eg. late and tale
	  * One way to find if two Strings are anagram in Java.
	  *  This method * assumes both arguments are not null and in lowercase. 
	  *  * * @return true, if both String are anagram */
	public static void main(String[] args) {
		System.out.println(isAnagram("late","tale"));
		System.out.println(isAnagram("rasp","spar"));
		System.out.println(isAnagram("tia","tea"));
		System.out.println(isAnagram("late","stale"));
		System.out.println(isAnagram("tate","tate"));
		System.out.println(isAnagramUsingSorting("late","tale"));
		System.out.println(isAnagramUsingSorting("rasp","spar"));
		System.out.println(isAnagramUsingSorting("tia","tea"));
		System.out.println(isAnagramUsingSorting("tate","tate"));
	}
	
	public static boolean isAnagram(String word, String anagram){
		if(word.length() != anagram.length())
		{ 
		return false;
		} 
		int count =0;
		char[] chars = word.toCharArray();
		char[] chars1 = anagram.toCharArray();
		for(char c : chars){
			for(char c1:chars1) {
				if(c1==c) {
						count++;
		}
			}
		}
		if(count==word.length()) {
			return true;
		}
		return false;
	}
	
	public static boolean isAnagramUsingSorting(String word,String anagram) {
		
		char[] charFromWord = word.toCharArray(); 
		for(char c:charFromWord) {
			System.out.print(c);
		}
		System.out.println();
		char[] charFromAnagram = anagram.toCharArray(); 
		for(char c:charFromAnagram) {
			System.out.print(c);
		}
		System.out.println();
		Arrays.sort(charFromWord);
		Arrays.sort(charFromAnagram); 
		return Arrays.equals(charFromWord, charFromAnagram); }

	
}
