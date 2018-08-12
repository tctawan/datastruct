package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Kruskal_MST {

    static class Edge implements Comparable<Edge>{
        int from, to , weight;

        @Override
        public int compareTo(Edge o) {

            if(this.weight == o.weight){
                return (this.from+this.to) - (o.from+o.to);
            }

            return this.weight - o.weight;
        }

        public String toString(){
            return String.format("["+this.weight+ ", "+ this.from + ", " + this.to+"]");
        }
    }

    static long mst(int[] gFrom, int[] gTo, int[] gWeight){

        Edge[] edges = new Edge[gFrom.length];

        for(int i = 0; i<gFrom.length; i++){
            Edge e  = new Edge();
            e.from= gFrom[i];
            e.to = gTo[i];
            e.weight = gWeight[i];

            edges[i] = e;
        }

        int[] id = new int[gFrom.length+1];
        int[] rank = new int[gFrom.length+1];

        for(int i =1 ;i<id.length; i++){
            id[i] = i;
            rank[i] = 1;
        }

        Arrays.sort(edges);


        long totalMin = 0;
        for(int i =0; i<edges.length; i++){

            Edge e = edges[i];
            int f = e.from; int t = e.to; int w = e.weight;

            if (find(id, f) != find(id, t)) {
                union(id, rank, f, t);
                totalMin += w;
            }

        }
        return totalMin;
    }

    static int find(int id[], int v){

        if(id[v] == v){
            return v;
        }
        else{
            id[v] = find(id,id[v]);
            return id[v];
        }
    }

    static void union(int[] id, int[] rank, int p, int q){

        int rp = find(id,p); int rq = find(id,q);

        if(rank[rp] == rank[rq] ){
            id[rq] = rp;
            rank[rp]++;
        }
        else if(rank[rp] < rank[rq]){
            id[rp] =rq;
        }else {
            id[rq] = rp;
        }
    }

}

