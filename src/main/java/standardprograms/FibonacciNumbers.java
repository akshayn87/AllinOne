package standardprograms;

import java.util.Scanner;

public class FibonacciNumbers {
    //Generating Fibonacci with Iteration and Recursssion
    public static void main(String[] args) {
        System.out.println("Enter number upto which Fibonacci series to print: ");
        int number = new Scanner(System.in).nextInt();
        System.out.println("Fibonacci series upto " + number + " numbers : ");
        //printing Fibonacci series upto number
        for (int i = 1; i <= number; i++) {
            System.out.print(FibonacciwithIteration(i) + " ");
        }

    }

    //Generating Fobonacci with Iteration
    public static int FibonacciwithIteration(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        int fibo1 = 1, fibo2 = 1, fibonacci = 1;

        for (int i = 3; i <= number; i++) {
            //Fibonacci number is sum of previous two Fibonacci number
            fibonacci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }
        return fibonacci; // Fibonacci number
    }

}
