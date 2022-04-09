package Learning;

public class Variables {

    private final double PI = 3.14;
    private String firstname;
    private int age;
    private int id;
    private char middleintial = 'J';
    private StreamsAPI streamsAPI;
    private LearningStrings learningStrings;

    public static void main(String[] args) {
        LearningStrings learnStrings = new LearningStrings();
        learnStrings.toString();
        Variables var = new Variables();
        System.out.println("=============================================");
        System.out.println(var.toString());


    }

    //=====Generating Getters from middle name to access the private variable
    public char getMiddleintial() {
        return middleintial;
    }

    //===================================Static Data Types===========================
    //String,int,vhar,long etc
    //===================================Dynamic Data Types==========================
    //var in javascript can store any data type String,int,char,boolean etc
    //==================================Constants==================================
    //Constants are defined in Capital like PI
    @Override
    public String toString() {
        return "Variables{" +
                "firstname='" + firstname + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", middleintial=" + middleintial +
                ", streamsAPI=" + streamsAPI +
                ", learningStrings=" + learningStrings +
                '}';
    }
}
