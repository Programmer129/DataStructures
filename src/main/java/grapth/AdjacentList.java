package grapth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class AdjacentList<T> implements Graph<T> {

    private List<Set<T>> graph;
    private int initialSize = 16;

    private AdjacentList(){
        this.graph = new ArrayList<>();
        for(int i = 0; i < initialSize; i++){
            this.graph.add(new HashSet<>());
        }
    }

    public static <T> AdjacentList<T> getInstance(){
        return new AdjacentList<>();
    }

    @Override
    public boolean addEdge(T a, T b) {
        if(this.graph.get(Integer.valueOf(a.toString())).contains(b) ||
                this.graph.get(Integer.valueOf(b.toString())).contains(a)){
            return false;
        }
        if(this.graph.size() > initialSize){
            initialSize <<= 1;
            if(initialSize >= Constants.LIMIT){
                throw new IndexOutOfBoundsException("index out of bound");
            }
            List<Set<T>> newGraph = new ArrayList<>();
            this.graph.stream().map(newGraph::add);
            for(int i = initialSize>>1; i < initialSize; i++){
                this.graph.add(new HashSet<>());
            }
        }
        this.graph.get(Integer.valueOf(a.toString())).add(b);
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

    public void printGraph() {
        for (int i = 0; i < this.graph.size(); i++) {
            System.out.println(i + ":"+this.graph.get(i));
        }
    }

}
