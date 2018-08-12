package p4;

import java.lang.reflect.Array;
import java.util.*;

//incomplete
public class PerfectHiding {
    public static int bestSpotDistance(int n, List<WeightedEdge> flights) {


        HashMap<Integer,HashSet<int[]>> adjTable = new HashMap<>();
        for(WeightedEdge we : flights){
            int f= we.first; int t = we.second; int w = we.cost;
            HashSet<int[]> nbrs = adjTable.get(f);
            if(nbrs == null ){
                nbrs = new HashSet<>();
            }
            int[] t_w = {t,w};
            nbrs.add(t_w);
            adjTable.put(f,nbrs);
        }

        // check adjTable
//        System.out.println("AdjTable:");
//        for(int key: adjTable.keySet()){
//
//            HashSet<int[]> nbrs = adjTable.get(key);
//            System.out.printf(key + " = ");
//            for(int[] edge: nbrs){
//                System.out.print(Arrays.toString(edge) + " ");
//            }
//
//            System.out.println("");
//        }
//        System.out.println(flights);
        int ans = search(adjTable,1);
        System.out.println(ans);
        return ans;
    }


    public static int search(HashMap<Integer,HashSet<int[]>> adjTable, int v){

//        System.out.println("new stack for v = " + v );
        if(adjTable.get(v) == null){
//            System.out.println("enter if...");
            return 0;
        }else{
//            System.out.println("enter else...");
            HashSet<int[]> nbrs = adjTable.get(v);
            int max =0;
            for(int[] edge: nbrs){
                int wOfSubTree = search(adjTable,edge[0])+ edge[1];
//                System.out.println(v+": w of subtree = " + wOfSubTree);
                if(wOfSubTree > max){
                    max = wOfSubTree;
                }
//                System.out.println(v+": current max = "+ max);
            }
//            System.out.println("returning...");
            return max;
        }

    }


    public static WeightedEdge Edge(int u, int v, int c) {
        return new WeightedEdge(u, v, c);
    }

    public static void main(String[] args) {
        List<WeightedEdge> flights = new ArrayList<>(Arrays.asList(
                Edge(1, 4, 3),
                Edge(4,2,8),
                Edge(4,3,3),
                Edge(3,5,4),
                Edge(1,6,9),
                Edge(6,7,1)));
        int n = 4;
        int expcted = 11;
        boolean verdict = bestSpotDistance(n, flights)==expcted;
        System.out.println("verdict: "+verdict);
    }

}
