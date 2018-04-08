import grapth.Pair;
import grapth.SimulateGraph;
import grapth.weighted_graph.WeithedGraph;
import grapth.weighted_graph.sssp.Dijkstra;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        WeithedGraph<Integer, Integer> graph = WeithedGraph.getInstance();

        graph.setInitialSize(1000);

        List<Pair<Integer,Pair<Integer,Integer>>> edges = SimulateGraph.generateTestCase();

        for (Pair<Integer, Pair<Integer, Integer>> edge : edges) {
            graph.addEdge(edge.getFirst() - 1,edge.getSecond().getFirst() - 1,edge.getSecond().getSecond());
        }

        Dijkstra<Integer, Integer> dijkstra = new Dijkstra<>(graph.getGraph());

        dijkstra.SSSPDijkstra(0);

        for(int i = 1; i< 1000; i++){
            System.out.println("shortest path from 0 to "+i+": "+dijkstra.shortestPathTo(i));
        }

    }
}
