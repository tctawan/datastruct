package hackerrank;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

class OrderTraversal {
    /*

class Node
    int data;
    Node left;
    Node right;
*/
    public static void levelOrder(Node root) {
        HashMap<Integer, TreeSet<Integer>> map = helper(new HashMap<>(), root, 0);
        for (int lvl = 0; lvl < map.size(); lvl++) {
            TreeSet<Integer> s = map.get(lvl);
            for (int data : s) {
                System.out.print(data + " ");
            }
        }

    }

    public static HashMap<Integer, TreeSet<Integer>> helper(HashMap<Integer, TreeSet<Integer>> map, Node node, int lvl) {
        if (node == null) {
            return map;
        } else {
            TreeSet<Integer> s = map.get(lvl);
            if (s == null) {
                s = new TreeSet<>();
            }
            s.add(node.data);
            map.put(lvl, s);
            HashMap<Integer, TreeSet<Integer>> leftMap = helper(map, node.left, lvl + 1);
            HashMap<Integer, TreeSet<Integer>> rightMap = helper(leftMap, node.right, lvl + 1);
            return rightMap;
        }

    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int t = scan.nextInt();
//        Node root = null;
//        while (t-- > 0) {
//            int data = scan.nextInt();
//            root = insert(root, data);
//        }
//        scan.close();
//        levelOrder(root);
//    }
}