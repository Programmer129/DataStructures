import grapth.network_flow.FordFulkerson;
import grapth.weighted_graph.WeithedGraph;

public class Main {

    public static void main(String[] args)  {

        WeithedGraph<Integer, Integer> graph = WeithedGraph.getInstance();
        graph.setInitialSize(6);
        graph.addEdge(0, 1, 16);
        graph.addEdge(0, 2, 13);
        graph.addEdge(1, 3, 12);
        graph.addEdge(2, 4, 14);
        graph.addEdge(2, 1, 4);
        graph.addEdge(3, 5, 20);
        graph.addEdge(3, 2, 9);
        graph.addEdge(4, 5, 4);
        graph.addEdge(4, 3, 7);

        FordFulkerson fulkerson = new FordFulkerson(graph, 0, 5);

        int maxFlow = fulkerson.maxFlow();

        System.out.println(maxFlow);
    }
}
