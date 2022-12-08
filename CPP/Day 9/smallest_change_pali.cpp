/*
/*
Mr Shravan is given a word W, and W cosists of lowercase alphabets and '#'. 
Mr Shravan is allowed to replace the '#' with any one lowercase alphabet, 
such that the word W is a palindrome and it has to be the lexicographically
smallest among all the possible options.

Your task is to help Mr Sharavan to return the lexicographically smallest 
palindrome string among all the possible options. 
OR "invlaid" if it is not possible.

Input Format:
-------------
A String W, consists of lowercase letters and #.

Output Format:
--------------
A String result.


Sample Input-1:
---------------
r#d#v##er

Sample Output-1:
----------------
redavader


Sample Input-2:
---------------
r#d#v#cer

Sample Output-2:
----------------
invalid
*/

#include <bits/stdc++.h>
using namespace std;

string palindrome(string s,int n){
    int start=0;
    int end=n-1;
    while(start<=end){
        if(s[start]=='#' && s[end]=='#'){
            s[start]='a';
            s[end]='a';
            start++;
            end--;
        }
        else if(s[start]=='#' && isalpha(s[end])){
            s[start] = s[end];
            start++;
            end--;
        }
        else if(s[end]=='#' && isalpha(s[start])){
            s[end] = s[start];
            start++;
            end--;
        }
        else if(s[start]==s[end]){
            start++;
            end--;
        }
        else{
            return "invalid";
        }
    }
    return s;
}
int main(){
    string s;
    cin>>s;
    cout<<palindrome(s,s.size())<<endl;
}
