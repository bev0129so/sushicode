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

    List<List<Integer>> subsetArr = new ArrayList<>();
    List<Integer> subsetList = new ArrayList<>();

    /**
     * https://programmercarl.com/0078.%E5%AD%90%E9%9B%86.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
     * @param nums
     * @return {@code List<List<Integer>>}
     */
    public List<List<Integer>> subsets(int[] nums) {
        subsetsBackTracking(nums, 0);
        return subsetArr;
    }
    
    public void subsetsBackTracking(int[] nums, int startIdx) {
//        if (!subsetList.isEmpty()) {
            subsetArr.add(new ArrayList<>(subsetList));
//        }
        for (int i = startIdx; i < nums.length; i++) {
            subsetList.add(nums[i]);
            subsetsBackTracking(nums, i + 1);
            subsetList.remove(subsetList.size() - 1);
        }
    }

    /**
     * https://programmercarl.com/0090.%E5%AD%90%E9%9B%86II.html
     * 理解“树层去重”和“树枝去重”非常重要
     * @param nums
     * @return {@code List<List<Integer>>}
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        subsetsWithDupBackTracking(nums, 0, used);
        return subsetArr;
    }
    
    public void subsetsWithDupBackTracking(int[] nums, int startIdx, boolean[] used) {
        subsetArr.add(new ArrayList<>(subsetList));
        for (int i = startIdx; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            used[i] = true;
            subsetList.add(nums[i]);
            subsetsWithDupBackTracking(nums, i + 1, used);
            used[i] = false;
            subsetList.remove(subsetList.size() - 1);
        }
    }


    /**
     * https://programmercarl.com/0491.%E9%80%92%E5%A2%9E%E5%AD%90%E5%BA%8F%E5%88%97.html
     * 
     * @param nums
     * @return {@code List<List<Integer>>}
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        boolean[] used = new boolean[nums.length];
        findSubsequencesBackTracking(nums, 0, used);
        return subsetArr;
    }
    
    public void findSubsequencesBackTracking(int[] nums, int startIdx, boolean[] used) {
        if (subsetList.size() >= 2) {
            subsetArr.add(new ArrayList<>(subsetList));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = startIdx; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            if (!subsetList.isEmpty()) {
                if (nums[i] < subsetList.get(subsetList.size() - 1)) {
                    continue;
                }
            }
            set.add(nums[i]);
            subsetList.add(nums[i]);
            used[i] = true;
            findSubsequencesBackTracking(nums, i + 1, used);
            subsetList.remove(subsetList.size() - 1);
            used[i] = false;
        }
    }

    List<List<Integer>> perArr = new ArrayList<>();
    List<Integer> plist = new ArrayList<>();

    /**
     * https://programmercarl.com/0046.%E5%85%A8%E6%8E%92%E5%88%97.html#%E6%80%9D%E8%B7%AF
     * 排列为什么for循环从0开始，因为集合是有序的，{1, 2} 和{2, 1}是两个集合
     * 而子集 集合是无序的，子集{1,2} 和 子集{2,1}是一样的
     * @param nums
     * @return {@code List<List<Integer>>}
     */
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permuteBackTracking(nums, used);
        return perArr;
    }

    public void permuteBackTracking(int[] nums, boolean[] used) {
        if (plist.size() == nums.length) {
            perArr.add(new ArrayList<>(plist));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            plist.add(nums[i]);
            used[i] = true;
            permuteBackTracking(nums, used);
            plist.remove(plist.size() - 1);
            used[i] = false;
        }
    }

    /**
     * https://programmercarl.com/0047.%E5%85%A8%E6%8E%92%E5%88%97II.html
     * @param nums
     * @return {@code List<List<Integer>>}
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        permuteUniqueBackTracking(nums, used);
        return perArr;
    }
    
    public void permuteUniqueBackTracking(int[] nums, boolean[] used) {
        if (plist.size() == nums.length) {
            perArr.add(new ArrayList<>(plist));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            used[i] = true;
            plist.add(nums[i]);
            permuteUniqueBackTracking(nums, used);
            used[i] = false;
            plist.remove(plist.size() - 1);
        }
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (l1, l2) -> l1.get(1).compareTo(l2.get(1)));
        boolean[] used = new boolean[tickets.size()];
        int size = tickets.size();
        findItineraryBackTracking(tickets, used, "JFK", size);
        if (arr.size() == 0) {
            return new ArrayList<>();
        }
        return arr.get(0);
    }
    
    public void findItineraryBackTracking(List<List<String>> tickets, boolean[] used, String startAp, int size) {
        if (arr.size() > 0) {
            return;
        }
        //路径到达某一大小
        if (list.size() == size) {
            List<String> r = new ArrayList<>(list);
            r.add(startAp);
            arr.add(r);
            return;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (used[i] || !tickets.get(i).get(0).equals(startAp)) {
                continue;
            }
            //剪枝
            if (i > 0 && 
                    tickets.get(i).get(0).equals(tickets.get(i - 1).get(0)) &&
                    tickets.get(i).get(1).equals(tickets.get(i - 1).get(1)) &&
                    used[i - 1] == false
            ) {
                continue;
            }
            list.add(tickets.get(i).get(0));
            used[i] = true;
            findItineraryBackTracking(tickets, used, tickets.get(i).get(1), size);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Week2 week2 = new Week2();
        List<List<String>> flights = new ArrayList<>();
        flights.add(Arrays.asList("MUC", "LHR"));
        flights.add(Arrays.asList("JFK", "MUC"));
        flights.add(Arrays.asList("SFO", "SJC"));
        flights.add(Arrays.asList("LHR", "SFO"));
        week2.findItinerary(flights);
    }
}
