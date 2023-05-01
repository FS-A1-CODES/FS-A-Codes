/* 
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).
Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.

Example:1
Input: root = [6 2 8 0 4 7 9 -1 -1 3 5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example:2
Input: root = [6 2 8 0 4 7 9 -1 -1 3 5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example : 3
Input: root = [2 1], p = 2, q = 1
Output: 2
  */

import java.util.*;
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Ancestor {
    Node root;

    public Ancestor() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    public void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
    
    public int LCA(Node rt,int a,int b)
    {
        Node ans = findLCA(rt,a,b);
        return ans.data;
    }
    public Node findLCA(Node rt,int a, int b)
    {
        if(rt == null || rt.data==a || rt.data==b)
        {
            return rt;
        }
        Node left = findLCA(rt.left,a,b);
        Node right = findLCA(rt.right,a,b);
        
        if(left==null)
        {
            return right;
        }
        else if(right==null)
        {
            return left;
        }
        else
        {
            return rt;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sarr[] = sc.nextLine().split(" ");
        int n = sarr.length;
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = Integer.parseInt(sarr[i]);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        Ancestor tree = new Ancestor();
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                tree.insert(arr[i]);
            }
        }
        System.out.println(tree.LCA(tree.root,a,b));
    }
}
