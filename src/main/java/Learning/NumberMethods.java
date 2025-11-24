package Learning;

public class NumberMethods {
    //Wrapper Classes
    //we come across situations where we need to use objects
    // instead of primitive data types. In order to achieve this,
    // Java provides wrapper classes.
    //All the wrapper classes
    //(Integer, Long, Byte, Double, Float, Short)
    //are subclasses of the abstract class Number.

    public static void main(String[] args) {
        NumberMethods nm = new NumberMethods();
        nm.integerWrapperClass();
        nm.XXXValue_Method();
        nm.compareToMethod();
        nm.equalsmethod();
        nm.valueOfmethod();
        nm.toString_method();
        nm.absolute_value_method();


    }
    public void integerWrapperClass(){
        Integer x = 5; // boxes int to an Integer object
        x = x + 10; // unboxes the Integer to a int
        System.out.println(x);
    }

    public void XXXValue_Method(){
        Integer x = 5;
        // Returns byte primitive data type
        System.out.println( x.byteValue() );
        // Returns double primitive data type
        System.out.println(x.doubleValue());
        // Returns long primitive data type
        System.out.println( x.longValue());
    }

    public void compareToMethod(){
        Integer x = 5;
        System.out.println(x.compareTo(3));
        System.out.println(x.compareTo(5));
        System.out.println(x.compareTo(8));
//If the Integer is equal to the argument then 0 is returned.
//If the Integer is less than the argument then -1 is returned.
//If the Integer is greater than the argument then 1 is returned.
    }

    public void equalsmethod(){
        Integer x = 5;
        Integer y = 10;
        Integer z =5;
        Short a = 5;
        System.out.println(x.equals(y));
        System.out.println(x.equals(z));
        System.out.println(x.equals(a));
    }

    public void valueOfmethod(){
        Integer x =Integer.valueOf(9);
        Double c = Double.valueOf(5);
        Float a = Float.valueOf("80");
        Integer b = Integer.valueOf("444",16);
        System.out.println(x);
        System.out.println(c);
        System.out.println(a);
        System.out.println(b);

    }

    public void toString_method(){
        Integer x = 5;
        System.out.println(x.toString());
        System.out.println(Integer.toString(12));
    }

    public void absolute_value_method(){
        Integer a = -8;
        double d = -100;
        float f = -90;
        System.out.println(Math.abs(a));
        System.out.println(Math.abs(d));
        System.out.println(Math.abs(f));
    }

    public void ceil_floor_method(){

        double d = -100.675;
        float f = -90;
        System.out.println(Math.floor(d));
        System.out.println(Math.floor(f));
        System.out.println(Math.ceil(d));
        System.out.println(Math.ceil(f));

    }

    public void round_method(){
        double d = 100.675;
        double e = 100.500;
        float f = 100;
        float g = 90f;
        System.out.println(Math.round(d));
        System.out.println(Math.round(e));
        System.out.println(Math.round(f));
        System.out.println(Math.round(g));
    }

    public void rint_method(){

        double d = 100.675;
        double e = 100.500;
        double f = 100.200;
        System.out.println(Math.rint(d));
        System.out.println(Math.rint(e));
        System.out.println(Math.rint(f));

    }

    public void min_max(){
        System.out.println(Math.min(12.123, 12.456));
        System.out.println(Math.min(23.12, 23.0));
        System.out.println(Math.max(12.123, 12.456));
        System.out.println(Math.max(23.12, 23.0));

    }

    public void log_and_exponentialmethod(){
        double x = 11.635;
        double y = 2.76;
        System.out.printf("The value of e is %.4f%n", Math.E);
        System.out.printf("exp(%.3f) is %.3f%n", x, Math.exp(x));
        System.out.printf("The value of e is %.4f%n", Math.E);
        System.out.printf("log(%.3f) is %.3f%n", x, Math.log(x));
    }

    public void power_squareroot_method(){
        double x = 11.635;
        double y = 2.76;
        System.out.printf("The value of e is %.4f%n", Math.E);
        System.out.printf("pow(%.3f, %.3f) is %.3f%n", x, y, Math.pow(x, y));

        System.out.printf("The value of e is %.4f%n", Math.E);
        System.out.printf("sqrt(%.3f) is %.3f%n", x, Math.sqrt(x));

    }

    


}
