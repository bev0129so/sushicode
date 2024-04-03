package com.pg.programmercarl.arr;

/**
 * @author luojx
 * @date 2024/3/2 13:29
 */
public class InsertPos {

    public static void main(String[] args) {
        InsertPos insertPos = new InsertPos();
        int[] firstAndLastPosition = insertPos.findFirstAndLastPosition(6, new int[]{5, 7, 7, 8, 8, 10});
        for (int i : firstAndLastPosition) {
            System.out.print(i + " ");
        }
    }

    /*
        35.搜索插入位置
        输入: [1,3,5,6], 2
        输出: 1
     */
    public int insertPosition(int target, int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    /*
        34.在排序数组中查找元素的第一个和最后一个位置
        输入：nums = [5,7,7,8,8,10], target = 8
        输出：[3,4]
     */
    public int[] findFirstAndLastPosition(int target, int[] nums) {
        int left = 0, right = nums.length - 1;
        int low = Integer.MAX_VALUE, high = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                low = mid;
                high = mid;
                left = mid;
                right = mid;
                while (--left >=0 && nums[left] == target) {
                    low--;
                }
                while (++right < nums.length && nums[right] == target) {
                    high++;
                }
                return new int[]{low, high};
            }
        }
        return new int[]{-1, -1};
    }
}
