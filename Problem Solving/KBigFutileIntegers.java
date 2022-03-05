import java.util.*;

public class KBigFutileIntegers {
    public static List<List<Integer>> kBigSets = new LinkedList<List<Integer>>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        findKBigSubsets(arr, new ArrayList<Integer>(), 0, k);
        List<Boolean> checked = new ArrayList<Boolean>(Collections.nCopies(arr.size(), false));
        int futile = 0;
        for (int i = 0; i < n; i++) {
            for (List<Integer> x : kBigSets) {
                if (x.contains(arr.get(i)) && checked.get(i) == false) {
                    x.remove(arr.get(i));
                    if (sum(x) >= k) {
                        futile++;
                        checked.add(i, true);
                    }
                    x.add(arr.get(i));
                }
            }
        }
        System.out.println(futile);
    }

    public static void findKBigSubsets(ArrayList<Integer> nums, ArrayList<Integer> output, int index, int k) {
        if (index == nums.size()) {
            if (sum(output) >= k)
                kBigSets.add(output);
            return;
        }
        findKBigSubsets(nums, new ArrayList<Integer>(output), index + 1, k);
        output.add(nums.get(index));
        findKBigSubsets(nums, new ArrayList<Integer>(output), index + 1, k);
    }

    private static int sum(List<Integer> sub) {
        int sum = 0;
        for (Integer i : sub) {
            sum += i;
        }
        return sum;
    }

}