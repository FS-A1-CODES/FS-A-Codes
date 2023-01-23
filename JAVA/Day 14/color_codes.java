/*
There are numerous possible combinations of HTML colour codes, and each one is 
given a specific identification number. Each codes[i] in the list,  
is an HTML colour code that was chosen by the web designer. The list may 
contain duplicate codes.

The web designer's customer made the decision to eliminate P number of 
consecutive codes from the list. However, the web designer wants to preserve as 
many distinctive colour codes as he can. Find out how many unique colour codes 
the web designer can preserve, and print the count of unique color codes.


Input Format:
-------------
Line-1: Comma separated integers, codes[], HTML color codes
Line-2: An integer P.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
2,3,2,6,3,3,7,1
4

Sample Output-1:
----------------
4

Explanation: 
------------
The unique color codes he can preserve are, [2,3,7,1]
by removing [2,6,3,3].


Sample Input-2:
---------------
1,2,1,2,3,3,2,1,2,1
6

Sample Output-2:
----------------
2

Explanation: 
------------
The unique color codes he can preserve are, [2,1,2,1] or [1,2,1,2]
by removing 6 contiguous codes.
*/

import java.util.*;
public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(",");
        int arr[] = new int[s.length];
        int x = 0;
        for(String i: s){
            arr[x] = Integer.parseInt(i);
            x++;
        }
        
        int p = sc.nextInt();
        System.out.println(helper(arr,p));
    }
    public static int helper(int arr[] ,int p){
        int i = 0;
        int j = p-1;
        int max = Integer.MIN_VALUE;
        while(i<j && j<arr.length){
            if(j-i+1 < p){
                j++;
            }
            else if(j-i+1>p){
                i++;
            }
            else{
                max = Math.max(max,func(arr,i,j));
                i++;
                j++;
            }
        }
        
        return max;
    }
    public static int func(int arr[], int i, int j){
        HashSet<Integer> hs = new HashSet<>();
        for(int k = 0;k<arr.length;k++){
            if(k>=i && k<=j){
                continue;
            }
            else{
                hs.add(arr[k]);
            }
        }
        
        return hs.size();
    }
}
