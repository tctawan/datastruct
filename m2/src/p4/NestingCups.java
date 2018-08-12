package p4;

import java.util.*;

public class NestingCups {
    public static String[] orderNestingCups(String[] measurements) {
        HashMap<Integer,String> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();

        for(int i = 0; i<measurements.length; i++){
            String[] splt = measurements[i].split(" ");
            int r;
            if(Character.isDigit(measurements[i].charAt(0))){

                r = Integer.parseInt(splt[0])/2;
                map.put(r,splt[1]);
            }else{

                r = Integer.parseInt(splt[1]);
                map.put(r,splt[0]);
            }
            set.add(r);
        }
        String[] ans = new String[set.size()];
        int i = 0;
        for(int rad: set ){
            ans[i] = map.get(rad);
            i++;
        }
        System.out.println(set);
        System.out.println(map);
        return ans;
    }

    public static void main(String[] args) {
        String[] example = {"red 10", "10 blue", "green 7"};
        String[] expcted = {"blue", "green", "red"};
        System.out.println("Verdict: "+ Arrays.equals(orderNestingCups(example), expcted));
        String[] example2 = {"yellow 18", "8 green", "12 gray", "teal 20", "24 vanilla", "100 koolaid"};
        String[] expcted2 = {"green", "gray", "vanilla", "yellow", "teal", "koolaid"};
        System.out.println("Verdict: "+ Arrays.equals(orderNestingCups(example2), expcted2));
    }
}
