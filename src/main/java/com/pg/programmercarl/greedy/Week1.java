package com.pg.programmercarl.greedy;

import java.util.*;

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
     * https://programmercarl.com/0376.%E6%91%86%E5%8A%A8%E5%BA%8F%E5%88%97.html#%E6%80%9D%E8%B7%AF
     * carl的策略有些复杂，建议直接看lc上的评论
     * @param nums
     * @return int
     */
    public int wiggleMaxLength(int[] nums) {
        Boolean preWiggleUp = null;
        if (nums.length < 2) return nums.length;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] > 0) {
                if (preWiggleUp != null && preWiggleUp) {
                    continue;
                }
                preWiggleUp = true;
                res++;
            } else {
                if (preWiggleUp != null && preWiggleUp == false) {
                    continue;
                }
                preWiggleUp = false;
                res++;
            }
        }
        return res;
    }

    /**
     * https://leetcode.cn/problems/maximum-subarray/submissions/522087575/
     * @param nums
     * @return int
     */
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n += nums[i];
            sum = Math.max(sum, n);
            if (n < 0) {
                n = 0;
            }
        }
        return sum;
    }

    /**
     * https://programmercarl.com/0122.%E4%B9%B0%E5%8D%96%E8%82%A1%E7%A5%A8%E7%9A%84%E6%9C%80%E4%BD%B3%E6%97%B6%E6%9C%BAII.html
     * @param prices
     * @return int
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                continue;
            }
            profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

    /**
     * https://programmercarl.com/0055.%E8%B7%B3%E8%B7%83%E6%B8%B8%E6%88%8F.html#%E6%80%9D%E8%B7%AF
     * 每移动一个单位，就更新最大覆盖范围
     * @param nums
     * @return boolean
     */
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i <= maxJump; i++) {
            if (maxJump >= nums.length - 1) {
                return true;
            }
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return false;
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
