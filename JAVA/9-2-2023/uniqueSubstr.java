import java.util.*;
class Test{
    public static Set<String> set = new HashSet<>();
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        for(int i = 1;i<=s.length();i++){
            StringBuffer sb = new StringBuffer("");
            for(int j = 0;j<i;j++){
                sb.append(s.charAt(j));
            }
            fn(sb.toString());
            for(int j = i;j<s.length();j++){
                sb.deleteCharAt(0);
                //System.out.println(sb.toString());
                sb.append(s.charAt(j));
                fn(sb.toString());
            }
        }
        //System.out.println(set);
        System.out.println(set.size());
        
    }
    
    public static void fn(String s){
        Map<Character,Integer> m = new HashMap<>();
        for(int i=0;i<s.length();i++){
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        }
        //System.out.println(m);
        int v = m.get(s.charAt(0));
        for(int i :m.values()){
             if(i!=v) return;
        }
            set.add(s);
    }
    
}
