/*
You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.
input : integer n which gives number of match sticks
        n integer values
output : true/false
example
input = 
5
1 1 2 2 2
output = true
Explanation : we can use match sticks with length 1 to form one side and other three sides are having match sticks with length 2
example 
input = 
5
3 3 3 3 4
output = false
Explanation we cannot for swuare using all the five matchsticks

*/
#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;
    int sum=0;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
        sum+=arr[i];
    }
    if(sum%4==0){
        cout<<"true"<<endl;
    }
    else{
        cout<<"false"<<endl;
    }
}
