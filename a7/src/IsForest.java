import java.util.ArrayList;
import java.util.HashSet;

public class IsForest {

    public static int identifyTrees(int n, Iterable<Pair<Integer, Integer>> edges){

        int[] id =new int[n];
        int[] size = new int[n];

        for(int i=0; i<id.length; i++){
            id[i] = i;
            size[i] = 1;
        }

        for(Pair<Integer,Integer> e: edges){
            int p = e.first; int q = e.second;

            if(find(id,p) == find(id,q)){
                return 0;
            }

            union(id,size,p,q);
        }

        HashSet<Integer> roots = new HashSet<>();
        for(int v : id){
            int root = find(id,v);
            roots.add(root);
        }

        return roots.size();
    }

    public static int find(int[] id, int v){

        if(id[v] == v){
            return v;
        }

        id[v] = find(id,id[v]);
        return id[v];
    }

    public static void union(int[] id, int[] size, int p, int q){

        int rp = find(id,p); int rq = find(id,q);

        if(size[rp] < size[rq]){
            size[rq] += size[rp];
            id[rp] = rq;
        }else {
            size[rp] += size[rq];
            id[rq] = rp;
        }

    }

//    public static void main(String[] args) {
//        int[][] n = {{1, 2}, {0, 3}, {4, 2}, {4, 5}, {1, 6}, {6, 5}};
//        ArrayList<Pair<Integer,Integer>> a = createPairList(n);
//        System.out.println(identifyTrees(7,a));
//
//    }
//
    public static ArrayList<Pair<String,String>> createPairList(String [][] n){

        ArrayList<Pair<String,String>> array =new ArrayList<>();
        for (String[] pair : n){
            String f = pair[0]; String s =pair[1];
            Pair<String,String> p = new Pair<>(f,s);
            array.add(p);
        }

        return array;
    }
}
