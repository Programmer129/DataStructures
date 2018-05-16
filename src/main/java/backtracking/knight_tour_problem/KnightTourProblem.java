package backtracking.knight_tour_problem;

import grapth.Pair;

import java.util.Arrays;
import java.util.Observable;

import static common.Constants.EIGHT;
import static common.Constants.ZERO;

@SuppressWarnings("unchecked")
public class KnightTourProblem extends Observable {

    private boolean [][] board;
    private int [][] visualise;
    private int moves = 0;
    private int knightX;
    private int knightY;
    private int [] moveX = {-1, -2, -2, -1, 1, 2,  2,  1};
    private int [] moveY = {-2, -1,  1,  2, 2, 1, -1, -2};
    public int step = 0;

    public KnightTourProblem(int knightX, int knightY) {
        this.board = new boolean[EIGHT][EIGHT];
        this.visualise = new int[EIGHT][EIGHT];
        for (int i = 0; i < board.length; i++) {
            this.board[i] = new boolean[EIGHT];
            this.visualise[i] = new int[EIGHT];
            Arrays.fill(this.board[i], false);
        }
        this.knightX = knightX;
        this.knightY = knightY;
        this.board[this.knightX][this.knightY] = true;
        this.visualise[this.knightX][this.knightY] = moves;
    }

    private boolean solve(int x, int y, int moves) throws InterruptedException {
        if(!checkUnvisitedCell()) {
            return true;
        }

        this.step++;

        for (int move = ZERO; move < EIGHT; move++) {
            int nextX = x + moveX[move];
            int nextY = y + moveY[move];
            if(nextX >=0 && nextX < EIGHT && nextY >=0 && nextY < EIGHT && !this.board[nextX][nextY]) {
                this.board[nextX][nextY] = true;
                setChanged();
                notifyObservers(new Pair<>(nextX, nextY));
                Thread.sleep(100);
                this.visualise[nextX][nextY] = moves + 1;
                if (solve(nextX, nextY, moves + 1)) {
                    return true;
                }
                this.board[nextX][nextY] = false;
            }
        }
        return false;
    }

    public void sovler() throws InterruptedException {
        Thread.sleep(3000);
        boolean solve = solve(this.knightX, this.knightY, this.moves);
        System.out.println(solve ? "Done" : "No solution");
    }

    private boolean checkUnvisitedCell() {
        for (boolean[] aBoard : this.board) {
            for (boolean anABoard : aBoard) {
                if (!anABoard) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printBoard() {
        for (int[] booleans : visualise) {
            for (int aBoolean : booleans) {
                if(aBoolean/10 != 0) {
                    System.out.print(aBoolean+"  ");
                }else{
                    System.out.print(" " + aBoolean + "  ");
                }
            }
            System.out.println();
        }
    }
}
