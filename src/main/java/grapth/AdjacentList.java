package grapth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class AdjacentList<T extends Number> implements Graph<T> {

    private List<Set<T>> graph;
    private int initialSize;

    private AdjacentList() {}

    @Override
    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize + 1;
        this.graph = new ArrayList<>();
        for(int i = 1; i < this.initialSize; i++){
            this.graph.add(new HashSet<>());
        }
    }

    public static <T extends Number> AdjacentList<T> getInstance(){
        return new AdjacentList<>();
    }

    @Override
    public List<Set<T>> getGraph() {
        return this.graph;
    }

    @Override
    public Graph<T> reverseGraph() {
        Graph<T> rGraph = AdjacentList.getInstance();
        rGraph.setInitialSize(this.graph.size());
        for(int i=0; i< this.graph.size();i++){
            Set<T> set = this.graph.get(i);
            for (T t : set) {
                rGraph.addEdge((T)(Number)(t.intValue()+1),(T)(Number)(i+1));
            }
        }
        return rGraph;
    }

    @Override
    public boolean addEdge(T a, T b) {
        int f = a.intValue() - 1;
        int l = b.intValue() - 1;

        this.graph.get(f).add((T)(Number)l);
        return  true;
    }

    @Override
    public boolean removeVertex(T a) {
        return false;
    }

    @Override
    public boolean removeEdge(T a, T b) {
        this.graph.get((a.intValue()-1)).remove(b.intValue()-1);
        return true;
    }

    @Override
    public Set<T> getChildren(T a) {
        return this.graph.get(Integer.valueOf(a.toString()));
    }

    @Override
    public void printGraph() {
        for (int i = 0; i < this.graph.size(); i++) {
            System.out.println(i + ":"+this.graph.get(i));
        }
    }

}
