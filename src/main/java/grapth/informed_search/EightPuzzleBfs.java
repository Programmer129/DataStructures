package grapth.informed_search;

import grapth.Constants;

import java.util.Comparator;
import java.util.PriorityQueue;

import static grapth.Constants.MOVES;
import static grapth.Constants.ONE;
import static grapth.Constants.SIZE;
import static grapth.Constants.row;
import static grapth.Constants.column;

public class EightPuzzleBfs {

    private int [][] initialMatrix;
    private int [][] finalMatrix;
    private PriorityQueue<StateNode> pq;

    public EightPuzzleBfs(int[][] initialMatrix, int[][] finalMatrix) {
        this.initialMatrix = initialMatrix;
        this.finalMatrix = finalMatrix;
        this.pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.getDepth() + o.getChangedCells()));
    }

    private int countChangedCells(int [][] initialMatrix, int [][] finalMatrix){
        int answer = Constants.ZERO;
        for(int i=0;i<SIZE;i++){
            for(int j = 0;j<SIZE;j++){
                answer += initialMatrix[i][j]!=finalMatrix[i][j] ? initialMatrix[i][j]!=0 ? 1:0 : 0;
            }
        }
        return answer;
    }

    private boolean isSafe(int x, int y){
        return x>=Constants.ZERO && x<SIZE && y>= Constants.ZERO && y<SIZE;
    }

    private void printMatrix(int [][] matrix){
        for(int i = 0;i<SIZE;i++){
            for(int j=0;j< SIZE;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printPath(StateNode last){
        if(last.parent == null){
            printMatrix(last.getMatrix());
            return;
        }
        printPath(last.parent);
        printMatrix(last.getMatrix());
    }

    public void informedBfs(int blankX, int blankY){
        StateNode node = new StateNode(initialMatrix, blankX, blankY, blankX, blankY, ONE);
        node.parent = null;
        node.setChangedCells(countChangedCells(initialMatrix, finalMatrix));
        pq.add(node);
        while(!pq.isEmpty()) {
            StateNode current = pq.poll();
            if(current.getChangedCells() == Constants.ZERO) {
                printPath(current);
                return;
            }
            for(int i=0;i<MOVES;i++){
                int newX = current.getX() + row[i];
                int newY = current.getY() + column[i];
                if(isSafe(newX, newY)){
                    StateNode next =
                            new StateNode(current.getMatrix(), current.getX(), current.getY(), newX, newY, current.getDepth() + ONE);
                    next.parent = current;
                    next.setChangedCells(countChangedCells(next.getMatrix(),finalMatrix));
                    pq.add(next);
                }
            }
        }
    }

}