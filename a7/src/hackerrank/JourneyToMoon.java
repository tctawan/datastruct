package hackerrank;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class JourneyToMoon {

    static long journeyToMoon(int n, int[][] astronaut) {


        HashSet<Integer> allAstros = createSet(n); // use it for making sure no one is left out
//        System.out.println(allAstros.toString());

        //Making Adj.Table.
        HashMap<Integer,HashSet<Integer>> adjTable = new HashMap<>();

        for(int[] pair : astronaut){

            int src = pair[0]; int nbr = pair[1];

            HashSet<Integer> setforSrc= adjTable.get(src);
            if(setforSrc == null){
                setforSrc = new HashSet<>();
            }

            HashSet<Integer> setforNbr= adjTable.get(nbr);
            if(setforNbr == null){
                setforNbr = new HashSet<>();
            }

            setforSrc.add(nbr);
            setforNbr.add(src);

            adjTable.put(src,setforSrc);
            adjTable.put(nbr,setforNbr);
        }
//        System.out.println(adjTable.toString());

        //Use DFS to get a table of countries and their astros.

        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, Integer> tableOfAstros = new HashMap<>();
        int country = 0;

        for (int v: allAstros ){
            if(!visited.contains(v)){
                int numOfAstros = 0;
                int astroPerCountry = dfs(adjTable,visited,v,numOfAstros);
                tableOfAstros.put(country, astroPerCountry);
                country += 1;
            }
        }

//        System.out.println(tableOfAstros.toString());

        //Use the tableOfAstros to do counting
        long count =0;
        int remaining = n;
        for(int c : tableOfAstros.keySet()){

             remaining = remaining- tableOfAstros.get(c);

            if(remaining == 0){
                break;
            }

            count += tableOfAstros.get(c)*(remaining);
        }

        return count;
    }

    //dfs return number of astros per country
    static int dfs( HashMap<Integer,HashSet<Integer>> adjTable, HashSet<Integer> visited,int v, int numAstros){

        if(!visited.contains(v)){
            visited.add(v);
            numAstros += 1;
            HashSet<Integer> setOfnbrs = adjTable.get(v);
            if(setOfnbrs == null){
                return 1;
            }

            for(int nbr : setOfnbrs){
               numAstros = dfs(adjTable,visited,nbr,numAstros);
            }
        }
        return numAstros;
    }

    static HashSet<Integer> createSet(int n){
        HashSet<Integer> setOfInt = new HashSet<>();
        for(int i=0; i<n; i++){
            setOfInt.add(i);
        }
        return  setOfInt;
    }

//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//
//        String[] np = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(np[0]);
//
//        int p = Integer.parseInt(np[1]);
//
//        int[][] astronaut = new int[p][2];
//
//        for (int i = 0; i < p; i++) {
//            String[] astronautRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 2; j++) {
//                int astronautItem = Integer.parseInt(astronautRowItems[j]);
//                astronaut[i][j] = astronautItem;
//            }
//        }
//
//        long result = journeyToMoon(n, astronaut);
//
//        System.out.println(result);
//
//        scanner.close();
//    }
}
