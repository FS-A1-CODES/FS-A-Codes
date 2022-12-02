/*Mr. Parandamayya is working with Strings.
He is given a String S. He has to find the palindromes in S, 
A palindrome can be a substring of S (Strictly substrings only, not subsequences).

Your task is to find the count the number of palindromes can be formed from S.

NOTE: Count each occurence of palindromes if duplicate substrings found. 

Input Format:
-------------
A string S

Output Format:
--------------
Print an integer, number of palindromes.


Sample Input-1:
---------------
divider

Sample Output-1:
----------------
9

Explanation:
-------------
Palindromes are d, i, v, i, d, e, r, ivi, divid

Sample Input-2:
---------------
abcdef

Sample Output-2:
----------------
6

Explanation:
-------------
Palindromes are a, b, c, d, e, f.
*/
#include<bits/stdc++.h>
using namespace std;
int solve(string s,vector<vector<int>>&cnt,int i,int j){
    if(i>j)return 1;
    if(cnt[i][j]!=-1)return cnt[i][j];
    if(s[i]==s[j])
   return cnt[i][j]=solve(s,cnt,i+1,j-1);
    else
   return cnt[i][j]=0;
   
}
int main(){
    string s;
    cin>>s;
    int n=s.size();
    int c=0;
    vector<vector<int>>cnt(n,vector<int>(n,-1));
    for(int i=0;i<n;i++)
    for(int j=i;j<n;j++)
  c+=solve(s,cnt,i,j);
   cout<<c;
}
