package grapth.weighted_graph.sssp;

import grapth.Constants;
import grapth.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
public class BellmanFord<T extends Number,E extends Number> {

    private List<Pair<T,Pair<T,E>>> edgeList;
    private List<E> distances;
    private int graphSize;

    public BellmanFord(List<Pair<T,Pair<T,E>>> edgeList, int graphSize) {
        this.edgeList = edgeList;
        this.graphSize = graphSize;
        this.distances = new ArrayList<>(this.graphSize);
        for (int i = 0; i < this.graphSize; i++) {
            this.distances.add((E)(Number) Constants.INFINUM);
        }
    }

    /**
     * Bottom-Up Dynamic Programming paradigm
     * @param start vertex
     */
    public void SSSPBellmanFord(T start) {
        this.distances.set(start.intValue(), (E)(Number)Constants.ZERO);
        for(int i = 0;i < this.graphSize; i++){
                for (Pair<T, Pair<T, E>> tPairPair : edgeList) {
                    T a = tPairPair.getFirst();
                    T b = tPairPair.getSecond().getFirst();
                    E w = tPairPair.getSecond().getSecond();
                    if (this.distances.get(a.intValue()).intValue()!= Constants.INFINUM && this.distances.get(a.intValue()).intValue() + w.intValue() < this.distances.get(b.intValue()).intValue()) {
                        this.distances.set(b.intValue(), (E) (Number) (this.distances.get(a.intValue()).intValue() + w.intValue()));
                    }
                }
        }
    }

    public E shortestPathTo(T t){
        return this.distances.get(t.intValue());
    }

}
