package Learning;

public class MethodsandConstructors {
    //void - only display things but do not return any value
    //()   - means it's not getting any inputs
    //Methods starts with lower case
    //Method names should ideally be verbs or denoting actions
    // The statements or declarations should always end with semicolon ;
    String message = "My groovy message" ;

    // Here message above is variable so we do not use quotes
    // In sayHello() above the Hello is string so we used double quotes
    public static void main(String[] args) {
        Variables v1 = new Variables();
        //private and not static methods can only access by defining class as objects and then methods calling
        //the private members
        System.out.println(v1.getMiddleintial());
        //We are passing method to object v1 and get the output
        //We should create an instance of class before defining the method as v1 is an instance
        // and we are calling getMiddleintial() method
        //What is static method ?
        //Iy you are making method static you are saying the compiles to build method without
        //defining the class.static gives the entry point for main without creating object
        // Static methods are mainly utlity classes not necessarily real world objects
        // For accessing static variable and methods we have to define the variable as static
        //What are Constructors ?
        //Constructor are methods which do not have return type even without defining it void
        //Every class has default Constructor even we define it or not
        //As soon as we create our own constructors the default constructor is no longer valid
        // and has to pass arguments as per created constructor
    }

    //What are Methods ?
    //Methods are block of code where work is done.Method is a function inside the class
    public void sayHello() {
        System.out.println("Hello");
    }

    public void saySomething(String message) {
        System.out.println(message);
    }
}
