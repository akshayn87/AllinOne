package Learning;

public class Loops {

    public static void main(String[] args) {
        Loops lp = new Loops();
        //lp.whileloop();
         //lp.forloop();
        // lp.dowhileloop();
         //lp.breakstatement();
        // lp.continuestatement();
         lp.EnhancedForLoop();
    }

    public void whileloop(){
        int x = 10;
        while( x < 20 ) {
            System.out.print("value of x : " + x);
            x++;
            System.out.print("\n");
        }
    }

    public void forloop(){
        for(int x = 10; x < 20; x = x+1) {
            System.out.print("In for Loop value of x : " + x );
            System.out.print("\n");
        }
    }

    public void dowhileloop(){
        int x = 10;
        do{
            System.out.print("In do While Loop value of x : " + x );
            x++;
            System.out.print("\n");
        }while( x < 20 );
    }

    public void breakstatement(){
       // When the break statement is encountered inside a loop,
       // the loop is immediately terminated and the program control
       // resumes at the next statement following the loop.
        int [] numbers = {10, 20, 30, 40, 50};
        for(int x : numbers ) {
            if( x == 30 ) {
                break;
            }
            System.out.print( x );
            System.out.print("\n");
        }
    }

    public void continuestatement(){
        int [] numbers = {10, 20, 30, 40, 50};
        for(int x : numbers ) {
            if( x == 30 ) {
                continue;
            }
            System.out.print( x );
            System.out.print("\n");
        }
    }

    public void EnhancedForLoop(){
        int [] numbers = {10, 20, 30, 40, 50};
        for(int x : numbers ){
            System.out.print( x );
            System.out.print(",");
        }
        System.out.print("\n");
        String [] names ={"James", "Larry", "Tom", "Lacy"};
        for( String name : names ) {
            System.out.print( name );
            System.out.print(",");
        }




    }


}
