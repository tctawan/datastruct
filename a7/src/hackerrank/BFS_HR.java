package hackerrank;

import java.io.IOException;
import java.util.*;

public class BFS_HR {

    static int[] bfs(int n, int m, int[][] edges, int s) {

        HashMap<Integer,HashSet<Integer>> verticesMap = new HashMap<>();
        //Making a map ; Mapping scrs to its nbrs.
        for(int[] edge : edges){

            int src = edge[0]; int nbr =edge[1];
            HashSet<Integer> setforscr = verticesMap.get(src);
            HashSet<Integer> setfornbr = verticesMap.get(nbr);

            if(setforscr == null){
                setforscr = new HashSet<>();
            }

            if(setfornbr == null){
                setfornbr = new HashSet<>();
            }

            setfornbr.add(src);
            setforscr.add(nbr);
            verticesMap.put(src,setforscr);
            verticesMap.put(nbr,setfornbr);
        }

        //Making another map; Mapping vtxes to its dist. from start.
        //Using bfs
        HashSet<Integer> frontier = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer,Integer> lvlMap = new HashMap<>();
        int lvl = 1;
        frontier.add(s);
        visited.add(s);

        while (!frontier.isEmpty()){

            frontier = findNrbs(verticesMap,frontier);
            frontier.removeAll(visited);

            for(int vertex: frontier){
                lvlMap.put(vertex,lvl*6);
            }

            visited.addAll(frontier);
            lvl += 1;
        }

        //putting all info into list
        int[] ans = new int[n-1];
        int i = 0;
        int vertex = 1;

        while (vertex<=n){

            if(vertex != s){
                Integer dis = lvlMap.get(vertex);
                if (dis == null){
                    dis = -1;
                }
                ans[i] = dis;
                i++;
            }
            vertex++;

        }
        return ans;

    }
    // Method to return set of neighbours of vertices
    static HashSet<Integer> findNrbs(HashMap<Integer,HashSet<Integer>> vm ,HashSet<Integer> vertices){

        HashSet<Integer> union = new HashSet<>();

        for(int source: vertices){

            HashSet<Integer> nbrsSet= vm.get(source);

            if(nbrsSet == null){
                break;
            }

            for(int nbr: nbrsSet){
                union.add(nbr);
            }
        }

        return union;

    }


//    public static void main(String[] args) throws IOException {
//
//        Scanner scanner = new Scanner(System.in);
//        int q = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int qItr = 0; qItr < q; qItr++) {
//            String[] nm = scanner.nextLine().split(" ");
//
//            int n = Integer.parseInt(nm[0]);
//
//            int m = Integer.parseInt(nm[1]);
//
//            int[][] edges = new int[m][2];
//
//            for (int i = 0; i < m; i++) {
//                String[] edgesRowItems = scanner.nextLine().split(" ");
//                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//                for (int j = 0; j < 2; j++) {
//                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
//                    edges[i][j] = edgesItem;
//                }
//            }
//
//            int s = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            int[] result = bfs(n, m, edges, s);
//            System.out.println(Arrays.toString(result));
//        }
//
//        scanner.close();
//    }
}
