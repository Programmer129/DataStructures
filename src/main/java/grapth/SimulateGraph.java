package grapth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class SimulateGraph {

    public static List<Pair<Integer,Pair<Integer,Integer>>> generateTestCase() {
        Set<Pair<Integer, Pair<Integer,Integer>>> set = new HashSet<>();

        Random random = new Random();

        for(int i = 0; i < 1000; i++){
            int a = random.nextInt(100) + 1;
            int b = random.nextInt(100) + 1;
            int w = random.nextInt(2000)+1;
            if(a != b){
                if(a > b){
                    int tmp = a^b;
                    a = b;
                    b = tmp^a;
                }


                set.add(new Pair<>(a,new Pair<>(b,w)));
            }
        }

        return new ArrayList<>(set);
    }

}
