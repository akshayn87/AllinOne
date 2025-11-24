package javaBook;

public class DataTypes {

	public DataTypes() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		int lightspeed;
		long days;
		long seconds;
		long distance;
		
		//Integers
		/**
		 * long
		 * int
		 * short
		 * byte
		 */
		
		lightspeed =186000;
		days =1000;
		seconds =days*24*60*60; //convert to seconds
		distance =lightspeed*seconds; //compute distance
		System.out.println("In days : "+days);
		System.out.println("In days light travelled: "+distance);
		
		//Floating Types
		/**
		 * char
		 * 
		 */
		char ch1,ch2,ch3;
		ch1=88;
		ch2='Y';
		System.out.println(ch1);//ASCII Value
		System.out.println(ch2);
		ch3 =(char) (ch2+1);
		System.out.println(ch3);
		ch3='A'+1;
		System.out.println(ch3);
		/*
		 * Booleans
		 *  boolean a
		 */
		boolean b = false;
		System.out.println("b is"+b);
		b=true;
		System.out.println("b is"+b);
		
	}

}
