package app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ml.CrossValidation;
import ml.DataPoint;
import ml.Knn;
import parsing.DataParser;
import ui.UserInterface;

import java.io.File;
import java.io.FileNotFoundException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        UserInterface userInterface = new UserInterface(primaryStage);

        userInterface.showUserInterface();
    }


    public static void main(String[] args) throws FileNotFoundException {

        launch(args);
    }
}
