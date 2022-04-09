package Learning;

public class LearningStrings {
    public static void main(String[] args) {
        String fruit = "apple";
        String anotherfruit = "apple";
        String vegetable = new String("brocolli");
        String anothervegetable = new String("brocolli");
        //====================Memory Allocation in String===============
        //Here fruit stores the reference or Memory Location of apple
        // When we define new with String it will store new memory location everytime
        //So fruit is same as anotherfruit but vegetable is not same as anothervegetable
        System.out.println(fruit == anotherfruit);
        System.out.println(vegetable == anothervegetable);
        String myText = "abcdefg";
        /*  String Methods
        uppercase()
        lowercase()
        strip()
        trim()

         */
        System.out.println(myText.toUpperCase());
        System.out.println(myText.toLowerCase());
        //System.out.println(myText.isBlank());
        System.out.println(myText.isEmpty());
        String myText1 = "here's my awesome firf text";
        System.out.println(myText1.replace("firf", "nice"));
        System.out.println(myText1.replace('e', 'z'));
        String firstName = "   Jake    ";
        System.out.format("'%s'", firstName.trim());
        //Multiline Strings
        String myText2 = "      \n          " +
                " First Line is here\n" +
                "Second Line is here\n           " +
                "Third line is here      " ;
        System.out.println("Normal Text :-" + myText2);
        System.out.println("String Leading Text :-" + myText2.stripLeading());
        System.out.println("String Trailing Text :-" + myText2.stripTrailing());
        System.out.println("Strip both leading and trailing :-" + myText2.strip());
        System.out.println("Strip Indent :-" + myText2.trim());
        System.out.println("Remove Spaces :-" + "\n" + myText2.replace("  ", "").strip());
        /*
        charAt()
        length()
        compareTo()
        compareToIgnoreCase()
        contains()
        concat()
        append()
         */
        System.out.println(firstName.charAt(0));
        System.out.println(firstName.charAt(2));
        String firstword = "Apple" ;
        String secondword = "Bananas" ;
        System.out.println("LearningStrings.main");
        System.out.println(firstword.compareTo(secondword));
        secondword = "apple" ;
        //case sensitive so false and outputs 32 as difference in ASCII value
        System.out.println(firstword.compareTo(secondword));
        //ignores case and outputs 0 as true
        System.out.println(firstword.compareToIgnoreCase(secondword));
        System.out.println(myText2.contains("Line is here"));
        //concat
        System.out.println(myText.concat(" ".concat(myText1)));
        //append
        String finalString = new StringBuilder()
                .append(myText)
                .append(" ")
                .append(myText1)
                .append(" ")
                .append(firstword)
                .toString();

        // append with memory management
        System.out.println(finalString);
        String finalString1 = new StringBuilder(myText.length()
                + myText1.length() + firstword.length() + 2)
                .append(myText)
                .append(" ")
                .append(myText1)
                .append(" ")
                .append(firstword)
                .toString();
        System.out.println(finalString1);

        //StringBuffer is same as above but Thread safe
        /*
        StringBuffer()
        toCharArray()
        substring()
        indexof()
        split()
        endswith()
        startswith()
        contentEquals()
         */
        StringBuffer oneMoreString = new StringBuffer();
        String one11 = oneMoreString.toString();
        one11 = String.format("%s %s\n", myText, myText1);
        System.out.println(one11);
        //SubStrings
        String parts = "akshay nikhare" ;
        System.out.println(parts);
        String firstpart = parts.substring(0, 6);
        System.out.println(firstpart);
        String secondpart = parts.substring(7);
        System.out.println(secondpart);
        String ProperName = firstpart.substring(0, 1).toUpperCase() +
                firstpart.substring(1) + " " +
                secondpart.substring(0, 1).toUpperCase() +
                secondpart.substring(1, 7);
        System.out.println(ProperName);
        //indexOf()
        System.out.println(myText2.indexOf("Line"));
        System.out.println(myText2.indexOf("Line", 33));
        //prints index with ascii value of a char and e char
        System.out.println(myText.indexOf(97));
        System.out.println(myText.indexOf(102));
        //split()
        String[] name = parts.split(" ");
        System.out.println(name[0] + " " + name[1]);
        //endswith()
        System.out.println(parts.endsWith("e"));
        //startswith()
        System.out.println(parts.startsWith("a"));
        System.out.println(parts.startsWith("s", 2));
        String FileName = "123." ;
        StringBuffer FileName1 = new StringBuffer("123.");
        //equals and contentequals
        System.out.println(FileName.equals(FileName1));
        System.out.println(FileName.contentEquals(FileName1));

    }
}
