package com.knapsack;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class KnapsackViewController extends Controller {

    @FXML
    StackPane itemContainer;

    @FXML
    StackPane backpackContainer;

    @FXML
    Label weightLabel;

    @FXML
    Label numberLabel;

    public void setup() {
        weightLabel.setText(String.valueOf(knapsack.getW()));
        numberLabel.setText(String.valueOf(knapsack.getN()));

        knapsack.setup();

        VBox container = new VBox();
        container.setSpacing(20);

        int i = 0;

        while(i < knapsack.getN()) {
            HBox hBox = new HBox();
            int j = 0;
            while(j < 10) {
                hBox.getChildren().add(knapsack.getItem(i).show());
                i++; j++;
                if(i >= knapsack.getN()) break;
            }
            hBox.setSpacing(10);
            hBox.setAlignment(Pos.CENTER);
            container.getChildren().add(hBox);
        }
        itemContainer.getChildren().add(container);
    }
}
