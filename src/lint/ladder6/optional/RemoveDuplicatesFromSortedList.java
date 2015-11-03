package lint.ladder6.optional;
/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

Have you met this question in a real interview? Yes
Example
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
import common.datastructure.ListNode;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        if (head == null) {
        	return null;
        }
        
        ListNode node = head;
        while (node.next !=  null) {
        	if (node.val == node.next.val) {
        		node.next = node.next.next;
        	} else {
        		node = node.next;
        	}
        }
    	
        return head;
    }  

}
