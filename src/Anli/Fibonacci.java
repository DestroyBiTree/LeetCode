package Anli;
import java.util.Scanner;

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be a positive integer.");
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 1;
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int fibonacciNumber = fibonacci(n);
        System.out.println(fibonacciNumber);
    }
}

