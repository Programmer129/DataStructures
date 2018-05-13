package grapth.weighted_graph.sssp;

import common.Constants;
import grapth.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("unchecked")
public final class Dijkstra<T extends Number, E extends Number> {

    private List<LinkedList<Pair<T,E>>> graph;
    private PriorityQueue<Pair<T,E>> pq;
    private List<E> distances;

    public Dijkstra(List<LinkedList<Pair<T,E>>> graph) {
        this.graph = graph;
        this.pq = new PriorityQueue<>(this.graph.size(), Comparator.comparingInt(o -> o.getSecond().intValue()));
        this.distances = new ArrayList<>(this.graph.size());
        for (int i = 0; i < this.graph.size(); i++) {
            this.distances.add((E)(Number)Constants.INFINUM);
        }
    }

    public void SSSPDijkstra(T start) {
        this.pq.add(new Pair<>(start,(E)(Number)Constants.ZERO));
        this.distances.set(start.intValue(), (E)(Number)Constants.ZERO);
        while(!pq.isEmpty()){
            Pair<T,E> current = pq.poll();
            for (Pair<T, E> tePair : this.graph.get(current.getFirst().intValue())) {
                if(current.getSecond().intValue() + tePair.getSecond().intValue()
                        < this.distances.get(tePair.getFirst().intValue()).intValue()){
                    this.distances.set(tePair.getFirst().intValue(), (E)(Number)(current.getSecond().intValue() + tePair.getSecond().intValue()));
                    pq.add(new Pair<>(tePair.getFirst(), this.distances.get(tePair.getFirst().intValue())));
                }
            }
        }
    }

    public E shortestPathTo(T t){
        return this.distances.get(t.intValue());
    }

}
