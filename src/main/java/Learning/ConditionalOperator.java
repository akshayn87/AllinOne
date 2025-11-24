package Learning;

public class ConditionalOperator {
    public static void main(String[] args) {
        int a, b;
        a = 10;
        b = (a == 1) ? 20: 30;
        System.out.println( "Value of b is : " + b );
        b = (a == 10) ? 20: 30;
        System.out.println( "Value of b is : " + b );

        //InstanceOF Operator
        String name = "James";
        // following will return true since name is type of String
        boolean result = name instanceof String;
        System.out.println( result );
        //This operator will still return true, if the object being compared
        // is the assignment compatible with the type on the right.
//        public class Car extends Vehicle {
//            public static void main(String args[]){
//                Vehicle a = new Car();
//                boolean result = a instanceof Car;
//                System.out.println( result );
//            }




    }
}
