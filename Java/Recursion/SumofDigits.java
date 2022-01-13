

import java.util.*;

public class SumofDigits {
    public static int sum = 0;

    public static int sumOfDigits(int n) {
        if (n <= 0)
            return 0;

        return n % 10 + sumOfDigits(n / 10);
    }
    public static int productOfDigits(int n) {
        if (n%10 ==n)
            return n;

        return n % 10 * productOfDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scanner.nextInt();
        System.out.println("Sum of digits of " + n + " is : " + sumOfDigits(n));
        System.out.println("Product of digits of " + n + " is : " + productOfDigits(n));

        scanner.close();

    }
}
