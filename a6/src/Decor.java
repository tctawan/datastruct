import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Decor {
    public static BinaryTreeNode mkTree(List<Integer> postOrder, List<Integer> inOrder){
        return helper(postOrder,inOrder,postOrder.size(),0,postOrder.size()-1);
    }

    public static BinaryTreeNode helper(List<Integer> postOrder, List<Integer> inOrder,int hi, int lo,int postI){
        if(hi-lo <= 0){
            return null;
        }if(hi-lo == 1){
            return new BinaryTreeNode(inOrder.get(lo));
        }
        else {
            int root = postOrder.get(postI);
            BinaryTreeNode tree = new BinaryTreeNode(root);
            int iRoot = inOrder.indexOf(root);
            int leftHi = iRoot;
            int rightLo = iRoot +1 ;
            int postIL = leftHi -1;
            int postIR = leftHi+(hi-rightLo)-1;
            tree.left = helper(postOrder,inOrder,leftHi,lo,postIL);
            tree.right = helper(postOrder,inOrder,hi,rightLo,postIR);
            return tree;
        }
    }

//    public static void main(String[] args) {
//        List<Integer> postOrder = new ArrayList<>();
//        Collections.addAll(postOrder, 11,3,8,7,6,5,9,4);
//        List<Integer> inOrder =  new ArrayList<>();
//        Collections.addAll(inOrder, 11,8,3,9,7,5,6,4);
//        BinaryTreeNode myTree = mkTree(postOrder,inOrder);
//        MakeTree.walkPostOrder(myTree);
//        System.out.println();
//        System.out.println(postOrder);
//        MakeTree.walkInOrder(myTree);
//        System.out.println();
//        System.out.println(inOrder);
//    }

}
