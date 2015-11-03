package lint.ladder6.required;

import common.datastructure.ListNode;

/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Have you met this question in a real interview? Yes
Example
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null && head.next.next != null) {
        	if (head.next.val == head.next.next.val) {
        		int key = head.next.val;
        		while (head.next != null && head.next.val == key) {
        			head.next = head.next.next;
        		}
        	} else {
        		head = head.next;
        	}
        }
    	
        return dummy.next;
    }
}
