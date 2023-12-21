package ocp_1Z0_819;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Test.Solution s = new Solution();

        System.out.println(Arrays.toString(s.twoSum(new int[]{3, 2, 3}, 6)));
    }

    static class Solution {
        private int[] res = new int[2];

        public int[] twoSum(int[] nums, int target) {
            helper(nums, target, 0, false);
            return res;
        }


        private int helper(int[] nums, int target, int i, boolean isDeducted) {
            if (i >= nums.length || target < 0) return -1;

            if (isDeducted && nums[i] == target) {
                return i;
            }

            int w;

            if (!isDeducted) {
                w = helper(nums, target - nums[i], i + 1, true);
                if (w != -1) {
                    res[0] = i;
                    res[1] = w;
                    return w;
                }
            }

            return helper(nums, target, i+1, isDeducted);
        }
    }
}
