package grapth.graph_tracersals;

import grapth.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class DepthFirstSearch<T extends Number> {

    private List<Set<T>> graph;
    private List<Boolean> visited;
    private List<T> parents;

    public List<T> getParents() {
        return parents;
    }

    private void init() {
        int size = this.graph.size();
        this.parents = new ArrayList<>(size);
        this.visited = new ArrayList<>(size);

        for(int i = 0; i< size; i++){
            this.parents.add(i, (T)(Number) Constants.INITIAL_VALUE);
            this.visited.add(i, false);
        }
    }

    public DepthFirstSearch(List<Set<T>> graph) {
        this.graph = graph;
    }

    private void dfsInit(T s) {
        this.visited.set(s.intValue(), true);
        for(T node: this.graph.get(s.intValue())){
            if(!this.visited.get(node.intValue())){
                this.parents.set(node.intValue(), s);
                dfsInit(node);
            }
        }
    }

    public synchronized void dfs(T s) {
        this.init();
        s = (T)(Number)(s.intValue() - 1);
        dfsInit(s);
    }

    public int connectedComponents() {
        this.init();
        int cc = 0;
        for(int i = 0; i < this.graph.size(); i++) {
            if(!this.visited.get(i)){
                cc++;
                dfsInit((T)(Number)i);
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

}
