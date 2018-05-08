import backtracking.sudoku.SudokuSolver;

public class Main {

    public static void main(String[] args) {
        int [][] grid =
                {
                        {0,1,0,0,0,2,0,0,9},
                        {8,0,0,0,0,0,0,0,0},
                        {0,0,4,0,6,0,0,5,0},
                        {9,0,0,5,0,0,0,8,0},
                        {0,2,0,0,0,0,7,0,0},
                        {0,0,3,0,0,1,0,0,6},
                        {0,5,0,7,0,0,2,0,0},
                        {0,0,0,0,9,0,0,4,0},
                        {0,0,6,0,0,3,0,0,1}
                };
        SudokuSolver sudokuSolver = new SudokuSolver(grid);
        sudokuSolver.solve();
        sudokuSolver.printGrid();
    }
}
