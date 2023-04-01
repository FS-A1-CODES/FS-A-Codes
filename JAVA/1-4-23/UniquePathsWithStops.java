import java.util.*;
class Path{
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
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.println(different(grid,row,col));
    }
    public static int different(int grid[][],int n,int m)
    {
        int dp[][] = new int[n][m];
        // for(int arr[]: dp)
        //     Arrays.fill(arr,-1);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=1;
                    continue;
                }
                if(grid[i][j]==1)
                {
                    dp[i][j]=0;
                    continue;
                }
                int up=0,left=0;
                if(i>0)
                {
                    up=dp[i-1][j];
                }
                if(j>0)
                {
                    left=dp[i][j-1];
                }
                dp[i][j]=up+left;
            }
        }
        return dp[n-1][m-1];
    }
}
