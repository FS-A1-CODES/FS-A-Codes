/*In Turkey, an ice cream parlour gives an offer to a lucky kid.
The parlour keeps N ice cream cups in a row, and there are different flavours 
of icecreams, where i-th cup filled with the flavour[i] type of ice cream.
The kid can pick the continuous set of ice cream cups, where the cups are filled
with icecreams of utmost two different flavours. The kid wants to 
pick the maximum number of ice cream cups from the row.
You will be given the integer array, flavours[] of size N.
Your task is to help the kid to pick the maximum number of ice cream cups 
with at most two different flavours.
Input Format:
-------------
Line-1: An integer, number of icecreams.
Line-2: N space separated integers, flavours[] 
Output Format:
--------------
Print an integer result, maximum number of icecream cups can be picked.
Sample Input-1:
---------------
10
1 2 3 1 1 3 3 2 3 2
Sample Output-1:
----------------
5
Explanation:
------------
The kid can pick the continuous set of icecream cups as follows: 3 1 1 3 3
Where the cups are filled with two different flavours, 1 and 3.
Sample Input-2:
---------------
10
2 1 1 3 2 1 3 0 0 3
Sample Output-2:
----------------
4.*/
import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Main {
  public static int iceCreams(int n, int[] arr) {
    Map<Integer, Integer> mp = new HashMap<>();
    int i = 0;
    int j = 0;
    int mx = 1;
    while (j < n) {
      mp.put(arr[j], mp.getOrDefault(arr[j], 0) + 1);
      if (mp.size() <= 2) {
        mx = Math.max(mx, j - i + 1);
        j++;
      } else if (mp.size() > 2) {
        while (mp.size() > 2) {
          mp.put(arr[i], mp.get(arr[i]) - 1);
          if (mp.get(arr[i]) == 0) mp.remove(arr[i]);
          i++;
        }
        j++;
      }
    }
    return mx;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    System.out.println(iceCreams(n, arr));
  }
}
