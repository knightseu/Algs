package lc.solutions;

import common.datastructure.ListNode;

/*
 *  Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. 
 */
public class ListReverse {
	 public ListNode reverseBetween(ListNode head, int m, int n) {
	     ListNode first = head, second = head;
	     while (m>1) {
	    	 first = first.next;
	    	 second = second.next;
	    	 m--;
	    	 n--;
	     }
	     while (n>1) {
	    	 second = second.next;
	    	 n--;
	     }
	     int tmp = first.val;
	     first.val = second.val;
	     second.val = tmp;
	     return head;
	 }
}
