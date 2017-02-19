package lint;

import common.datastructure.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/**
 * Created by xuanlin on 17/2/18.
 */
public class MergeKSortedList {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }

        int size = lists.size();
        PriorityQueue<ListNode> heap = new PriorityQueue<>(size,
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        if (o1 == null) {
                            return 1;
                        } else if (o2 == null) {
                            return -1;
                        }
                        return o1.val - o2.val;
                    }
                });

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = head;
            if (head.next != null) {
                heap.add(head.next);
            }
        }
        return dummy.next;


    }
}


/*
Merge k sorted linked lists and return it as one sorted list.

Analyze and describe its complexity.

Example
Given lists:

[
  2->4->null,
  null,
  -1->null
],
return -1->2->4->null.
 */