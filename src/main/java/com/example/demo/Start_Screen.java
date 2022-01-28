package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.*;

public class Start_Screen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    AudioClip audio = new AudioClip(getClass().getResource("audio/DS.mp3").toExternalForm());
    public void start(Stage primaryStage) throws Exception{

        Image icon = new Image("file:src/main/resources/images/logo1.png");
        primaryStage.getIcons().add(icon);

        primaryStage.setTitle("Forest");
        Pane root = new Pane();
        root.setPrefSize(1080,720);

        Image img = new Image("file:src/main/resources/images/gifBG2.gif");

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(1080);
        imgView.setFitHeight(720);

        GameMenu gameMenu = new GameMenu(primaryStage);
        GameTitle gameTitle = new GameTitle();

        root.getChildren().addAll(imgView, gameMenu, gameTitle);

        // set a new scene
        Scene scene = new Scene(root);

        audio.play();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // Create a Game Title named "FOREST"
    public static class GameTitle extends StackPane{

        private Text t;

        public GameTitle(){

            t = new Text("Sigma Survival\nRPG");
            t.setFont(Font.font("Verdana" , 70));
            t.setFill(Color.WHITE);

            setAlignment(Pos.CENTER_LEFT);
            setRotate(-0.5);
            getChildren().addAll(t);

            t.setTranslateX(70);
            t.setTranslateY(150);

        }
    }

    public static class GameMenu extends Parent {
        public GameMenu(Stage w){
            VBox menu = new VBox(10);
            VBox subMenu = new VBox(10);

            menu.setTranslateX(80);
            menu.setTranslateY(400);

            subMenu.setTranslateX(100);
            subMenu.setTranslateY(200);

            final int offset = 400;

            MenuButton btnStart = new MenuButton("PLAY GAME");
            btnStart.setOnMouseClicked(event -> {
                UserInterface UI = new UserInterface();
                UI.createUI(w);

            });

            MenuButton btnExit = new MenuButton("QUIT GAME");
            btnExit.setOnMouseClicked(event -> {
                System.exit(0);
            });

            menu.getChildren().addAll(btnStart, btnExit);

            Rectangle background = new Rectangle (1080,720);
            background.setFill(Color.BLACK);
            background.setOpacity(0.4);

            getChildren().addAll(background, menu);
        }
    }

    // Menu button design
    public static class MenuButton extends StackPane{
        private Text text;

        public MenuButton(String name){
            text = new Text(name);
            text.getFont();
            text.setFont(Font.font(20));
            text.setFill(Color.WHITE);

            Rectangle box = new Rectangle(150, 40);
            box.setOpacity(0.6);
            box.setFill(Color.BLACK);
            box.setEffect(new GaussianBlur(3.5));

            setAlignment(Pos.CENTER_LEFT);
            setRotate(-0.5);
            getChildren().addAll(box, text);

            setOnMouseEntered(event -> {
                box.setTranslateX(5);
                text.setTranslateX(5);
                box.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
            });

            setOnMouseExited(event -> {
                box.setTranslateX(0);
                text.setTranslateX(0);
                box.setFill(Color.BLACK);
                text.setFill(Color.RED);
            });

            DropShadow drop = new DropShadow(50, Color.RED);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));

        }
    }


}

