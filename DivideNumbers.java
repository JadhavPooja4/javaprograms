import java.util.InputMismatchException;
import java.util.Scanner;



public class DivideNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            double result = divide(num1, num2);
            System.out.println("The result of dividing " + num1 + " by " + num2 + " is: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input Please enter numeric values");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("We cannot divide by zero.");
        }
        return a / b;
    }
}
