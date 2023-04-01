import java.util.*;

class TreapNode {
    int data;
    int priority;
    TreapNode left;
    TreapNode right;

    TreapNode(int data) {
        this.data = data;
        this.priority = new Random().nextInt(1000);
        this.left = this.right = null;
    }
}

class Treap {
    static int k;

    public static TreapNode rotateLeft(TreapNode root) {
        TreapNode R = root.right;
        TreapNode X = R.left;
        R.left = root;
        root.right = X;
        return R;
    }

    public static TreapNode rotateRight(TreapNode root) {
        TreapNode L = root.left;
        TreapNode Y = L.right;
        L.right = root;
        root.left = Y;
        return L;
    }

    public static TreapNode insertNode(TreapNode root, int data) {
        if (root == null) {
            return new TreapNode(data);
        }
        if (data <= root.data) {
            root.left = insertNode(root.left, data);
            if (root.left.priority > root.priority) {
                root = rotateRight(root);
            }
        } else {
            root.right = insertNode(root.right, data);
            if (root.right.priority > root.priority) {
                root = rotateLeft(root);
            }
        }
        return root;
    }

    static void inorder(TreapNode root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
             Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            heights.add(sc.nextInt());
        }
        Collections.sort(heights, Collections.reverseOrder());
        System.out.println(heights.get(p-1));
    }
}
