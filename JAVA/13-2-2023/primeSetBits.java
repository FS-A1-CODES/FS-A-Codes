/*
Given two integers left and right, return the count of numbers in the inclusive range [left, right]
 having a prime number of set bits in their binary representation.

Recall that the number of set bits an integer has is the number of 1's present when written in binary.

For example, 21 written in binary is 10101, which has 3 set bits.
 

Example 1:

Input: 6  10
Output: 4
Explanation:
6  -> 110 (2 set bits, 2 is prime)
7  -> 111 (3 set bits, 3 is prime)
8  -> 1000 (1 set bit, 1 is not prime)
9  -> 1001 (2 set bits, 2 is prime)
10 -> 1010 (2 set bits, 2 is prime)
4 numbers have a prime number of set bits.
Example 2:

Input: 10 15
Output: 5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
5 numbers have a prime number of set bits.

*/

import java.util.*;
class Test{
    public static boolean isPrime(int n){
        int temp;
        int res=0;
        while(n>0){
            temp = n%2;
            if(temp==1){
                res++;
            }
            n/=2;
        }
        if(res==2){
            return true;
        }
        else if(res>2 && res%2!=0){
            return true;
        }
        return false;
    }
    public static int primeBits(int low,int high){
        int ans=0;
        for(int i=low;i<=high;i++){
            if(isPrime(i)){
                ans++;
            }
        }
        return ans;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        System.out.println(primeBits(low,high));
    }
}
