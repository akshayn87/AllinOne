package Learning;

import java.util.Stack;

public class Stack1 {
    public static void main(String[] args) {
        DefiningStack();
        addElementsToStack();
        removeElementsFromStack();
        peekandSearch();
        sortStack();


    }

    public static void DefiningStack() {
        // Stack1 stk = new Stack1();
        Stack<Integer> stk = new Stack<>();
        //Stack<Number> stk1 = new Stack<Integer>();
        System.out.println("Stack is Empty ?" + stk.empty());
    }

    public static void addElementsToStack() {
        Stack<String> stk1 = new Stack<>();
        stk1.push("One");
        stk1.push("Two");
        stk1.push("Three");
        System.out.println(stk1);
    }

    public static void removeElementsFromStack() {
        Stack<String> stk1 = new Stack<>();
        stk1.push("One");
        stk1.push("Two");
        stk1.push("Three");
        stk1.pop();
        System.out.println(stk1);
    }

    public static void peekandSearch() {
        Stack<String> stk1 = new Stack<>();
        stk1.push("One");
        stk1.push("Two");
        stk1.push("Three");
        stk1.push("Four");
        System.out.println("Top Element :-" + stk1.peek());
        System.out.println("Index of Two element :-" + stk1.search("Two"));
        System.out.println("Size :-" + stk1.size());
    }

    public static void sortStack() {
        Stack<Integer> inpstk = new Stack<>();
        Stack<Integer> outstk = new Stack<>();
        inpstk.push(12);
        inpstk.push(25);
        inpstk.push(17);
        inpstk.push(5);
        System.out.println("Input Stack :-" + inpstk);
        while (!inpstk.isEmpty()) {
            int tmp = inpstk.pop();
            while (!outstk.isEmpty() && outstk.peek()
                    > tmp) {
                inpstk.push(outstk.pop());
            }

            // push temp in temporary of stack
            outstk.push(tmp);
        }
        System.out.println("Sorted Stack :-" + outstk);

    }
}
