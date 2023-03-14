/*

Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
Example 2:

Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You do not need to jump.
Example 3:

Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 
 Constraints:
1 <= arr.length <= 5 * 104
-108 <= arr[i] <= 108


*/

//THIS IS A BFS PROBLEM

#include <bits/stdc++.h>
using namespace std;

int minJumps(int array[],int n){
    unordered_map<int,vector<int>> adj;
    for(int i=0;i<n;i++){
        adj[array[i]].emplace_back(i);
    }
    queue<int> q;//queue of indexes
    vector<int> visited(n,false);
    q.push(0);
    int jumps=0;
    while(!q.empty()){
        int size = q.size();
        while(size--){
            int curId = q.front();
            q.pop();
            if(curId == n-1){//if we react last index
                return jumps;
            }
            //moving forward and backward
            if(curId+1<n && !visited[curId+1]){
                visited[curId+1] = true;
                q.push(curId+1);
            }
            if(curId-1>=0 && !visited[curId-1]){
                visited[curId-1] = true;
                q.push(curId-1);
            }
            //jumping through the indexes
            for(auto index : adj[array[curId]]){
                if(!visited[index]){
                    visited[index] = true;
                    q.push(index);
                }
            }
            adj[array[curId]].clear();
        }
        jumps++;
    }
    return -1;
}

int main(){
    int n;
    cin>>n;
    int array[n];
    for(int i=0;i<n;i++){
        cin>>array[i];
    }
    cout<<minJumps(array,n)<<endl;
}
