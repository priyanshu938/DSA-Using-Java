import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, 4 };
        int target = 0;
        System.out.println(threeSumBruteForce(nums, target));
    }

    private static List<List<Integer>> threeSumBruteForce(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> sub = new LinkedList<Integer>();
                        sub.add(nums[i]);
                        sub.add(nums[j]);
                        sub.add(nums[k]);
                        result.add(sub);
                    }
                }
            }
        }
        return result;
    }
}
