package Hacckerearth;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

public class RepeatedString {
  static long repeatedString(String s, long n) {
        int strlength = s.length();
        long q,r=0;
        q=n/strlength;
        r=n%strlength;
        long partialstrlenth =(r==0)?0:r;
         return q*freq(s,n)+freq(s,partialstrlenth);
    }

    static long freq(String s,long n){
      int count =0;
      for(int i=0;i<s.length();i++){
          if(s.charAt(i)=='a')
              count++;
      }
      return  count;
    }



    public static  void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Input");
        String s = sc.next();
        System.out.println("Enter the Repetitions");
        long n =sc.nextLong();
        long aCount =repeatedString(s,n);
        System.out.println(aCount);
        sc.close();

    }


}
