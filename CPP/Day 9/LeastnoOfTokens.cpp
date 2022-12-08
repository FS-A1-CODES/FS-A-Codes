/*
/*
You are given some tokens printed with unique numbers on them and an integer T.
Your task is to find the least number of tokens that you need to make up the 
value T, by adding the numbers printed on all the tokens. 
If you cannot make the value T, by any combination of the tokens, return -1.

NOTE: Assume that you have an unlimited set of tokens of each number type.

Input Format:
-------------
Line-1: Space separated integers tokens[], number printed on tokens.
Line-2: An integer T.

Output Format:
--------------
Print an integer, minimum number of tokens to make the value T.


Sample Input-1:
---------------
1 2 5
11

Sample Output-1:
----------------
3

Explanation:
------------
5+5+1 = 11


Sample Input-2:
---------------
2 4
15

Sample Output-2:
----------------
-1

*/
//failing 8th test case due to long int input
#include <bits/stdc++.h>
using namespace std;

int minTokens(int i,int target,vector<int>& arr,vector<vector<int>>& dp){
    if(i==0){
        if(target%arr[0]==0){
            return target/arr[0];
        }
        else{
            return 1e9+7;
        }
    }
    if(dp[i][target]!=-1){
        return dp[i][target];
    }
    int pick = 1e9+7;
    int not_pick = 0+minTokens(i-1,target,arr,dp);
    if(arr[i]<=target){//condition to pick the element as token
    //pick the element and stay there
        pick = 1+minTokens(i,target-arr[i],arr,dp);//reduce the target value;
    }
    
    return dp[i][target] = min(pick,not_pick);
}
int main(){
    vector<int> arr;
    int tar;
    string s,t;
    getline(cin,s);
    cin>>tar;
    stringstream ss(s);
    while(getline(ss,t,' ')){
        arr.emplace_back(stoi(t));
    }
    int n = arr.size();
    vector<vector<int>> dp(n,vector<int>(tar+1,-1));
    int ans = minTokens(n-1,tar,arr,dp);
    if(ans>=1e9+7){
        cout<<-1;
    }
    else{
        cout<<(int)ans;
    }
}
