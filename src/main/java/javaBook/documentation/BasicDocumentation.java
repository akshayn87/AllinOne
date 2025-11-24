package javaBook.documentation;
/**
 * @author Akshay
 * @version 11
 * @since 
 * {@docRoot}
 * 
 * {@code}
 * Step I :create a class
 * Step II :open command prompt
 * Step III :navigate to the class which you want to generate document
 *            C:\Projects\AllinOne\src\main\java\javaBook\documentation>
 * Step IV : Type javadoc BasicDocumentation.java on the terminal
 * Step V : Navigate to the Class where the class is present you will see the files created there
 * Step VI : on terminal pass command 
 *             C:\Projects\AllinOne\src\main\java\javaBook\documentation>javadoc -author BasicDocumentation.java
 * Step VII : Now authore will be added to the documentation            
 *
 */
public class BasicDocumentation {

	/**
	 * 
	 * @param args
	 * 
	 * Pass AddNum Method to main
	 */
	
	
	public static void main(String[] args) {
		
		AddNum(10,20);
		AddNum(50,20);
		
	}
	
	/**
	 * Addition of two numbers
	 * @param n1 first integer
	 * @param n2 second integer
	 * @return integer returns the addition as result
	 */
	public static int AddNum(int n1,int n2) {
		int n3 =n1+n2;
		return n3;
	}
	
	
}
