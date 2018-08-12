import java.util.*;

public class Cycle {


    public static List<String> findCycle(ArrayList<Pair<String, String>> graph){


        // Adj table; only contains "reachable" neighbours
        HashMap<String,HashSet<String>> adjTable = new HashMap<>();
        for(int i =0 ; i<graph.size(); i++){
            String node = graph.get(i).first;
            String directed = graph.get(i).second;

            HashSet<String> s = adjTable.get(node);
            if(s == null){
                s = new HashSet<>();
            }

            s.add(directed);
            adjTable.put(node,s);

        }

        //dfs in undir. graph


        LinkedList<String> cl = new LinkedList<>();
        CDState state = new CDState();
        state.cycleFound = false;


            for (Pair<String, String> p : graph) {
                String v = p.first;
                HashSet<String > entered = new HashSet<>();
                HashSet<String> exited = new HashSet<>();
                if (!entered.contains(v)) {
                    cl = dfsHelper(adjTable, entered, exited, v, cl, state);
                }
            }

            if(cl.size() == 0){
                cl = null;
            }
        return cl;


    }

    static LinkedList<String> dfsHelper(HashMap<String,HashSet<String>> adjTable, HashSet<String> entered, HashSet<String> exited,
                                       String v, LinkedList<String> cl, CDState state){

        if(!entered.contains(v)){
            entered.add(v);

            if(adjTable.get(v) == null){
                return cl;
            }

            for (String nbr : adjTable.get(v)) {
                cl = dfsHelper(adjTable, entered, exited, nbr, cl,state);
                exited.add(nbr);

                if(state.cycleFound && !state.cycleStop) {
                    cl.addFirst(v);
                    break;
                }
            }

            if (state.cycleEnd == v) {
                state.cycleStop = true;
            }

            return cl;

        }
        else if(!exited.contains(v)){
            state.cycleFound = true;
            state.cycleEnd = v;

        }


        return cl;
    }


//    public static void main(String[] args) {
//
//
//        String[][] n =  {{"C", "D"}};
//        ArrayList<Pair<String,String>> graph =IsForest.createPair(n);
//        System.out.println(findCycle(graph));
//    }
}
