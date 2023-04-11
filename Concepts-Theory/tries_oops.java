//The code is a simplified and strong version of original src code

import java.util.*;

class Node {
    private Node children[];//children for every node
    private boolean EndOfWord;
    private int count; // added count property

    Node() {
        children = new Node[26];
        EndOfWord = false;
        count = 0; // initialize count to zero
        for(int i=0;i<26;i++){
            children[i] = null;
        }
    }
    //to check if child exists
    public boolean containsChild(char ch) {
        return children[ch - 'a'] != null;
    }
    //to get child at index
    public Node get(char ch) {
        return children[ch - 'a'];
    }
    //to set the endword value
    public void setEnd(boolean value) {
        EndOfWord = value;
    }
    //to check if word is ended or not
    public boolean isEndWord() {
        return EndOfWord;
    }
    //to insert child to particular root
    public void put(char ch, Node root) {
        children[ch - 'a'] = root;
    }
    //to increase count value
    public void incrementCount() {
        count++;
    }
    //to decrease count value
    public void decrementCount() {
        count--;
    }
    //to access count at that node
    public int getCount() {
        return count;
    }
}

public class Trie {
    static Node root = new Node();
    
    public static void insert(String word) {
        Node current = root;
        int l = word.length();
        for (int i = 0; i < l; i++) {
            int idx = word.charAt(i) - 'a';
            if (!current.containsChild(word.charAt(i))) {// if no child
                current.put(word.charAt(i), new Node());
            }
            current = current.get(word.charAt(i));
            current.incrementCount(); // increment count at each node
            if (i == l - 1) {
                current.setEnd(true);
            }
        }
    }

    public static boolean search(String word) {
        Node current = root;
        int l = word.length();
        for (int i = 0; i < l; i++) {
            int idx = word.charAt(i) - 'a';
            if (!current.containsChild(word.charAt(i))) {// no child node
                return false;
            }
            //moving towards child
            current = current.get(word.charAt(i));
        }
        return current.isEndWord();
    }
    //delete with search property
    public static void delete(String word) {
        if (!search(word)) {
            return;
        }
        Node current = root;
        int l = word.length();
        for (int i = 0; i < l; i++) {
            Node child = current.get(word.charAt(i));
            child.decrementCount(); // decrement count at each node
            if (child.getCount() == 0) { // delete node if count becomes zero
                current.put(word.charAt(i), null);
                return;
            }
            current = child;
        }
        current.setEnd(false);
    }
    public static void printWords(Node root, String prefix) {
        if (root == null) {
            return;
        }
        if (root.isEndWord()) {
            System.out.println(prefix);
        }
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            Node child = root.get(ch);
            if (child != null) {
                printWords(child, prefix + ch);
            }
        }
    }
    public static String ans = "";
    //to check longest word with common prefix
    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            Node child = root.get(ch);
            //checking only if the prefix exists as a word in the trie
            if (child != null && child.isEndWord()) {
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(child, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Trie root = new Trie();
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            insert(input[i]);
        }
        StringBuilder temp = new StringBuilder("");
        longestWord(root, temp);
        System.out.println(ans);
        //printWords(root,"");
    }
}
