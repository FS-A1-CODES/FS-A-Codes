/*Mr. Parandamayya is working with Strings.
He is given a String S. He has to find the palindromes in S, 
A palindrome can be a substring of S (Strictly substrings only, not subsequences).
Your task is to find the count the number of palindromes can be formed from S.
NOTE: Count each occurence of palindromes if duplicate substrings found. 
Input Format:
-------------
A string S
Output Format:
--------------
Print an integer, number of palindromes.
Sample Input-1:
---------------
divider
Sample Output-1:
----------------
9
Explanation:
-------------
Palindromes are d, i, v, i, d, e, r, ivi, divid
Sample Input-2:
---------------
abcdef
Sample Output-2:
----------------
6
Explanation:
-------------
Palindromes are a, b, c, d, e, f.
*/
import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static int solve(String s, int[][] cnt, int i, int j) {
    if (i > j) return 1;
    if (cnt[i][j] != -1) return cnt[i][j];
    if (s.charAt(i) == s.charAt(j))
      return cnt[i][j] = solve(s, cnt, i + 1, j - 1);
    else
      return cnt[i][j] = 0;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    int n = s.length();
    int c = 0;
    int[][] cnt = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        Arrays.fill(cnt[i], -1);
        c += solve(s, cnt, i, j);
      }
    }
    System.out.println(c);
  }
}
