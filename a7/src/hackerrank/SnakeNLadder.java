package hackerrank;

import java.awt.print.PrinterGraphics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SnakeNLadder {

    // Complete the quickestWayUp function below.
    static int quickestWayUp(int[][] ladders, int[][] snakes) {

        HashMap<Integer ,Integer> ladderNsnake = new HashMap<>();
        for(int[] ladder : ladders){

            ladderNsnake.put(ladder[0], ladder[1]);
        }

        for(int[] snake : snakes){

            ladderNsnake.put(snake[0], snake[1]);
        }

        // Make adj.table
        HashMap<Integer,HashSet<Integer>> adjTable = new HashMap<>();
        for(int i =1; i<100; i++){

            if(ladderNsnake.containsKey(i)){
                continue;
            }

            HashSet<Integer> nbrs = new HashSet<>();
            for (int add= 1; add<=6 ; add++){
                int sum = i+add;

                if(ladderNsnake.get(sum) != null){
                    sum = ladderNsnake.get(sum);
                }

                nbrs.add(sum);
            }
            adjTable.put(i,nbrs);
        }

        //BFS and keep track of when we reach 100

        HashSet<Integer> frontier = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        frontier.add(1); visited.add(1);

        int count = 0;
        while (!visited.contains(100)){
            if(count > 100){
                return -1;
            }
            frontier = nbrs(adjTable, frontier);
            frontier.removeAll(visited);
            visited.addAll(frontier);
            count++ ;
        }
        return count;

    }

    static HashSet<Integer> nbrs(HashMap<Integer,HashSet<Integer>> adjTable, HashSet<Integer> frontier){

        HashSet<Integer> union = new HashSet<>();

        for (int vtx : frontier){
            union.addAll(adjTable.get(vtx));
        }

        return union;
    }

}
