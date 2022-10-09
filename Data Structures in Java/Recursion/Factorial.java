
import java.util.*;

public class Factorial {
    public static int factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static int sumNto1(int n) {
        if (n <= 1)
            return 1;
        return n + sumNto1(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scanner.nextInt();
        System.out.println("Factorial of " + n + " is : " + factorial(n));
        System.out.println("Sum of " + n + " to 1 is : " + sumNto1(n));

        scanner.close();

    }
}
