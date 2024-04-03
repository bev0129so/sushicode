package com.pg.programmercarl.linklist;

/**
 * @author luojx
 * @date 2024/3/5 15:19
 */
public class RemoveNthListNode {
    
    /*
        1   2   3   4   5
        2
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
