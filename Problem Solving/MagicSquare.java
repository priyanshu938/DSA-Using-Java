
import java.util.*;

public class MagicSquare {

    public static int m1(List<List<Integer>> s) {
        return Math.abs(8 - s.get(0).get(0)) + Math.abs(3 - s.get(0).get(1)) + Math.abs(4 - s.get(0).get(2)) +
                Math.abs(1 - s.get(1).get(0)) + Math.abs(5 - s.get(1).get(1)) + Math.abs(9 - s.get(1).get(2)) +
                Math.abs(6 - s.get(2).get(0)) + Math.abs(7 - s.get(2).get(1)) + Math.abs(2 - s.get(2).get(2));
    }

    public static int m2(List<List<Integer>> s) {
        return Math.abs(6 - s.get(0).get(0)) + Math.abs(1 - s.get(0).get(1)) + Math.abs(8 - s.get(0).get(2)) +
                Math.abs(7 - s.get(1).get(0)) + Math.abs(5 - s.get(1).get(1)) + Math.abs(3 - s.get(1).get(2)) +
                Math.abs(2 - s.get(2).get(0)) + Math.abs(9 - s.get(2).get(1)) + Math.abs(4 - s.get(2).get(2));
    }

    public static int m3(List<List<Integer>> s) {
        return Math.abs(2 - s.get(0).get(0)) + Math.abs(7 - s.get(0).get(1)) + Math.abs(6 - s.get(0).get(2)) +
                Math.abs(9 - s.get(1).get(0)) + Math.abs(5 - s.get(1).get(1)) + Math.abs(1 - s.get(1).get(2)) +
                Math.abs(4 - s.get(2).get(0)) + Math.abs(3 - s.get(2).get(1)) + Math.abs(8 - s.get(2).get(2));
    }

    public static int m4(List<List<Integer>> s) {
        return Math.abs(4 - s.get(0).get(0)) + Math.abs(9 - s.get(0).get(1)) + Math.abs(2 - s.get(0).get(2)) +
                Math.abs(3 - s.get(1).get(0)) + Math.abs(5 - s.get(1).get(1)) + Math.abs(7 - s.get(1).get(2)) +
                Math.abs(8 - s.get(2).get(0)) + Math.abs(1 - s.get(2).get(1)) + Math.abs(6 - s.get(2).get(2));
    }

    public static int m5(List<List<Integer>> s) {
        return Math.abs(8 - s.get(0).get(0)) + Math.abs(1 - s.get(0).get(1)) + Math.abs(6 - s.get(0).get(2)) +
                Math.abs(3 - s.get(1).get(0)) + Math.abs(5 - s.get(1).get(1)) + Math.abs(7 - s.get(1).get(2)) +
                Math.abs(4 - s.get(2).get(0)) + Math.abs(9 - s.get(2).get(1)) + Math.abs(2 - s.get(2).get(2));
    }

    public static int m6(List<List<Integer>> s) {
        return Math.abs(6 - s.get(0).get(0)) + Math.abs(7 - s.get(0).get(1)) + Math.abs(2 - s.get(0).get(2)) +
                Math.abs(1 - s.get(1).get(0)) + Math.abs(5 - s.get(1).get(1)) + Math.abs(9 - s.get(1).get(2)) +
                Math.abs(8 - s.get(2).get(0)) + Math.abs(3 - s.get(2).get(1)) + Math.abs(4 - s.get(2).get(2));
    }

    public static int m7(List<List<Integer>> s) {
        return Math.abs(2 - s.get(0).get(0)) + Math.abs(9 - s.get(0).get(1)) + Math.abs(4 - s.get(0).get(2)) +
                Math.abs(7 - s.get(1).get(0)) + Math.abs(5 - s.get(1).get(1)) + Math.abs(3 - s.get(1).get(2)) +
                Math.abs(6 - s.get(2).get(0)) + Math.abs(1 - s.get(2).get(1)) + Math.abs(8 - s.get(2).get(2));
    }

    public static int m8(List<List<Integer>> s) {
        return Math.abs(4 - s.get(0).get(0)) + Math.abs(3 - s.get(0).get(1)) + Math.abs(8 - s.get(0).get(2)) +
                Math.abs(9 - s.get(1).get(0)) + Math.abs(5 - s.get(1).get(1)) + Math.abs(1 - s.get(1).get(2)) +
                Math.abs(2 - s.get(2).get(0)) + Math.abs(7 - s.get(2).get(1)) + Math.abs(6 - s.get(2).get(2));
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        int minCost = Math.min(m1(s), m2(s));
        minCost = Math.min(minCost, m3(s));
        minCost = Math.min(minCost, m4(s));
        minCost = Math.min(minCost, m5(s));
        minCost = Math.min(minCost, m6(s));
        minCost = Math.min(minCost, m7(s));
        minCost = Math.min(minCost, m8(s));
        return minCost;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<List<Integer>> s = new ArrayList<>();
        System.out.println("Enter 3x3 matrix elements : ");
        for (int i = 0; i < 3; i++) {
            List<Integer> x = new ArrayList<Integer>();
            for (int j = 0; j < 3; j++) {
                int z = sc.nextInt();
                x.add(z);
            }
            s.add(x);
        }
        int result = formingMagicSquare(s);
        System.out.println("Required Minimum Cost is : " + result);
        sc.close();
    }
}
