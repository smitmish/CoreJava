class Calculator {
    int add(int a, int b){
        return a+b;
    }
    int subtract(int a, int b){
        return a-b;
    }
    int multiply(int a, int b){
        return a*b;
    }
    double divide(int a, int b){
        if(b==0){
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double)a/b;
    }
}

public class CLassObjectExample {
    public static void main(String[] args){
        Calculator calc = new Calculator();
        System.out.println("Addition: " + calc.add(5, 3));
        System.out.println("Subtraction: " + calc.subtract(5, 3));
        System.out.println("Multiplication: " + calc.multiply(5, 3));
        System.out.println("Division: " + calc.divide(5, 3));
    }

}
