import grapth.AdjacentList;
import grapth.Graph;
import grapth.Pair;
import grapth.traversal_applications.StronglyConnectedComponents;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Graph<Integer> graph = AdjacentList.getInstance();

        graph.setInitialSize(10);

        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,5);
        graph.addEdge(3,1);
        graph.addEdge(3,7);
        graph.addEdge(4,3);
        graph.addEdge(5,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
        graph.addEdge(6,8);
        graph.addEdge(6,9);
        graph.addEdge(6,10);
        graph.addEdge(7,5);
        graph.addEdge(8,10);
        graph.addEdge(9,10);

        StronglyConnectedComponents<Integer> stronglyConnectedComponents = new StronglyConnectedComponents<>(graph);

        Pair<List<Integer>[], Integer> scc = stronglyConnectedComponents.getSCC();

        int size = scc.getSecond();

        System.out.println("Strongly connected components:");
        for(int i=0;i<size;i++){
            System.out.println(scc.getFirst()[i]);
        }

    }
}
