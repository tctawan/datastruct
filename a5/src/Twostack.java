import java.util.Stack;

public class Twostack {
    static int twoStacks(int x, int[] a, int[] b) {
        Stack<Integer> sa = new Stack<>();
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            temp += a[i];
            if (temp <= x) {
                sa.push(a[i]);
                sum = temp;
            } else {
                break;
            }
        }
        int maxScore = sa.size();
        Stack<Integer> sb = new Stack<>();

        for (int i = 0; i < b.length; i++) {
            sum += sb.push(b[i]);
            while (sum > x) {
                if (sa.size() == 0) {
                    if (sb.size() + sa.size() > maxScore && sum <= x) {
                        maxScore = sb.size() + sa.size();
                    }
                    return maxScore;
                } else {
                    sum -= sa.pop();
                }
            }
            if (sb.size() + sa.size() > maxScore) {
                maxScore = sa.size() + sb.size();
            }
        }
        return maxScore;
    }

//        public static void main (String[]args){
//            int[] a = {14,0,15,12,15,6,15,0,18,19,16,1,3,9,5,19,0,10,10,2,14,12,1,4,6,6,10,16,7,2,14,2};
//
//            int[] b = {2,2,6,9,0,1,1,18,12,17,11,16,18,8,7,18,19,17,13,13,2,14,10,8,0,0,4,0,2,11,2,16};
//
//            System.out.println(twoStacks(19, a, b));
//        }
    }

