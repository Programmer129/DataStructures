import grapth.Pair;
import grapth.SimulateGraph;
import grapth.weighted_graph.WeithedGraph;
import grapth.weighted_graph.sssp.Dijkstra;
import grapth.weighted_graph.sssp.SSSPDirectedAsyclicGraph;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        WeithedGraph<Integer, Integer> graph = WeithedGraph.getInstance();

        graph.setInitialSize(2000);

        List<Pair<Integer, Pair<Integer,Integer>>> edges = SimulateGraph.generateTestCase();

        for (Pair<Integer, Pair<Integer, Integer>> edge : edges) {
            graph.addEdge(edge.getFirst(),edge.getSecond().getFirst(),edge.getSecond().getSecond());
        }

        SSSPDirectedAsyclicGraph<Integer, Integer> dag = new SSSPDirectedAsyclicGraph<>(graph.getGraph());
        Dijkstra<Integer, Integer> dijkstra = new Dijkstra<>(graph.getGraph());

        long startDijkstra = System.currentTimeMillis();
        dijkstra.SSSPDijkstra(0);
        long endDijkstra = System.currentTimeMillis();

        long startDag = System.currentTimeMillis();
        dag.SSSPDAG(0);
        long endDag = System.currentTimeMillis();

        System.out.println("Dijkstra time:" + (double) (endDijkstra - startDijkstra) /1000.0);
        System.out.println("Dag time:" + (double) (endDag - startDag) /1000.0);

        for(int i = 1; i< 2000; i++){
            System.out.println("1) shortest path from 0 to "+i+": "+dag.shortestPathTo(i));
            System.out.println("1) shortest path from 0 to "+i+": "+dijkstra.shortestPathTo(i));
        }

    }
}