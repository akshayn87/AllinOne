package standardprograms;

public class FindGCD {

	public static void main(String[] args) {
		System.out.println(findGCD(8, 32));
		System.out.println(findGCD1(16, 32));
	}

	private static int findGCD(int number1, int number2) {
		// base
		if (number2 == 0) {
			return number1;
		}
		return findGCD(number2, number1 % number2);
	}
	
	private static int findGCD1(int number1,int number2) {
		int Temp,GCD=0;
		while(number2 != 0)  
		{  
		Temp = number2;  
		number2 = number1 % number2;  
		number1 = Temp;  
		}  
		GCD = number1;  
		return GCD;
	}
}
