package com.rango.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum//">两数之和</a>
 */
public class N0001TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i], dif;
            if (map.containsKey(dif = target - cur)) {
                return new int[]{map.get(dif), i};
            }
            map.put(cur, i);
        }
        return new int[]{};
    }

}
