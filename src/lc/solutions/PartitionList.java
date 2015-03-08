package lc.solutions;

public class PartitionList {
	 public ListNode partition(ListNode head, int x) {
	        if (head == null) return null;
	        ListNode leftDummy= new ListNode(0);
	        ListNode rightDummy = new ListNode(0);
	        ListNode left=leftDummy,  right = rightDummy;
	        //left,right - keep track of last element in each list
	        while (head!=null) {
	            if (head.val<x) {
	                left.next = head;
	                left = head;
	            }
	            else {
	                right.next = head;
	                right = head;
	            }
	            head = head.next;
	        }
	        //adjust tail when finish
	        right.next = null;
	        left.next = rightDummy.next;
	        return leftDummy.next;
	    }+
}
