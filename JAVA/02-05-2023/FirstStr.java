/*Mr.chary is playing with strings, he has one main string and one substring he has to find the first occurance of given substring in the main string. Help him by writing a java program using trie datastructure.
input : mainstring and substring
output : index if substring is found and -1 if substring is not found

example 1:
input = keshavmemorialinstitueoftechnology
mem
output =6
explanation "mem" starts at index 6
example 2:
input = keshavmemorialjuniorcollege
col
output = 20
*/

import java.util.*;

 class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        String haystack = scanner.nextLine();
        
        
        String needle = scanner.nextLine();
        
        int index = strStr(haystack, needle);
		System.out.println(index);
        
    }
    
    public static int strStr(String haystack, String needle) {
        
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;
        
        Trie trie = new Trie();
        for(int i=0; i<haystack.length(); i++){
            trie.insert(haystack.substring(i), i);
        }
        return trie.search(needle);
    }
    
    static class Trie {
    
        Map<Character, Trie> map;
        List<Integer> indexes;
        
        Trie() {
            map = new HashMap<>();
            indexes = new ArrayList<>();
        }
        
        void insert(String text, int ind) {
            Trie trie = this;
            //write ur code here
            for(char c:text.toCharArray()){
                if(!trie.map.containsKey(c)){
                    trie.map.put(c,new Trie());
                }
                //trie = trie.map.get(c);
                trie = trie.map.get(c);
                trie.indexes.add(ind);
            }
        }
        
        int search(String text) {
            Trie trie = this;
            //write ur code here
            for(char c:text.toCharArray()){
                if(!trie.map.containsKey(c)){
                    return -1;
                }
                trie = trie.map.get(c);
            }
            return trie.indexes.get(0);
        } 
    }
}
