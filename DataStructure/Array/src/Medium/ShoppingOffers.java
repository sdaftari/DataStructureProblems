//Example 1:
//Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
//Output: 14
//Explanation: 
//There are two kinds of items, A and B. Their prices are $2 and $5 respectively. 
//In special offer 1, you can pay $5 for 3A and 0B
//In special offer 2, you can pay $10 for 1A and 2B. 
//You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.

package Medium;
import java.util.*;

public class ShoppingOffers {
	
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return backTrace(price, special, needs, 0);
    }
    
    private int backTrace(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int start)
    {
        int res = directPurchase(price, needs);
        for (int i = start; i < special.size(); i++)
        {
            List<Integer> offer = special.get(i);
            if (isValid(offer, needs))
            {
                List<Integer> tempNeeds = new ArrayList<Integer>();
                for (int j = 0; j < needs.size(); j++)
                {
                    tempNeeds.add(needs.get(j) - offer.get(j));
                }
                
                // offer.get(offer.size()-1) gets the price for that offer + try next offers
                res = Math.min(res, offer.get(offer.size()-1) + backTrace(price, special, tempNeeds, start));
            }
        }
        
        return res;
    }
    
    private boolean isValid(List<Integer> offer, List<Integer> needs) 
    {
      for (int i = 0; i < needs.size(); i++) 
      {
          if (needs.get(i) < offer.get(i)) 
              return false;
      }
      return true;
    }

    
    private int directPurchase(List<Integer> price, List<Integer> needs) 
    {
      int total = 0;
      for (int i = 0; i < needs.size(); i++) {
        total += price.get(i) * needs.get(i);
      }
      return total;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
