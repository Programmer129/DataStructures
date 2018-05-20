package backtracking;

public class RatInMaze {
    private int[][] maze;
    private int[][] path;

    public RatInMaze(int[][] maze, int[][] path) {
        this.maze = maze;
        this.path = path;
    }

    private boolean isSafe(int[][] maze, int x, int y) {
        if (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1) {
            return true;
        }
        return false;
    }

    private void printPath(int[][] path) {
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean solveMazeRecurse(int[][] maze, int x, int y, int[][] path) {
        if (x == maze.length - 1 && y == maze.length - 1) {
            path[x][y]=1;
            return true;
        }
        if (isSafe(maze, x, y)) {
            path[x][y] = 1;
            if (solveMazeRecurse(maze, x + 1, y, path)) {
                return true;

            }
            if (solveMazeRecurse(maze, x, y + 1, path)) {
                return true;
            }

            path[x][y] = 0;
            return false;

        }
        return false;
    }


    public boolean solveMaze(int x, int y) {
        if(solveMazeRecurse(this.maze, x, y, this.path)){
            printPath(this.path);
            return true;
        }
        return false;
    }
}
