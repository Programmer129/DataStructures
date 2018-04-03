package grapth.graph_tracersals;

import grapth.Constants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class BreadthFirstSearch<T extends Number> {

    private List<Boolean> visited;
    private List<T> parents;
    private List<Set<T>> graph;
    private List<Colors> colors;

    public List<T> getParents() {
        return parents;
    }

    private void init() {
        int size = this.graph.size();
        this.parents = new ArrayList<>(size);
        this.colors = new ArrayList<>(size);
        this.visited = new ArrayList<>(size);

        for(int i = 0; i< size; i++){
            this.parents.add(i, (T)(Number)Constants.INITIAL_VALUE);
            this.colors.add(i, Colors.WHITE);
            this.visited.add(i, false);
        }
    }

    public BreadthFirstSearch(List<Set<T>> graph) {
        this.graph = graph;
        this.init();
    }

    public synchronized void bfs(T s){
        s = (T)(Number)(s.intValue() - 1);
        Queue<T> queue = new LinkedList<>();
        queue.add(s);
        this.colors.set(s.intValue(), Colors.GRAY);
        this.visited.set(s.intValue(), true);
        while(!queue.isEmpty()){
            T current = queue.poll();
            for(T node: this.graph.get(current.intValue())){
                if(!this.visited.get(node.intValue()) && this.colors.get(node.intValue()).equals(Colors.WHITE)){
                    this.visited.set(node.intValue(), true);
                    this.colors.set(node.intValue(), Colors.GRAY);
                    this.parents.set(node.intValue(), current);
                    queue.add(node);
                }
            }
            this.colors.set(current.intValue(), Colors.BLACK);
        }
    }

    private enum Colors {
        WHITE,
        BLACK,
        GRAY
    }

}
