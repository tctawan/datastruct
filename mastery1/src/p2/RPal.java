package p2;

import java.util.*;

public class RPal {
    public static int numberOfProperRPal(int n) {
        if(n == 1){
            return 0;
        }
        int ans =helper(n)+1;
        System.out.println(ans);

        return ans;
    }

    public static int helper(int n){

        if(n <= 3){
            return 0;
        }else{
            int side = 0;
            int count = 0;
            while(n>1){
                n -= 2;
                side++;
                if(side != 1 && n != 1) {
                    count += helper(side)+1;
                }
//                System.out.println("n is : " + n+ " , side is : " + side);
//                System.out.println("count : " + count);
//                System.out.println("--------------------------------");
            }
            return count;
        }

    }



    public static void main(String[] args) {
        int[] tests = {1,2,3,4,5,6,7,14};
        int[] expected = {0,1,1,2,1,3,2,11};

        for (int i=0;i<tests.length;i++) {

            System.out.println("verdict: "+(expected[i]==numberOfProperRPal(tests[i])));
        }
    }
}
