import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        int target = 0;
        System.out.println(threeSumBruteForce(nums, target));
        System.out.println(threeSumUsingTwoPointerApproach(nums, target));

    }

    private static List<List<Integer>> threeSumUsingTwoPointerApproach(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int a = 0 - nums[i];
                int s = i + 1, e = nums.length - 1;
                while (s < e) {
                    int b = nums[s], c = nums[e];
                    if (b + c == a) {
                        res.add(Arrays.asList(-a, b, c));
                        while (s < e && nums[s] == nums[s + 1])
                            s++;
                        while (s < e && nums[e] == nums[e - 1])
                            e--;
                        s++;
                        e--;
                    } else if (b + c > a)
                        e--;
                    else
                        s++;
                }
            }
        }
        return res;
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
