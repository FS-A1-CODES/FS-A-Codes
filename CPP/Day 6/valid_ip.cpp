/*
Bob Khan is working with various number systems.
He has created two kinds of addressing systems to share information 
between any two electronic devices.
Addresses in Type-I has following properties:
	- This addressing has four parts, each part is called as 'octet'
	- each octet can have a decimal value between 0 to 255 only
	- each part is separated by periods(.) 
	- Leading 0's are not allowed.
	- each part should conatins atmost 3 digits.
if any octet in the 4 parts, is not satisfying the rules
specified said to be  "invalid" addressing.
Addresses in Type-II has following properties:
	- This addressing has eight parts, each part is called as 'hextet'
	- each hextext can have a hexadecimal value between 0 to ffff only
	- each part is separated by colons (:) 
	- each part should conatins atmost 4 alphanumerics, 
	  as per hexademial number system.
if any hextet in the 8 parts, is not satisfying the rules
specified said to be "Invalid" addressing.
		
You will be given an address as a string	addr.
Your task is to find, whether the given address "addr" belongs to which asddress type.
And return "Type-I" if belongs to "Type-I" Addressing, 
return "Type-II" if belongs to "Type-II" Addressing, 
return "Invalid" if not belongs to either "Type-I"  or "Type-II"Addressing.
Input Format:
-------------
A string, an address addr.
Output Format:
--------------
Print a string output, as mentioned in above statement.
Sample Input-1:
---------------
213.234.45.12
Sample Output-1:
----------------
Type-I
Sample Input-2:
---------------
abcd:ef12:3456:7:dce8:fab9:1:0cda
Sample Output-2:
----------------
Type-II
Sample Input-3:
---------------
abcd:ef12:3456:7:0dce8:fab9:1:0cda
Sample Output-3:
----------------
Invalid
Sample Input-4:
---------------
123.234.34@.31
Sample Output-4:
----------------
Invalid
*/

#include<bits/stdc++.h>
using namespace std;
bool checkType1(string ip){
    int c=0; 
    string s="";
    for(int i=0;i<ip.length();i++){
        if(ip[i]=='.'){
            c++;
            if(s.empty() || (s.front() == '0' && s.size()>1) || stoi(s)>255){
                return false;
            }
            s="";
            continue;
        }
        if(!isdigit(ip[i]) || s.size() == 3){
            return false;
        } 
        s=s+ip[i];
    }
    if(s.empty() || (s.front() == '0' && s.size() > 1) || stoi(s) > 255){
        return false;
    } 
    if(c==3){
        return true;
    }
    return false;
}
bool checkType2(string ip){
    int c=0; 
    string s="";
    for(int i=0;i<ip.length();i++){
        if(ip[i]==':'){
            c++;
            if(s.empty()){
                return false;
            }
            s="";
            continue;
        }
        if(!isxdigit(ip[i]) || s.size() == 4){ 
            return false;
        }
        s=s+ip[i];
    }
    if(s.empty()){ 
        return false;
    }
    if(c==7){
        return true;
    }
    return false;
}
int main(){
    string ip;
    getline(cin,ip);
    for(int i=0;i<ip.length();i++){
        if(ip[i]=='.'){
            if(checkType1(ip)==true){
                cout<<"Type-I";
            }
            else{
                cout<<"Invalid";
            }
            exit(0);
        }
        else if(ip[i]==':'){
            if(checkType2(ip)==true){
                cout<<"Type-II";
            }
            else{
                cout<<"Invalid";
            }
            exit(0);
        }
    }
    cout<<"Invalid";
}
