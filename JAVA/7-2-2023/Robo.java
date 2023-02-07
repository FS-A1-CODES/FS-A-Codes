import java.util.*;
class Robo
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char arr[][] = new char[n][n];
        for(int i=0;i<n;i++)
        {
            char carr[] = sc.nextLine().toCharArray();
            for(int j=0;j<n;j++)
            {
                arr[i][j] = carr[j];
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((arr[i][j]=='O') && (i==0 || i==n-1 || j==0 || j==n-1))
                {
                    // System.out.println(i+" "+j);
                    dfs(arr,i,j,n);
                    // System.out.println(arr[i][j]);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]=='S')
                {
                    System.out.print('O'+" ");
                }
                else
                {
                    System.out.print('X'+" ");
                }
            }
            System.out.println();
        }
    }
    public static void dfs(char[][] arr,int i,int j,int n)
    {
        if(i>=0 && i<n && j>=0 && j<n && arr[i][j]=='O')
        {
            arr[i][j] = 'S';
            dfs(arr,i+1,j,n);
            dfs(arr,i,j+1,n);
            dfs(arr,i-1,j,n);
            dfs(arr,i,j-1,n);
        }
        return ;
    }
}
