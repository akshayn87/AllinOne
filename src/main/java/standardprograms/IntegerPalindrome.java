package standardprograms;

import java.util.Iterator;
import java.util.Scanner;

public class IntegerPalindrome {
    public static void main(String args[]) {

        System.out.println("Please Enter a number : ");
        System.out.println("Enter 'Q' to quit");
        Scanner sc = new Scanner(System.in);
       int c='Q';
        
        
        while(sc.hasNextInt()) {
        	 int palindrome = sc.nextInt();
        if (isPalindrome(palindrome)) {
            System.out.println("Number : " + palindrome
                    + " is a palindrome");
        } else {
            System.out.println("Number : " + palindrome
                    + " is not a palindrome");
        }
        if(palindrome==c) {
        	break;
        }
        //sc.nextInt();
        }
       sc.close();

    }

    /*
     * Java method to check if a number is palindrome or not
     */
    public static boolean isPalindrome(int number) {
        int palindrome = number; // copied number into variable
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        // if original and the reverse of number is equal means
        // number is palindrome in Java
        return number == reverse;
    }

}
