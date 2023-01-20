/*
Mr. Gnanesh is working with words. He has given a list of words. 
Each word in the list contains only two lowercase letters [a-z].

He wants to create the biggest word BW, by concatenating words from the list, which 
is a palindrome too. He is allowed to use each word from the list at most once.

Return the length of the biggest word that can be formed using the list.
If it is impossible to create a such word, return 0.

Input Format:
-------------
Space separated strings, words[], two letter words.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
ab ba dd

Sample Output-1:
----------------
6

Explanation: 
------------
The biggest word is, ab,dd,ba => abddba, which is a palindrome.


Sample Input-2:
---------------
pq rs sr mk km pq

Sample Output-2:
----------------
8

Explanation: 
------------
The biggest word is, rs,sr,mk,km => rsmkkmsr or mkrssrkm..etc, 
which is a palindrome.


Sample Input-3:
---------------
aa bb cc

Sample Output-3:
----------------
2

*/

import java.util.*;
class Test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String arr[] = sc.nextLine().split(" ");
        int n = arr.length;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            int val = map.getOrDefault(arr[i],0);
            map.put(arr[i],val+1);
        }
        int flag = 0;
        int count=0;
        // System.out.println(map);
        for(int i=0;i<n;i++)
        {
            if(arr[i].charAt(0)==arr[i].charAt(1) && flag==0)
            {
                // System.out.println("middle word "+arr[i]);
                count+=2;
                flag=1;
                map.put(arr[i],map.get(arr[i])-1);
            }
            else
            {
                String rev = reverse(arr[i]);
                // System.out.println("word:"+arr[i]+" reverse:"+rev);
                if(map.containsKey(rev) && map.get(arr[i])>0)
                {
                    map.put(arr[i],map.get(arr[i])-1);
                    if(map.get(rev)>0){
                        map.put(rev,map.get(rev)-1);
                        count+=4;
                    }
                }
            }
        }
        System.out.println(count);
    }
    public static String reverse(String s)
    {
         StringBuilder sb = new StringBuilder(s);
         return sb.reverse().toString();
    }
}
