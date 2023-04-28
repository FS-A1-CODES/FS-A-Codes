/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 
0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there 
is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting
from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
Constraints:

n == graph.length
1 <= n <= 104
0 <= graph[i].length <= n
0 <= graph[i][j] <= n - 1
graph[i] is sorted in a strictly increasing order.
The graph may contain self-loops.
The number of edges in the graph will be in the range [1, 4 * 104].

input=7
7
0 1
0 2
1 2
1 3
2 5
3 0
4 5
output=[2, 4, 5, 6]
*/


import java.util.*;
class Graph{
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int n ; 
    Graph(int n)
    {
        this.n = n;
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList());
        }
    }
    public static void addEdge(int u,int v)
    {
        graph.get(u).add(v);
    }
    public static ArrayList<Integer> findSafeNodes()
    {
        ArrayList<Integer> res = new ArrayList<>();
        int vs[] = new int[n];
        for(int i =0;i<n;i++)
        {
            if(dfs(vs,i))
            {
                res.add(i);
            }
        }
        return res;
    }
    public static boolean dfs(int vs[], int i)
    {
        if(vs[i]!=0)
        {
            return vs[i]==2;
        }
        vs[i]=1;
        for(int adj : graph.get(i))
        {
            if(vs[adj]==2)
            {
                continue;
            }
            if(vs[adj]==1 || !dfs(vs,adj))
            {
                return false;
            }
        }
        vs[i]=2;
        return true;
    }
}
class Safety{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int edges = sc.nextInt();
        Graph gr = new Graph(n);
        for(int i=0;i<edges;i++)
        {
            gr.addEdge(sc.nextInt(),sc.nextInt());
        }
        System.out.println(gr.findSafeNodes());
    }
}
