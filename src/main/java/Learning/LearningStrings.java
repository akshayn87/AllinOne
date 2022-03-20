package Learning;

public class LearningStrings {
    public static void main(String[] args) {
        String fruit = "apple";
        String anotherfruit = "apple";
        String vegetable = new String("brocolli");
        String anothervegetable = new String("brocolli");
        System.out.println(fruit == anotherfruit);
        System.out.println(vegetable == anothervegetable);
        String myText = "abcdefg";
        System.out.println(myText.toUpperCase());
        System.out.println(myText.toLowerCase());
        //System.out.println(myText.isBlank());
        System.out.println(myText.isEmpty());
        String myText1 = "here's my awesome firf text";
        System.out.println(myText1.replace("firf", "nice"));
        System.out.println(myText1.replace('e', 'z'));
        String firstName = "   Jake    ";
        System.out.format("'%s'", firstName.trim());


    }
}
