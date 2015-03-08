package lc.solutions;

import common.datastructure.ListNode;

public class RemoveDuplicateFromList {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) return null;
        ListNode p = head, q;
        while (null !=p) {
        	q=  p.next;
            while (null!=q && q.val == p.val) {
        	    q = q.next;
            }
            p.next = q;
            p = q;
        }
        
        return head;
    }
    public ListNode deleteDuplicates2(ListNode head) {
    	if (null == head || null == head.next) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode r = dummy, p = head,q;
        while (null != p) {
        	q=  p.next;
        	int count=1;
            while (null!=q && q.val == p.val) {
            	p = q;
        	    q = q.next;
        	    count++;
            }
            if (count>1) {
            	r.next = q;
            }
            else
                r = p;
            p = q;
        }
        
        return dummy.next;
   }
}
