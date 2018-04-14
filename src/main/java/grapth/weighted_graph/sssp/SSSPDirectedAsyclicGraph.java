package grapth.weighted_graph.sssp;

import grapth.Constants;
import grapth.Pair;
import grapth.graph_tracersals.DepthFirstSearch;
import stack.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
public class SSSPDirectedAsyclicGraph<T extends Number, E extends Number> {

    private List<LinkedList<Pair<T,E>>> graph;
    private DepthFirstSearch<T, E> dfs;
    private Stack stack;
    private List<Boolean> visited;
    private List<E> distances;

    public SSSPDirectedAsyclicGraph(List<LinkedList<Pair<T,E>>> graph) {
        this.graph = graph;
        this.dfs = new DepthFirstSearch<>(this.graph, true);
        this.stack = new Stack(this.graph.size());
        this.visited = new ArrayList<>();
        this.distances = new ArrayList<>(this.graph.size());
        for (int i = 0; i < this.graph.size(); i++) {
            this.distances.add((E)(Number) Constants.INFINUM);
            this.visited.add(Constants.FASLE);
        }
    }

    public void SSSPDAG(T start) {
        this.distances.set(start.intValue(), (E)(Number)(Constants.ZERO));
        this.dfs.dfsForScc(start, stack, visited);

        while(!stack.isEmpty()) {
            T current = (T)stack.peek();
            stack.pop();
            for (Pair<T, E> child : this.graph.get(current.intValue())) {
                if(this.distances.get(current.intValue()).intValue() + child.getSecond().intValue()
                        < this.distances.get(child.getFirst().intValue()).intValue()) {
                    this.distances.set(child.getFirst().intValue()
                            , (E)(Number)(this.distances.get(current.intValue()).intValue() + child.getSecond().intValue()));
                }
            }
        }
    }

    public E shortestPathTo(T t){
        return this.distances.get(t.intValue());
    }

}
