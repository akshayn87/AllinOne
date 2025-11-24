package Hacckerearth;

import java.util.Scanner;

public class Characters {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int [] freq = new int[s.length()];
        char minChar = s.charAt(0), maxChar = s.charAt(0);
        int i, j, min, max;
        //Converting String to char array
        char[] ch = s.toCharArray();
        System.out.println(ch);
        for (i = 0; i < ch.length; i++) {
            freq[i] = 1;
            for (j = i + 1; j < ch.length; j++) {
                if ((ch[i] == ch[j])&& ch[i] != ' ' && ch[i] != '0') {
                    freq[i]++;
                    ch[j] = '0';
                }
            }
        }
        //Determine minimum and maximum occurring characters
        min = max = freq[0];
        for (i = 0; i < freq.length; i++) {

            //If min is greater than frequency of a character
            //then, store frequency in min and corresponding character in minChar
            if (min > freq[i] && freq[i] != '0') {
                min = freq[i];
                minChar = ch[i];
            }
            //If max is less than frequency of a character
            //then, store frequency in max and corresponding character in maxChar
            if (max < freq[i]) {
                max = freq[i];
                maxChar = ch[i];
            }
        }
        System.out.println("Minimum occurring character: " + minChar +" freq :"+min);
        System.out.println("Maximum occurring character: " + maxChar +" freq :"+max);

    }

}
