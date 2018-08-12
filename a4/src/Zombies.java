import java.util.Arrays;

public class Zombies {
    public static int countBad(int[] hs){return helper(hs).first;}

    public static Pair<Integer,int[]> helper(int[] hs){
        if(hs.length == 1){
            Pair<Integer,int[]> p = new Pair<>(0,hs);
            return p;
        }else{
            int n = hs.length;
            int m = n/2;
            int[] leftA = Arrays.copyOfRange(hs,0,m);
            int[] rightA = Arrays.copyOfRange(hs,m,n);
            Pair<Integer,int[]> pleft = helper(leftA);
            Pair<Integer,int[]> pright = helper(rightA);
            Pair<Integer,int[]> newp = merge(pleft,pright);
            return newp ;


        }
    }

    public static Pair<Integer, int[]> merge(Pair<Integer,int[]> pleft, Pair<Integer,int[]> pright){
        int[] a = pleft.second;
        int[] b = pright.second;
        int count =pleft.first+pright.first;
        int leftoverA = a.length;
        int[] sorted = new int[a.length+b.length];
        int ai = 0; int bi =0; int si = 0;
        while(ai < a.length && bi< b.length){
            if(a[ai] > b[bi]){
                sorted[si++] = a[ai++];
                leftoverA -= 1;
            }
            else{
                sorted[si++] = b[bi++];
                count += leftoverA;
            }
        }
        while(ai<a.length){sorted[si++] = a[ai++];}
        while(bi<b.length){ sorted[si++ ] = b[bi++];}
        Pair<Integer,int[]> newp = new Pair<>(count, sorted);
        return newp;
    }


//    public static void main(String[] args) {
//        Pair<Integer, String> p = new Pair<>(73001, "Hello World");
//        System.out.println(p);
//        Integer theIntPart = p.first;
//        String theStrPart = p.second;
//        System.out.println(theStrPart);
//        System.out.println(theIntPart);
//    }
//        public static void main(String[] args) {
//        int[] a ={1, 7, 22, 13, 25, 4, 10, 34, 16, 28, 19,31};
//            System.out.println(countBad(a));
//
//        }
}
