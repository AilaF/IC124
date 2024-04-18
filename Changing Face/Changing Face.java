import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.shape.Line;

public class ChangingFacee extends Application {

    @Override
    public void start(Stage stage) {
        // create and configure the main circle for the face
        Circle face = new Circle(125, 125, 80);
        face.setFill(Color.YELLOW);
        face.setStroke(Color.BLACK);
        
        // create and configure the circles for the eyes
        Circle rightEye = new Circle(86, 100, 10);
        rightEye.setFill(Color.YELLOW);
        rightEye.setStroke(Color.BLACK);
        
        Circle leftEye = new Circle(162, 100, 10);
        leftEye.setFill(Color.YELLOW);
        leftEye.setStroke(Color.BLACK);
        
        // create and configure a smiling mouth (this is how it will start)
        Arc mouth = new Arc(125, 150, 45, 35, 0, -180);
        mouth.setFill(Color.YELLOW);
        mouth.setStroke(Color.BLACK);
        mouth.setType(ArcType.OPEN);
        
        // create and configure the text
        Text caption = new Text(95, 240, "Smile");
        caption.setFill(Color.BLACK);
        caption.setFont(Font.font("Verdana", 15));
        
        // create a group that holds all the features
        Group group = new Group(face, rightEye, leftEye, mouth, caption);
        
        // create buttons to change facial expression
        Button smileButton = new Button("Smile");
        Button frownButton = new Button("Frown");
        Button shockButton = new Button("Shock");
        
        // create a horizontal container to hold the buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(smileButton, frownButton, shockButton);
        
        // create a vertical container to hold the button box and the face group
        VBox root = new VBox(10);
        root.setBackground(Background.EMPTY);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(buttonBox, group);
        
        // create and configure a new scene
        Scene scene = new Scene(root, 250, 275, Color.WHITE);
        
        
        // change facial expression based on button clicks
        smileButton.setOnAction(e -> {mouth.setLength(-180); caption.setText("Smile");});
        frownButton.setOnAction(e -> {mouth.setLength(180); caption.setText("Frown");});
        shockButton.setOnAction(e -> {mouth.setLength(360); caption.setText("Shock");});
        
        // add the scene to the stage, then set the title
        stage.setScene(scene);
        stage.setTitle("Changing Face by Clyde Balaman");
        // show the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
