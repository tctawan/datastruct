
public class RPal {

    public static int countRPal(int N){
        return helper(N)+1;
    }

    public static int helper(int N){
        if(N<= 1){
            return 0;
        }
        if(N<=3){
            return 1;
        }
        else{
            int side=0;
            int count=0;
            while(N>1){
                N -=2;
                side++;
                count += helper(side)+1;
            }
            return count;
        }
    }


    public static void main(String[] args) {
        System.out.println(countRPal(2));
    }
}
