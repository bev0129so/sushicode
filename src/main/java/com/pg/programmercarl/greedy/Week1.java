package com.pg.programmercarl.greedy;

import java.util.Arrays;

public class Week1 {

    /**
     * @param g
     * @param s
     * @return int
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cd = 0;
        for (int i = s.length - 1, j = g.length - 1; i >= 0 && j >= 0;) {
            if (s[i] >= g[j]) {
                cd++;
                j--;
                i--;
            } else {
                j--;
            }
        }
        return cd;
    }

    /**
     * 跳最小的步数来获取最大的覆盖范围
     * @param nums
     * @return int
     */
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int step = 0;
        int maxCover = 0, curDis = 0;
        for (int i = 0; i < nums.length; i++) {
            maxCover = Math.max(maxCover, nums[i] + i);
            if (i == curDis) {
                step++;
                curDis = maxCover;
                if (curDis >= nums.length - 1) {
                    break;
                }
            }
        }
        return step;
    }
}
