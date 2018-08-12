//public class DoubleTrouble2 {
//    public static Integer select(int[] A, int[] B, int k){
//        Integer a =selectHelper(A,B,k,k,0);
//        if(a == null){
//            return A[k];
//        }
//        return a;
//    }
//
//    public static Integer selectHelper(int[] A, int[] B, int k ,int hi, int lo){
//        if(hi-lo == 0){
//            return null;
//        }else{
//            int mid = (hi+lo)/2;
//            System.out.println(mid);
//            int check = A[k-mid];
//            int value = B[mid];
//
//            if(value < check ){
//                Integer ans = selectHelper(A,B,k,hi,mid+1);
//
//                if(ans == null){
//                    return Math.max(value,A[k-mid-1]);
//                }
//                return ans;
//            }else{
//                return selectHelper(A,B,k,mid,lo);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        int[] A = {1,4,6,15,35,40,41,42,43,47,51,60};
//        int[] B = {10,12,50,61,63,70,100,101,105};
////        System.out.println(rank(A,B,106));
//        System.out.println(select(A,B,13));
//    }
//}
