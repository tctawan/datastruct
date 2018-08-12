package p3;

import java.util.*;

public class LeftSight {

    public static Integer[] lookLeft(int[] hs) {

        Stack<Integer> stack = new Stack<>();
        Integer[] lookLeft = new Integer[hs.length];

        for(int i =0; i<hs.length ; i++){
            int h = hs[i];
            Integer lowest = null;

            if(stack.size() != 0){
                lowest = stack.peek();
            }

            while (lowest != null && lowest < h) {
                stack.pop();
                if(stack.size() != 0){
                    lowest = stack.peek();
                }else {
                    lowest = null;
                }
            }
            lookLeft[i] = lowest;
            stack.add(h);
        }
//        System.out.println(Arrays.toString(lookLeft));

      return lookLeft;
    }

    public static void main(String args[]) {
      // sample test
      int[] hs = {3, 11, 5, 7, 2, 8};
      Integer[] expected = {null, null, 11, 11, 7, 11};
      System.out.println("verdict: " + Arrays.equals(expected, lookLeft(hs)));
    }
}
