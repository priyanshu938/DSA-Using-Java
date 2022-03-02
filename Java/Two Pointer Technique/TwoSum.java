import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 17;
        System.out.println(twoSumBruteForceQuadraticTimeComplexity(nums, target));
        System.out.println(twoSumUsingHashMapLinearTimeComplexity(nums, target));

    }

    private static List<Integer> twoSumUsingHashMapLinearTimeComplexity(int[] nums, int target) {
        List<Integer> ans = new LinkedList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (map.containsKey(find)) {
                ans.add(find);
                ans.add(nums[i]);
                break;
            } else
                map.put(nums[i], i);
        }
        return ans;
    }

    private static List<Integer> twoSumBruteForceQuadraticTimeComplexity(int[] nums, int target) {
        List<Integer> ans = new LinkedList<Integer>();
        for (Integer x : nums) {
            for (Integer y : nums) {
                if (x + y == target) {
                    ans.add(x);
                    ans.add(y);
                    return ans;
                }
            }

        }
        return ans;
    }
}