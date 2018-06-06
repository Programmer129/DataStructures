package common;

import java.util.List;

import static common.Constants.ZERO;

public class Mapper {

    public static int [][] toMatrix(List<List<Integer>> lists) {
        int [][] result = new int[lists.size()][lists.get(ZERO).size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = lists.get(i).stream().mapToInt(Integer::valueOf).toArray();
        }

        return result;
    }

}
