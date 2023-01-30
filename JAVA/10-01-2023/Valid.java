/*The Valid shortcuts of a string "abcd", are as follows:
abcd, abcd, a1cd, ab1d, abc1, 2cd, a2d, ab2, 1b1d, 1bc1,a1c1, 
1b2, 2c1, 3d, a3, 4

You are given a string S and shortcut string  SC, 
Your task is to find out whether the string matches with the 
given shortcut or not.
if matched print true, else false.

Note:
String S contains only lowercase letters and String SC contains 
only lowercase letters and digits.

Input Format:
-------------
Two space separated Strings S and SC

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
internationalization i12iz4n

Sample Output-1:
----------------
true

Sample Input-2:
---------------
apple a2e

Sample Output-2:
----------------
false
*/




import java.util.*;
public class Valid {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        String word = s[0];
        String target = s[1];
        System.out.println(isValid(word,target));
    }
    public static boolean isValid(String word,String target)
    {
        int n1=word.length(),n2=target.length();
        int w=0,t=0,count=0;
        while(t<n2 && w<n1)
        {
            if(target.charAt(t)>='0' && target.charAt(t)<='9')
            {
                if(count==0 && target.charAt(t)=='0')
                {
                    return false;
                }
                count=count*10+(target.charAt(t)-'0');
            }
            else{
                if(count != 0)
                {
                    w+=count;
                    count=0;
                }
                if(w>=n1 || target.charAt(t)!=word.charAt(w) )
                {
                    return false;
                }
                w++;
            }
            t++;
        }
        return w+count==n1 && t==n2;
    }
}
