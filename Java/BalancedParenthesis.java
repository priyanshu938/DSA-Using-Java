import java.util.*;

public class BalancedParenthesis {
    public static boolean checkParenthesis(String parenthesis) {
        Deque<Character> stack = new ArrayDeque<Character>();
        char c = parenthesis.charAt(0);
        stack.push(c);
        Character p = c;
        for (int i = 1; i < parenthesis.length(); i++) {
            if (i != 0) {
                c = parenthesis.charAt(i);
                p = stack.peek();
            }
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' && p == '{' || c == ']' && p == '[' || c == ')' && p == '(') {
                stack.pop();
            } else
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string containing parenthesis :");
        String parenthesis = scanner.next();
        scanner.close();
        if (checkParenthesis(parenthesis) == true) {
            System.out.println("Balanced Parenthesis");
        } else
            System.out.println("Unbalanced Parenthesis");

    }
}