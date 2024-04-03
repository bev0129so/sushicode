package com.pg.programmercarl.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luojx
 * @date 2024/3/6 10:43
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] idx = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (!map.containsKey(remain)) {
                continue;
            }
            List<Integer> x = map.get(remain);
            for (Integer dx : x) {
                if (dx == i) {
                    continue;
                }
                idx[0] = i;
                idx[1] = dx;
            }
        }
        return idx;
    }
}
