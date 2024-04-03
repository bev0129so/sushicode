package com.pg.programmercarl.linklist;

/**
 * @author luojx
 * @date 2024/3/5 14:55
 */
public class SwapListNode {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = temp1;
            cur.next.next.next = temp2;
            cur = cur.next.next;
        }
        return dummy.next;
    }
//   dd -> A -> B -> C -> D
}
