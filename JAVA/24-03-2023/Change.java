import java.util.*;
class Change{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String tar = sc.next();
        System.out.println(minDistance(word,tar));
    }
    public static int minDistance(String word,String tar)
    {
        int w = word.length();
        int t = tar.length();
        int dp[][] = new int[w+1][t+1];
        
        for (int i = 1; i <= w; i++){
          dp[i][0] = i;
        }
        for (int j = 1; j <= t; j++){
          dp[0][j] = j;
        }
        for(int i=1;i<=w;i++)
        {
            for(int j=1;j<=t;j++)
            {
                if(word.charAt(i-1)==tar.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[w][t];
    }
}
