package com.pg.programmercarl.stackqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author luojx
 * @date 2024/3/26 9:26
 */
public class TopK {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        //返回负数，那么第一个形参在前
        //返回正数，那么第二个形参在前
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, ((o1, o2) -> o2[2] - o1[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
