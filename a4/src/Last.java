public class Last {
    public static Integer binarySearchLast(int[] a, int k){
        return helper(a,k,0,a.length);

    }

    public static Integer helper(int[] a, int k, int low, int high){
        if (high-low == 0){
            return null;
        }else{
            int m = (high + low)/2;
            if(a[m] == k){
                Integer r = helper(a,k,m+1,high);
                if(r == null){
                    return m;
                }
                return r;

            }else if(a[m] > k){
                return helper(a,k,low,m);
            }else{
                return helper(a,k,m+1,high);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,1,1,1,1,1,1};
        Integer ans =binarySearchLast(a, 1);
        System.out.println( ans);
    }
}