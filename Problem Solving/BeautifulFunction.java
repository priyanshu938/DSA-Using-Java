import java.util.*;

public class BeautifulFunction {
    public static int count_trailing_zeroes(int num) {
        int c = 0;
        while (num > 0) {
            String d = Integer.toString(num);
            num /= 10;
            if (d.endsWith("0"))
                c++;
            else
                return c;
        }
        return c;
    }

    public static int returnBeautiful(int num) {
        num = num + 1;
        int count = count_trailing_zeroes(num);
        if (count == 0)
            return num;
        else
            return num / (int) Math.pow(10, count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(returnBeautiful(n));
        while (true) {
            int beautiful = returnBeautiful(stack.peek());
            // System.out.println(stack); uncomment this to check iterations
            if (stack.contains(beautiful))
                break;
            stack.push(beautiful);
        }
        System.out.println(n == 1 ? stack.size() : stack.size() + 1);
        scanner.close();
    }
}