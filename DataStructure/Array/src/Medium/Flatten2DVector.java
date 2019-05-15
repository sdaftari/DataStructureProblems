//Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and hasNext.
//Example:
//Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
//iterator.next(); // return 1
//iterator.next(); // return 2
//iterator.next(); // return 3
//iterator.hasNext(); // return true
//iterator.hasNext(); // return true
//iterator.next(); // return 4
//iterator.hasNext(); // return false

package Medium;
import java.util.*;

public class Flatten2DVector {
	
	int indexList, indexEle;
    List<List<Integer>> vec; 
    
    public Flatten2DVector(List<List<Integer>> vec2d) {
        indexList = 0;
        indexEle = 0;
        vec = vec2d;
    }

    public int next() {
        return vec.get(indexList).get(indexEle++);
    }

    public boolean hasNext() {
        while(indexList < vec.size()){
            if(indexEle < vec.get(indexList).size())
                return true;
            else{
                indexList++;
                indexEle = 0;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
