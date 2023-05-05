/*You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Input=3 3
2 1 1
1 1 0
0 1 1
Output=4

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.*/


import java.util.*;
class Rotting {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int grid[][] = new int[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(bfs(grid,row,col));
    }
    public static int bfs(int grid[][],int row, int col)
    {
        int count=0,fresh=0;
        Queue<int[]> que = new LinkedList<>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==2)
                {
                    int t[] = {i,j};
                    que.add(t);
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        
        int dirs[][] = {{0,-1},{0,1},{1,0},{-1,0}};
        while(!que.isEmpty())
        {
            int size = que.size();
            for(int i=0;i<size;i++)
            {
                int[] cur = que.poll();
                int x = cur[0];
                int y = cur[1];
                for(int[] dir : dirs)
                {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX>=0 && newX<row && newY>=0 && newY<col && grid[newX][newY]==1) 
                    {
                        grid[newX][newY] = 2; 
                        fresh--; 
                        int[] t = {newX,newY};
                        que.add(t); 
                    }
                }
            }
            count++; 
        }
        return (fresh>0) ? -1 : count-1;
    }
}
