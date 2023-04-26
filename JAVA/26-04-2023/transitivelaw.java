import java.util.*;
class DSU {
    int[] parent;
    int[] rank;

    public DSU(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int findSet(int x) {
        if (parent[x] != x) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
    
        if (px == py) {
            return;
        }
    
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }
}
class Transitive
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        DSU dsu = new DSU(26);
        for(String comp : str.split(" "))
        {
            int a = comp.charAt(0)-'a';
            int b = comp.charAt(3)-'a';
            if(comp.charAt(1)!='!')
           
                dsu.union(a,b);
        }
        boolean flag=true;
        for(String comp : str.split(" "))
        {
            if(comp.charAt(1)=='!'){
                int a = comp.charAt(0)-'a';
                int b = comp.charAt(3)-'a';
                if(dsu.findSet(a) == dsu.findSet(b))
                {
                    // System.out.println(a+" "+b);
                    flag=false;
                    break;
                }
            }
        }
        System.out.println(flag);
    }
}
