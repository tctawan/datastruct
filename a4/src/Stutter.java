public class Stutter {
    public static boolean isSubstr(String a, String b){
        int ia = 0;
        for(int ib =0; ib<b.length(); ib++){
            if(a.length()>0) {
                if (b.charAt(ib) == a.charAt(ia)) {
                    ia += 1;
                }
                if (ia == a.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String stutter(String A, int k){
        String B = "";
        for(int i=0; i<A.length(); i++){
            char l = A.charAt(i);
            for(int r=0; r<k; r++){
                B += l;
            }
        }
        return B;
    }

    public static int maxStutter(String a, String b){
        int maxStut = b.length()/a.length();
        return helper(a,b,maxStut,0);
    }

    public static int helper(String a, String b, int hi, int lo){
        if(hi-lo == 0){
            return 0;
        }else if(hi-lo == 1){
            if(isSubstr(a,b)){
                return 1;
            }
            return 0;
        }else{
            int mid = (hi+lo)/2;
            String temp = stutter(a,mid);
            if(isSubstr(temp,b)){
                temp = stutter(a, mid+1);
                if(isSubstr(temp,b)){
                    return helper(a,b,hi,mid);
                }
                return mid;
            }else{
                return helper(a,b,mid,lo);
            }
        }
    }

    public static void main(String[] args) {
        String a = "e";
        String b = "e";
        System.out.println(maxStutter(a,b));
//        System.out.println(stutter("a",0));
    }
}
