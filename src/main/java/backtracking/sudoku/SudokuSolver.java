package backtracking.sudoku;

import grapth.Pair;

import static grapth.Constants.NINE;
import static grapth.Constants.ONE;
import static grapth.Constants.TREE;
import static grapth.Constants.ZERO;

@SuppressWarnings("unchecked")
public class SudokuSolver {

    private int [][] grid;

    public SudokuSolver(int [][] grid) {
        this.grid = grid;
    }

    public boolean solve() {

        Pair<Integer, Integer> pair = new Pair<>(ZERO, ZERO);

        if(!numberOfUnassignedCell(pair)) {
            return true;
        }

        for(int start = ONE; start <= NINE; start++) {
            if (isValid(pair.getFirst(), pair.getSecond(), start)) {
                grid[pair.getFirst()][pair.getSecond()] = start;
                if (solve()) {
                    return true;
                }
                grid[pair.getFirst()][pair.getSecond()] = ZERO;
            }
        }
        return false;
    }

    private boolean isValid(int row, int column, int number) {
        for(int i = ZERO; i < NINE; i++){
            if(grid[row][i] == number){
                return false;
            }
        }
        for(int i = ZERO; i < NINE; i++) {
            if (grid[i][column] == number) {
                return false;
            }
        }
        for(int i = ZERO; i< TREE;i++) {
            for(int j = ZERO; j < TREE;j++) {
                if(grid[i + row - row%3][j + column - column%3] == number){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean numberOfUnassignedCell(Pair<Integer,Integer> pair) {
        for(int row = ZERO; row< NINE; row++){
            for(int column =ZERO;column<NINE;column++){
                if(grid[row][column] == ZERO){
                    pair.setFirst(row);
                    pair.setSecond(column);
                    return true;
                }
            }
        }
        return false;
    }

    public void printGrid() {
        for(int i=ZERO;i<NINE;i++) {
            for(int j=ZERO;j<NINE;j++) {
                System.out.print(this.grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
