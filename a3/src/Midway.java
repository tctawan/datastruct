public class Midway {

    public static long stepsRemaining(int[] diskPos){

        int correctPos = 0;
        int remaining = (int)Math.pow(2,diskPos.length)-1;
        boolean diskEven = false;
        boolean baseEven = true;

        if((diskPos.length)%2 == 0){
            diskEven = true;
            baseEven = false;
        }

        for(int i = diskPos.length-1; i>=0; i--){
            System.out.println("current pos : " + diskPos[i]+ " ,remaining : " + remaining);
            System.out.println("disk: "+ diskEven+", base: "+baseEven +" --- "+(i+1)+" : " +correctPos);
            if(diskPos[i] != correctPos){
                remaining -= Math.pow(2,i);

                if(baseEven){
                    if(diskEven){
                        correctPos = 1;
                    }else{
                        if(correctPos == 0){
                            correctPos = 2;
                        }else{
                            correctPos =0;
                        }
                    }
                }else{
                    if(!diskEven){
                        correctPos = 1;
                    }else{
                        if(correctPos == 0){
                            correctPos = 2;
                        }else{
                            correctPos =0;
                        }
                    }
                }
                baseEven = !baseEven;
            }

            diskEven = !diskEven;
        }
        return remaining;
    }

    public static void main(String[] args) {
        int[] a ={0,0,0,0,0,0};
        System.out.println(stepsRemaining(a));
    }
}
