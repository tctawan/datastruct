package hackerrank;

import java.util.HashSet;
import java.util.Scanner;

public class ConnectedCells {

    static int connectedCell(int[][] matrix) {

        int max = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int y=0; y<matrix.length; y++){
            for(int x=0; x<matrix[0].length; x++){
                int count = 0;
                if(matrix[y][x] == 1) {
                    count = bfs(matrix, visited, x, y);
//                    System.out.println("total count ==  " + count);
//                    System.out.println(x + " " + y);
                }
                if(count> max){
                    max = count;
                }
            }
        }
        return max;

    }

    static int bfs(int[][] matrix, boolean[][] visited,int x, int y){
        int count = 0;

        if(x<0 || y<0 ){
            return 0;
        }

        if(x >= matrix[0].length || y >= matrix.length){
            return 0;
        }

        if(matrix[y][x] == 0){
            return 0;
        }

        if(!visited[y][x]){
            count ++;
            visited[y][x] = true;
            count +=bfs(matrix,visited,x,y+1);
            count +=bfs(matrix,visited,x,y-1);
            count +=bfs(matrix,visited,x+1,y);
            count +=bfs(matrix,visited,x-1,y);
            count +=bfs(matrix,visited,x+1,y+1);
            count +=bfs(matrix,visited,x+1,y-1);
            count += bfs(matrix,visited,x-1,y+1);
            count +=bfs(matrix,visited,x-1,y-1);
//            System.out.println("along the way count == " + count);
        }

        return count;

    }
}
