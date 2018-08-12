package hackerrank;

import java.util.ArrayList;
import java.util.Collections;

public class CheckBST {
    public static boolean checkBST(Node root) {
        ArrayList<Integer> a = helper(root, new ArrayList<>());
        ArrayList<Integer> tempA = new ArrayList<>(a);
        Collections.sort(a);
        for(int i=0; i<a.size(); i++){
            if(i<a.size()-1 && a.get(i) == a.get(i+1)){
                return false;
            }
            if(tempA.get(i) != a.get(i)){
                return false;
            }
        }
        return true;

    }

    public static ArrayList<Integer> helper(Node node, ArrayList<Integer> a){
        if(node == null){
            return a;
        }else{
            helper(node.left,a);
            a.add(node.data);
            helper(node.right,a);
            return a;
        }
    }
}
