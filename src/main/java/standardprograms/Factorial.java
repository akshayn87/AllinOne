package standardprograms;

import java.util.Scanner;

public class Factorial {

    public static void main(String args[]) {

        System.out.println("Please Enter a number : ");
        long input = new Scanner(System.in).nextLong();

        //finding factorial of a number in Java using recursion - Example
        System.out.println("factorial of 5 using recursion in Java is: " + factorial(input));

        //finding factorial of a number in Java using Iteration - Example
        System.out.println("factorial of 6 using iteration in Java is: " + fact(input));
    }


    /*
     * Java program example to find factorial of a number using recursion
     * @return factorial of a number
     */
    public static long factorial(long number) {
        //base case
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1); //is this tail-recursion?
    }

    /*
     * Java program example to calculate factorial using while loop or iteration
     * @return factorial of a number
     */

    public static long fact(long number) {
        long result = 1;
        while (number != 0) {
            result = result * number;
            number--;
        }

        return result;
    }

}
