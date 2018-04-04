package grapth.weighted_graph;

import grapth.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WeithedGraph<T extends Number,E extends Number>{

    private List<LinkedList<Pair<T,E>>> graph = new ArrayList<>();
    private int initialSize;

    private WeithedGraph(){ }

    public void setInitialSize(int initialSize){
        this.initialSize = initialSize;
        for (int i = 0; i < initialSize; i++) {
            this.graph.add(new LinkedList<>());
        }
    }

    public static <T extends Number,E extends Number> WeithedGraph<T,E> getInstance(){
        return new WeithedGraph<>();
    }

    public List<LinkedList<Pair<T, E>>> getGraph() {
        return graph;
    }

    public WeithedGraph<T,E> reverseGraph() {
        WeithedGraph<T,E> rGraph = WeithedGraph.getInstance();
        rGraph.setInitialSize(this.graph.size());
        for(int i=0; i< this.graph.size();i++){
            LinkedList<Pair<T,E>> set = this.graph.get(i);
            for (Pair<T,E> t : set) {
                rGraph.addEdge((T)(Number)(t.getFirst().intValue()+1),(T)(Number)(i+1),t.getSecond());
            }
        }
        return rGraph;
    }

    public void addEdge(T a, T b, E w){
        this.graph.get(a.intValue()).add(new Pair<>(b,w));
    }

    public void printGraph(){
        for (int i = 0; i < this.graph.size(); i++) {
            System.out.print(i+":[");
            for (Pair<T, E> tePair : this.graph.get(i)) {
                System.out.print("{"+tePair.getFirst()+","+tePair.getSecond()+"}, ");
            }
            System.out.println("]");
        }
    }

}