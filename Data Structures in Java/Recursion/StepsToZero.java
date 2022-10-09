

import java.util.*;

public class StepsToZero {
    public static int steps(int n, int c) {
        if (n == 0)
            return c;
        if (n % 2 == 0) {
            return steps(n / 2, c + 1);
        } else
            return steps(n - 1, c + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scanner.nextInt();
        System.out.println("Number of steps to zero are : " + steps(n, 0));
        scanner.close();
    }
}
