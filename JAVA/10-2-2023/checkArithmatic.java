/*
Mr Srikanth has given a task to his students.
He has given a list of N numbers, nums[], the list contains both poitive and 
negative integers. Also given two more list of integers as start[] and end[],
where start[] list contains starting indices, and end[] contains ending indices.

Now, the students task is to check and return the boolean values as a list res[],
for each 'i' between, 0<=i<N, check that the rearrangement of sublist of nums[], 
from nums[start[i]] to nums[end[i]] forms an arithmetic series or not.

NOTE: A series is said to be arithmetic, if and only if,
nums[i+1]-nums[i]==nums[1]-nums[0], for all valid 'i' value.

i.e., 1,3,5,7,9 is a valid series.
2, 3, 5, 8, 12 is not a valid series.


Constraints:
------------
0<= start[i]<=end[i] < nums[].length


Input Format:
-------------
Line-1: comma separated integers, nums[]
Line-2: comma separated integers, start[]
Line-3: comma separated integers, end[]

Output Format:
--------------
Print a list of boolean values of length equals to start[]/end[] list.


Sample Input-1:
---------------
2,8,4,6,10,11,12,14,20,16,18,22,24
0,1,3,6,8
3,4,5,9,12

Sample Output-1:
----------------
[true,true,false,false,true]

Explanation: 
------------
The sublist from 0 to 3 is: [2, 8, 4, 6] => [2,4,6,8] is valid
The sublist from 1 to 4 is: [8, 4, 6,10] => [4,6,8,10] is valid
The sublist from 3 to 5 is: [6, 10, 11] is invalid for any arrangement.
The sublist from 6 to 9 is: [12, 14, 20, 16] is invalid
The sublist from 8 to 12 is: [20, 16, 18, 22,24] is valid

*/

import java.util.*;
class Test{
    public static boolean helper(List<Integer> al){
        int d=al.get(1)-al.get(0);
        for(int i=2;i<al.size();i++){
            if(al.get(i)-al.get(i-1)!=d) return false;
        }
        return true;
    }
    public static boolean[] isArithmetic(int num[],int start[],int end[]){
        boolean res[]=new boolean[start.length];
        for(int i=0;i<start.length;i++){
            int l=start[i];
            int r=end[i];
            List<Integer> al=new ArrayList<>();
            for(int j=l;j<=r;j++){
                al.add(num[j]);
            }
            Collections.sort(al);
            if(helper(al)) res[i]=true;
            else res[i]=false;
        }
        return res;
    }
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] n=sc.nextLine().split(",");
        int arr[]=new int[n.length];
        for(int i=0;i<n.length;i++) arr[i]=Integer.parseInt(n[i]);
        String[] start=sc.nextLine().split(",");
        int s[]=new int[start.length];
        for(int i=0;i<start.length;i++) s[i]=Integer.parseInt(start[i]);
        String[] end=sc.nextLine().split(",");
        int e[]=new int[end.length];
        for(int i=0;i<end.length;i++) e[i]=Integer.parseInt(end[i]);
        System.out.println(Arrays.toString(isArithmetic(arr,s,e)));
    }
}
