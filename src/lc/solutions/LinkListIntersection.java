package lc.solutions;

import common.datastructure.ListNode;

public class LinkListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p=headA, q=headB;
        while ((p!=null) &&(q!=null)) {
        	p=p.next;
        	q=q.next;
        }
        while (p!=null) {
        	headA = headA.next;
        	p = p.next;
        }
        while (q!=null) {
        	headB = headB.next;
        	q = q.next;
        }
        while ((headA!=null) && (headA!=headB)) {
        	headA=headA.next;
        	headB=headB.next;
        }
        return headA;
    }
}
