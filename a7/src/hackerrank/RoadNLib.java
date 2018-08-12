package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RoadNLib {

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

        if(c_lib<c_road){
            long x = n;
            return x*c_lib;
        }
        int[] rank = new int[n+1];
        int[] id = new int[n+1];


        for(int i=1;i<id.length; i++){
            id[i] = i;
            rank[i] = 1;
        }


        for(int[] city : cities){

            int cityA = city[0]; int cityB = city[1];

            if(find(id,id[cityA]) != find(id,id[cityB])){
                union(id,rank,cityA,cityB);
            }
        }
//        System.out.println("array id == " +Arrays.toString(id));

        HashMap<Integer,Long> connectedTown = new HashMap<>();

        for(int i = 1; i<id.length; i++){
            int root = find(id,id[i]);
            Long count = connectedTown.get(root);
            if(count == null){
                count = (long)0;
            }
            count++;
            connectedTown.put(root,count);
        }

//        System.out.println("connected Town == " +connectedTown.toString());

        long buildRoadAndLib = 0;

        for(int root : connectedTown.keySet() ){
            buildRoadAndLib += (connectedTown.get(root)-1)*c_road + c_lib;

        }

        return buildRoadAndLib;

    }

    static int find(int[] id , int v ){

        if(id[v] == v){
            return v;
        }
        id[v] = find(id,id[v]);
        return id[v];
    }

    static void union(int[] id ,int[] rank, int p, int q){

        int rp = find(id,p); int rq = find(id,q);

        if(rank[rp] == rank[rq]){
            rank[rp]++;
            id[rq] = rp;
        }else if (rank[rp] < rank[rq]){
            id[rp] = rq;
        }else {
            id[rq] = rp;
        }

    }
}
