package lc.solutions;

public class ListAddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;
        ListNode rst = new ListNode(0);
        ListNode last = rst;
        int carryover = 0;
        while ((l1!=null) && (l2!=null) )
        {
            int sum = l1.val+l2.val+carryover;
            last.next =  new ListNode(sum % 10);
            carryover = sum / 10;
            l1=l1.next;
            l2=l2.next;
            last=last.next;
        }
        
        while (l1 != null) {
            int sum = l1.val+carryover;
            last.next =  new ListNode(sum % 10);
            carryover = sum / 10;
            l1=l1.next;
            last=last.next;
        }
        
        while (l2 != null) {
            int sum = l2.val+carryover;
            last.next =  new ListNode(sum % 10);
            carryover = sum / 10;
            l2=l2.next;
            last=last.next;
        }
        
        if (carryover != 0) last.next = new ListNode(carryover);
        
        return rst.next;
    }
}
