package com.pg.programmercarl.hashmap;

import java.util.*;

/**
 * @author luojx
 * @date 2024/3/6 10:16
 */
public class ArrayIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> list = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }
        for (int n : nums2) {
            if (set.contains(n)) {
                list.add(n);
            }
        }
        int[] a = new int[list.size()];
        int i = 0;
        for (Integer s : list) {
            a[i++] = s;
        }
        return a;
    }

    public int[] intersectV2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                list.add(n);
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    map.remove(n);
                }
            }
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }
}
