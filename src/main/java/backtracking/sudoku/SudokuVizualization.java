package backtracking.sudoku;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class SudokuVizualization extends Application implements Observer {

    private TextField [][] textFields = new TextField[9][9];
    private int [][] grid = new int[9][9];

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        this.textFields = this.gridToField();

        FlowPane flowPane = new FlowPane();
        GridPane board = new GridPane();
        Label label = new Label("Sudoku Solver");

        label.setFont(Font.font(20));
        flowPane.getChildren().add(label);
        flowPane.setAlignment(Pos.CENTER);

        for (int col = 0, c = 0; col < 9; col++) {
            for (int row = 0, r = 0; row < 9; row++) {
                StackPane cell = new StackPane();
                TextField textField = this.textFields[col][row];

                textField.setMaxWidth(50);
                cell.getChildren().add(textField);
                board.add(cell, col, row);
            }
        }

        flowPane.getChildren().add(board);
        Scene scene = new Scene(flowPane);
        primaryStage.setResizable(false);
        primaryStage.setWidth(500);
        primaryStage.setHeight(400);
        primaryStage.setScene(scene);
        primaryStage.show();

        SudokuSolver sudokuSolver = new SudokuSolver(this.grid);

        sudokuSolver.addObserver(this);

        sudokuSolver.solve();
    }

    private int [][] compute() {
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
       this.grid = grid;
        return this.grid;
    }

    private TextField[][] gridToField() {
        TextField[][] matrix = new TextField[9][9];
        int [][] grid = this.compute();

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                matrix[row][col] = new TextField();
                matrix[row][col].setText(grid[row][col] == 0 ? " " : String.valueOf(grid[row][col]));
            }
        }
        return matrix;
    }

    @Override
    public void update(Observable o, Object arg) {
        int [] arr = (int[])arg;
        System.out.println(arr[0]);
    }
}
