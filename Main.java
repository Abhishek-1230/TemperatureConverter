package com.internshala.temp;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);

    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");

        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createmenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");

        primaryStage.show();
    }
    private MenuBar createmenu(){


        Menu fileMenu = new Menu("File");
        MenuItem newmenuItem = new MenuItem("New");

        newmenuItem.setOnAction(event -> System.out.println("New menu Item Click"));
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitmenuitem = new MenuItem(" Quit");

        quitmenuitem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });


        fileMenu.getItems().addAll(newmenuItem,separatorMenuItem, quitmenuitem);

        Menu HelpMenu = new Menu("Help");
        MenuItem learnmenuitem = new MenuItem("Learn how to use");
        MenuItem aboutmenuitem = new MenuItem("About");

        aboutmenuitem.setOnAction(event -> aboutapp());
        HelpMenu.getItems().addAll(learnmenuitem, aboutmenuitem);



        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu , HelpMenu);

        return menuBar;
    }

    private void aboutapp() {
        Alert alertdialog = new Alert(Alert.AlertType.INFORMATION);
        alertdialog.setTitle("My first Desktop Application");
        alertdialog.setHeaderText("Learning Fx");
        alertdialog.setContentText("I am just a Beginner but i Want to perform more");

        ButtonType yesbtn = new ButtonType("yes");
        ButtonType nobtn = new ButtonType("no");
        alertdialog.getButtonTypes().addAll(yesbtn, nobtn);
        Optional<ButtonType> clickbtn = alertdialog.showAndWait();

        if(clickbtn.isPresent() && clickbtn.get() == yesbtn){
            System.out.println("Yes Button is Clicked");
        }else{
            System.out.println("No Button is Clicked");
        }

    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
