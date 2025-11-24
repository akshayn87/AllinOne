package standardprograms;

import java.util.Scanner;

public class LeapYear {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 System.out.println("Enter 'Q' to Quit");
		int c=0;
		while(sc.hasNext()) {	
		int input =sc.nextInt();
		System.out.println(lY(input));
		if(input==c) {
			break;
		}
		}
	}
	private static boolean lY(int year) {
		if(year%400 == 0||((year%100)!=0)&&(year%4 ==0))
		return true;
		return false;
	}
}