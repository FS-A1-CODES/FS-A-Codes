/*Mr Aziz is playing with alphabets.
He is given a word Target.
He need to generate the word target using the following rules:
	Step-1: Initialize a word W="", an empty string.
	Step-2: Insert the word "pqr" in W at any place.
	Step-3: Repeat Step-2, till it reaches the length of Target.
	
Inserting the word "pqr" in W is as follows: 
	- W=W.substr(0,k) + "pqr" + W.substr(k)
, where W=W.substr(0,k) + W.substr(k). 
Note that W.substr(0,k) and W.substr(k) may be empty.

Your task is to check whether Aziz can generate Target word or not.
Return true if he can generate, otherwise, return false.

Input Format:
-------------
A String, Target.

Output Format:
--------------
Print a boolean result.


Sample Input-1:
---------------
pqpqrpqrr

Sample Output-1:
----------------
true


Sample Input-2:
---------------
pppqrqqrr

Sample Output-2:
----------------
false


Sample Input-3:
---------------
pppqrqrqr

Sample Output-3:
----------------
true

*/

#include<bits/stdc++.h>
using namespace std;
bool solve(string s){
    stack<char>st;
    for(auto i:s){
        if(st.empty())
        st.push(i);
        else if(i!='r')
        st.push(i);
        else if(!st.empty() && i=='r'){
            if(st.top()!='q')
            return false;
            st.pop();
            if(st.top()!='p')
            return false;
            st.pop();
        }
    }
    if(st.empty())
    return true;
    return false;
}
int main(){
    string word;
    cin>>word;
    if(solve(word))
    cout<<"true";
    else
    cout<<"false";
}
