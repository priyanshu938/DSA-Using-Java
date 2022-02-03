import java.util.Scanner;

public class MinimumWithdrawls {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), amount;
        int[] arr = new int[n];
        // int[] arr = { 1, 6, 3, 2, 1, 5, 12, 8, 4, 8, 3 };
        // int amount = 18;
        // answer should be 4
        for (int i = 0; i < n; i++) {
        arr[i] = scanner.nextInt();
        }
        amount = scanner.nextInt();
        System.out.println(minWithdraw(arr, amount));
        scanner.close();
    }

    private static int sum(int[] arr, int i, int j) {
        int sum = 0;
        for (int x = i; x <= j; x++) {
            sum += arr[x];
        }
        return sum;

    }

    private static int minWithdraw(int[] arr, int amount) {
        int arraySum = sum(arr, 0, arr.length - 1);
        int target = arraySum - amount;
        int i = 0, j = 1, max_length = 0, current_sum, current_length;
        if (amount > arraySum)
            return -1;
        while (i < arr.length && j < arr.length) {
            current_sum = sum(arr, i, j);
            if (current_sum < target)
                j = j + 1;
            else if (current_sum > target)
                i = i + 1;
            else {
                current_length = j - i + 1;
                max_length = Math.max(current_length, max_length);
                j = j + 1;
            }
        }
        if (max_length == 0) {
            if (amount == arraySum)
                return arr.length;
            else
                return -1;
        }

        int answer = arr.length - max_length;
        return answer;
    }
}