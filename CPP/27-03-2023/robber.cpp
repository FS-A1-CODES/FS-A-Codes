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

#include <bits/stdc++.h>
using namespace std;

int memoization(int i,int n,vector<int>& dp,int arr[]){
    if(i>=n){
        return 0;
    }
    if(dp[i]!=-1){
        return dp[i];
    }
    int not_pick = memoization(i+1,n,dp,arr);
    int pick = arr[i]+memoization(i+2,n,dp,arr);
    return dp[i] = max(not_pick,pick);
}

int main(){
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    vector<int> dp(n,-1);
    
    cout<<memoization(0,n,dp,arr)<<endl;
}
