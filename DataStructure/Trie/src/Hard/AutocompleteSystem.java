//Example:
//Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2]) 
//The system have already tracked down the following sentences and their corresponding times: 
//"i love you" : 5 times 
//"island" : 3 times 
//"ironman" : 2 times 
//"i love leetcode" : 2 times 
//Now, the user begins another search: 
//
//Operation: input('i') 
//Output: ["i love you", "island","i love leetcode"] 
//Explanation: 
//There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front 
//of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored. 


package Hard;
import java.util.*;

public class AutocompleteSystem {
	
	class TrieNode 
	{
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;
        public TrieNode() 
        {
            children = new HashMap<Character, TrieNode>();
            counts = new HashMap<String, Integer>();
            isWord = false;
        }
    }
    
    class Pair 
    {
        String s;
        int c;
        public Pair(String s, int c) {
            this.s = s; this.c = c;
        }
    }
    
    TrieNode root;
    String prefix;
    
    public AutocompleteSystem(String[] sentences, int[] times) 
    {
        root = new TrieNode();
        prefix = "";
        
        for (int i = 0; i < sentences.length; i++) 
            add(sentences[i], times[i]);
    }
    
    private void add(String s, int count) 
    {
        TrieNode curr = root;
        for (char c : s.toCharArray()) 
        {
            TrieNode next = curr.children.get(c);
            if (next == null) 
            {
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
            curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
        }
        curr.isWord = true;
    }
    
    public List<String> input(char c) 
    {
        if (c == '#') 
        {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }
        
        prefix = prefix + c;
        TrieNode curr = root;
        for (char cc : prefix.toCharArray()) 
        {
            TrieNode next = curr.children.get(cc);
            if (next == null) 
                return new ArrayList<String>();
            // Once the complete prefix string is parsed, curr will point to last node
            curr = next;
        }
        
        // If both strings have same count, compare ASCII values and return in ascending order
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
        // Here, curr points to last node of prefix, which contains counts, which has {sentence, time} list for all sentences
        // Add all the Pairs of sentence and their count to the priority queue
        for (String sentence : curr.counts.keySet()) 
            pq.add(new Pair(sentence, curr.counts.get(sentence)));

        List<String> res = new ArrayList<String>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) 
            res.add(pq.poll().s);
        
        return res;
    }

	public static void main(String[] args) {
		String[] sentences = {"i love you", "island","ironman", "i love leetcode"};
		int[] times = {5,3,2,2};
		AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
	}

}
