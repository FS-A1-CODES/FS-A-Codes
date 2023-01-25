/*
There are N number of small cartoons and each cartoon will have a balloon of 
some color identified by a number. You are asked to select fixed number of 
P-cartoons as a subset every time and find the number of unique colored 
balloons in the number of cartoons "P" you pick everytime.

The resultant cartoons ans will be N-P+1 and return it.

The number of distinct number of balloons is:
    nums[i:i+p-1] = [nums[i], nums[i+1], ..., nums[i+p-1]].


Input Format:
-------------
Line-1: Two space separated integers, N and P
Line-2: N space separated integers, nums[]

Output Format:
--------------
Print the (N-P+1) integers as output.


Sample Input-1:
---------------
7 4
1 2 2 3 3 4 4

Sample Output-1:
----------------
3 2 3 2

Explanation: 
------------
The number of distinct elements in each subarray of size P goes as follows:
- nums[0:3] = [1,2,2,3] so ans[0] = 3
- nums[1:4] = [2,2,3,3] so ans[1] = 2
- nums[2:5] = [2,3,3,4] so ans[2] = 3
- nums[3:6] = [3,3,4,4] so ans[3] = 2


Sample Input-2:
---------------
6 3
1 1 1 1 1 1

Sample Output-2:
----------------
1 1 1 1

Explanation:
------------
The number of distinct elements in each subarray goes as follows:
- nums[0:2] = [1,1,1] so ans[0] = 1
- nums[1:3] = [1,1,1] so ans[1] = 1
- nums[2:4] = [1,1,1] so ans[2] = 1
- nums[3:5] = [1,1,1] so ans[3] = 1


Sample Input-3:
---------------
7 3
1 2 3 4 2 1 3

Sample Output-3:
----------------
3 3 3 3 3

*/

import java.util.*;
public class p1{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        cartoon(arr,p);
        
    }
    
    public static void cartoon(int arr[],int p){
        
        HashMap<Integer,Integer>mp=new HashMap<Integer,Integer>();
        for(int i=0;i<p;i++)
        mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        
        System.out.println(mp.size());
        
        for(int i=p;i<arr.length;i++){
            if(mp.get(arr[i-p])==1)
            mp.remove(arr[i-p]);
            else
            mp.put(arr[i-p],mp.get(arr[i-p])-1);
            
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
            
        System.out.println(mp.size());
            
            
        
    }
    return ;
}
}
