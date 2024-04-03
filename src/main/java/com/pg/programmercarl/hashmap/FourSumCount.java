package com.pg.programmercarl.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luojx
 * @date 2024/3/6 11:03
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int len = nums1.length;
        int res = 0;
        Map<Integer, Integer> pre = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = nums1[i] + nums2[j];
                pre.put(sum, pre.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = (nums3[i] + nums4[j]) * -1;
                if (pre.containsKey(sum)) {
                    res+=pre.get(sum);
                }
            }
        }
        return res;
    }
}
