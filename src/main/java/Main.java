import grapth.Pair;
import grapth.SimulateGraph;
import grapth.weighted_graph.WeithedGraph;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        WeithedGraph<Integer,Integer> weithedGraph = WeithedGraph.getInstance();

        weithedGraph.setInitialSize(100);

        List<Pair<Integer, Pair<Integer,Integer>>> edges = SimulateGraph.generateTestCase();

        edges.forEach(edge -> {
            weithedGraph.addEdge(edge.getFirst(),edge.getSecond().getFirst(),edge.getSecond().getSecond());
        });

        weithedGraph.printGraph();

    }
}
