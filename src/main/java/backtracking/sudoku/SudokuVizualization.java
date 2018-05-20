package backtracking.sudoku;

import common.Mapper;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SudokuVizualization extends Application implements Observer {

    private TextField [][] textFields = new TextField[9][9];
    private int [][] grid = new int[9][9];

    private static final String PATH = "C:\\Users\\avtod\\Desktop\\dataStructures\\src\\main\\resources\\sudoku.txt";

    @Override
    public void start(Stage primaryStage)  {

        Thread thread = new Thread(() -> {
            SudokuSolver sudokuSolver = new SudokuSolver(this.grid);
            sudokuSolver.addObserver(this);
            try {
                sudokuSolver.sovler();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "algorithm thread");

        try {
            this.textFields = this.gridToField();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FlowPane flowPane = new FlowPane();
        GridPane board = new GridPane();
        Label label = new Label("Sudoku Solver");

        label.setFont(Font.font(20));
        flowPane.getChildren().add(label);
        flowPane.setAlignment(Pos.CENTER);

        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
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
        thread.start();
    }

    private int [][] loadData() throws IOException {
        Path path = Paths.get(PATH);
        Stream<String> stream = Files.lines(path);
        List<List<Integer>> result = stream.map(line -> Arrays.stream(line.split(" "))
                .map(Integer::valueOf).collect(Collectors.toList())).collect(Collectors.toList());

        return Mapper.toMatrix(result);
    }

    private TextField[][] gridToField() throws IOException {
        TextField[][] matrix = new TextField[9][9];
        int [][] grid = this.loadData();
        this.grid = grid;

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
        this.textFields[arr[0]][arr[1]].setText(String.valueOf(arr[2]));
        this.textFields[arr[0]][arr[1]].setStyle("-fx-text-fill: red;");
        this.textFields[arr[0]][arr[1]].fireEvent(new ActionEvent());
    }
}
