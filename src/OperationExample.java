public class OperationExample {
    void main(){
        //Arthmetic operations
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println("c="+c);
        c = a - b;
        System.out.println("c="+c);
        c = a * b;
        System.out.println("c="+c);
        c = a / b;
        System.out.println("c="+c);
        c = a % b;
        System.out.println("c="+c);
        //Logical operations
        //Double pipe (||) is used for logical OR operation so 
        // if first condition is true then it will not check the second condition 
        // and evaluate to true.
        boolean bool1 = true;
        boolean bool2 = false;  
        boolean bool3 = bool1 && bool2;
        System.out.println("bool3="+bool3);
        bool3 = bool1 || bool2;
        System.out.println("bool3="+bool3);
        bool3 = !bool1;
        System.out.println("bool3="+bool3);
        System.out.println(a == b);
        //Increment and Decrement operations
        int d = 10;
        d++; //assign value first and then increment it.  
        System.out.println("d="+d);
        d--;
        System.out.println("d="+d);
        ++d; //increment value first and then assign it to d.
        System.out.println("d="+d);
        --d; //decrement value first and then assign it to d.
        System.out.println("d="+d);

        //Relational operations
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= b);
        System.out.println(a <= b);
        System.out.println(a != b); 

    }
}
