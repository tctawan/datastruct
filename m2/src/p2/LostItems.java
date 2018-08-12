package p2;

import java.util.*;

public class LostItems {

    public static int[] lostItems(int[] a, int b[]) {
        Arrays.sort(a);
        int al=a.length;
        int bl =b.length;
        Arrays.sort(b);
        int ia = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int ib = 0; ib<b.length; ib++){
            if(ia < al && b[ib] == a[ia]){
                ia++;
            }else{
                ans.add(b[ib]);
            }
        }
        int[] finalans =new int[ans.size()];
        for(int i=0; i<finalans.length; i++){
            finalans[i] = ans.get(i);
        }
        return finalans;
    }

    public static void main(String[] args) {
//        int[] inA = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
//        int[] inB = {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
//        int[] expected = {204, 205, 206};

        int[] inA = {1,1,1,1,1,1,1,1,1};
        int[] inB = {1,1,1,1,1,1,1,1,1,1,1,1};
        int[] expected = {1,1,1};

        int[] yourOutput = lostItems(inA, inB);
        System.out.println("verdict: "+Arrays.equals(yourOutput, expected));
    }
}
