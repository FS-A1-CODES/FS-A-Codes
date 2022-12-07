/*
Mr Shravan is given a word W, and W is a palindrome. Mr Shravan is 
allowed to replace only one letter in W, with any lowercase alphabet, 
such that the word W is not a palindrome again and which is the 
lexicographically smallest among all the possible options.

Examples of Lexicographical order are:
	- aaa is smaller than aab
	- abb is smaller than abc.

Return the lexicographically smallest string among all the possible options.

Input Format:
-------------
A String P, palindrome.

Output Format:
--------------
A String result.


Sample Input-1:
---------------
abcdcba

Sample Output-1:
----------------
aacdcba


Sample Input-2:
---------------
aaaa

Sample Output-2:
----------------
aaab


Sample Input-3:
---------------
aaabaaa

Sample Output-3:
----------------
aaabaab

*/

import java.util.*;
class Test{
  public static void main(){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for(int i=0;i<s.length()/2;i++){
			if(s.charAt(i)!='a'){
				s.charAt(i) = 'a';
				System.out.println(s);
				System.exit(0);
			}
		}
		s[s.length()-1] = 'b';
		System.out.println(s);
	}
}
		

