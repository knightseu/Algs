package lint.ladder6.required;

import common.datastructure.ListNode;

/*
 * Reverse a linked list from position m to n.

Have you met this question in a real interview? Yes
Example
Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.

Note
Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.

Challenge
Reverse it in-place and in one-pass
 */
public class ReverseLinkListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (m >= n || head == null) {
        	return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode premNode = dummy;
        
        for (int i = 1; i < m; i++) {
        	if (premNode == null) {
        		return null;
        	}
        	premNode = premNode.next;
        }
        
        ListNode mNode = premNode.next;
        ListNode nNode = mNode, postnNode = mNode.next;
        for (int i = m; i < n; i++) {
        	if (postnNode == null) {
        		return null;
        	}
        	ListNode temp = postnNode.next;
        	postnNode.next = nNode;
        	nNode = postnNode;
        	postnNode = temp;
        }
        
        mNode.next = postnNode;
        premNode.next = nNode;
        
        return dummy.next;
    }

}
