import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MultiwayMerge {
    public static LinkedList<Integer> mergeAll(LinkedList<Integer>[] lists) {
        Comparator<LinkedList<Integer>> c = new LinkedListComparator();
        PriorityQueue<LinkedList<Integer>> pq = new PriorityQueue<>(c);
        LinkedList<Integer> finalList = new LinkedList<>();
        int numOfEle = 0;
        for(int i = 0; i<lists.length; i++){
            pq.add(lists[i]);
            numOfEle += lists[i].size();
        }
        while(numOfEle != 0){
            LinkedList<Integer> ll = pq.poll();
            Integer num =ll.poll();
            finalList.add(num);
            numOfEle--;
            if(ll.size() !=0){
                pq.add(ll);
            }

        }
        return finalList;
    }

//    public static void main(String[] args) {
//        LinkedList<Integer> ll = new LinkedList<>();
//        LinkedList<Integer> ll2 = new LinkedList<>();
//        ll.add(3);
//        ll.add(4);ll.add(5);ll.add(6);ll.add(9);ll.add(10);
//        ll2.add(-20);ll2.add(21);ll2.add(29);ll2.add(500);
//        LinkedList<Integer>[] lla = new LinkedList[2];
//        lla[0] = ll;
//        lla[1] = ll2;
//
//        System.out.println(mergeAll(lla));
//    }

    public static class LinkedListComparator implements Comparator<LinkedList<Integer>> {
        public int compare( LinkedList<Integer> a, LinkedList<Integer> b) {
            return a.peek()-b.peek();
        }
    }
}
