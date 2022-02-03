import java.util.*;

public class MinimumPluses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.next().split("=");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int lengthOfX = input[0].length() - 1;
        if (minimum_pluses(x, y, lengthOfX, 1) == -1) {
            System.out.println("Not possible");
        } else
            ;

        sc.close();
    }

    private static int minimum_pluses(int x, int y, int lengthOfX, int level) {

        int first, second, sum=0;

        if (level == lengthOfX) {
            return x;
        }

        for (int i = 0; i < lengthOfX - level; i++) {
            first = Integer.parseInt(Integer.toString(x).substring(0, lengthOfX - level+1));
            second = Integer.parseInt(Integer.toString(x).substring(lengthOfX - level+1));
            sum = minimum_pluses(first, y, lengthOfX, level + 1) + second;
            if (sum == y) {
                System.out.println(sum + "+" + second + "=" + y);
                return 1;
            }
        }
        return -1;

    }
}
