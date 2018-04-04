import grapth.Pair;
import grapth.weighted_graph.minimum_spaning_tree.Kruskal;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

         List<Pair<Integer,Pair<Integer,Integer>>> edgeList = new ArrayList<>();

         edgeList.add(new Pair<>(0,new Pair<>(1,10)));
         edgeList.add(new Pair<>(0,new Pair<>(2,5)));
         edgeList.add(new Pair<>(1,new Pair<>(3,7)));
         edgeList.add(new Pair<>(2,new Pair<>(3,1)));
         edgeList.add(new Pair<>(2,new Pair<>(4,2)));
         edgeList.add(new Pair<>(4,new Pair<>(1,3)));

        Kruskal<Integer,Integer> kruskal = new Kruskal<>(edgeList, 5);

        kruskal.findMST();

        List<Pair<Integer,Integer>> mst = kruskal.getMst();

        System.out.println(mst);
        System.out.println(kruskal.getMstValue());

    }
}
