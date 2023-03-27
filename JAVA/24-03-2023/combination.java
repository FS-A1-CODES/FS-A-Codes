/*
Given an array of distinct integers candidates and a target integer target, return a list 
of all unique combinations of candidates where the chosen numbers sum to target. You may 
return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two 
combinations are unique if the 
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to 
target is less than 150 combinations for the given input.

 

Example 1:

Input: 4
2 3 6 7
 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:
Input: 3
2 3 5 
8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:
Input: 1
2
1
Output: []

*/

import java.util.*;
public class Test{
    public static void helper(int i,int arr[],int target,List<List<Integer>> ans,List<Integer> ds){
        if(i==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
        }
        if(i>=arr.length) return;
        if(arr[i]<=target){
            ds.add(arr[i]);
            helper(i,arr,target-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }
        helper(i+1,arr,target,ans,ds);
    }
    public static List<List<Integer>> combination(int arr[],int target){
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,arr,target,ans,new ArrayList<>());
        return ans;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(combination(arr,target));
    }
}
