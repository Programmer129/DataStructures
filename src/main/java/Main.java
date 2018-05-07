import backtracking.SudokuSolver;

public class Main {

    public static void main(String[] args) {
        int [][] grid =
                {
                        {9,0,0,8,0,1,0,6,5},
                        {0,0,1,2,6,5,3,8,9},
                        {0,6,0,9,0,7,4,1,2},
                        {3,1,6,5,2,4,9,0,8},
                        {0,8,0,1,9,0,0,0,0},
                        {2,4,9,6,0,8,5,3,0},
                        {0,9,3,4,0,2,0,5,7},
                        {1,5,4,0,0,9,6,2,3},
                        {7,2,8,3,0,0,1,9,4}
                };
        SudokuSolver sudokuSolver = new SudokuSolver(grid);
        sudokuSolver.solve();
        sudokuSolver.printGrid();
    }
}
