/*
There is a network of servers, given in the form of a directed graph and data is constantly being transfered among these servers.
You can send the data from a given source server 's' to a destination server 't'. The data has to be tranfered along the disjoint paths.
Find the maximum number of disjoint paths through which the data can be transfered.
 
Note:Two paths are said to be disjoint paths, if they don’t share any edge.

 Example:
 input =8
0 1 1 1 0 0 0 0
0 0 1 0 0 0 0 0
0 0 0 1 0 0 1 0
0 0 0 0 0 0 1 0
0 0 1 0 0 0 0 1
0 1 0 0 1 0 0 1
0 0 0 0 0 1 0 1
0 0 0 0 0 0 0 0
0 7

output = 2

 */
import java.util.*;

class Edge{
    private int source;
    private int dest;
    
    public Edge(int source, int dest){
        this.source = source;
        this.dest = dest;
    }
    public int getSource(){
        return source;
    }
    public int getDest(){
        return dest;
    }
}

class Graph{
    private int n;//no of vertices
    private List<Edge>[] adjList;
    public Graph(int n){
        this.n = n;
        adjList = new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i] =new ArrayList<>();
        }
    }
    //function to add an edge in our graph
    public void addEdge(int source,int dest){
        Edge edge = new Edge(source,dest);
        adjList[source].add(edge);
    }
    //function to check if we have a Augmenting path
    public boolean hasPath(int[][] matrix,int[] parent,int source,int dest){
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        Queue<Integer> q = new LinkedList<>();
        q.add(source);//adding element to our queue
        visited[source] = true;//marking it as visited
        parent[source] = -1;//as it is 1st element, no parent
        while(!q.isEmpty()){
            int u = q.poll();
            for(Edge edge:adjList[u]){
                int v = edge.getDest();
                //if we have an unvisited edge
                if(!visited[v] && matrix[u][v] > 0){
                    q.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        //we should return if we have visited our destination or not
        return visited[dest];
    }
    public int maxDisjointPaths(int[][] matrix,int source, int dest){
        int[] parent = new int[n];
        int maxFlow = 0;
        //while there exists an augmenting path, we should add flow to max flow in graph
        while(hasPath(matrix,parent,source,dest)){
            int pathFlow = Integer.MAX_VALUE;
            for(int v = dest;v!=source;v = parent[v]){
                int u = parent[v];
                for(Edge edge:adjList[u]){
                    if(edge.getDest()==v){
                        pathFlow = Math.min(pathFlow,matrix[u][v]);
                        break;
                    }
                }
            }
            //updating residual capacities of the edges and reverse edges along the path
            for(int v = dest;v!=source;v=parent[v]){
                int u = parent[v];
                for(Edge edge:adjList[u]){
                    if(edge.getDest()==v){
                        matrix[u][v] -=  pathFlow;
                        matrix[v][u] += pathFlow;
                        break;
                    }
                }
            }
            //add pathflow to maxFlow;
            maxFlow += pathFlow;
        }
        return maxFlow;
    }
}

public class Test{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int source = sc.nextInt();
        int dest = sc.nextInt();
        Graph graph = new Graph(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    graph.addEdge(i,j);
                }
            }
        }
        System.out.println(graph.maxDisjointPaths(matrix,source,dest));
    }
}
