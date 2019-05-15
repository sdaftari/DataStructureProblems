// Preorder Example
//Consider the following binary search tree: 
//
//     5
//    / \
//   2   6
//  / \
// 1   3
//Example 1:
//Input: [5,2,6,1,3]
//Output: false
//Example 2:
//Input: [5,2,1,3,6]
//Output: true
// O(N) and O(N)
// Inorder Example
// int arr[] = {19, 23, 25, 30, 45}; Output: Yes

package Medium;
import java.util.*;

public class VerifyOrder {

	public boolean verifyPreorder(int[] preorder) 
	{
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack<>();
        for (int p : preorder)
        {
            // The highest number should come last, 
            // so if we encounter highest number and the smaller number comes after, return false
            if (p < low)
                return false;
            
            // If current element is greater than stack top, we are tracing right side elements
            // So pop stack elements and replace low
            while (!path.isEmpty() && p > path.peek())
                low = path.pop();
            // Add all smaller elements from left to stack
            path.push(p);
        }
        
        return true;
    }
	
	// Function that returns true if array is Inorder  
	// traversal of any Binary Search Tree or not.  
    static boolean verifyInorder(int[] arr, int n) 
    { 
        // Array has one or no element  
        if (n == 0 || n == 1) 
            return true; 
  
        // Unsorted pair found 
        for (int i = 1; i < n; i++)  
        { 
            if (arr[i - 1] > arr[i]) { 
                return false; 
            } 
        } 
  
        // No unsorted pair found  
        return true; 
    } 
	
    //Check if the postorder array is a valid BST
	public static boolean verifyPostorder(int[] nodes, int len){
		return ValidateBSTHelper(nodes, 0, len-1);
	}
	
	//Helper method for checking if the postorder array is a valid BST
	private static boolean ValidateBSTHelper(int[] arr, int start, int end){
		if(end <= start)  //empty tree and a tree has only one node are BST
			return true;
		int root = arr[end]; //current root value
		int i = end-1;
		while(i >= start && arr[i] > root){
			i--;
		}
		int left = i;
		while(i >= start && arr[i] < root){
			i--;
		}
		if(i != start-1) 
			return false;
		//Recursively check left subtree and right subtree
		return ValidateBSTHelper(arr, start, left) && ValidateBSTHelper(arr,left+1,end-1);
	}
	
	public static void main(String[] args) {
		int[] input = {3, 1, 2, 5, 6};
		VerifyOrder obj = new VerifyOrder();
		System.out.println(verifyPostorder(input, input.length));
	}

}
