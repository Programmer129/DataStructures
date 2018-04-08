import grapth.informed_search.EightPuzzleBfs;

public class Main {

    public static void main(String[] args) {

        int [][] initial = {
                {1,2,3},
                {5,6,0},
                {7,8,4}
        };

        int [][] fin = {
                {1,2,3},
                {4,5,6},
                {7,8,0}
        };

        EightPuzzleBfs bfs = new EightPuzzleBfs(initial, fin);

        bfs.informedBfs(1,2);

    }
}
