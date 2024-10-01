package Oct_1_Task;

public class Calculator {
     static int a=50;
     static int b = 20;

    public static void main(String[] args) {

        System.out.println(add());

        System.out.println(subtract());

        System.out.println(multiply());

        System.out.println(divide());

    }

    // Method to perform addition
    public static int add( ) {
        return a + b;
    }

    // Method to perform subtraction
    public static int subtract() {
        return a - b;
    }

    // Method to perform multiplication
    public static int multiply() {
        return a * b;
    }

    // Method to perform division (with a check to avoid division by zero)
    public static int divide() throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return a / b;
    }
}



