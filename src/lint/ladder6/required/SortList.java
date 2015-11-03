package lint.ladder6.required;

import common.datastructure.ListNode;

/*
 * Sort a linked list in O(n log n) time using constant space complexity.

Have you met this question in a real interview? Yes
Example
Given 1-3->2->null, sort it to 1->2->3->null.
 */
public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode mid = findMedian(head);
    	ListNode right = sortList(mid.next);
    	mid.next = null;
    	ListNode left = sortList(head);
    	
    	return merge(left, right);
    }
    
    private ListNode findMedian(ListNode head) {
    	if (head == null) {
    		return null;
    	}
    	ListNode slow = head, fast = head.next;
    	while (fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	return slow;
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 !=null && head2 != null) {
        	if (head1.val < head2.val) {
        		tail.next = head1;
        		head1 = head1.next;
        	} else {
        		tail.next = head2;
        		head2 = head2.next;
        	}
        	tail = tail.next;
        }
        if (head1 != null) {
        	tail.next = head1;
        } else {
        	tail.next = head2;
        }
        
        return dummy.next;
    }

}
