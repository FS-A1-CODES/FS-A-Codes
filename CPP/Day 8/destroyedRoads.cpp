/*
Due to the heavy rains in TS & AP states, the road from 
Hyderabad to Kakinada destroyed at N places.
Let us assume Vijayawada is at the center bewteen Hyd and Kakinada
NHAI planned to call for fresh bids to repair these pool of destroyed roads.

The destroyed road is indicated as road[x]=[x-from, x-to], where 0 < = x < N 
-500 <= x-from < x-to <= 500. The road from Hyderabad to Vijayawada indicated 
with negative values, and Vijayawada to Kakinada indicated with positive values.

A destroyed road D2 = [r, s] follows a destroyed road D1 = [p, q] if q < r.
A pool of roads at different places can be formed in this way. 

NHAI given a task to you to find the size of maximum pool can be formed.
You do not need to use up all the given roads. You can select the roads in any order.

Note: Size is the number of destroyed roads in the pool.

Input Format:
-------------
Line-1: An integer N, number of roads.
Next N lines: two space separated integers, x-from and x-to values.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
4
1 4
-10 -3
-5 0
5 6

Sample Output-1:
----------------
3

Explanation:
------------
The pool is : [-10, -3] -> [1, 4] -> [5, 6]
or [-5, 0] -> [1, 4] -> [5, 6]


Sample Input-2:
---------------
4
-50 -20
-15 0
5 20
25 40

Sample Output-2:
----------------
4

Explanation:
------------
The pool is : [-50, -20] -> [-15, 0] -> [5, 20] -> [25, 40]
*/

//DP APPROACH
#include <bits/stdc++.h>
using namespace std;
typedef vector<int> v;
int memoization(int i,int n,int last,vector<vector<int>>& roads,vector<vector<int>>& dp){
    if(i==n){
        return 0;
    }
    if(dp[i][last+1]!=-1){
        return dp[i][last+1];
    }
    int pick_ele = -1e9;//to pick the max element
    if(last==-1 || roads[i][0] > roads[last][1]){//condition q<r
        pick_ele = 1+memoization(i+1,n,i,roads,dp);
    }
    //dont pick the element and move forward
    int not_pick_ele = memoization(i+1,n,last,roads,dp);
    //update the max value in dp for further usage
    return dp[i][last+1] = max(pick_ele,not_pick_ele);
}
static bool comp(v a,v b){
    return a[0]<b[0];
}
int main(){
    int n;
    cin>>n;
    vector<v> roads;
    string s;
    int it=n;
    while(it--){
        int p,q;
        v t;
        cin>>p>>q;
        t.emplace_back(p);
        t.emplace_back(q);
        roads.push_back(t);
    }
    sort(roads.begin(),roads.end(),comp);
    vector<v> dp(n,v(n+1,-1));
    cout<<memoization(0,n,-1,roads,dp);
}


