package Learning;

public class DecisionMaking {

    public static void main(String[] args) {
        DecisionMaking dm = new DecisionMaking();
        dm.ifstatement();
        dm.ifelsestatement();
        dm.if_elseif_else_statement();
        dm.nested_if_statement();
        dm.switch_statement();

    }

    public void ifstatement() {
        int x = 10;
        if (x < 20) {
            System.out.print("This is if statement");
            System.out.print("\n");
        }
    }

    public void ifelsestatement(){
        int x=30;
        if( x < 20 ){
            System.out.print("This is if statement");
            System.out.print("\n");
        }else{
            System.out.print("This is else statement");
            System.out.print("\n");
        }

    }
    public void if_elseif_else_statement(){
        int x = 30;
        if( x == 10 ){
            System.out.print("Value of X is 10");
            System.out.print("\n");
        }else if( x == 20 ){
            System.out.print("Value of X is 20");
            System.out.print("\n");
        }else if( x == 30 ){
            System.out.print("Value of X is 30 \n");
        }else{
            System.out.print("This is else statement");
            System.out.print("\n");
        }
    }

    public void nested_if_statement(){
        int x = 30;
        int y = 10;
        if( x == 30 ){
            if( y == 10 ){
                System.out.print("X = 30 and Y = 10\n");
            }
        }
    }

    public void switch_statement(){
        char grade = 'C';
        switch(grade)
        {
            case 'A' :
                System.out.println("Excellent!");
                break;
            case 'B' :
            case 'C' :
                System.out.println("Well done");
                break;
            case 'D' :
                System.out.println("You passed");
            case 'F' :
                System.out.println("Better try again");
                break;
            default :
                System.out.println("Invalid grade");
        }
        System.out.println("Your grade is " + grade);
    }


}
