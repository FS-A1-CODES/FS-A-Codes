import java.util.*;
class Jump
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        System.out.println(minJumps(arr,n));                                                           
    }
    public static int minJumps(int[] arr,int n)
    {
        int dp[] = new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++)
        {
            int two = Integer.MAX_VALUE;
            int one = dp[i-1]+Math.abs(arr[i]-arr[i-1]);
            if(i>1)
                two = dp[i-2]+Math.abs(arr[i]-arr[i-2]);
            dp[i]=Math.min(one,two);
        }
        return dp[n-1];
    }
}
