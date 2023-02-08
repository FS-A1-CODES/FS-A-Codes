import java.util.*;
class Boxes
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        int arr[][] = new int[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if((arr[i][j]==0) && (i==0 || i==row-1 || j==0 || j==col-1))
                {
                    dfs(arr,i,j,row,col);
                }
            }
        }
        int count = 0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(arr[i][j]==0)
                {
                    count++;
                    dfs(arr,i,j,row,col);
                }
            }
        }
        System.out.println(count);
    }
    public static void dfs(int[][] arr,int i,int j,int r,int c)
    {
        if(i>=0 && i<r && j>=0 && j<c && arr[i][j]==0)
        {
            arr[i][j] = 1;
            dfs(arr,i+1,j,r,c);
            dfs(arr,i,j+1,r,c);
            dfs(arr,i-1,j,r,c);
            dfs(arr,i,j-1,r,c);
        }
        return ;
    }
}
