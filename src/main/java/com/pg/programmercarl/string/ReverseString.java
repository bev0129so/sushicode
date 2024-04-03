package com.pg.programmercarl.string;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luojx
 * @date 2024/3/12 9:02
 */
public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public String reverseWords(String s) {
        List<String> split = Arrays.stream(s.split(" ")).filter(item -> !"".equals(item)).collect(Collectors.toList());
        int left = 0;
        int right = split.size() - 1;
        while (left < right) {
            String temp = split.get(left);
            split.set(left, split.get(right));
            split.set(right, temp);
            left++;
            right--;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.size(); i++) {
            builder.append(split.get(i));
            if (i != split.size() - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = last;
            last = cur;
            cur = temp;
        }
        return last;
    }
}
