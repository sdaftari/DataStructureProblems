package Medium;

public class CircularDeque {
	int[] queue;
    int len = 0;
    int front, rear = -1;
    int cap;
    
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public CircularDeque(int k) {
        queue =  new int[k];
        cap = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) 
    {
        if(!isFull())
        {
            front = (front-1)%cap;
            if(front < 0)
                front += cap;
            queue[front] = value;
            len++;
            return true;
        }
        return false;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) 
    {
        if(!isFull())
        {
            rear = (rear + 1)%cap;
            queue[rear] = value;
            len++;
            return true;
        }
        return false;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() 
    {
        if(!isEmpty())
        {
            front = (front +1)%cap;
            len--;
            return true;
        }
        return false;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() 
    {
        if(!isEmpty())
        {
            rear = (rear -1) % cap;
            if(rear < 0)
                rear += cap;
            len--;
            return true;
        }
        return false;
    }
    
    /** Get the front item from the deque. */
    public int getFront() 
    {
        if(isEmpty()) 
            return -1;
        return queue[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() 
    {
        if(isEmpty()) 
            return -1;
        if(rear <0) 
            rear += cap;
        return queue[rear];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return len == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return len == cap;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
