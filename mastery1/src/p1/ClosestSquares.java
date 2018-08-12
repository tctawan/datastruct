package p1;

import java.util.*;

public class ClosestSquares {

    public static long closestSquares(int[] a){

        long[] b = new long[a.length];
        for(int i =0; i<b.length; i++){
            long n = a[i];
            b[i] = n*n;
        }
        Arrays.sort(b);

        long mindiff =Long.MAX_VALUE;

        for(int i=0;i<b.length-1; i++){
            long b1 = b[i];
            long b2 = b[i+1];



            if(b2-b1<mindiff){
                mindiff = b2-b1;
            }

        }
        System.out.println(mindiff);
        return mindiff;
    }

    public static void main(String[] args) {
        int[] test0 = {5, 9, 1, 11, 2, -9};
        int expected = 500;

        System.out.println("verdict: "+(expected==closestSquares(test0)));
    }
}
