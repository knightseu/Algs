/**
 * 
 */
package lc.solutions;

import common.datastructure.ListNode;

/**
 * @author xuanlin
 *
 */
public class LC025_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
    	
    	if(k == 0 || k == 1) return head;
    	
    	ListNode cur=head;
    	int count = 0;
    	while (null != cur) {
    		count++;
    		cur = cur.next;
    	}
    	int loopN = count/k;
    	if (0==loopN) return head;
    	
    	cur = head;
    	for (int j=0; j < loopN; j++) {
    		for (int i=0; i<k; i++) {
    			
    		}
    	}
        return head;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
