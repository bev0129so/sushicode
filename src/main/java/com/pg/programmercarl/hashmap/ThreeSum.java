package com.pg.programmercarl.hashmap;

import java.util.*;

/**
 * @author luojx
 * @date 2024/3/7 10:00
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,-1,0};
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(nums);
    }
    /*
        使用双指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                    continue;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                    continue;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right - 1] == nums[right]) right--;
                    while (left < right && nums[left + 1] == nums[left]) left++;
                }
                left++;
                right--;
            }
        }
        return res;
    }
}
