/*
A transitive law is "If a == b and b == c, then a == c"
Which also says "If a == b and b != c, then a != c"

You will be given a list of strings relations[], i.e, like p==q or p!=q.
Your task is to find out whether all the relations follow the transitive law or not.
If all of them followed return true, otherwise return false.

Input Format:
-------------
Space separated strnigs, list of relations

Output Format:
--------------
Print a boolean value, whether transitive law is obeyed or not.


Sample Input-1:
---------------
a==b c==d c!=e e==f

Sample Output-1:
----------------
true


Sample Input-2:
---------------
a==b b!=c c==a

Sample Output-2:
----------------
false


Sample Input-3:
---------------
a==b b==c c!=d d!=e f==g g!=d

Sample Output-3:
----------------
true

*/

#include <bits/stdc++.h>
using namespace std;

class UnionFind{
    public:
    vector<int> parent;
    vector<int> rank;
    UnionFind(int n){
        parent.resize(n);
        rank.resize(n);
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }
    int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    void union_nodes(int x,int y){
        int parX = find(x);
        int parY = find(y);
        if(parX==parY){
            return;
        }
        if(rank[parX]<rank[parY]){
            parent[parX] = parY;
        }
        else if(rank[parX]>rank[parY]){
            parent[parY] = parX;
        }
        else{
            parent[parY] = parX;
            rank[parX]++;
        }
    }
};


bool transitiveRelations(vector<string>& relations) {
    // Create a union-find data structure
    UnionFind uf(26);

    // Union nodes that are equal
    for (string relation : relations) {
        if (relation[1] == '=') {
            int a = relation[0] - 'a';
            int b = relation[3] - 'a';
            uf.union_nodes(a, b);
        }
    }

    // Check if all not-equal nodes are in different connected components
    for (string relation : relations) {
        if (relation[1] == '!') {
            int a = relation[0] - 'a';
            int b = relation[3] - 'a';
            if (uf.find(a) == uf.find(b)) {
                return false;
            }
        }
    }

    // All relations follow the transitive law
    return true;
}


//for input
vector<string> split(const string& s, char delimiter) {
    vector<string> tokens;
    string token;
    istringstream tokenStream(s);
    while (getline(tokenStream, token, delimiter)) {
        tokens.push_back(token);
    }
    return tokens;
}

int main() {
    string input;
    getline(cin, input);
    vector<string> relations = split(input, ' ');
    bool result = transitiveRelations(relations);
    if(result){
        cout<<"true"<<endl;
    }
    else{
        cout<<"false"<<endl;
    }
}
