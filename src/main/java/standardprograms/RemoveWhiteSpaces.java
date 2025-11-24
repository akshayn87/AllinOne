package standardprograms;

public class RemoveWhiteSpaces {

	// Write a Java Program to remove all white spaces from a string without using
	// replace().

	public static void main(String[] args) {
		String str1 = "Saket Saurav is an Autom ation Engi ne er";
		System.out.println(removeWitheSpaces(str1));
		System.out.println(RemoveWhiteSpacewithreplaceall(str1));
	}


	/**
	 * @param str1
	 * @return
	 */
	public static StringBuffer removeWitheSpaces(String str1) {
		char[] chars = str1.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			if ((chars[i] != ' ') && (chars[i] != '\t')) {
				sb.append(chars[i]);
			}
		}
		return sb;
	}
	
	
	public static String RemoveWhiteSpacewithreplaceall(String str1) { 
		//1. Using replaceAll() Method 
		String str2 = str1.replaceAll("\\s", ""); 
		return str2;
}
	
}