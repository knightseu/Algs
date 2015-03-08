package lc.solutions;

import common.datastructure.ListNode;

public class LinkListRotate {
	/*
	 * 1.Since n may be a large number compared to the length of list. So we need to know the length of linked list.
	 * After that, move the list after the (l-n%l )th node to the front to finish the rotation.
	 * 
	 * 2.dummy node
	 */
    public ListNode rotateRight(ListNode head, int n) {
    	if (null == head ||  null == head) return head;
    	if (n<=0) return head;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
        ListNode p= dummy, q = dummy;
        int k=0;
        while (q.next!=null) { 
        	k++;
        	q=q.next;
        }
        
        for (int i=k-n%k; i>0;i--)
        	p=p.next;
        q.next = dummy.next;
        dummy.next = p.next;
        p.next = null;
        return dummy.next;
    }
}
