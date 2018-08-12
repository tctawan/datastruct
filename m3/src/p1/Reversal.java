package p1;

import java.util.*;
public class Reversal {
    public static Map<Integer, Set<Integer>> reverseGraph(Map<Integer, Set<Integer>> G) {

        Map<Integer,Set<Integer>> reverseG = new HashMap<>();

        for(int s : G.keySet() ){

            Set<Integer> nbrs = G.get(s);

            if(nbrs == null){
                continue;
            }

            for(int v: nbrs){
                Set<Integer> reverseNbrs = reverseG.get(v);

                if(reverseNbrs == null){
                    reverseNbrs = new HashSet<>();
                }

                reverseNbrs.add(s);
                reverseG.put(v,reverseNbrs);

            }

        }
//        System.out.println(G.toString());
//        System.out.println(reverseG.toString());
        return reverseG;
    }

    // helper - you don't need to use it
    static class GraphBuilder {
        Map<Integer, Set<Integer>> graph;

        private GraphBuilder() {
            graph = new HashMap<>();
        }
        public static GraphBuilder emptyGraph() {
            return new GraphBuilder();
        }
        public GraphBuilder edge(int u, int v) {
            if (!graph.containsKey(u)) graph.put(u, new HashSet<>());
            graph.get(u).add(v);
            return this;
        }
        public Map<Integer, Set<Integer>> build() {
            return graph;
        }

        public static boolean graphEquals(Map<Integer, Set<Integer>> G,
                                          Map<Integer, Set<Integer>> H) {
            return H.keySet().equals(G.keySet()) && // same set of vertices
                H.keySet().stream() // the neighbors are the same
                .map((Integer u) -> H.get(u).equals(G.get(u)))
                .allMatch(e -> e);

        }
    }
    public static void main(String[] args) {
        Map<Integer, Set<Integer>> G =
                GraphBuilder.emptyGraph()
                .edge(0,1)
                .edge(2,0)
                .edge(3,2)
                .edge(0,3)
                .edge(3,1)
                .build();
        Map<Integer, Set<Integer>> expected =
                GraphBuilder.emptyGraph()
                .edge(1,0)
                .edge(0,2)
                .edge(2,3)
                .edge(3,0)
                .edge(1,3)
                .build();
        boolean verdict = GraphBuilder.graphEquals(reverseGraph(G), expected);
        System.out.println("verdict: "+verdict);
    }
}
