package com.pg.programmercarl.arr.interv;

import java.util.LinkedList;
import java.util.List;

/**
 * @author luojx
 * @date 2024/3/5 8:53
 */
public class Permutation {
    public static void main(String[] args) {
    }

    private List<List<Integer>> res = new LinkedList<>();

    /* 全排列 */
    public List<List<Integer>> permute(List<Integer> nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.size()];

        backtrack(nums, track, used);
        return res;
    }
    void backtrack(List<Integer> nums, LinkedList<Integer> track, boolean[] used) {
        if (!track.isEmpty())
            res.add(new LinkedList(track));
        if (track.size() == nums.size()) {
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (used[i]) {
                continue;
            }
            track.add(nums.get(i));
            used[i] = true;
            backtrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
