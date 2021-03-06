package Medium;

public class MinHeap {

	int capacity;
	int heapSize;
	int[] heapList;
	
	public MinHeap(int cap)
	{
		capacity = cap;
		heapSize = 0;
		heapList = new int[cap];
	}
	
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(11);
		minHeap.add(3);
		minHeap.add(2);
		minHeap.deleteKey(1);
		minHeap.add(15);
		minHeap.add(5);
		minHeap.add(4);
		minHeap.add(45);
		
		System.out.println(minHeap.extractMin());
		
		System.out.println(minHeap.getMin());
		
		minHeap.decreaseKey(2, 1);
		
		System.out.println(minHeap.getMin());
	}	
	
	public int getMin()
	{
		return heapList[0];
	}
	
	public void add(int k)
	{
		if (heapSize == capacity)
	    {
	        System.out.println("\nOverflow: Could not insertKey\n");
	        return;
	    }
	 
	    // First insert the new key at the end
		heapSize++;
	    int i = heapSize - 1;
	    heapList[i] = k;
	 
	    // Fix the min heap property if it is violated
	    while (i != 0 && heapList[parent(i)] > heapList[i])
	    {
	       swap(heapList, i, parent(i));
	       i = parent(i);
	    }
	}
	
	private void decreaseKey(int i, int new_val)
	{
		heapList[i] = new_val;
	    while (i != 0 && heapList[parent(i)] > heapList[i])
	    {
	       swap(heapList, i, parent(i));
	       i = parent(i);
	    }
	}
	
	public int extractMin()
	{
	    if (heapSize <= 0)
	        return Integer.MAX_VALUE;
	    
	    if (heapSize == 1)
	    {
	    	heapSize--;
	        return heapList[0];
	    }
	 
	    // Store the minimum value, and remove it from heap
	    int root = heapList[0];
	    heapList[0] = heapList[heapSize-1];
	    heapSize--;
	    minHeapify(0);
	 
	    return root;
	}
	
	private void minHeapify(int i)
	{
	    int l = leftIndex(i);
	    int r = rightIndex(i);
	    int smallest = i;
	    if (l < heapSize && heapList[l] < heapList[i])
	        smallest = l;
	    if (r < heapSize && heapList[r] < heapList[smallest])
	        smallest = r;
	    if (smallest != i)
	    {
	        swap(heapList, i, smallest);
	        minHeapify(smallest);
	    }
	}
	
	private void deleteKey(int i)
	{
	    decreaseKey(i, Integer.MIN_VALUE);
	    extractMin();
	}
	
	public boolean isEmpty() {
        return heapSize == 0;
    }
	
	protected boolean hasParent(int i) {
        return i > 1;
    }
        
    protected int leftIndex(int i) {
        return i * 2;
    }    
    
    protected int rightIndex(int i) {
        return i * 2 + 1;
    }   
    
    protected int parent(int i) {
        return i / 2;
    }
	
	protected void swap(int[] heapList, int index1, int index2) {
        int tmp = heapList[index1];
        heapList[index1] = heapList[index2];
        heapList[index2] = tmp;        
    }
	
}
