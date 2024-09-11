package com.rango.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/3sum/">15.三数之和</a>
 */
public class N0015ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // 如果当前数与前一个数相等，则跳过
                continue;
            }
            if (nums[i] > 0) { // 如果当前数大于0，则后面数必大于0，直接跳出
                break;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) { // 如果当前数小于0，则需要将j右移
                    j++;
                } else if (sum > 0) { // 如果当前数大于0，则需要将k左移
                    k--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while (j < k && nums[j] == nums[j - 1]) { // 如果当前数与前一个数相等，则跳过
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) { // 如果当前数与后一个数相等，则跳过
                        k--;
                    }
                }
            }
        }
        return ans;
    }


}
