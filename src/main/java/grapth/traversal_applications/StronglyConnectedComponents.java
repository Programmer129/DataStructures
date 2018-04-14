package grapth.traversal_applications;

import grapth.Graph;
import grapth.Pair;
import grapth.graph_tracersals.DepthFirstSearch;
import stack.Stack;

import java.util.ArrayList;
import java.util.List;

public class StronglyConnectedComponents<T extends Number, E extends Number> {

    private DepthFirstSearch<T, E> depthFirstSearch;
    private Graph<T> graph;
    private List<T> sccUtil;

    public StronglyConnectedComponents(Graph<T> graph) {
        this.sccUtil = new ArrayList<>();
        this.graph = graph;
        this.depthFirstSearch = new DepthFirstSearch<>(this.graph.getGraph());
    }

    private Stack getStack(){
        Stack stack = new Stack(this.graph.getGraph().size());
        List<Boolean> visited = new ArrayList<>(this.graph.getGraph().size());
        for (int i = 0; i < this.graph.getGraph().size(); i++) {
            visited.add(false);
        }
        for(int i=0;i<this.graph.getGraph().size();i++) {
            if(!visited.get(i)) {
                depthFirstSearch.dfsForScc((T) Integer.valueOf(i), stack, visited);
            }
        }

        return stack;
    }

    public Pair<List<T>[], Integer> getSCC(){

        Stack stack = this.getStack();

        this.graph = this.graph.reverseGraph();

        List<Boolean> visited = new ArrayList<>(this.graph.getGraph().size());
        for (int i = 0; i < this.graph.getGraph().size(); i++) {
            visited.add(false);
        }

        List<T>[] scc = new ArrayList[1000];
        for (int i = 0; i < scc.length; i++) {
            scc[i] = new ArrayList<>();
        }

        int i = 0;
        while(!stack.isEmpty()){
            if(!visited.get(stack.peek().intValue())){
                dfsUtil((T)stack.peek(), visited);
                scc[i++].addAll(this.sccUtil);
                this.sccUtil.clear();
            }
            stack.pop();
        }

        return new Pair<>(scc, i);
    }

    private void dfsUtil(T s, List<Boolean> visited){
        visited.set(s.intValue(), true);
        this.sccUtil.add(s);
        for(T node: this.graph.getGraph().get(s.intValue())){
            if(!visited.get(node.intValue())){
                dfsUtil(node, visited);
            }
        }
    }

}
