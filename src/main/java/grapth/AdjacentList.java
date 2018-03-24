package grapth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class AdjacentList<T> implements Graph<T> {

    private List<Set<T>> graph;
    private int initialSize;

    private AdjacentList(){
        this.initialSize++;
        this.graph = new ArrayList<>();
        for(int i = 1; i < initialSize; i++){
            this.graph.add(new HashSet<>());
        }
    }

    @Override
    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public static <T> AdjacentList<T> getInstance(){
        return new AdjacentList<>();
    }

    @Override
    public List<Set<T>> getGraph() {
        return this.graph;
    }

    @Override
    public boolean addEdge(T a, T b) {

        this.graph.get(Integer.valueOf(a.toString()) - 1).add(b);
        return  true;
    }

    @Override
    public boolean removeEdge(T a, T b) {
        return false;
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
