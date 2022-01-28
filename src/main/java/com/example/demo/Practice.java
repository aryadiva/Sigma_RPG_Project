package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Objects;


public class Practice extends Application{

    public static void main(String[] args){
        launch(args);
    }

    // Entire window calls Stage
    // Content inside your window calls Scene
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Title of Window");

        Button button;
        button = new Button();
        button.setText(" Night comes, and you are driving alone in the forest." +
                " Suddenly, your car are stopping working, no matter you have tried to restart the car engine so many times!" +
                "'Damn it! Why bad luck keeps happening on me!' You shouted with frustration");

//        Rectangle textBox = new Rectangle(500,250);
//        textBox.setOpacity(0.6);
//        textBox.setFill(Color.RED);
//        textBox.setStroke(Color.GREEN);

        Image img = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/ImgForest.jpg")));

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(900);
        imgView.setFitHeight(700);

        TextArea textBox = new TextArea();

        textBox.setPrefColumnCount(15);
        textBox.setPrefHeight(450);
        textBox.setPrefWidth(300);
        textBox.setText(" Night comes, and you are driving alone in the forest.\n" +
                " Suddenly, your car are stopping working, no matter you have tried to restart the car engine so many times!\n" +
                "'Damn it! Why all the bad luck keeps happening on me!' You grumbled.\n");


        StackPane layout = new StackPane();
        layout.getChildren().addAll(textBox,button);


        Scene scene = new Scene(layout, 900,750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
