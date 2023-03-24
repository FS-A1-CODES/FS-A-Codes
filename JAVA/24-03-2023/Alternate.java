import java.util.*;
class Alternate{
    private static char c1[],c2[],c3[];
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.next();
        System.out.println(isAlternate(s1,s2,s3));
    }
    public static boolean isAlternate(String s1,String s2,String s3){
        if(s1.length()+s2.length()!=s3.length())
            return false;
        c1=s1.toCharArray();
        c2=s2.toCharArray();
        c3=s3.toCharArray();
        boolean valid[][] =new boolean[s1.length()+1][s2.length()+1];
        return dfs(0,0,0,valid);
    }
    public static boolean dfs(int i,int j,int k,boolean valid[][])
    {
        if(valid[i][j])
        {
            return false;
        }
        if(k==c3.length)
        {
            return true;
        }
        boolean valid1 = i<c1.length && c1[i] == c3[k] && dfs(i+1,j,k+1,valid); 
        boolean valid2 = j<c2.length && c2[j] == c3[k] && dfs(i,j+1,k+1,valid);
        boolean check=valid1||valid2;
        if(!check)
            valid[i][j] = true;
        return check;
    }
}
