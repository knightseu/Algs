package lint.ladder6.required;

import common.datastructure.ListNode;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = head;
        for (int i = 0; i < n; i++) {
        	if (tail == null) {
        		return null;
        	}
        	tail = tail.next;
        }
        ListNode preNode = dummy;
        while (tail != null) {
        	tail =  tail.next;
        	preNode = preNode.next;
        }	
        preNode.next = preNode.next.next;
        return dummy.next;
    }

}
