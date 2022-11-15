import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import java.util.Random;

public class DessertGame extends Application {
	private int score = 0;
    @Override
    public void start(final Stage stage) {
        // Step 3 & 4
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Dessert in the Desert JavaFX Game");
        
        // Step 5
        Label scoreLabel = new Label("Score: 0");
        borderPane.setTop(scoreLabel);
        BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        exitButton.requestFocus();
        borderPane.setBottom(exitButton);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);
        
        // Step 6
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);

        // TODO: Step 7-10
        
        //Dessert Button
        Button dessert = new Button("Dessert");
        Button desert1 = new Button("Desert");
        Button desert2 = new Button("Desert");
        Button desert3 = new Button("Desert");
        Button desert4 = new Button("Desert");
        Button desert5 = new Button("Desert");
        Button desert6 = new Button("Desert");
        Button desert7 = new Button("Desert");

        pane.getChildren().add(dessert);
        pane.getChildren().add(desert1);
        pane.getChildren().add(desert2);
        pane.getChildren().add(desert3);
        pane.getChildren().add(desert4);
        pane.getChildren().add(desert5);
        pane.getChildren().add(desert6);
        pane.getChildren().add(desert7);
        
        Random randomGen = new Random();
        Button[] buttons = new Button[]{dessert, desert1, desert2, desert3, desert4, desert5, desert6, desert7};
        
        dessert.setOnAction(event -> {
            score++;
            scoreLabel.setText("Score: "+score);
            randomizeButtonPositions(randomGen, buttons);
            exitButton.requestFocus();
        });
        
        for (int lcv = 1; lcv<buttons.length; lcv++) {
        	buttons[lcv].setOnAction(event -> {
                score--;
                scoreLabel.setText("Score: "+score);
                randomizeButtonPositions(randomGen, buttons);
                exitButton.requestFocus();
            });
        }
        
        randomizeButtonPositions(randomGen, buttons);
        exitButton.requestFocus();
        
        stage.setScene(scene);
        stage.show();
    }
    
    private static void randomizeButtonPositions(Random randomGen, Button[] buttons) {
        for (Button button:buttons) {
            button.setLayoutX(randomGen.nextInt(600));
            button.setLayoutY(randomGen.nextInt(400));
        }
        return;
    }

    public static void main(String[] args) {
        Application.launch();
    }
    
    
}