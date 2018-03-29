import grapth.AdjacentList;
import grapth.Graph;
import grapth.Pair;
import grapth.SimulateGraph;
import grapth.traversal_applications.StronglyConnectedComponents;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Graph<Integer> graph = AdjacentList.getInstance();

        graph.setInitialSize(100);

        List<Pair<Integer, Integer>> edges = SimulateGraph.generateTestCase();

        for (Pair<Integer, Integer> edge : edges) {
            graph.addEdge(edge.getFirst(), edge.getSecond());
        }

        graph.printGraph();

        StronglyConnectedComponents<Integer> stronglyConnectedComponents = new StronglyConnectedComponents<>(graph);

        Pair<List<Integer>[], Integer> scc = stronglyConnectedComponents.getSCC();

        int size = scc.getSecond();

        System.out.println("Strongly connected components:");
        for(int i=0;i<size;i++){
            System.out.println(scc.getFirst()[i]);
        }

    }
}
