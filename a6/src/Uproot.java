import java.lang.reflect.Array;
import java.util.*;

public class Uproot {
    public static HashMap<Integer, Integer> treeToParentMap(BinaryTreeNode T){
        HashMap<Integer,Integer> hm = new HashMap<>();
        t2pmhelper(hm,T);
        return hm;

    }
    public static void t2pmhelper(HashMap<Integer,Integer> hm , BinaryTreeNode T){
        if(T.right == null && T.left == null){
            return;
        }
        else {
            if (T.right != null) {
                hm.put(T.right.key, T.key);
                t2pmhelper(hm, T.right);
            }
            if(T.left != null){
                hm.put(T.left.key,T.key);
                t2pmhelper(hm,T.left);
            }
        }
    }

    public static BinaryTreeNode parentMapToTree(Map<Integer, Integer> map) {

        HashMap<Integer,Stack<Integer>> parentsMap = new HashMap<>();
        Set<Integer> childrenSet = map.keySet();

        //create map that maps parent to its child.
        for (Integer child : childrenSet) {
            Integer parent = map.get(child);
            Stack<Integer> stack = parentsMap.get(parent);
            if(stack == null){
                stack = new Stack<>();
            }
            stack.push(child);
            parentsMap.put(parent,stack);
        }

//        System.out.println(parentsMap.toString());

        // find the root
        int root = 0;
        Set<Integer> parentsSet = parentsMap.keySet();
        for(Integer parent : parentsSet){
            if(!childrenSet.contains(parent)){
                root = parent;
                break;
            }
        }
//        System.out.println(root);
        //make the tree
        return pm2thelper(parentsMap,root);
    }

    public static BinaryTreeNode pm2thelper(Map<Integer,Stack<Integer>> parentMap, int node ){
        Stack<Integer> stackOfChildren = parentMap.get(node);
        BinaryTreeNode t  = new BinaryTreeNode(node);

        if(stackOfChildren == null){
            return t;
        }else{
            while (!stackOfChildren.isEmpty()) {
                Integer child = stackOfChildren.pop();
                BinaryTreeNode childNode = pm2thelper(parentMap, child);
                if(t.left == null){
                    t.left = childNode;
                }else {
                    t.right = childNode;
                }
            }
            return t;
        }
    }

//    public static void main(String[] args) {
//        BinaryTreeNode T = new BinaryTreeNode(new BinaryTreeNode(new BinaryTreeNode(14),20,null),1,new BinaryTreeNode(new BinaryTreeNode(2),9,new BinaryTreeNode(18)));
//        HashMap<Integer,Integer> hm =treeToParentMap(T);
//        System.out.println(hm.toString());
//    }

//    public static void main(String[] args) {
//        int[] a = makeArray(2000);
//        System.out.println(Arrays.toString(a));
//        BinaryTreeNode check= MakeTree.buildBST(a);
//        MakeTree.check(check);
//        System.out.println("checked");
//        HashMap<Integer,Integer> hm = treeToParentMap(check);
//        BinaryTreeNode b =parentMapToTree(hm);
//        MakeTree.check(b);
//        System.out.println("Done");
//    }

    public static int[] makeArray(int size){
        int[] array = new int[size];
        Random random = new Random();
        for(int i = 0; i<size; i++){
            int num = random.nextInt(20000) +1;
            array[i] = num;
        }
        return array;
    }
}
