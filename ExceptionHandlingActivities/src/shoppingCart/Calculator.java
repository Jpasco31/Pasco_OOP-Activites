package shoppingCart;

public class Calculator {
    public int add(int x, int y) {
        return x + y;
    }

    // This method could throw an ArithmeticException
    public double divide(int x, int y) {
        double quotient;

        if (y != 0) {
            quotient = (double) x / y;
        } else {
            System.out.println("Arithmetic handling: there is an error y = 0");
            quotient = 0;
        }

        return quotient;
    }
}