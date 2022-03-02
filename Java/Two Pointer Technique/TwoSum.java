import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(twoSumBruteForceQuadraticTimeComplexity(nums, target));
        System.out.println(twoSumUsingHashMapLinearTimeComplexity(nums, target));
        System.out.println(twoSumUsingTwoPointersApproach(nums, target));
    }

    private static List<Integer> twoSumUsingTwoPointersApproach(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        Arrays.sort(nums);
        List<Integer> ans = new LinkedList<Integer>();

        while (s < e) {
            if (nums[s] + nums[e] == target) {
                ans.add(nums[s]);
                ans.add(nums[e]);
                break;
            } else if (nums[s] + nums[e] > target) {
                e--;
            } else
                s++;
        }
        return ans;
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
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    return ans;
                }
            }
        }
        return ans;
    }
}