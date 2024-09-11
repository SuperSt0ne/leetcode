package com.rango.leetcode;

/**
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">209.长度最小的子数组</a>
 */
public class N0209MinimumSizeSubArraySum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    /**
     * sliding window
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, windowSum = 0;
        //window[i, j]
        for (int i = 0, j = 0; j < nums.length; j++) {
            windowSum += nums[j];
            while (windowSum >= target) {
                ans = Math.min(ans, j - i + 1);
                windowSum -= nums[i];
                i++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


}
