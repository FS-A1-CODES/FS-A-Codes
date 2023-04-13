//tries code 
/*
Imagine that you are playing  word game, the conept of game is,you will be given  list of different words and  Provided with a search word, you should determine if you can change exactly one character in this search word to match any word in the given list of words.
      "note use trie datastructure only."
input :
       line one is an integer(say n) which gives number of words to read
	   next n lines list of words in lowercase only
	   next line a word to search
output :
         true or false
sample cases
example 1:
input :5
hello
kmit
ngit
kmec
aiml
kmIt
output : true
Explanation : we can change the I in kmIt to i to match kmit of input word so result is true
example 2:
input = 6
bill
ball
board
bat
boat
bracnh
ball
output = true
Explanation : we have exact match for ball search key in the given strings but by changing one character that is a in ball we can make it as bill hence result is true
Example 3:
input=5
ball
board
bat
boat
branch
ball
output =false
Explanation : search keyword ball can't form any word in the given words with one character change hence result is false.
*/

import java.util.Scanner;
class TrieNode {
    boolean isWord;
    TrieNode[] children;
    TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}

class MagicDictionary {
    
    TrieNode root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    private void insert(String word){
        int len = word.length();
        TrieNode current = root;
        for(int i=0;i<len;i++){
            int idx = word.charAt(i)-'a';
            if(current.children[idx]==null){
                current.children[idx] = new TrieNode();
            }
            current = current.children[idx];
            if(i==len-1){
                current.isWord = true;
            }
        }
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        //write ur code here
        for(int i=0;i<dict.length;i++){
            insert(dict[i]);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        // write ur code here
        int n = word.length();
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            //move to every character
            for(char j='a';j<='z';j++){
                if(j==ch){
                    continue;
                }
                StringBuilder sb = new StringBuilder(word);
                //if capital letter set it to small
                sb.setCharAt(i,j);
                if(findWord(sb.toString(),root)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean findWord(String word, TrieNode node) {
        // write ur code here
        int n = word.length();
        TrieNode current = node;
        for(int i=0;i<n;i++){
            int idx = word.charAt(i)-'a';
            //if word not found return false
            if(current.children[idx]==null){
                return false;
            }
            current = current.children[idx];
        }
        return current.isWord;
    }
	
    public static void main(String[] args) {
        MagicDictionary obj = new MagicDictionary();
        Scanner scanner = new Scanner(System.in);

        
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] dict = new String[n];
        for (int i = 0; i < n; i++) {
            dict[i] = scanner.nextLine();
        }
        obj.buildDict(dict);

        String word = scanner.nextLine();
        boolean result = obj.search(word);
        System.out.println(result);

        scanner.close();
    
}

}
