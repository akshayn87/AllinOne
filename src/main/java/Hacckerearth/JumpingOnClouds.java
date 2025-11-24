package Hacckerearth;

import java.util.Scanner;

public class JumpingOnClouds {


    static  int jumpingOnClounds(int c []){
        int len =c.length;
        int count = -1;
        for(int i=0;i<len;){
            if(i+2<len && c[i+2]==0){
                i =i+2;
            }else{
                i++;
            }
            count++;
        }
        return count;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int c[] = new int [n];
        for(int i=0;i<n;i++){
            c[i]=sc.nextInt();
        }
        System.out.println("Array elements are: ");
        // accessing array elements using the for loop
        for (int i=0; i<n; i++)
        {
            System.out.print(c[i]+" ");
        }
        System.out.println("\n"+jumpingOnClounds(c));

    }
}
