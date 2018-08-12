package hackerrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxSubASum {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {

        long sum = 0;
        long[] ps = new long[a.length];

        for(int i =0; i<a.length;i++){
            sum = (a[i] % m + sum)%m;
            ps[i] = sum;
        }
        long max = 0;
        TreeSet<Long> ts = new TreeSet<>();

        for(int i=0; i<ps.length; i++){
            ts.add(ps[i]);
            Long ub =ts.higher(ps[i]);
            if(ub != null){
                max= Math.max((ps[i] -ub +m)%m,max);
            }
            max = Math.max(max,ps[i]);
        }
        return max;

    }
}
