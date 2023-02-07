import java.util.*;
public class detective{
    public static void findDetective(int n,int r,int arr[]){
        int res=-1;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==n-1){
                res=i;
                count++;
            }
        }
        if(count==1) System.out.println(res);
        else System.out.println(-1);
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int arr[] = new int[n+1];
        for(int i=0;i<r;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[b]++;
        }
        findDetective(n,r,arr);
    }
}
