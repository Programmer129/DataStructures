import grapth.network_flow.DinicAlgorithm;
import grapth.network_flow.FordFulkerson;
import grapth.weighted_graph.WeithedGraph;

public class Main {

    public static void main(String[] args)  {

        WeithedGraph<Integer, Integer> graph = WeithedGraph.getInstance();
        WeithedGraph<Integer, Integer> graph1 = WeithedGraph.getInstance();
        graph1.setInitialSize(6);
        graph.setInitialSize(6);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 10);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 4, 9);
        graph.addEdge(1, 4, 8);
        graph.addEdge(1, 2, 2);
        graph.addEdge(3, 5, 10);
        graph.addEdge(4, 5, 10);
        graph.addEdge(4, 3, 10);

        graph1.setGraph(graph);

        FordFulkerson fulkerson = new FordFulkerson(graph, 0, 5);

        DinicAlgorithm dinic = new DinicAlgorithm(graph1, 0, 5);

        System.out.println(fulkerson.maxFlow());
        System.out.println(dinic.maxFlow());
    }
}
