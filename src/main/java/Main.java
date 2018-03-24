import grapth.AdjacentList;
import grapth.Graph;
import grapth.graph_tracersals.BreadthFirstSearch;
import grapth.graph_tracersals.DepthFirstSearch;

public class Main {

    public static void main(String[] args) {

        Graph<Integer> adjacentList = AdjacentList.getInstance();

        adjacentList.setInitialSize(5);


       adjacentList.addEdge(1,2);
        adjacentList.printGraph();
//        adjacentList.addEdge(1,5);
//        adjacentList.addEdge(2,3);
//        adjacentList.addEdge(3,4);

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();

        depthFirstSearch.setGraph(adjacentList.getGraph());

        System.out.println(depthFirstSearch.connectedComponents());


//        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
//        breadthFirstSearch.setGraph(adjacentList.getGraph());
//        breadthFirstSearch.bfs(1);
//        System.out.println(breadthFirstSearch.getParents());

    }
}
