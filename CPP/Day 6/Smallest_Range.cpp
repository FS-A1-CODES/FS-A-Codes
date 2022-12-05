/*
Mr Subodh is given an array arr[] of M integers between 0 to 10000.
And he is also given another integer P.
Subodh has to update each integer in the arr[]:
Subodh is allowed to update the arr[i], as follows:
	- arr[i] = arr[i] + P (or) arr[i] = arr[i] - P.

Subodh has to find the update score as the difference between 
maximum element in the arr[] to the minimum element arr[] after all the
elements in the arr[] updated. and return the minimum update score.

Input Format:
-------------
Line-1: Two space separated integers M and P.
Line-2: M space separated integers, integer > 0.

Output Format:
--------------
Print an integer result.

Sample Input-1:
---------------
3 2
2 6 3

Sample Output-1:
----------------
1

Explanation: 
------------
Update the array as [4, 4, 5]. The score is maximum(arr) - minimum(arr)
=> 5 - 4 = 1.


Sample Input-2:
---------------
4 3
1 11 8 4

Sample Output-2:
----------------
4

Explanation: 
------------
Update the array as [4, 8, 5, 7]. The score is maximum(arr) - minimum(arr) 
=> 8 - 4 = 4

*/

#include<bits/stdc++.h>
using namespace std;
int smallest_range(vector<int>&v,int m,int n){
    int ans=v[m-1]-v[0];
    int l=v[0]+n;
    int r=v[m-1]-n;
    for(int i=1;i<m;i++){
        int mn=min(v[i]-n,l);
        int mx=max(v[i-1]+n,r);
        ans=min(ans,mx-mn);
    }
    return ans;
}
int main(){
    int m,n;
    cin>>m>>n;
    vector<int>v;
    for(int i=0;i<m;i++)
    {
        int a;
        cin>>a;
        v.push_back(a);
    }
    sort(v.begin(),v.end());
    cout<<smallest_range(v,m,n);
}
