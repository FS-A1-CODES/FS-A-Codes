/*
You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. 
You want to use all the matchsticks to make one square. You should not break any stick, but you can 
link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.
input : integer n which gives number of match sticks
        n integer values
output : true/false
example
input = 
5
1 1 2 2 2 
output = true 
Explanation : we can use match sticks with length 1 to form one side and other three sides are having match sticks with length 2
example 
input = 
5
3 3 3 3 4
output = false
Explanation we cannot for swuare using all the five matchsticks

*/
import java.util.*;
class Square{
    public static int arr[] = new int[4]; 
    public static int target=0;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(findSquare(arr));
    }
    public static boolean findSquare(int mat[]) {
        int n=mat.length;
        if(n<4)
            return false;
        for (int i : mat) {
            target += i;
        }
        if (target % 4 != 0){
            return false; 
        }
        Arrays.sort(mat);
        target/=4;
        return square(mat,n - 1);
     }
    
    public static boolean square(int mat[],int ind) {
        
        if (arr[0] == arr[1] && arr[2] == arr[3] && arr[3] == target) 
            return true;
        for(int i=0;i<4;i++){
            arr[i] += mat[ind];
            if (arr[i]<= target && square(mat, ind - 1)) {
                return true;
            }
            arr[i] -= mat[ind];
        }
        return false;
    }
}
