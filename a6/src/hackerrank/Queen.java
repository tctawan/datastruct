package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Queen {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        HashMap<Integer,HashMap<Integer,int[]>> mapOfObs = new HashMap<>();
        HashSet<int[]> setOfObs = new HashSet<>();
        for(int[] obstacle: obstacles){
            setOfObs.add(obstacle);
            int obsRow = obstacle[0];
            int obsCol = obstacle[1];
            HashMap<Integer, int[]> innermap = mapOfObs.get(obsRow);
            if(innermap == null){
                innermap = new HashMap<>();
            }
            innermap.put(obsCol,obstacle);
            mapOfObs.put(obsRow,innermap);
        }
        int count =0 ;
        count += walkUp(n, k, r_q, c_q, mapOfObs,setOfObs);
        count += walkDown(n, k, r_q, c_q, mapOfObs,setOfObs);
        count += walkLeft(n, k, r_q, c_q, mapOfObs,setOfObs);
        count += walkRight(n, k, r_q, c_q, mapOfObs,setOfObs);
        count += walkLeftUp(n, k, r_q, c_q, mapOfObs,setOfObs);
        count += walkRightUp(n, k, r_q, c_q, mapOfObs,setOfObs);
        count += walkLeftDown(n, k, r_q, c_q, mapOfObs,setOfObs);
        count += walkRightDown(n, k, r_q, c_q, mapOfObs,setOfObs);
        return count ;

    }

    static int walkUp(int n, int k, int r_q, int c_q,HashMap<Integer,HashMap<Integer,int[]>> mapOfObs,HashSet<int[]> setOfObs) {
        int count = 0;
        int[] obs;
        while(r_q != n ) {
            r_q +=1;
            if(mapOfObs.get(r_q) == null){
                obs = new int[]{0};
            }else {
                obs = mapOfObs.get(r_q).get(c_q);
            }
            if(setOfObs.contains(obs)){
                break;
            }
            count += 1;
        }
        return count;
    }

    static int walkDown(int n, int k, int r_q, int c_q, HashMap<Integer,HashMap<Integer,int[]>> mapOfObs,HashSet<int[]> setOfObs) {
        int count = 0;
        int[] obs ;
        while( r_q != 1) {
            r_q -=1;

            if(mapOfObs.get(r_q) == null){
                obs = new int[]{0};
            }else {
                obs = mapOfObs.get(r_q).get(c_q);
            }
            if(setOfObs.contains(obs)){
                break;
            }

            count += 1;
        }
        return count;
    }

    static int walkLeft(int n, int k, int r_q, int c_q, HashMap<Integer,HashMap<Integer,int[]>> mapOfObs,HashSet<int[]> setOfObs) {
        int count = 0;
        int[] obs ;
        while( c_q != 1) {
            c_q -=1;
            if(mapOfObs.get(r_q) == null){
                obs = new int[]{0};
            }else {
                obs = mapOfObs.get(r_q).get(c_q);
            }
            if(setOfObs.contains(obs)){
                break;
            }
            count += 1;
        }
        return count;
    }
    static int walkRight(int n, int k, int r_q, int c_q, HashMap<Integer,HashMap<Integer,int[]>> mapOfObs,HashSet<int[]> setOfObs) {
        int count = 0;
        int[] obs ;
        while( c_q != n) {
            c_q +=1;
            if(mapOfObs.get(r_q) == null){
                obs = new int[]{0};
            }else {
                obs = mapOfObs.get(r_q).get(c_q);
            }
            if(setOfObs.contains(obs)){
                break;
            }
            count += 1;
        }
        return count;
    }

    static int walkLeftUp(int n, int k, int r_q, int c_q, HashMap<Integer,HashMap<Integer,int[]>> mapOfObs,HashSet<int[]> setOfObs) {
        int count = 0;
        int[] obs ;
        while( r_q != n && c_q != 1) {
            r_q += 1;
            c_q -=1;
            if(mapOfObs.get(r_q) == null){
                obs = new int[]{0};
            }else {
                obs = mapOfObs.get(r_q).get(c_q);
            }
            if(setOfObs.contains(obs)){
                break;
            }
            count += 1;
        }
        return count;
    }

    static int walkRightUp(int n, int k, int r_q, int c_q, HashMap<Integer,HashMap<Integer,int[]>> mapOfObs,HashSet<int[]> setOfObs) {
        int count = 0;
        int[] obs ;
        while( r_q != n && c_q != n) {
            r_q += 1;
            c_q +=1;
            if(mapOfObs.get(r_q) == null){
                obs = new int[]{0};
            }else {
                obs = mapOfObs.get(r_q).get(c_q);
            }
            if(setOfObs.contains(obs)){
                break;
            }
            count += 1;
        }
        return count;
    }

    static int walkLeftDown(int n, int k, int r_q, int c_q, HashMap<Integer,HashMap<Integer,int[]>> mapOfObs,HashSet<int[]> setOfObs) {
        int count = 0;
        int[] obs ;
        while( r_q != 1 && c_q != 1) {
            r_q -= 1;
            c_q -=1;
            if(mapOfObs.get(r_q) == null){
                obs = new int[]{0};
            }else {
                obs = mapOfObs.get(r_q).get(c_q);
            }
            if(setOfObs.contains(obs)){
                break;
            }
            count += 1;
        }
        return count;
    }

    static int walkRightDown(int n, int k, int r_q, int c_q, HashMap<Integer,HashMap<Integer,int[]>> mapOfObs,HashSet<int[]> setOfObs) {
        int count = 0;
        int[] obs ;
        while( r_q != 1 && c_q != n) {
            r_q -= 1;
            c_q +=1;
            if(mapOfObs.get(r_q) == null){
                obs = new int[]{0};
            }else {
                obs = mapOfObs.get(r_q).get(c_q);
            }
            if(setOfObs.contains(obs)){
                break;
            }
            count += 1;
        }
        return count;
    }



//    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//
//        String[] nk = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nk[0]);
//
//        int k = Integer.parseInt(nk[1]);
//
//        String[] r_qC_q = scanner.nextLine().split(" ");
//
//        int r_q = Integer.parseInt(r_qC_q[0]);
//
//        int c_q = Integer.parseInt(r_qC_q[1]);
//
//        int[][] obstacles = new int[k][2];
//
//        for (int i = 0; i < k; i++) {
//            String[] obstaclesRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 2; j++) {
//                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
//                obstacles[i][j] = obstaclesItem;
//            }
//        }
//
//        int result = queensAttack(n, k, r_q, c_q, obstacles);
//        System.out.println(result);
//        scanner.close();
//    }
}
