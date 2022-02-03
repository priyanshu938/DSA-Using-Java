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

        return -1;

    }
}