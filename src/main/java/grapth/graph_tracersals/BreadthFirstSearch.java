package grapth.graph_tracersals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {

    private List<Boolean> visited;
    private List<Integer> parents;
    private List<Set<Integer>> graph;
    private List<Colors> colors;

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
        Colors[] arr2 = new Colors[16];
        Arrays.fill(arr2, Colors.WHITE);
        this.colors = Arrays.asList(arr2);
    }

    public BreadthFirstSearch() {
        this.init();
    }

    public void setGraph(List<Set<Integer>> graph){
        this.graph = graph;
    }

    public void bfs(int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        this.colors.set(s, Colors.GRAY);
        this.visited.set(s, true);
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int node: this.graph.get(current)){
                if(!this.visited.get(node) && this.colors.get(node).equals(Colors.WHITE)){
                    this.visited.set(node, true);
                    this.colors.set(node, Colors.GRAY);
                    this.parents.set(node, current);
                    queue.add(node);
                }
            }
            this.colors.set(current, Colors.BLACK);
        }
    }

    private enum Colors {
        WHITE,
        BLACK,
        GRAY
    }

}
