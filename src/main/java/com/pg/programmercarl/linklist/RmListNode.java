package com.pg.programmercarl.linklist;

/**
 * @author luojx
 * @date 2024/3/5 14:24
 */
public class RmListNode {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val != val) {
                cur = cur.next;
                continue;
            }
            cur.next = cur.next.next;
        }
        return dummy.next;
    }
}
