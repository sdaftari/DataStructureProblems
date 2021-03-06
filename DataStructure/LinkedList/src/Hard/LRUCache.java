//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
/*
 * The problem can be solved with a hashtable that keeps track of the keys and its values in the double linked list. 
 * One interesting property about double linked list is that the node can remove itself without other reference. 
 * In addition, it takes constant time to add and remove nodes from the head or tail.
 * Particularly about the double linked list that I implemented is that I create a pseudo head and tail to mark the boundary, so that we don't need to check the NULL node during the update. 
 * This makes the code more concise and clean, and also it is good for the performance as well.
 */

package Hard;
import java.util.*;
public class LRUCache {
	
	private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
	private int count;
	private int capacity;
	private DLinkedNode head, tail;
	
	public LRUCache(int capacity)
	{
		this.count = 0;
		this.capacity = capacity;
		head = new DLinkedNode();
		head.pre = null;
		tail = new DLinkedNode();
		tail.post = null;
		head.post = tail;
		tail.pre = head;
	}
	
	public int get(int key)
	{
		DLinkedNode node = cache.get(key);
		if(node == null)
			return -1; // should raise exception here.
		
		// move the accessed node to the head;
		this.moveToHead(node);
		
		return node.value;
	}
	
	public void set(int key, int value)
	{
		DLinkedNode node = cache.get(key);
		
		if (node == null)
		{
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;
			
			this.cache.put(key, newNode);
			this.addNode(newNode);
			
			++count;
			
			if(count > capacity)
			{
				// pop the tail
				DLinkedNode tail = this.popTail();
				this.cache.remove(tail.key);
				--count;
			}
		}
		else
		{
			// update the value.
			node.value = value;
			this.moveToHead(node);
		}
	}
	
	// Always add new node right after head
	private void addNode(DLinkedNode node)
	{
		node.pre = head;
		node.post = head.post;
	}

	//Remove an existing node from the linked list.
	private void removeNode(DLinkedNode node){
		DLinkedNode pre = node.pre;
		DLinkedNode post = node.post;
		
		pre.post = post;
		post.pre = pre;
	}
	
	private void moveToHead(DLinkedNode node){
		this.removeNode(node);
		this.addNode(node);
	}
	
	private DLinkedNode popTail(){
		DLinkedNode res = tail.pre;
		this.removeNode(res);
		return res;
	}

}

class DLinkedNode {
	int key;
	int value;
	DLinkedNode pre;
	DLinkedNode post;
}
