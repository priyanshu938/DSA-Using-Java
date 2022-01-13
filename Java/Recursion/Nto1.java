

import java.util.*;

public class Nto1 {
    public static void oneToN(int n) {

        if (n == 0)
            return;
        oneToN(n - 1);
        System.out.print(n + " ");

    }

    public static void nToOne(int n) {
        if (n == 0)
            return;
        System.out.print(n + " ");
        nToOne(n - 1);

    }

    public static void both(int n) {
        if (n == 0)
            return;
        System.out.print(n + " ");
        both(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scanner.nextInt();
        System.out.println("N to 1 : ");
        nToOne(n);
        System.out.println("\n1 to N : ");
        oneToN(n);
        System.out.println("\nBoth : ");
        both(n);

        scanner.close();
    }
}