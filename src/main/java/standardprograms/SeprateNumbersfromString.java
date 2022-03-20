package standardprograms;


public class SeprateNumbersfromString {

    public static void SeprateNumbersfromString() {
        String example3 = "sdfvsdf68fsdfsf8999fsdf09";
        String numberOnly = example3.replaceAll("[^0-9]", "");
        System.out.println(numberOnly);
        System.out.println();
    }

    public static void UsingRegexSeperateNumbersfromString() {
        String line = "This order was32354 placed for QT ! OK?";
        String regex = "[^\\d]+";

        String[] str = line.split(regex);
        System.out.println(str[1]);
    }

    public static void splitString() {
        String str = "This order was32354 placed for QT ! OK?";
        StringBuffer alpha = new StringBuffer(),
                num = new StringBuffer(), special = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
                num.append(str.charAt(i));
            else if (Character.isAlphabetic(str.charAt(i)))
                alpha.append(str.charAt(i));
            else
                special.append(str.charAt(i));
        }

        System.out.println(alpha);
        System.out.println(num);
        System.out.println(special);
    }

    public static void main(String[] args) {
        SeprateNumbersfromString();
        UsingRegexSeperateNumbersfromString();
        splitString();

    }
}
