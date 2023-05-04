/*
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi]
 represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly 
connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
input = number of nodes n 
number of edges m
m number of edges 
output = integer 

sample cases:
input =
4
3
0 1
0 2
1 2
output = 1
case 2:
input = 6
5
0 1
0 2
0 3
1 2
1 3
output = 2
 */


import java.util.*;
class DSU {
    int[] parent;
    int[] rank;
    int components=0;
    public DSU(int n) {
        components=n;
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
            rank[i]=1;
        }
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px != py) {
            if (rank[px] < rank[py]) {
                parent[px] = py;
        
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
                
            } else {
                parent[py] = px;
                rank[px]++;
            }
            components--;
        }
    }
}
class Connected{\
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sides = sc.nextInt();
        DSU dsu = new DSU(n);
        for(int i=0;i<sides;i++) {
            dsu.union(sc.nextInt(),sc.nextInt());
        }
        if(sides<n-1)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(dsu.components - 1);
        }
    }
}
