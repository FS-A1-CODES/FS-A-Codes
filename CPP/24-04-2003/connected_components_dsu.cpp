/*
/*
There are N cities, and M routes[], each route is a path between two cities.
routes[i] = [city1, city2], there is a travel route between city1 and city2.
Each city is numbered from 0 to N-1.
 
There are one or more Regions formed among N cities. 
A Region is formed in such way that you can travel between any two cities 
in the region that are connected directly and indirectly.
 
Your task is to findout the number of regions formed between N cities. 
 
Input Format:
-------------
Line-1: Two space separated integers N and M, number of cities and routes
Next M lines: Two space separated integers city1, city2.
 
Output Format:
--------------
Print an integer, number of regions formed.
 
 
Sample Input-1:
---------------
5 4
0 1
0 2
1 2
3 4
 
Sample Output-1:
----------------
2
 
 
Sample Input-2:
---------------
5 6
0 1
0 2
2 3
1 2
1 4
2 4
 
Sample Output-2:
----------------
1

*/
#include <bits/stdc++.h>
using namespace std;

class UnionFind{
    public:
        vector<int> parent;
        UnionFind(int n){
            parent.resize(n);
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }
        int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        void union_fn(int x,int y){
            int par_x = find(x);
            int par_y = find(y);
            if(par_x != par_y){
                parent[par_x] = par_y;
            }
        }
};

int ConnectedComponents_UF(int n,vector<vector<int>>& edges){
    UnionFind uf(n);
    for(auto& edge:edges){//creating union
        uf.union_fn(edge[0],edge[1]);
    }
    int Component_count = 0;
    for(int i=0;i<n;i++){
        if(uf.find(i)==i){//if its equal to ultimate parent
            Component_count++;
        }
    }
    return Component_count;
}

int main(){
    int V,E;
    cin>>V>>E;
    vector<vector<int>> edges(E,vector<int>(2,0));
    for(int i=0;i<E;i++){
        cin>>edges[i][0]>>edges[i][1];
    }
    cout<<ConnectedComponents_UF(V,edges)<<endl;
}
