package Learning;

public class RegularExpressions {
    //=========================Regular Expressions============================
    /*
    What are Regular Expressions ?
    Regular Expressions is a language of expressing patterns of text using symbols and we are able
    to extract test from unicode pattern
    */
    //matches() method

    public static void main(String[] args) {
        System.out.println("cat".matches("Cat"));
        /*
        Use of Square Brackets to define compare ---> []
        Here you write c or C it will match and output True
         */
        System.out.println("cat".matches("[cC]at"));
        System.out.println("Cat".matches("[cC]at"));
        /*
        Specify range of characters within Square brackets

         */
        System.out.println("Range");
        System.out.println("fat".matches("[a-z]at"));
        System.out.println("hat".matches("[a-z]at"));
        System.out.println("mat".matches("[a-z]at"));
        System.out.println("lat".matches("[a-z]at"));
        System.out.println("2at".matches("[a-z]at"));
        System.out.println("Aat".matches("[aA-zZ]at"));
        System.out.println("aat".matches("[aA-zZ]at"));
        /*
        Match anything not starting with B
        ^ -> Caret symbol and c i.e ^c means not
         */
        System.out.println("Negation or not or not of c");
        System.out.println("cat".matches("[^c]at"));
        System.out.println("Bat".matches("[^B]at"));
        System.out.println("Bat".matches("[^b]at"));
        System.out.println("9at".matches("[^b]at"));
        System.out.println("#at".matches("[^b]at"));
        /*
        Word escape with \w
        Here \ extra in the java to recognize \w
         */
        System.out.println("Word Escape");
        System.out.println("Lat".matches("\\wat"));
        System.out.println("9at".matches("\\wat"));
        System.out.println("#at".matches("\\wat"));
        //Any three letter word recognized
        System.out.println("Any three letter word recognized");
        System.out.println("#we".matches("\\w\\w\\w"));
        System.out.println("_bg".matches("\\w\\w\\w"));
        System.out.println("___".matches("\\w\\w\\w"));
        System.out.println("zbg".matches("\\w\\w\\w"));

    }
}
