/*
Mr. Bob is a Military Encoders. 
Mr. Bob writes a word as shown below and then merges them. 
Help Bob to write the code. 

Mr. Bob will be given a word 'w' and a number 'n' 

Sample Test Case - 1
input = 
ABCDE
2
output = ACEBD


This is How Bob writes the letters of the word 
A    C    E
   B    D

Now concatenate the two rows and ignore spaces in every row. We get ACEBD


Sample Test Case - 2
input = system 
3
output = seytms

s         e
  y    t    m
     s

Now concatenate the 3 rows we get seytms*/

#include<bits/stdc++.h>

using namespace std;

int main()
{
    string s;
    cin>>s;
    
    int m,n=s.length();
  cin>>m;
    
    vector<char>inner(n,'#');
    vector<vector<char>>grid(m,inner);
    
    int x=0,y=0,i=0,desc=1;
    while(y<n)
    {
        
        grid[x][y]=s[i];
        i++;
        if(desc==1)
        {
            if(x+1>m-1)
            {
                desc=0;
                x--;
                if(x<0)
                    x=0;
            }
            else
                x++;
        }
        else
        {
            if(x-1<0)
            {
                desc=1;
                x++;
                if(x>m-1)
                    x=0;
            }
            else
                x--;
    }
        y++;
        
    }
    
    string res="";
   
    
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(grid[i][j]!='#')
                res+=grid[i][j];
        }
    }
    cout<<res;
    
    
}

