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

public class SudokuVizualization extends Application {

    private TextField [][] textFields = new TextField[9][9];

    @Override
    public void start(Stage primaryStage) {

        FlowPane flowPane = new FlowPane();
        GridPane board = new GridPane();

        Label label = new Label("Sudoku Solver");
        label.setFont(Font.font(20));
        flowPane.getChildren().add(label);
        flowPane.setAlignment(Pos.CENTER);

        for (int col = 0; col < 11; col++) {
            for (int row = 0; row < 13; row++) {
                StackPane cell = new StackPane();
                TextField textField = new TextField();

                textField.setMaxWidth(50);
                cell.getChildren().add(textField);

                if(row == 3 || row == 8) {
                    row++;
                    board.add(new Label(" "), col, row);
                    continue;
                }

                board.add(cell, col, row);
            }
            if(col == 2 || col == 6) {
                col++;
                for (int i = 0; i < 11; i++) {
                    board.add(new Label(" "), col, i);
                }
            }
        }


        flowPane.getChildren().add(board);
        Scene scene = new Scene(flowPane);
        primaryStage.setResizable(false);
        primaryStage.setWidth(500);
        primaryStage.setHeight(400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
