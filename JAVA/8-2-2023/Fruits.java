/*
/*You are visiting a farm that has a single row of fruit trees arranged from left to right.
 The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. 

However, the owner has some strict rules that you must follow:
You only have two baskets, and each basket can only hold a single type of fruit. 
There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
 while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Sample cases:

case 1:
Input: 
3
1 2 1
Output: 3
Explanation: We can pick from all 3 trees.

Case  2:
Input: 
4
0 1 2 2 
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].

case 3:
Input: 
 5
1 2 3 2 2
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
*/

import java.util.*;
class Test{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        System.out.println(totalFruit(arr));
    }

    public static int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> fruitCount = new HashMap<>();
        while (right < fruits.length) {
            int fruit = fruits[right];
            fruitCount.put(fruit, fruitCount.getOrDefault(fruit, 0) + 1);
            while (fruitCount.size() > 2) {
                int leftFruit = fruits[left];
                fruitCount.put(leftFruit, fruitCount.get(leftFruit) - 1);
                if (fruitCount.get(leftFruit) == 0) {
                    fruitCount.remove(leftFruit);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
            right++;
        }
        return maxFruits;
    }

}
