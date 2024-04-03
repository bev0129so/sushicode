package com.pg.programmercarl.arr;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author luojx
 * @date 2024/3/5 10:56
 */
public class Permute {

    public static void main(String[] args) {
        Permute p = new Permute();
        p.permute(new int[]{1, 2, 3});
    }

    List<List<Integer>> res = new ArrayList<>();
    List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permute(new LinkedList<>(), nums, used);
        System.out.println("res = " + res);
        return res;
    }
    
    void permute(LinkedList<Integer> tempRes, int[] nums, boolean[] used) {
        if (tempRes.size() == nums.length) {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            tempRes.add(nums[i]);
            used[i] = true;
            permute(tempRes, nums, used);
            tempRes.removeLast();
            used[i] = false;
        }
        
    }
    
}
