package lc.solutions;

import common.datastructure.ListNode;

public class ListMergeTwoSorted {
	
	//keep l1, l2 as they are
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if (null ==l1) return l2;
	        if (null ==l2) return l1;
	        ListNode head=null, last = null;
	        while ((l1 !=null) && (l2!=null) ) {
	            if (l1.val>l2.val) {
	              ListNode tmp = new ListNode(l2.val);
	              if (head ==null) {
	                  head = tmp;
	                  last = head;
	              }
	              else {
	                  last.next = tmp;
	                  last = last.next;
	              }
	              l2=l2.next;
	            }
	            else {
	              ListNode tmp = new ListNode(l1.val);
	              if (head ==null) {
	                  head = tmp;
	                  last = head;
	              }
	              else {
	                  last.next = tmp;
	                  last = last.next;
	              }
	              l1=l1.next;
	            }
	        }
	        if (l1==null) {
	            while (l2 !=null) {
	                ListNode tmp = new ListNode(l2.val);
	              if (head ==null) {
	                  head = tmp;
	                  last = head;
	              }
	              else {
	                  last.next = tmp;
	                  last = last.next;
	              }
	              l2=l2.next;
	            }
	        }
	        else {
	            while (l1!=null) {
	              ListNode tmp = new ListNode(l1.val);
	              if (head ==null) {
	                  head = tmp;
	                  last = head;
	              }
	              else {
	                  last.next = tmp;
	                  last = last.next;
	              }
	              l1=l1.next;
	            }
	        }
	    return head;
	}
	 //we can break l1 and l2
	 public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
	     ListNode dummy = new ListNode(0);
	     ListNode lastnode = dummy;
	     while ((l1!=null) && (l2!=null)) {
	    	 if (l1.val<l2.val) {
	    		 lastnode.next=l1;
	    		 l1 = l1.next;
	    	 }
	    	 else {
	    		 lastnode.next = l2;
	    		 l2 = l2.next;
	    	 }
    		 lastnode = lastnode.next;
	     }
	     if (l1==null)
	    	 lastnode.next = l2;
	     else
	    	 lastnode.next = l1;
	     
	     return dummy.next;
	 }
}
