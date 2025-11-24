package Hacckerearth;

import java.util.Scanner;

public class UtopianTree {

    static long uptopiantree(int n){

        //2^n -1 -Even  2^n -Odd
        // n = cycle k =n/2 ,where k is number of years
        return (1 <<((n>>1)+1))-1<<n%2;
    }



    public static  void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int T =sc.nextInt();
    for (int i=0;i<T;i++){
        int cycle =sc.nextInt();
        System.out.println(uptopiantree(cycle));
    }
    sc.close();
    }


}
