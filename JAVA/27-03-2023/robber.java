/*
shobraj is  a professional robber planning to rob houses along a street. Each house has a 
certain amount of money stashed, the only constraint stopping him from robbing each of 
them is that adjacent houses have security systems connected and it will automatically 
contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the 
maximum amount of money he can rob tonight without alerting the police.

 

Example 1:

Input: 
4
1 2 3 1
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: 5 
2 7 9 3 1
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

*/

class Solution {
    public int helper(int[] nums,int idx,int[] dp){
        if(idx==nums.length-1) return nums[idx];
        if(idx>=nums.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int take = nums[idx] + helper(nums,idx+2,dp);
        int not_take = helper(nums,idx+1,dp);
        dp[idx] = Math.max(take,not_take);
        return dp[idx];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
}
