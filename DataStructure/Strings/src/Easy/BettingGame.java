//You are involved in a betting game whose rules are as follows :
//a) If you win a round, the bet amount will be added to your current sum and next bet amount will become $1;
//b) If you lose a round, the bet amount will be reduced from your current sum and next bet will become twice the previous.
//c) game ends either when all the rounds are complete or when you don't have sufficient sum.
//Initially, you are given with a string consisiting of characters from the set {'W', 'L'}, where 'W' indicates a win and 'L' indicates a loss, and initial sum is 4. Initial bet amount for the 1st round will be $1.
//
//You need to find and print the amount at the end of the game (final sum) and in case you do not have enough money in between the game to play the next round, then print -1.
//
//Example:
//
//Input:
//2
//WL
//WLWLLLWWLW
//
//Output:
//4
//-1

package Easy;

public class BettingGame {

	static Integer finalAmt; 
	Integer initaialAmt; 
	Integer betAmt; 
	String betResultSequence; 

	public Integer calculatFinalAmount1(Integer initialAmt, String betResultSequence)
	{ 
		finalAmt = initialAmt; 
		betAmt=1; 
	
		for(int i=0; i < betResultSequence.length(); i++)
		{ 
			if((betResultSequence.charAt(i)) == 'L')
			{ 
				finalAmt -= betAmt; 
				betAmt *=2; 
			}
			else{ 
				finalAmt += betAmt; 
				betAmt =1; 
			} 
		} 

		return finalAmt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
