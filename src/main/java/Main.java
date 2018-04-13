import grapth.Pair;
import grapth.SimulateGraph;
import grapth.weighted_graph.WeithedGraph;
import grapth.weighted_graph.sssp.BellmanFord;
import grapth.weighted_graph.sssp.Dijkstra;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        WeithedGraph<Integer, Integer> graph = WeithedGraph.getInstance();

        graph.setInitialSize(1000);

        List<Pair<Integer, Pair<Integer,Integer>>> edges = SimulateGraph.generateTestCase();

        for (Pair<Integer, Pair<Integer, Integer>> edge : edges) {
            graph.addEdge(edge.getFirst(),edge.getSecond().getFirst(),edge.getSecond().getSecond());
        }

        BellmanFord<Integer, Integer> bellmanFord = new BellmanFord<>(edges, 1000);
        Dijkstra<Integer, Integer> dijkstra = new Dijkstra<>(graph.getGraph());

        long dijkstraStart = System.currentTimeMillis();
        dijkstra.SSSPDijkstra(0);
        long dijkstraEnd = System.currentTimeMillis();

        System.out.println("dijkstra Time:"+ (double)(dijkstraEnd-dijkstraStart)/1000.0);

        long bellmanStart = System.currentTimeMillis();
        bellmanFord.SSSPBellmanFord(0);
        long bellmanEnd = System.currentTimeMillis();

        System.out.println("bellman Time:"+ (double)(bellmanEnd-bellmanStart)/1000.0);


        for(int i = 1; i< 1000; i++){
            System.out.println("1) shortest path from 0 to "+i+": "+bellmanFord.shortestPathTo(i));
            System.out.println("2) shortest path from 0 to "+i+": "+dijkstra.shortestPathTo(i));
        }

    }
}
