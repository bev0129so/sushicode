package com.pg.programmercarl.backtracking;

import java.util.*;

/**
 * @author luojx
 * @date 2024/4/8 11:00
 */
public class Week2 {
    
    List<List<String>> arr = new ArrayList<>();
    List<String> list = new ArrayList<>();

    /**
     * https://programmercarl.com/0131.%E5%88%86%E5%89%B2%E5%9B%9E%E6%96%87%E4%B8%B2.html#%E6%80%9D%E8%B7%AF
     * 关键在于如何分割，可以画一棵树
     * @param s
     * @return {@code List<List<String>>}
     */
    public List<List<String>> partition(String s) {
        partitionBacktracking(s, 0);
        return arr;
    }
    
    public void partitionBacktracking(String s, int startIdx) {
        if (startIdx >= s.length()) {
            arr.add(new ArrayList<>(list));
        }
        for (int i = startIdx; i < s.length(); i++) {
            if (isPalindrome(s, startIdx, i)) {
                list.add(s.substring(startIdx, i + 1));
            } else {
                continue;
            }
            partitionBacktracking(s, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 可以考虑用动态规划优化速度
     * @param target
     * @param start
     * @param end
     * @return boolean
     */
    public boolean isPalindrome(String target, int start, int end) {
        String s = target.substring(start, end);
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    List<String> store = new ArrayList<>();
    /**
     * https://programmercarl.com/0093.%E5%A4%8D%E5%8E%9FIP%E5%9C%B0%E5%9D%80.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
     * @param s
     * @return {@code List<String>}
     */
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return list;
        }
        restoreIpAddressesBackTracking(s, 0);
        return list;
    }
    
    public void restoreIpAddressesBackTracking(String s, int startIdx) {
        if (store.size() == 3) {
            String lastNet = s.substring(startIdx);
            if (!validateIp(lastNet)) {
                return;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < store.size(); i++) {
                builder.append(store.get(i));
                builder.append(".");
            }
            builder.append(lastNet);
            list.add(builder.toString());
            return;
        }
        for (int i = startIdx; i < s.length(); i++) {
            String net = s.substring(startIdx, i + 1);
            if (validateIp(net)) {
              store.add(net);  
            } else {
                break;
            }
            restoreIpAddressesBackTracking(s, i + 1);
            store.remove(store.size() - 1);
        }
    }
    
    public boolean validateIp(String net) {
        if (net == null || net.equals("")) {
            return false;
        }
        if (net.length() > 1 && net.startsWith("0")) {
            return false;
        }
        if (net.length() > 3) {
            return false;
        }
        int n = Integer.parseInt(net);
        if (n > 255) {
            return false;
        }
        return true;
    }
    
}
