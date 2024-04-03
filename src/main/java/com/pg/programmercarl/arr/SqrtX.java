package com.pg.programmercarl.arr;

import java.util.Stack;

/**
 * @author luojx
 * @date 2024/3/2 14:13
 */
public class SqrtX {

    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        boolean b = sqrtX.backspaceCompare("ab##", "c#d#");
        System.out.println("b = " + b);
    }

    /*
    输入：x = 8
    输出：2
    解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > (x / mid)) {
                right = mid - 1;
            } else if (mid < (x / mid)) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid > num) {
                right = mid - 1;
            } else if ((long) mid * mid < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /*
        26. 删除有序数组中的重复项
        输入：nums = [1,1,1,2,2,3,3,4]
        输出：5, nums = [0,0,1,2,3,4]
        解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int slow = 1, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /*
        输入: nums = [0,1,0,3,12]
        输出: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
        int k = 0;
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            if (nums[fast] == 0)
                k++;
            fast++;
        }
        for (int j = nums.length - 1; j >= nums.length - k; j--) {
            nums[j] = 0;
        }
    }



    /*
        输入：s = "ab##", t = "c#d#"
        输出：true
        解释：s 和 t 都会变成 ""。
     */
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stackS.push(s.charAt(i));
            } else {
                if (!stackS.empty())
                    stackS.pop();
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                stackT.push(t.charAt(i));
            } else {
                if (!stackT.empty())
                    stackT.pop();
            }
        }
        StringBuilder b1 = new StringBuilder();
        StringBuilder b2 = new StringBuilder();
        while (!stackS.empty()) {
            b1.append(stackS.pop());
        }

        while (!stackT.empty()) {
            b2.append(stackT.pop());
        }
        return b1.toString().equals(b2.toString());
    }

}
