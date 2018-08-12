package p4;

import java.util.*;

public class Manhattan {
    public static int distanceFromStart(String moves) {

        char[] ca = moves.toCharArray();
        int counta = 0;
        int countb  =0;
        for(char c: ca){
            if(c == 'N'){
                counta++;
            }else if(c == 'E'){
                countb++;
            }else if (c == 'S'){
                counta--;
            }else{
                countb--;
            }
        }
        return Math.abs(counta)+Math.abs(countb);

    }
    public static void main(String[] args) {
        String test = "WWWEWNNS"; // end up at 3 north, 2 west
        int expected = 4;
        System.out.println("verdict: " + (expected==distanceFromStart(test)));
    }
}
