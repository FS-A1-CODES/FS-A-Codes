/*
There is a Game where a fighter consumes power[i] on the i-th hour. 

Given an integer k, for every consecutive sequence of k hours (power[i], 
power[i+1], ..., power[i+k-1] for all 0 <= i <= n-k), they look at T, 
the total power consumed during that sequence of k hours (power[i] + 
power[i+1] + ... + power[i+k-1]):

If T < lower, fighter performed poorly and lose 1 point; 
If T > upper, fighter performed well and gain 1 point;
Otherwise, fighter performed normally and there is no change in points.

Initially, the fighter has zero points. Return the total number of points the 
fighter has after consuming power for power.length hours.

Note that the total points can be negative.

 
Input Format
--------------
Line-1: An integer N, the arrray length.
Line-2: Array of integers, power[]
Line-3: Three integers -subarray length K, lower value and upper value

output Format
--------------
An integer total points

Sample Input-1:
---------------
4
7 10 0 0
2 1 12

Sample Output-1:
----------------
0

Explanation:
------------
Since k = 2, we consider subarrays of length 2.
power[0] + power[1] > upper so 1 point is gained.
lower <= power[1] + power[2] <= upper so no change in points.
power[2] + power[3] < lower so 1 point is lost.


Sample Input-2:
2
5 10
2 0 1

Sample Output-2:
----------------
1

Explanation:
------------
Since k = 2, we consider subarrays of length 2.
power[0] + power[1] > upper so 1 point is gained.
Example 3:

Sample Input-3:
---------------
5
1 2 3 4 5
1 3 3

Sample Output-3:
----------------
0

Explanation:
------------
Since k = 1, Since k = 2, we consider subarrays of length 1. and compare it 
to lower and upper. power[0] and power[1] are less than lower so 2 points are lost. 
power[3] and power[4] are greater than upper so 2 points are gained.


*/

class Test{
    int compare(int sum,int low,int up){
        int res=0;
        if(sum<low){
            res--;
        }
        else if(sum>up){
            res++;
        }
        else{
            return res;
        }
    }
    int Fighter_power(int[] arr,int n,int k,int low,int up){
        int res=0;
        int sum=0;
        int i=0,j=0;
        while(j<n){
            sum+=arr[i];
            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                res += compare(sum,low,up);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int low = sc.nextInt();
        int up = sc.nextInt();
        System.out.println(Fighter_power(arr,n,k,low,up));
    }
}
