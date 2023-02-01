/*A string is good if there are no repeated characters.
Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.
Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
A substring is a contiguous sequence of characters in a string.

Example 1:
input: s = "xyzzaz"
output: 1

Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".


Example 2:
Input: s = "aababcabc"
Output: 4
Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".

*/


import java.util.*;
class Unique{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(Unq(s));
    }
    public static int Unq(String s)
    {
        HashSet<String> set = new HashSet<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int i=0,j=0,n=s.length();
        int count=0;
        while(j<n)
        {
            if(j-i+1<3)
            {
                int x = map.getOrDefault(s.charAt(j),0);
                map.put(s.charAt(j),x+1);
                j++;
            }
            else if(j-i+1==3)
            {
                int x = map.getOrDefault(s.charAt(j),0);
                map.put(s.charAt(j),x+1);
                j++;
                if(map.size()==3)
                {
                    // set.add(s.substring(i,i+3));
                    count++;
                }
                // System.out.println(s.substring(i,i+3));
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i))==0)
                {
                    map.remove(s.charAt(i));
                }
                i++;
            }
        }
        // System.out.println(set);
        return count;
    }
}
