/*You are given an integer array nums and two integers minK and maxK.

A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

The minimum value in the subarray is equal to minK.
The maximum value in the subarray is equal to maxK.
Return the number of fixed-bound subarrays.

A subarray is a contiguous part of an array.
 input = 4
  1 1 1 1 
  1
  1
  output = 10


Example 1:

Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
Output: 2
Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
Example 2:

Input: nums = [1,1,1,1], minK = 1, maxK = 1
Output: 10
Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
 
Constraints:
2 <= nums.length <= 10^5
1 <= nums[i], minK, maxK <= 10^6
*/

//its kind of sliding window problem, but can be solved with 3 pointers approach
#include <bits/stdc++.h>
using namespace std;

int boundedSubArrays(int arr[],int n,int minK,int maxK){
    int min_ind=-1,max_ind=-1,not_ind=-1;
    int res=0;
    for(int i=0;i<n;i++){
        if(arr[i]<minK || arr[i]>maxK){//if our element is not following the condition of min and max
            not_ind = i;
        }
        if(arr[i]==minK){//if the curr element is min in subarray
            min_ind=i;
        }
        if(arr[i]==maxK){//if curr element is max in subarray
            max_ind = i;
        }
        //counting no of subarrays 
        res += max(0,min(min_ind,max_ind)-not_ind);
    }
    return res;
}

int main(){
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int minK,maxK;
    cin>>minK>>maxK;
    cout<<boundedSubArrays(arr,n,minK,maxK)<<endl;
}
