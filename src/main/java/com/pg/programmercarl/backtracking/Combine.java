package com.pg.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

/**
 * @author luojx
 * @date 2024/4/7 15:44
 */
public class Combine {
    List<List<Integer>> arr = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    public List<List<Integer>> combine(int n, int k) {
        combineBackTracking(n, k, 1);
        return arr;
    }
    
    public void combineBackTracking(int n, int k, int startIdx) {
        if (stack.size() == k) {
            arr.add(new ArrayList<>(stack));
            return;
        }
        for (int i = startIdx; i <= n; i++) {// 控制树的横向遍历
            stack.add(i);// 处理节点
            combineBackTracking(n, k, i + 1);// 递归：控制树的纵向遍历，注意下一层搜索要从i+1开始
            stack.pop();// 回溯，撤销处理的节点
        }
    }

    /**
     * https://programmercarl.com/0216.%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8CIII.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3BackTracking(k, n, 0, 1);
        return arr;
    }

    public void combinationSum3BackTracking(int k, int sum, int curSum, int startIdx) {
        if (curSum > sum) {
            return;
        }
        if (stack.size() == k && curSum == sum) {
            arr.add(new ArrayList<>(stack));
        }
        for (int i = startIdx; i <= 9; i++) {
            stack.add(i);
            curSum += i;
            combinationSum3BackTracking(k, sum, curSum, i + 1);
            stack.pop();
            curSum -= i;
        }
    }
    
    public Integer getSum(Stack<Integer> stack) {
        int sum = 0;
        Enumeration<Integer> enumeration = stack.elements();
        while (enumeration.hasMoreElements()) {
            sum += enumeration.nextElement();
        }
        return sum;
    }
}
