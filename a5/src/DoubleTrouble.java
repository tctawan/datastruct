public class DoubleTrouble {
    public static int rank(int[] A, int[] B, int e){
        int countA = helperRank(A,e,A.length,0);
        int countB = helperRank(B,e,B.length, 0);
        return countA+countB;
    }
    public static int helperRank(int[] A, int e, int hi, int lo){
        int check = hi-lo;
        if (check == 0){
            return hi;
        }
        if(check == 1){
            if(e>A[lo]){
                return hi;
            }else {
                return lo;
            }
        }else{
            int mid = (hi+lo)/2;
            int num = A[mid];
            if(e < num){
                return helperRank(A,e,mid,lo);
            }else if(e == num){
                return mid;
            }else {
                return helperRank(A,e,hi,mid+1);
            }
        }
    }
    public static Integer select(int[] A, int[] B, int k){
        Integer fromA = helperSelect(A,B,k,A.length,0);
        System.out.println(fromA);
        if(fromA == null){
            Integer fromB = helperSelect(B,A,k,B.length, 0);
            return fromB;
        }
        return fromA;

    }

    public static Integer helperSelect(int[] A,int[] B,int rank,int hi, int lo){
        if(hi-lo == 0){
            return null;
        }else {
            int mid = (hi+lo)/2;
            int e = A[mid];
            int e_rank =  rank(A,B,e);
            if(e_rank == rank){
                return e;
            }else if(e_rank < rank){
                return helperSelect(A,B,rank,hi,mid+1);
            } else {
                return helperSelect(A,B,rank,mid,lo);
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1,4,6,15,35,40,41,42,43,47,51,60};
        int[] B = {10,12,50,61,63,70,100,101,105};
//        System.out.println(rank(A,B,106));
        System.out.println(select(A,B,15));
    }
}
