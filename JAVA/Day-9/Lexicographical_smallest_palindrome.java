/*
Mr Shravan is given a word W, and W cosists of lowercase alphabets and '#'. 
Mr Shravan is allowed to replace the '#' with any one lowercase alphabet, 
such that the word W is a palindrome and it has to be the lexicographically
smallest among all the possible options.

Your task is to help Mr Sharavan to return the lexicographically smallest 
palindrome string among all the possible options. 
OR "invlaid" if it is not possible.

Input Format:
-------------
A String W, consists of lowercase letters and #.

Output Format:
--------------
A String result.


Sample Input-1:
---------------
r#d#v##er

Sample Output-1:
----------------
redavader


Sample Input-2:
---------------
r#d#v#cer

Sample Output-2:
----------------
invalid
*/
import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid(s));
    }
    public static String isValid(String s)
    {
        int n = s.length();
        char[] arr = s.toCharArray();
        for(int i=0;i<n/2;i++)
        {
            if(arr[i]=='#' || arr[n-1-i]=='#')
            {
                if(arr[i]=='#' && arr[n-1-i]!='#')
                {
                    arr[i]=arr[n-1-i];
                }
                else if(arr[i]!='#' && arr[n-1-i]=='#')
                {
                    arr[n-1-i]=arr[i];
                }
                else
                {
                    arr[n-1-i]='a';
                    arr[i]='a';
                }
            }
            else if(arr[i]==arr[n-1-i])
            {
                continue;
            }
            else 
            {
                return "Invalid";
            }
        }
        return String.valueOf(arr);
    }
}
