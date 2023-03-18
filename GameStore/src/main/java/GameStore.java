

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class Project extends Application{

    @Override
    public void start(Stage primaryStage){
    Pane Hpane = new HBox(10); //Horizontal box that is the pane that creates a row! (10 is ten pixels away)
    //we dont necesarrily have to use HBox or plain pane, this is just to test ig

    Hpane.setPadding(new Insets(200, 300, 200, 300)); //setting the margin of the pane

    Image image = new Image("image/ca.gif"); //creates the image
    
    Hpane.getChildren().add(new ImageView(image));//add image to pane
    
    Button button1 = new Button("ADD GAME!"); //button for add game
    Button button2 = new Button("SEARCH GAME!"); //button for search game

    //setting preferences for the buttons 
    button1.setPrefWidth(100);
    button1.setPrefHeight(50);
    button2.setPrefWidth(100);
    button2.setPrefHeight(50);

    //adding the buttons
    Hpane.getChildren().add(button1);   
    Hpane.getChildren().add(button2);  

    //checking if title works
    Label label = new Label("Game Store");

    //setting the style of the title
    label.setFont(Font.font("Times New Roman", 
      FontWeight.BOLD, FontPosture.ITALIC, 20));

    //adding the title
    Hpane.getChildren().add(label);

    //setting up the scene
    Scene scene = new Scene(Hpane);
    primaryStage.setTitle("Professor might be a spy omg"); // Set the stage title holy fuck hes probably an american spy
    primaryStage.setScene(scene);
    primaryStage.show(); // Display the stage

    }

    public static void main(String[] args){
        launch(args);
    }
}

