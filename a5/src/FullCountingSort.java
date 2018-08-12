import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class FullCountingSort {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] ori = new String[n][2];
        String[][] sorted = new String[n][2];
        int[] count = new int[100];
        int[] keyOrders = new int[n];

        for (int listNum = 0; listNum < n; listNum++) {
            String[] xs = br.readLine().split(" ");
            int key = Integer.parseInt(xs[0]);
            count[key]++;
            if(listNum < n/2){
                xs[1] = "-";
            }
            ori[listNum] = xs;
            keyOrders[listNum] = key;
        }
        //        System.out.println(Arrays.deepToString(ori));


//                System.out.println(Arrays.toString(count));

        //manipulate the count array for sorting
        for(int index = 0; index<count.length -1 ; index++){
            count[index +1] += count[index];
        }
//        System.out.println(Arrays.toString(count));

        //sorting using counting sort

        for(int i = 1 ; i<ori.length+1; i++ ){
            String[] pair = ori[ori.length-i];
            int key = keyOrders[ori.length-i];
            int newIndex = count[key] -1;
            count[key]--;
            sorted[newIndex] = pair ;
        }
//        System.out.println(Arrays.deepToString(sorted));
        //creating the string
        StringBuilder sb = new StringBuilder();
        for(String[] pair: sorted){
            sb.append(pair[1]);
            sb.append(" ");

        }
        sb.trimToSize();
        System.out.println(sb.toString());

        br.close();
    }
}
