import java.util.*;
public class CombinationSum {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 }, target = 8;
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("When repetition is allowed : ");
        findCombinationRepetitionAllowed(0, target, stack, arr);
        System.out.println("When repetition is not allowed : ");
        findCombinationRepetitionNotAllowed(0, target, stack, arr);
    }

    // repeatition allowed
    private static void findCombinationRepetitionAllowed(int index, int target, Stack<Integer> stack, int[] arr) {
        if (index == arr.length) {
            if (target == 0) {
                System.out.println(stack);
            }
            return;
        }
        if (arr[index] <= target) {
            stack.push(arr[index]);
            findCombinationRepetitionAllowed(index, target - arr[index], stack, arr);
            stack.pop();
        }
        findCombinationRepetitionAllowed(index + 1, target, stack, arr);
    }

    // repeatition not allowed
    private static void findCombinationRepetitionNotAllowed(int index, int target, Stack<Integer> stack, int[] arr) {
        if (index == arr.length) {
            if (target == 0) {
                System.out.println(stack);
            }
            return;
        }
        stack.push(arr[index]);
        findCombinationRepetitionNotAllowed(index + 1, target - arr[index], stack, arr);
        stack.pop();
        findCombinationRepetitionNotAllowed(index + 1, target, stack, arr);
    }
}