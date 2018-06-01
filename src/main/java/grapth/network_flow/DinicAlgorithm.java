package grapth.network_flow;

import grapth.Pair;
import grapth.weighted_graph.WeithedGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DinicAlgorithm {

    private WeithedGraph<Integer, Integer> graph;
    private int s;
    private int t;
    private boolean prune;
    private int flow;

    public DinicAlgorithm(WeithedGraph<Integer, Integer> graph, int s, int t) {
        this.graph = graph;
        this.s = s;
        this.t = t;
    }

    private boolean isPath(WeithedGraph<Integer, Integer> graph,int [] level, int s, int t) {
        level[s] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for (Pair<Integer, Integer> pair : graph.getGraph().get(current)) {
                if(level[pair.getFirst()] < 0 && pair.getSecond() > 0) {
                    level[pair.getFirst()] = level[current] + 1;
                    queue.add(pair.getFirst());
                }
            }
        }

        return level[t] > 0;
    }

    private int getFlow(WeithedGraph<Integer, Integer> graph, int[] level, int s, int t, boolean[] visited, int [] parents) {
        visited[s] = true;
        boolean valid = false;
        if(s == t){
            this.prune = true;
           return flow;
        }
        for (Pair<Integer, Integer> pair : graph.getGraph().get(s)) {
            if(!visited[pair.getFirst()] && pair.getSecond() > 0 && !prune && level[s] + 1 == level[pair.getFirst()]) {
                valid = true;
                flow = Math.min(flow, pair.getSecond());
                parents[pair.getFirst()] = s;
                int res = getFlow(graph, level, pair.getFirst(), t, visited, parents);
                if(res == 0) {
                    flow = Integer.MAX_VALUE;
                }
            }
        }
        return valid ? flow : 0;
    }

    public int maxFlow() {
        int flow = 0;

        while(true) {
            int [] level = new int[graph.getGraph().size()];
            Arrays.fill(level, -1);

            if(!isPath(graph, level, s, t)) {
                break;
            }

            while(true) {
                int [] parents = new int[graph.getGraph().size()];
                boolean [] visited = new boolean[graph.getGraph().size()];
                Arrays.fill(parents, -1);
                Arrays.fill(visited, false);

                this.prune = false;
                this.flow = Integer.MAX_VALUE;
                int tempFlow = getFlow(graph, level, s, t, visited, parents);

                if(tempFlow <= 0 || tempFlow == Integer.MAX_VALUE) {
                    break;
                }

                for(int v = t; parents[v] != -1; v = parents[v]) {
                    Pair<Integer, Integer> pair;
                    for (Pair<Integer, Integer> integerPair : graph.getGraph().get(parents[v])) {
                        if(integerPair.getFirst().equals(v)) {
                            pair = integerPair;
                            pair.setSecond(pair.getSecond() - tempFlow);
                            int index = graph.getGraph().get(parents[v]).indexOf(pair);
                            graph.getGraph().get(parents[v]).set(index, pair);
                            break;
                        }
                    }
                }

                flow +=tempFlow;
            }
        }

        return flow;
    }
}
