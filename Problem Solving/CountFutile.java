import java.util.*;

public class CountFutile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        // int n = 3, k = 9;
        // List<Integer> arr = new ArrayList<Integer>(Arrays.asList(17,5,3));
        int futile = 0, sum = sum(arr);
        for (Integer x : arr) {
            if (sum - x >= k)
                futile++;
        }
        System.out.println(futile);

    }

    private static int sum(List<Integer> sub) {
        int sum = 0;
        for (Integer i : sub) {
            sum += i;
        }
        return sum;
    }
}
