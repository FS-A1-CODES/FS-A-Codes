/*
Mr.Bob and Mr.Cob are working on a Military Mission. 
They are supposed to encode the message and send the message to the under-cover team.

Where Cob has written a script. Where the Script says double all the ascii values other than mentioned in the bracket
(97,101,105,111,117,65,69,73,79,85) and place a '#' in between. 

Help Bob in writing the Code. 


Sample Test Case-1
input = attack the enemy
output = at#tt#tac#ck#k t#th#he en#nem#my#y*/


import java.util.*;
class Encoder{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] c = {'a','e','i','o','u','A','E','I','O','U'};
        StringBuilder sb = new StringBuilder();
        List<Character> res = new ArrayList<>();
        for(int i=0;i<c.length;i++){
            res.add(c[i]);
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==' '){
                sb.append(" ");
            }
            else if(!res.contains(ch)){
                String str = ch+"#"+ch;
                sb.append(str);
            }
            else{
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }
}
