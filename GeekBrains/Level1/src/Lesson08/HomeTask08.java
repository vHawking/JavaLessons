package Lesson08;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HomeTask08 extends Application {
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_WIDTH = 510;

    private static Map field;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btnNewGame = new Button("Start new game");
        Button btnExitGame = new Button("Exit game");

        GridPane bottomPanel = new GridPane();
        bottomPanel.setAlignment(Pos.CENTER);
        bottomPanel.setHgap(10);
        bottomPanel.setVgap(10);
        bottomPanel.add(btnNewGame, 0,0);
        bottomPanel.add(btnExitGame, 1,0);

        BorderPane pane = new BorderPane();
        pane.setBottom(bottomPanel);

        field = new Map();


        btnNewGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Let's game start!!!");
            }
        });

        btnExitGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        Scene scene = new Scene(pane, WIN_WIDTH, WIN_HEIGHT);
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Map extends GridPane {
    public Map() {
        setBackground(Color.BLUE);
    }

    private void setBackground(Color blue) {
    }
}
