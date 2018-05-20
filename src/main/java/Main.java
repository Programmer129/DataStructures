import backtracking.RatInMaze;

public class Main {

    public static void main(String[] args)  {
        int [][]maze =
                {{1,1,1,1},
                        {0,0,0,1},
                        {0,0,0,1},
                        {0,0,0,1}
                };
        int [][] path = {{0,0,0,0}, {0,0,0,0},{0,0,0,0},{0,0,0,0}};
        RatInMaze ratInMaze = new RatInMaze(maze,path);
        ratInMaze.solveMaze(0,0);
    }
}
