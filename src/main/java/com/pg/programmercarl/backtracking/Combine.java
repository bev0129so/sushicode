package com.pg.programmercarl.backtracking;

import java.util.*;

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


    List<Integer> list = new ArrayList<>();

    /**
     * https://programmercarl.com/0039.%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8C.html
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumBackTracking(candidates, target, 0);
        return arr;
    }
    
    public void combinationSumBackTracking(int[] candidates, int leftVal, int startIdx) {
        if (leftVal < 0) {
            return;
        }
        if (leftVal == 0) {
            arr.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIdx; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSumBackTracking(candidates, leftVal - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }


    /**
     * https://programmercarl.com/0040.%E7%BB%84%E5%90%88%E6%80%BB%E5%92%8CII.html#%E6%80%9D%E8%B7%AF
     * 
     * @param candidates
     * @param target
     * @return {@code List<List<Integer>>}
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        combinationSum2Backtracking(candidates, target, 0, used);
        return arr;
    }
    
    public void combinationSum2Backtracking(int[] candidates, int leftVal, int startIdx, boolean[] used) {
        if (leftVal < 0) {
            return;
        }
        if (leftVal == 0) {
            arr.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIdx; i < candidates.length; i++) {
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 要对同一树层使用过的元素进行跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            list.add(candidates[i]);
            used[i] = true;
            combinationSum2Backtracking(candidates, leftVal - candidates[i], i + 1, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }


    Map<Character, char[]> map = new HashMap<>();
    List<String> listc = new ArrayList<>();
    List<Character> cr = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) {
            return listc;
        }
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        letterCombinationsBackTracking(digits.toCharArray(), 0);
        return listc;
    }

    public void letterCombinationsBackTracking(char[] digits, int startIdx) {
        if (cr.size() == digits.length) {
            Character[] characters = new Character[digits.length];
            cr.toArray(characters);
            String res = new String();
            for (Character character : characters) {
                res += character;
            }
            listc.add(res);
            return;
        }
        for (int i = startIdx; i < digits.length; i++) {
            for (int j = 0; j < map.get(digits[i]).length; j++) {
                cr.add(map.get(digits[i])[j]);
                letterCombinationsBackTracking(digits, i + 1);
                cr.remove(cr.size() - 1);
            }
        }
    }
}
