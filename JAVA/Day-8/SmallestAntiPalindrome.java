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
class Solution{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());
        System.out.println(antiPal(sb));
    }
    public static String antiPal(StringBuilder sb)
    {
        int n = sb.length();
        for(int i=0;i<n/2;i++)
        {
            if(sb.charAt(i)!='a')
            {
                sb.replace(i,i+1,""+'a');
                return sb.toString();
            }
        }
        sb.replace(n-1,n,""+'b');
        return sb.toString();
    }
}
