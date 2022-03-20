package standardprograms;

public class Welcome {

    public static void main(String[] args) {
        System.out.println("Welcome to the Java Interview Programs!");
        //Program 1
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString();
        //Program 2
        reverseString.reverseStringwithSwapping();
        reverseString.reverseStringcharacterBycharacter();
    }
}
