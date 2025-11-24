package standardprograms;

public class Amstrong {
	
//	Write a Java Program to check Armstrong number.
//	Answer:��First of all we need to understand what Armstrong Number is.
//	Armstrong number is the number which is the sum of the cubes of all its unit, 
//	tens and hundred digits for three-digit numbers.
//	153 = 1*1*1 + 5*5*5 + 3*3*3 = 1 + 125 + 27 = 153
//	If you have a four-digit number lets say
//	1634 = 1*1*1*1 + 6*6*6*6 + 3*3*3*3 + 4*4*4*4 = 1 + 1296 + 81 + 256 = 1634

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//It is the number to check Armstrong 
		getAmstrong(153);
		getAmstrong(15);
		getAmstrong(1000);
		}

/**
 * @param c
 * @param temp
 * @param n
 */
public static void getAmstrong(int n) {
	int c=0,a,temp;
	temp=n;
	while(n>0) 
	{
		a=n%10; 
		System.out.println(a);
		n=n/10; 
		System.out.println(n);
		c=c+(a*a*a);
		System.out.println(c);
		} 
	if(temp==c) {
		System.out.println("armstrong number"); 
	}
	else {
		System.out.println("Not armstrong number");
	}
} 


}
