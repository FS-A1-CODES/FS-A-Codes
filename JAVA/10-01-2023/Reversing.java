/* Given a string s, .reverse only all the vowels in the 
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
appear in both lower and upper cases, more than once.

Example 1:
Input: hello
Output: holle


Example 2:
Input: Keshavmemorial
Output: Kashivmomerael

Example 3:
Input: variations
Output: voriatians

*/

import java.util.*;
public class Reversing {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseVowel(s));
    }
    public static String reverseVowel(String s)
    {
        char[] arr = s.toCharArray();
        int n=s.length();
        int l=0,r=n-1;
        while(l<n && r>=0)
        {
            while(l<r && notVowel(arr[l]))
            {
                l++;
            }
            while(r>l && notVowel(arr[r]))
            {
                r--;
            }
            if(l<r)
            {
                char ch = arr[l];
                arr[l] = arr[r];
                arr[r] = ch;
            }
            l++;
            r--;
        }
        return new String(arr);
    }
    public static boolean notVowel(char ch)
    {
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return false;
        return true;
    }
}
