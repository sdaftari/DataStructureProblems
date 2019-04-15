//Given an array of n words. Some words are repeated twice, we need count such words.	

package Easy;
import java.util.*;

public class TwiceCounter {
	static int countWords(String str[], int n) 
    { 
        // map to store count of each word 
        HashMap<String, Integer> m = new HashMap<>(); 
          
        for (int i = 0; i < n; i++){ 
            if(m.containsKey(str[i])){ 
                int get = m.get(str[i]); 
                m.put(str[i], get + 1); 
            } 
            else{ 
                m.put(str[i], 1); 
            } 
        } 
              
        int res = 0; 
        for (Map.Entry<String, Integer> it: m.entrySet()){ 
            if(it.getValue() == 2) 
                res++; 
        } 
                  
        return res; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
