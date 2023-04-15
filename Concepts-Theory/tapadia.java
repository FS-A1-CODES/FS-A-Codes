//Note:It doesn't delete prefix without using search.Check main and delete code 
//tapadia sir's version
import java.util.*;

class Trie 
{	
	static final int NUM_CHARS = 26;
	static boolean isDeleted = false;
	// trie node
	static class TrieNode
	{
		TrieNode[] children = new TrieNode[NUM_CHARS];
	
		// isEndOfWord is true if the node represents end of a word
		boolean isEndOfWord;
		
		TrieNode()
		{
			isEndOfWord = false;
			for (int i = 0; i < NUM_CHARS; i++)
				children[i] = null;
		}
	};
	
	static TrieNode root;
	
	// If not present, inserts key into trie
	// If the key is prefix of trie node, just marks leaf node
	static void insert(String key)
	{
		int level;
		int length = key.length();
		int index;
	
		TrieNode currentNode = root;
	
		for (level = 0; level < length; level++)
		{
			index = key.charAt(level) - 'a';
			if (currentNode.children[index] == null)
				currentNode.children[index] = new TrieNode();
	
			currentNode = currentNode.children[index];
		}
	
		// mark last node as leaf
		currentNode.isEndOfWord = true;
	}
	
	// Returns true if key (prefix or complete word) is present in trie, else false
	static boolean search(String key)
	{
		int level;
		int length = key.length();
		int index;
		TrieNode currentNode = root;
	
		for (level = 0; level < length; level++)
		{
			index = key.charAt(level) - 'a';
	
			if (currentNode.children[index] == null)
				return false;
	
			currentNode = currentNode.children[index];
		}
	
		// To check if prefix exists in the Trie
		// return true;

		// To check for complete word
		return (currentNode.isEndOfWord);
	}

	// Returns true if root has no children, else false
    static boolean isEmpty(TrieNode root)
    {
        for (int i = 0; i < NUM_CHARS; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }

	// Recursive function to delete a key from given Trie
    static TrieNode delete(TrieNode root, String key, int depth)
    {
		//System.out.println("key " + key + " depth " + depth + " root.isEndOfWord " + root.isEndOfWord);
        // If tree is empty
        if (root == null)
            return null;
 
        // If last character of key is being processed
        if (depth == key.length()) 
		{ 
			isDeleted = root.isEndOfWord;
            // This node is no more end of word after removal of given key
            if (root.isEndOfWord)
                root.isEndOfWord = false;
 
            // If given is not prefix of any other word
            if (isEmpty(root)) 
			{
                return null;
            } 
            return root;
        }
		
		// If not last character, recur for the child obtained using ASCII value
        int index = key.charAt(depth) - 'a';
		//System.out.println("index " + index + " key.charAt(depth) " + key.charAt(depth));

		if (root.children[index] == null)
				return null;

        root.children[index] = delete(root.children[index], key, depth + 1);
 
        // If root does not have any child (its only child got
        // deleted), and it is not end of another word.
        if (isEmpty(root) && root.isEndOfWord == false)
		{
            return null;
        } 
        return root;
    }

	// To check if current node is leaf node or not
	static boolean isLeafNode(TrieNode root) 
	{
		return root.isEndOfWord == true;
	}
 
	// print Trie
	static void print(TrieNode root, char[] str, int level) 
	{
		// If node is leaf node, it indicates end of string, 
		// so a null character is added and string is printed
		if (isLeafNode(root)) 
		{
			for (int k = level; k < str.length; k++)
				str[k] = 0;
			System.out.println(str);
		}
	 
		int i;
		for (i = 0; i < NUM_CHARS; i++) 
		{
			// if NON NULL child is found add parent key to str and
			// call the print function recursively for child node
			if (root.children[i] != null) 
			{
				str[level] = (char) (i + 'a');
				print(root.children[i], str, level + 1);
			}
		}
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String keys[]=sc.nextLine().split(" ");	
	
		root = new TrieNode();
	
		// Construct trie
		int i;
		for (i = 0; i < keys.length ; i++)
			insert(keys[i]);

		char[] str = new char[50];
	 
		// printing content of Trie
		System.out.println("Content of Trie: ");
		print(root, str, 0);

		while(true)
		{
			System.out.println("Enter a word to search");
			String word = sc.next();
			if(word.equals("-1"))
				break;
			if(search(word) == true)
				System.out.println(word + " is present ");
			else System.out.println(word + " is not present");
		}

		while(root != null)
		{
			System.out.println("Enter a word to delete");
			String word = sc.next();
			if(word.equals("-1"))
				break;

			if(delete(root, word, 0) != null & isDeleted == true)
			{
				System.out.println(word + " is deleted ");
			}
			else
				System.out.println(word + " is not present in Trie to be deleted");

			System.out.println("Content of Trie after deletion: ");
			print(root, str, 0);
		}
	}
}
