package com.pg.programmercarl.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowsMaximum {

    public static void main(String[] args) {
        SlidingWindowsMaximum windowsMaximum = new SlidingWindowsMaximum();
        int[] arr = windowsMaximum.maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * https://programmercarl.com/0239.%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3%E6%9C%80%E5%A4%A7%E5%80%BC.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
     * carl有问题
     * @param nums
     * @param k
     * @return {@link int[]}
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - (k - 1)];
        int idx = 0;
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        res[idx++] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            res[idx++] = nums[deque.peekFirst()];
        }
        return res;
    }
}
