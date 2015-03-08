package lc.solutions;

import java.util.HashMap;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

[Thoughts]

首先，对于cache，如果希望有O(1)的查找复杂度，肯定要用hashmap来保存key和对象的映射。对于LRU而言，问题在于如何用O(1)解决cache entry的替换问题。

简单的说，cache的存储是一个链表的话，那么只要保证从头到尾的顺序就是cache从新到旧的顺序就好了，对于任何一个节点，如果被访问了，那么就将该节点移至头部。如果cache已满，那么就把尾部的删掉，从头部插入新节点。

所以，需要用到两个数据结构

1. hashmap， 保存key和对象位置的映射

2. list，保存对象新旧程度的序列。不一定是list，也可以用vector，不过list的好处是已经实现了头尾操作的api，vector的话，还要自己写，麻烦。 
 */
public class LC146_LRUCache {
	  private class Node{
	        Node prev;
	        Node next;
	        int key;
	        int value;

	        public Node(int key, int value) {
	            this.key = key;
	            this.value = value;
	            this.prev = null;
	            this.next = null;
	        }
	    }

	    private int capacity;
	    private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
	    private Node head = new Node(-1, -1);
	    private Node tail = new Node(-1, -1);

	    public void LRUCache(int capacity) {
	        this.capacity = capacity;
	        tail.prev = head;
	        head.next = tail;
	    }

	    public int get(int key) {
	        if( !hs.containsKey(key)) {
	            return -1;
	        }

	        // remove current
	        Node current = hs.get(key);
	        current.prev.next = current.next;
	        current.next.prev = current.prev;

	        // move current to tail
	        move_to_tail(current);

	        return hs.get(key).value;
	    }

	    public void set(int key, int value) {
	        if( get(key) != -1) {
	            hs.get(key).value = value;
	            return;
	        }

	        if (hs.size() == capacity) {
	            hs.remove(head.next.key);
	            head.next = head.next.next;
	            head.next.prev = head;
	        }

	        Node insert = new Node(key, value);
	        hs.put(key, insert);
	        move_to_tail(insert);
	    }

	    private void move_to_tail(Node current) {
	        current.prev = tail.prev;
	        tail.prev = current;
	        current.prev.next = current;
	        current.next = tail;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
