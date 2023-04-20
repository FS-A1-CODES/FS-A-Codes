/*
EA Sports, developed a video game. They designed a game in such a way that, 
there are L number of levels from 1 to L. There are D number of dependencies
where each dependency[m] = [ Xm, Ym ], represents a prerequisite relationship,
that is, in order to play level-Ym, you must have completed the level-Xm.

In one day you can complete any number of levels as long as you 
have completed all the prerequisites levels in the game. 

You cannot play a level-Ym which has some prerequisite level-Xm on same day.

Write a method to return the minimum number of days to complete all the levels
in the game. If there is no way to complete all the levels, return -1.


Input Format:
-------------
Line-1: An integer L, number of levels.
Line-2: An integer D, number of dependencies.
Next D lines: Two space separated integers, Xm and Ym.

Output Format:
--------------
An integer, the minimum number of days to complete all the levels in the game.


Sample Input-1:
---------------
3
2
1 3
2 3

Sample Output-1:
----------------
2

Explanation-1:
--------------
On the first day, levels 1 and 2 are completed. 
On the second day, level-3 is completed.


Sample Input-2:
---------------
3
3
1 2
2 3
3 1

Sample Output-2:
----------------
-1

Explanation-2:
-------------
No level can be completed because they depend on each other.

*/

import java.util.*;

class Graph {
    int v;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); 

    public Graph(int V) {
        v = V;  
        for(int i = 0; i < v; i++) {
            graph.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int u, int v) {
        graph.get(u).add(v);
    }

    public int noOfDays() {
        int count = 0;
        int[] indg = new int[v];
        for(int i = 0; i < v; i++) {
            for(int adj : graph.get(i)) {
                indg[adj]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < v; i++) {
            if(indg[i] == 0) {
                que.add(i);
            }
        }
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                int val = que.poll();
                for(int adj : graph.get(val)) {
                    indg[adj]--;
                    if(indg[adj] == 0) {
                        que.add(adj);
                    }
                }
            }
            count++;
        }
        for (int i = 0; i < v; i++) {
            if (indg[i] != 0) {
                return -1;
            }
        }
        return count;
    }
}

public class Parallel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Graph gr = new Graph(v);
        for(int i = 0; i < e; i++) {
            gr.addEdge(sc.nextInt() - 1, sc.nextInt() - 1);
        }
        System.out.println(gr.noOfDays());
    }
}
