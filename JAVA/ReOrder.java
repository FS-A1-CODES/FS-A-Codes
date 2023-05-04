/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color
are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function and use two pointer approach.
sample cases
example 1
input = 8
0 1 2 0 1 2 2 1
output = 0 0 1 1 1 2 2 2
example 2
input = 5
1 2 1 2 1
output = 1 1 1 2 2
*/

import java.util.*;
class Colour
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println(arraySort(arr));
    }
    public static String arraySort(int arr[])
    {
        int start=0,n=arr.length;
        int end=n-1,ind=0;
        while(ind<=end)
        {
            if(arr[ind]==0)
            {
                swap(start,ind,arr);
                start++;
                ind++;
            }
            else if(arr[ind]==1)
            {
                ind++;
            }
            else{
                swap(end,ind,arr);
                end--;
            }
        }
        return Arrays.toString(arr);
    }
    public static void swap(int a,int b,int arr[])
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]=temp;
    }
}
