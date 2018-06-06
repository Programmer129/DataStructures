package grapth.network_flow;

import grapth.Pair;
import grapth.weighted_graph.WeithedGraph;

import java.util.ArrayList;
import java.util.List;

public class FordFulkerson {

    private WeithedGraph<Integer, Integer> graph;
    private int s;
    private int t;
    private boolean prune = false;

    public FordFulkerson(WeithedGraph<Integer, Integer> graph,int s, int t) {
        this.graph = graph;
        this.s = s;
        this.t = t;
    }

    private boolean isPath(WeithedGraph<Integer,Integer> graph, int s, int t, List<Integer> parent, List<Boolean> visited) {
        visited.set(s, true);
        if(s == t){
            this.prune = true;
            return true;
        }
        for (Pair<Integer, Integer> pair : graph.getGraph().get(s)) {
            if(!visited.get(pair.getFirst()) && pair.getSecond() > 0 && !prune) {
                parent.set(pair.getFirst(), s);
                isPath(graph, pair.getFirst(), t, parent, visited);
            }
        }
        return prune;
    }

    public int maxFlow() {
        int flow = 0;

        while(true) {
            List<Integer> parents = new ArrayList<>(graph.getGraph().size());
            List<Boolean> visited = new ArrayList<>(graph.getGraph().size());

            for (int i = 0; i< graph.getGraph().size(); i++) {
                parents.add(-1);
                visited.add(false);
            }

            int f = Integer.MAX_VALUE;

            boolean res = isPath(graph, s, t , parents, visited);

            if(!res) {
                break;
            }
            prune = false;

            for(int v = t; parents.get(v) != -1; v = parents.get(v)) {
                int result = 0;
                for (Pair<Integer, Integer> pair : graph.getGraph().get(parents.get(v))) {
                    if(pair.getFirst().equals(v)) {
                        result = pair.getSecond();
                        break;
                    }
                }
                f = Math.min(f, result);
            }

            flow += f;

            for(int v = t; parents.get(v) != -1; v = parents.get(v)) {
                Pair<Integer, Integer> pair;
                for (Pair<Integer, Integer> integerPair : graph.getGraph().get(parents.get(v))) {
                    if(integerPair.getFirst().equals(v)) {
                        pair = integerPair;
                        pair.setSecond(pair.getSecond() - f);
                        int index = graph.getGraph().get(parents.get(v)).indexOf(pair);
                        graph.getGraph().get(parents.get(v)).set(index, pair);
                        break;
                    }
                }
            }
        }

        return flow;
    }
}
