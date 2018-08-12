import java.util.Arrays;

public class MakeTree {
    public static BinaryTreeNode buildBST(int[] keys){
        Arrays.sort(keys);
        return helper(keys,keys.length,0);
    }

    public static BinaryTreeNode helper(int[] keys, int hi, int lo){
        int middle = (hi+lo)/2;
        if(hi-lo ==0){
            return null;
        }
        int key = keys[middle];
        if(hi-lo == 1){
            return new BinaryTreeNode(key);
        }else{
            BinaryTreeNode left = helper(keys,middle,lo);
            BinaryTreeNode right = helper(keys,hi,middle+1);
            return new BinaryTreeNode(left,key,right);
        }
    }

    public static void walkInOrder(BinaryTreeNode b){
        if(b == null){
            return;
        }else{
            walkInOrder(b.left);
            System.out.print(b.key + " ");
            walkInOrder(b.right);
        }
    }

    public static void walkPostOrder(BinaryTreeNode b){
        if(b == null){
            return;
        }else{
            walkPostOrder(b.left);
            walkPostOrder(b.right);
            System.out.print(b.key + " ");
        }
    }

//    public static void main(String[] args) {
//        int[] keys = {5,19,20,60,100};
//        BinaryTreeNode b =buildBST(keys);
//        check(b);
//    }
}
