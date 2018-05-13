package grapth.weighted_graph.minimum_spaning_tree;

import common.Constants;
import grapth.Pair;
import union_find.UnionFind;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class Kruskal<T extends Number,E extends Number> {

    private List<Pair<T,Pair<T,E>>> edgeList;
    private UnionFind<T> unionFind;
    private List<Pair<T,T>> mst;
    private E mstValue;
    private int graphSize;

    public Kruskal(List<Pair<T,Pair<T,E>>> edgeList, int graphSize){
        this.edgeList = edgeList;
        this.graphSize = graphSize;
        this.unionFind = new UnionFind<>(graphSize);
        this.mst = new ArrayList<>(graphSize);
        this.mstValue = (E)(Number)Constants.ZERO;
        this.edgeList = this.edgeList.stream()
                .sorted(Comparator.comparingInt(edge -> edge.getSecond().getSecond().intValue())).collect(Collectors.toList());
    }

    public void findMST() {
        for (Pair<T, Pair<T, E>> tPairPair : edgeList) {
            T a = tPairPair.getFirst();
            T b = tPairPair.getSecond().getFirst();
            E w = tPairPair.getSecond().getSecond();
            if(!unionFind.isConnected(a, b)){
                unionFind.connect(a, b);
                this.mst.add(new Pair<>(a, b));
                this.mstValue = (E)(Number)(this.mstValue.intValue() + w.intValue());
            }
        }
    }

    public List<Pair<T,T>> getMst(){
        return mst;
    }

    public E getMstValue() {
        return mstValue;
    }
}
