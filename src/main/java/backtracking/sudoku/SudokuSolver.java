package backtracking.sudoku;

import grapth.Pair;

import java.util.Observable;

import static grapth.Constants.NINE;
import static grapth.Constants.ONE;
import static grapth.Constants.TREE;
import static grapth.Constants.ZERO;

@SuppressWarnings("unchecked")
class SudokuSolver extends Observable {

    private int [][] grid;
    private int [] messige = new int[3];
    private int step = 0;

    SudokuSolver(int[][] grid) {
        this.grid = grid;
    }

    private boolean solve() throws InterruptedException {

        Pair<Integer, Integer> pair = new Pair<>(ZERO, ZERO);

        if(!numberOfUnassignedCell(pair)) {
            return true;
        }

        for(int start = ONE; start <= NINE; start++) {
            if (isValid(pair.getFirst(), pair.getSecond(), start)) {
                grid[pair.getFirst()][pair.getSecond()] = start;
                this.messige[0] = pair.getFirst();
                this.messige[1] = pair.getSecond();
                this.messige[2] = start;
                setChanged();
                notifyObservers(this.messige);
                System.out.println("step: "+ this.step++);
                Thread.sleep(100);
                if (solve()) {
                    return true;
                }
                grid[pair.getFirst()][pair.getSecond()] = ZERO;
            }
        }
        return false;
    }

    boolean sovler() throws InterruptedException {
        Thread.sleep(5000);
        return solve();
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
