package com.pg.programmercarl.linklist;

/**
 * @author luojx
 * @date 2024/3/5 14:44
 */
public class ReverseList {
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
