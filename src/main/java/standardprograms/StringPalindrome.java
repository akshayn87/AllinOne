package standardprograms;

public class StringPalindrome {

    //A String is said to be a palindrome if the reverse of String is equal to itself
    // like "aba" is a palindrome because the opposite of "aba" is also "aba",
    // but "abc" is not a palindrome because the reverse of "abc" is "cba" which is not equal
    //Read more: https://www.java67.com/2015/06/how-to-check-is-string-is-palindrome-in.html#ixzz7MpmYHMoR


    public static boolean isPalindromString(String text) {

        String reverse = reverse(text);
        return text.equals(reverse);
    }


    public static String reverse(String input) {
        if (input == null || input.isEmpty()) {

            return input;
        }
        return input.charAt(input.length() - 1)
                + reverse(input.substring(0, input.length() - 1));
    }


    public static void main(String args[]) {
        System.out.println("Is aaa palindrom?: " + isPalindromString("aaa"));
        System.out.println("Is abc palindrom?: " + isPalindromString("abc"));
        System.out.println("Is bbbb palindrom?: " + isPalindromString("bbbb"));
        System.out.println("Is defg palindrom?: " + isPalindromString("defg"));


    }
}

