package com.pg.programmercarl.linklist;

/**
 * @author luojx
 * @date 2024/3/5 15:35
 */
public class IntersectListNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListNodeLen(headA);
        int lenB = getListNodeLen(headB);
        ListNode curA = headA;
        ListNode curB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                curA = curA.next;
            }
        } else if (lenA < lenB) {
            for (int i = 0; i < lenB - lenA; i++) {
                curB = curB.next;
            }
        }
        while (curA!=null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
    private int getListNodeLen(ListNode node) {
        int len = 0;
        ListNode cur = node;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}
