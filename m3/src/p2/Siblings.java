package p2;

import java.util.*;

public class Siblings {
    // add your class variable here
    // e.g. int magic;  and set the value in the constructor
    HashMap<Integer,Integer> lvlMap;

    public Siblings(HashMap<Integer, Integer> cpTree) {
        int root = 0;


        // Table that maps parents to its children
        HashMap<Integer,HashSet<Integer>> childrenTable = new HashMap<>();

        for(int v: cpTree.keySet()){
            Integer p = cpTree.get(v);

            //Find root.
            if(p == null){
                root = v;
                continue;
            }

            HashSet<Integer> children = childrenTable.get(p);

            if(children == null){
                children = new HashSet<>();
            }

            children.add(v);
            childrenTable.put(p,children);
        }

        // Making map that tells lvl of vertices
        lvlMap = new HashMap<>();
        lvlMap.put(root,0);
        HashSet<Integer> frontier = childrenTable.get(root);
        int lvl = 1;
        while (frontier.size() > 0){

            for(int v: frontier){
                lvlMap.put(v,lvl);
            }
            frontier = getAllSiblings(childrenTable,frontier);
            lvl++;

        }
//        System.out.println(lvlMap);

//        System.out.println(childrenTable);
//        System.out.println(cpTree);
  }

  public HashSet<Integer> getAllSiblings(HashMap<Integer,HashSet<Integer>> childrenTable, HashSet<Integer> frontier){
        HashSet<Integer> union = new HashSet<>();

        for(int v: frontier) {
            if (childrenTable.get(v) != null) {
                union.addAll(childrenTable.get(v));
            }
        }
        return union;

  }

  public boolean isSibling(int u, int v) {
        if(lvlMap.get(u).equals(lvlMap.get(v))){
            return true;
        }

      return false;
  }

  public static void main(String[] args) {
      HashMap<Integer, Integer> tr = new HashMap<>();
      // Setting up test input: par[i] is the parent of nodes[i]
      Integer[] par   = {null, 4, 4, 4, 3, 3, 8, 8, 8};
      Integer[] nodes = {   4, 1, 3, 8, 0, 2, 6, 7, 5};
      for (int i=0;i<par.length;i++) tr.put(nodes[i], par[i]);

      Siblings sbl = new Siblings(tr);
      System.out.println("Verdict: " + (true==sbl.isSibling(2, 5)));
      System.out.println("Verdict: " + (false==sbl.isSibling(1, 7)));
  }
}
