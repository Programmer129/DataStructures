package grapth.weighted_graph;

import grapth.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
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

    public void setGraph(WeithedGraph<T,E> weithedGraph) {
        this.graph.clear();
        for (LinkedList<Pair<T, E>> pairs : weithedGraph.getGraph()) {
            LinkedList<Pair<T,E>> list = new LinkedList<>();
            for (Pair<T, E> pair : pairs) {
                list.add(new Pair<>(pair.getFirst(), pair.getSecond()));
            }
            addList(list);
        }
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

    // graph is undirect
    public void addEdge(T a, T b, E w){
        this.graph.get(a.intValue()).add(new Pair<>(b,w));
    }

    private void addList(LinkedList<Pair<T,E>> linkedList) {
        this.graph.add(linkedList);
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
