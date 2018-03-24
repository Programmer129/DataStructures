package grapth.graph_tracersals;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public final class DepthFirstSearch {

    private List<Set<Integer>> graph;
    private List<Boolean> visited;
    private List<Integer> parents;

    public List<Integer> getParents() {
        return parents;
    }

    private void init() {
        Boolean [] arr = new Boolean[16];
        Arrays.fill(arr, false);
        this.visited = Arrays.asList(arr);
        Integer [] arr1 = new Integer[16];
        Arrays.fill(arr1, -1);
        this.parents = Arrays.asList(arr1);
    }

    public DepthFirstSearch() {
        this.init();
    }

    public void setGraph(List<Set<Integer>> graph){
        this.graph = graph;
    }

    public void dfs(int s) {
        this.visited.set(s, true);
        for(int node: this.graph.get(s)){
            if(!this.visited.get(node)){
                this.parents.set(node, s);
                dfs(node);
            }
        }
    }

    public int connectedComponents() {
        int cc = 0;
        for(int i = 1; i < this.graph.size(); i++) {
            if(!this.visited.get(i)){
                cc++;
                dfs(i);
            }
        }
        return cc;
    }

}
