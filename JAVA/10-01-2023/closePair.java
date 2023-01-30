/* Two brothers want to play a game, 
The rules of the game are: one player gives two sorted lists of 
numerical elements and a number (sum). 
The opponent has to find the closest pair of elements 
to the given sum.
-> pair consists of elements from each list

Please help those brothers to develop a program, that takes 
two sorted lists as input and return a pair as output.

Input Format:
-------------
size of list_1
list_1 values
size of list_2
list_2 values
closest number

Output Format:
--------------
comma-separated pair

Sample Input-1:
---------------
4
1 4 5 7
4
10 20 30 40
32
Sample Output-1
---------------
1,30

Sample Input-2
---------------
3
2 4 6
4
5 7 11 13
15

*/

import java.util.*;
class Test{
    public static int[] closePair(int n1,int n2,int key,int[] arr1,int[] arr2){
        //we want min diff so initialize to max value
        int diff = Integer.MAX_VALUE;
        //to store indexes
        int ind1 = 0,ind2=0;
        int start = 0,end = n2-1;
        int[] res = new int[2];
        while(start < n1){
            int abs = Math.abs(arr1[start]+arr2[end] - key);
            if(end >= 0 && abs < diff){
                diff = abs;
                res[0] = arr1[start];
                res[1] = arr2[end];
                end--;
            }
            else{
                start++;
            }
        }
        return res;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i=0;i<n2;i++){
            arr2[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int[] res = closePair(n1,n2,key,arr1,arr2);
        System.out.println(res[0]+","+res[1]);
    }
}
