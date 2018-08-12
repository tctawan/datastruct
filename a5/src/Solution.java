import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void sort(String[][] a) {
        for(int i =0; i<a.length/2; i++ ){
            a[i][1] = "-";
        }
        String[][] sorted = new String[a.length][2];
        int[] count = new int[10];
        //count each pair according to the num
        for(String[] sa : a){
            count[Integer.parseInt(sa[0])]++;
        }
        //modify count
        for(int i=0; i<count.length-1;i++){
            count[i+1] += count[i];
        }
        for(String[] sa : a){
            int pos = Integer.parseInt(sa[0]);
            sorted[count[pos]-1] = sa;
        }
        StringBuilder sb = new StringBuilder();
        for(String[] sa: sorted){
            sb.append(sa[1]);
        }
        System.out.println(sb.toString());


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int nItr = 0; nItr < n; nItr++) {
            String[] xs = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xs[0]);

            String s = xs[1];
        }

        scanner.close();
    }
}
