package p1;

import java.util.*;

public class ParenPairs {

    public static int[] match(String ex) {
        String[] brackets= ex.split("");
        int[] ans = new int[brackets.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<brackets.length; i++){
            String bracket = brackets[i];
            if(bracket.equals("(")){
                s.push(i);
            }else {
                int open_index= s.pop();
                int close_index = open_index-i;
                ans[open_index] = i;
                ans[i] = close_index;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String st = "()(()(()))";
        int[] expcted = {1, -1, 9, 4, -1, 8, 7, -1, -3, -7};
        int[] result = match(st);

        String st2 = "(()()(()))";
        int[] expcted2 = {9, 2, -1, 4, -1, 8, 7, -1, -3, -9};
        int[] result2 = match(st2);

        System.out.println("Verdict: "+ Arrays.equals(expcted, result));
        System.out.println("Verdict: "+ Arrays.equals(expcted2, result2));
        // TODO: Write a lot more tests
    }
}
