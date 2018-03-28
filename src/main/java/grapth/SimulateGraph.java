package grapth;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulateGraph {

    public static List<Pair<Integer,Integer>> generateTestCase() {
        List<Pair<Integer,Integer>> edges = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < 1000000; i++){
            int a = random.nextInt(10000) + 1;
            int b = random.nextInt(10000) + 1;
            if(a != b){
                edges.add(new Pair<>(a,b));
            }
        }

        return edges;
    }

}
