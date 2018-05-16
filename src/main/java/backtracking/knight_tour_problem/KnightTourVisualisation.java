package backtracking.knight_tour_problem;

import grapth.Pair;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.Observable;
import java.util.Observer;

public class KnightTourVisualisation extends Application implements Observer {

    private static final String PATH = "/home/levani/IdeaProjects/dataStructures/src/main/resources/knight.png";

    private GridPane board;

    @Override
    public void start(Stage primaryStage) {

        Thread thread = new Thread(() -> {
           KnightTourProblem knightTourProblem = new KnightTourProblem(5, 5);
           knightTourProblem.addObserver(this);
            try {
                knightTourProblem.sovler();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        board = new GridPane();

        drawBoard(board);

        setKnight(board, 5, 5);

        Scene scene = new Scene(board);

        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setResizable(false);
        primaryStage.show();
        thread.start();
    }

    private void drawBoard(GridPane board) {
        board.setAlignment(Pos.CENTER);
        Rectangle [][] rectangles = new Rectangle[9][9];

        for(int i = 0; i< 8; i++){
            for(int j = 0; j<9;j++){
                StackPane cell = new StackPane();
                if(j == 0) {
                    Label label = new Label();
                    label.setMaxWidth(50);
                    label.setMaxHeight(50);
                    label.setText(String.valueOf(i+1));
                    label.setFont(Font.font(20));
                    cell.getChildren().add(label);

                    board.add(cell, j, i );
                    continue;
                }
                rectangles[i][j] = new Rectangle();
                rectangles[i][j].setWidth(50);
                rectangles[i][j].setHeight(50);
                if(i%2==0) {
                    if(j%2==0) {
                        rectangles[i][j].setFill(Color.web("#5A4C23"));
                    }
                    else{
                        rectangles[i][j].setFill(Color.web("#C6CAB0"));
                    }
                }
                else{
                    if(j%2==0) {
                        rectangles[i][j].setFill(Color.web("#C6CAB0"));
                    }
                    else{
                        rectangles[i][j].setFill(Color.web("#5A4C23"));
                    }
                }

                rectangles[i][j].setStroke(Color.WHITE);

                cell.getChildren().add(rectangles[i][j]);

                board.add(cell, j, i);
            }
        }

        for(int i = 1; i< 9; i++) {
            StackPane cell = new StackPane();
            Label label = new Label();
            label.setMaxWidth(50);
            label.setMaxHeight(50);
            label.setText(String.valueOf((char)(i+64)));
            label.setFont(Font.font(20));
            cell.getChildren().add(label);
            label.setAlignment(Pos.CENTER);
            board.add(cell, i, 8);
        }
    }

    private void setKnight(GridPane board, int column, int row) {
        Image image = new Image(Paths.get(PATH).toUri().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);

        board.add(imageView, 5, 5);
    }


    @Override
    public void update(Observable o, Object arg) {
        Pair<Integer, Integer> pair = (Pair<Integer, Integer>)arg;
        // link between Fx and algorithm thread
    }
}
