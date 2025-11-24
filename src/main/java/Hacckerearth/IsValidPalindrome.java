package Hacckerearth;

import java.util.Scanner;

public class IsValidPalindrome {

    static boolean IsValidPalindrome(String s){
        int len =s.length();
        // aabbccbbaa
        for(int i=0;i<len/2;i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return  true;
    }


    public static  void main(String [] args){

        Scanner sc = new Scanner(System.in);
        String s =sc.next();
        System.out.println(IsValidPalindrome(s));
    }
}
