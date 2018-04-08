package grapth.informed_search;

public class StateNode {

    public StateNode parent;

    private int matrix[][];
    private int x;
    private int y;
    private int depth;
    private int changedCells;

    private static final int SIZE = 3;

    StateNode(int[][] matrix, int x, int y, int newX, int newY, int depth) {
        this.matrix = new int[SIZE][SIZE];
        copy(matrix,this.matrix);

        int tmp = this.matrix[x][y];
        this.matrix[x][y] = this.matrix[newX][newY];
        this.matrix[newX][newY] = tmp;
        this.depth = depth;
        this.x = newX;
        this.y = newY;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getChangedCells() {
        return changedCells;
    }

    public void setChangedCells(int changedCells) {
        this.changedCells = changedCells;
    }

    private void copy(int [][] init, int [][] cp){
        for(int i = 0;i<SIZE;i++){
            System.arraycopy(init[i], 0, cp[i], 0, SIZE);
        }
    }
}
