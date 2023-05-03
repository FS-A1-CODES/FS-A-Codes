/*
Mr. Nivas is designing a new dictionary which searches the words in it by a prefix and a sufix
when we supply a list of words and a prefix and suffix characters it will return the index of the word in the dictionary
which has the prefix and the suffix matches with search key prefix and suffix. If there is more tan one valid index, return the largest of them. If there is no such word  then return -1

Input : number of words n
sequence of n words
prefix character
suffix character
output : index of the word matching with prefix and suffix
Example 1:
input :8
mon tue wed thu fri sat sun mon
m 
n
output : 7
explanation : prefix is 'm' and suffix is 'n'
there are two matches at index 0 and index 7, as per constraint it is returning highest index value i.e 7
example 2 :
input :6
jan feb mar apr may june
j
y
output : -1

*/
import java.util.*;
class TrieNode {
    public Map<Character, TrieNode> children;
    public Set<String> words;
    public TrieNode() {
        children = new HashMap<>();
        words = new HashSet<>();
    }
}
class WordFilter {
    private TrieNode rootP, rootS; 
    private Map<String, Integer> indexes; 
    
    public WordFilter(String[] words) {
        rootP = new TrieNode();
        rootS = new TrieNode();
        indexes = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            insert(words[i]);
            indexes.put(words[i], i);
        }
    }
    
    private void insert(String word) {
        TrieNode ptrP = rootP, ptrS = rootS;
       //forward inserting
       for(int i=0;i<word.length();i++){
           char c =  word.charAt(i);
           ptrP.children.putIfAbsent(c,new TrieNode());
           ptrP = ptrP.children.get(c);
           ptrP.words.add(word);
       }
       for(int i=word.length()-1;i>=0;i--){
           char c = word.charAt(i);
           ptrS.children.putIfAbsent(c,new TrieNode());
           ptrS = ptrS.children.get(c);
           ptrS.words.add(word);
       }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode ptrP = rootP, ptrS = rootS;
        for (char ch : prefix.toCharArray()) {
            if (!ptrP.children.containsKey(ch)) {
                return -1;
            }
            ptrP = ptrP.children.get(ch);
        }
        for (int i=suffix.length()-1; i>=0; i--) {
            char ch = suffix.charAt(i);
            if (!ptrS.children.containsKey(ch)) {
                return -1;
            }
            ptrS = ptrS.children.get(ch);
        }
        int result = -1;
        for (String word : ptrP.words) {
            if (ptrS.words.contains(word)) {
                int index = indexes.get(word);
                if (index > result) {
                    result = index;
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int n = scanner.nextInt();
        String[] words = new String[n];
        
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }
        
        
        WordFilter filter = new WordFilter(words);
        
        
        
        String prefix = scanner.next();
        
        String suffix = scanner.next();
        int index = filter.f(prefix, suffix);
		System.out.println(index);
        
    }


}
