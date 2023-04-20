/*
A graduate at University of China (UoC) has to follow certain rules. The rules are as follows:

UoC is offering K subjects, the subjects are indexed from 0 to K-1.
Some subjets have to follow the conditions, like condition[i]= [Xi, Yi] which specifies you must
take the subject Yi before the subject Xi.

You are given total number of subjects and a list of the condition pairs.
Return the ordering of subjects that a graduate should take to finish all subjects.
	- the result set should follow the given order of conditions.
	- If it is impossible to complete all subjects, return an empty set.

Input Format:
-------------
Line-1: An integer K, number of subjects.
Line-2: An integer C, number of conditions.
Next C lines: Two space separated integers, Xi and Yi.

Output Format:
--------------
Return a list of integers, the ordering of subjects that a graduate should take to finish all subjects


Sample Input-1:
---------------
4
3
1 2
3 0
0 1

Sample Output-1:
----------------
[2, 1, 0, 3]

Explanation-1:
--------------
There are a total of 4 courses to take. 
Subject 1  should be taken after you finished subject 2.
Subject 3  should be taken after you finished subject 0.
Subject 0  should be taken after you finished subject 1.
So the correct subject order is [2, 1, 0, 3].

Sample Input-2:
---------------
5
5
0 1
1 2
2 3
3 4
4 0

Sample Output-2:
----------------
[]

Explanation-2:
-------------
No subject can be completed because they depend on each other.
*/

import java.util.*;
class Graph {
    int v;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); 
    public Graph(int V)
    {
        v=V;  
        for(int i=0;i<v;i++)
        {
            graph.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(int u, int v)
    {
        graph.get(v).add(u);
    }
    public ArrayList<Integer> noOfDays() {
        ArrayList<Integer> res = new ArrayList<>();
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
            int val = que.poll();
            res.add(val);
            // System.out.println("Answer is " + val);
            for(int adj : graph.get(val)) {
                indg[adj]--;
                if(indg[adj] == 0) {
                    que.add(adj);
                }
            }
            // System.out.println("queue size " + que.size())
        }
        return res;
    }
}
class Schedule{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Graph gr = new Graph(v);
        for(int i=0;i<e;i++)
        {
            gr.addEdge(sc.nextInt(),sc.nextInt());
        }
        System.out.println(gr.noOfDays());
    }
}
