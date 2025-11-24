package standardprograms;

public class ReverseString {
    public static void reverseString() {
        String example1 = "Hello World at your DoorSteps", reverse = "";
        for (int unit = 0; unit < example1.length(); unit++) {
            char ch = example1.charAt(unit);
            reverse = ch + reverse;

        }
        System.out.println("Standard Word :- " + example1);
        System.out.println("Reverse Word :-" + reverse);
    }

    //Swapping method
    public static void reverseStringwithSwapping() {
        String example2 = "Hello World at your DoorSteps", reverse = "";
        char[] reversechar = example2.toCharArray();
        int start = 0, end = 0;
        end = reversechar.length - 1;

        for (start = 0; start < end; start++, end--) {
            // Swap values of left and right
            char temp = reversechar[start];
            reversechar[start] = reversechar[end];
            reversechar[end] = temp;
        }

        for (char c : reversechar)
            System.out.print(c);
        System.out.println();
    }

    // Reverse a String
    public void reverseStringcharacterBycharacter() {

        String input = "GeeksForGeeks";

        // convert String to character array
        // by using toCharArray
        char[] try1 = input.toCharArray();

        for (int i = try1.length - 1; i >= 0; i--)
            System.out.print(try1[i]);
    }
    
    public static void reverseByStringBuffer () {
    	
    	StringBuffer sb = new StringBuffer("11GeeksForGeeks11");
    	
    	sb =sb.reverse();
    	
    	System.out.println(sb);
    	
    	
    }
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	reverseString() ;
    	reverseStringwithSwapping();
    	reverseByStringBuffer ();
	}
 
}
