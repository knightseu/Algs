package lint.ladder6.required;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import common.datastructure.ListNode;

public class MergeKSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
        	return null;
        }
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        
        for (int i= 0; i< lists.size(); i++) {
        	if (lists.get(i) != null) {
        	    heap.offer(lists.get(i));
        	}
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()){
        	ListNode head = heap.poll();
        	tail.next = head;
        	tail = head;
        	if (head.next != null) {
        		heap.offer(head.next);
        	}
        }
        return dummy.next;
    }
    
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
    	public int compare(ListNode list1, ListNode list2) {
    		if (list1 == null) {
    			return 1;
    		} else if (list2  == null) {
    			return -1;
    		}
    		return list1.val - list2.val;
    	}
    };

}
