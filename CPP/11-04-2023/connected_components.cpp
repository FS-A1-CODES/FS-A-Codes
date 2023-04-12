//connected components

#include<iostream>
#include<list>
#include<vector>
using namespace std;

class Graph {

    private:

        int nodes;
        list<int> *adjlist;

    public:

        Graph() {
        }

        Graph (int nodes) { // Allocate resources
            adjlist = new list<int> [nodes];
            this->nodes = nodes;
        }

        ~Graph () { // Free allocated resources
            delete [] adjlist;
        }

        void AddEdge (int src, int dst) {
            adjlist[src].push_back(dst);
            adjlist[dst].push_back(src);
        }
        int countComponents(int v){
            vector<bool> vis(v,false);
            int count=0;
            for(int i=0;i<v;i++){
                if(!vis[i]){
                    dfs(i,vis);
                    count++;
                }
            }
            return count;
        }
        void dfs(int i,vector<bool>& vis){
            vis[i] = true;
            for(auto j:adjlist[i]){
                if(!vis[j])
                dfs(j,vis);
            }
        }
};


int main(){
    int n,m;
    cin>>n>>m;
    Graph g(n);
    for(int i=0;i<m;i++){
        int x,y;
        cin>>x>>y;
        g.AddEdge(x,y);
    }
    int res = g.countComponents(n);
    cout<<res<<endl;
    return 0;
}
