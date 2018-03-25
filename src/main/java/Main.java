import grapth.AdjacentList;
import grapth.Graph;
import grapth.Pair;
import grapth.SimulateGraph;
import grapth.graph_tracersals.BreadthFirstSearch;
import grapth.graph_tracersals.DepthFirstSearch;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Graph<Integer> graph = AdjacentList.getInstance();

        graph.setInitialSize(10000);

        List<Pair<Integer,Integer>> edges = SimulateGraph.generateTestCase();

        for(Pair<Integer,Integer> a: edges) {
            graph.addEdge(a.getFirst(), a.getSecond());
        }

        graph.printGraph();

        BreadthFirstSearch<Integer> breadthFirstSearch = new BreadthFirstSearch<>(graph.getGraph());

        long startBfs = System.currentTimeMillis();

        breadthFirstSearch.bfs(1);

        long endBfs = System.currentTimeMillis();

        System.out.println((double)(endBfs - startBfs)/1000.0);


    }
}
