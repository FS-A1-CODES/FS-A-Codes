/* Vikas and jayadeep are playing with strings and they try to list the matching words for a given searchword 
with in list of strings, can you develop a program using trie to help them.
You are given an array of strings products seperated by ',' and a string searchWord.
Design a system that suggests at most three product names from products after each character of searchWord is 
typed. Suggested products should have common prefix with searchWord. 
If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.
input : line 1 : words seperated by ','
        line 2 : searchword 
output : list of lists of suggested products.
sample cases
case 1:
input :
mobile,mouse,moneypot,moniter,mousepad
mouse
output : [[mobile, moneypot, moniter], [mobile, moneypot, moniter], [mouse, mousepad], [mouse, mousepad], [mouse, mousepad]]

Explanation :output contains 5 lists as key word length is 5
list 1 contains the three lexicographically minimum products matching with m
list 2 contains the three lexicographically minimum products matching with mo
list 3 contains the three lexicographically minimum products matching with mou
list 4 contains the three lexicographically minimum products matching with mous
list 5 contains the three lexicographically minimum products matching with mouse
case 2 :
input :
mango,mobile,mouse,moneypot,moniter,mouse,maximum,marvel
mouse
output:
[[mango, marvel, maximum], [mobile, moneypot, moniter], [mouse], [mouse], [mouse]]
Explanation : output list contains 5 lists as keyword length is 5
list 1 contains the three lexicographically minimum products matching with m
list 2 contains the three lexicographically minimum products matching with mo
list 3 contains only one word which matches with mou
list 4 contains only one word which matches with mous
list 5 contains only one word which matches with mouse



input :
bag,bags,baggage,banner,baseball,box,bill,brown,ball,baby
bag
output :[[baby, bag, baggage], [baby, bag, baggage], [bag, baggage, bags]]


*/

import java.util.*;
class TrieNode {
    char c;
    boolean isWord;
    TrieNode[] children;
    
    public TrieNode(char c) {
        this.c = c;
        this.isWord = false;
        this.children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        this.root = new TrieNode(' ');
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    public List<String> search(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return result;
            }
            node = node.children[c - 'a'];
        }
        dfs(node, prefix, result);
        return result;
    }
    
    private void dfs(TrieNode node, String prefix, List<String> result) {
        if (node.isWord) {
            result.add(prefix);
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                dfs(node.children[i], prefix + node.children[i].c, result);
            }
        }
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String target) {
        Trie trie = new Trie();
        for(String product : products)
        {
            trie.insert(product);
        }
        List<List<String>> res = new ArrayList<>();
        String search = "";
        for(char ch : target.toCharArray())
        {
            search+=ch;
            List<String> temp = trie.search(search);
            if(temp.size()>3)
            {
                temp=temp.subList(0,3);
            }
            res.add(temp);
        }
        return res;
    }

	public static void main(String[] args)
	{
      Scanner sc=new Scanner(System.in);
	  String line1=sc.nextLine();
	  String key=sc.nextLine();
	  String[] words=line1.split(",");
	  System.out.println(new Solution().suggestedProducts(words,key));
    }
}
