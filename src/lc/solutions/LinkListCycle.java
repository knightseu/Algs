package lc.solutions;

import common.datastructure.ListNode;

public class LinkListCycle {
    public boolean hasCycle(ListNode head) {
        if ((null==head) || (head.next == null)) return false;
        ListNode slow=head, fast=head.next;
        while (slow != fast) {
        	if ((fast.next ==null) || (fast.next.next==null)) return false;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        return true;
    }
    
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head, fast=head;
        while ((fast !=null) && (fast.next!=null)) {
        	fast = fast.next.next;
        	slow = slow.next;
        	if (fast == slow) break;
        }
        if (fast ==null || fast.next == null) return null;
        fast = head;
        while (slow != fast) {
        	slow=slow.next;
        	fast=fast.next;
        }
        return slow;
    }
}
