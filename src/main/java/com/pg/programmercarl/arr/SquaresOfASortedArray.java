package com.pg.programmercarl.arr;

/**
 * 977.有序数组的平方
 *
 * @author luojx
 * @date 2024/3/1 9:32
 */
public class SquaresOfASortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{-4,-1,0,3,10};
        SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray();
        int[] ints = squaresOfASortedArray.squareOfSortedArr(arr);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
    public int[] squareOfSortedArr(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int idx = nums.length - 1;
        int[] result = new int[nums.length];
        while (idx >= 0) {
            if (nums[l] * nums[l] < nums[r] * nums[r]) {
                result[idx--] = nums[r] * nums[r];
                r--;
            } else {
                result[idx--] = nums[l] * nums[l];
                l++;
            }
        }
        return result;
    }
}
