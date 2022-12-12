/*Aruna is a typewriter, typing a document on her laptop. Suddenly her system got
hacked and whatever she types as words are displayed in reverse and with simple 
braces. She types only lowercase letters.

In order to get the actual words, Aruna has to reverse each word starting with 
the word which is in innermost most braces and remove those braces.
Help Aruna to get actual words.

Constraints:
------------
  - 0 <= word.length <= 2000
  - Word only contains lower case English characters and parentheses.
    It's guaranteed that all braces are balanced.


Input Format:
-------------
Line-1: a string represents an encoded word.

Output Format:
--------------
return the original string.


Sample Input-1:
---------------
(pqrs)

Sample Output-1:
----------------
srqp


Sample Input-2:
---------------
(uoy(are)woh)

Sample Output-2:
----------------
howareyou

Explanation
------------
Initially "are" will be revesed as "era".
Then (uoyerawoh) will be reversed.
*/
#include<bits/stdc++.h>
using namespace std; 
string Type(string s){
    stack<int>st;
    string ans;
    for(int i=0;i<s.size();i++){
        if(s[i]=='(')
        st.push(i);
        else if(s[i]==')')
        {
            int tp=st.top();
            st.pop();
            reverse(s.begin()+tp+1,s.begin()+i);
        }
    }
    for(auto x:s)
    if(x!='(' && x!=')')
    ans+=x;
    return ans;
}
int main(){
    string s;
    cin>>s;
    cout<<Type(s);
}
