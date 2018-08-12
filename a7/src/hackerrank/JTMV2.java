package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class JTMV2 {

    static long journeyToMoon(int n, int[][] astronaut) {


        // Creating a unionFind structure which would help to build a map of astros for each country
        int[] id = new int[n];
        int[] size = new int[n];


        for(int i =0; i<n; i++){  // initial unionFind
            id[i] = i;
            size[i] = 1;
        }

        for(int[] pair : astronaut){ // Union the astros

            int l = pair[0]; int r = pair[1];
            union(l,r,id,size);
        }
        // Creating map of astros for each countires

        HashMap<Integer, Integer> astrosMap = new HashMap<>();
        for(int parent : id ){

            int root = root(parent,id);
            astrosMap.put(root,size[root]);
        }

        // counting
        long count = 0;
        for(int country :astrosMap.keySet()){

            int num = astrosMap.get(country);

            n = n-num;
            if(n == 0){
                break;
            }
            count += n*num;
        }

        return count;


    }

    static int root(int p, int[] id){
        int root = p;
        if(p == id[p]){
            return root;
        }else {
            id[p] = root(id[p],id);
            return id[p];
        }

    }

    static void union(int p, int q,int[] id , int[] sz){
        int rp = root(p,id); int rq = root(q,id);

        if(rp == rq) {
            return;
        }

        if(sz[rp] > sz[rq]){
            id[rq] = rp;
            sz[rp] += sz[rq];
        }
        else{
            id[rp] = rq;
            sz[rq] += sz[rp];
        }
    }
}
