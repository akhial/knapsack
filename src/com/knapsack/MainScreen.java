package com.knapsack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainScreen extends Application {

    private Stage primaryStage;

    Controller setScene(String url) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(url));
        Parent root = loader.load();

        primaryStage.setTitle("Knapsack");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.setResizable(true);
        primaryStage.show();

        return loader.getController();
    }

    void reset() throws Exception {
        Knapsack knapsack = new Knapsack();

        Controller controller = setScene("/KnapsackInputView.fxml");
        controller.setKnapsack(knapsack);
        controller.setMainScreen(this);
        primaryStage.setResizable(false);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Knapsack knapsack = new Knapsack();

        Controller controller = setScene("/KnapsackInputView.fxml");
        controller.setKnapsack(knapsack);
        controller.setMainScreen(this);
        primaryStage.setResizable(false);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
