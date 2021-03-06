package grapth.graph_tracersals;

import grapth.Constants;
import grapth.Pair;
import grapth.weighted_graph.WeithedGraph;
import stack.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public final class DepthFirstSearch<T extends Number, E extends Number> {

    private List<Set<T>> graph;
    private List<Boolean> visited;
    private List<T> parents;
    private Stack dfsStack;
    private List<T> scc;
    private List<T> ccNumberNodes;
    private Integer counter;
    private Boolean isWeighted;

    private void init() {
        int size = this.graph.size();
        this.parents = new ArrayList<>(size);
        this.visited = new ArrayList<>(size);
        this.dfsStack = new Stack(size);
        this.scc = new ArrayList<>(size);
        this.ccNumberNodes = new ArrayList<>(size);
        this.counter = 0;
        for(int i = 0; i< size; i++){
            this.parents.add(i, (T)(Number) Constants.INITIAL_VALUE);
            this.visited.add(i, false);
            this.ccNumberNodes.add(i, (T)(Number)0);
        }
    }

    public DepthFirstSearch(List<Set<T>> graph) {
        this.graph = graph;
        this.init();
    }

    public DepthFirstSearch(List<LinkedList<Pair<T,E>>> weightedGraph, boolean isWeighted){
        this.isWeighted = isWeighted;
        if(isWeighted) {
            this.graph = WeithedGraph.toGraph(weightedGraph);
        }
        this.init();
    }

    private void dfsInit(T s) {
        this.visited.set(s.intValue(), true);
        this.counter++;
        for(T node: this.graph.get(s.intValue())){
            if(!this.visited.get(node.intValue())){
                this.parents.set(node.intValue(), s);
                dfsInit(node);
            }
        }
    }

    public synchronized void dfs(T s) {
        this.init();
        dfsInit(s);
    }

    public synchronized void dfsForScc(T s, Stack stack, List<Boolean> visited) {
        visited.set(s.intValue(), true);
        for (T node : this.graph.get(s.intValue())) {
            if(!visited.get(node.intValue())){
                dfsForScc(node, stack, visited);
            }
        }
        stack.push(s);
    }

    public int connectedComponents() {
        this.init();
        int cc = 0;
        for(int i = 0; i < this.graph.size(); i++) {
            if(!this.visited.get(i)){
                this.counter = 0;
                dfsInit((T)(Number)i);
                this.ccNumberNodes.set(cc++, (T)counter);
            }
        }
        return cc;
    }

    private boolean hasCycleInit(T s) {
        this.visited.set(s.intValue(), true);
        for(T node: this.graph.get(s.intValue())){
            if(!this.visited.get(node.intValue())){
                this.parents.set(node.intValue(), s);
                hasCycleInit(node);
            }
            else
                if(!node.equals(this.parents.get(s.intValue()))){
                    return true;
                }
        }
        return false;
    }

    /**
     * works only undirected graph
     * @return
     */
    public boolean hasCycle() {
        this.init();
        T one = (T)(Number)(1);
        return hasCycleInit(one);
    }

    public Stack getDfsStack() {
        return dfsStack;
    }

    public List<T> getParents() {
        return parents;
    }

    public List<Boolean> getVisited() {
        return visited;
    }

    public List<T> getCcNumberNodes() {
        return ccNumberNodes;
    }

    public List<T> getScc() {
        List<T> res = this.scc;
        this.scc.clear();
        return res;
    }
}
