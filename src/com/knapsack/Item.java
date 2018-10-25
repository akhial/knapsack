package com.knapsack;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class Item {

    private int weight;
    private int value;
    private boolean toggle = true;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    Node show() {
        VBox box = new VBox();

        Rectangle r = new Rectangle(25, 25);

        JFXTextField w = new JFXTextField();
        JFXTextField n = new JFXTextField();

        VBox vBox = new VBox();
        vBox.getChildren().add(w);
        vBox.getChildren().add(n);

        box.getChildren().add(r);

        r.setOnMouseClicked(event -> {
            if(toggle) {
                box.getChildren().add(vBox);
                toggle = !toggle;
            } else {
                box.getChildren().remove(1);
                toggle = !toggle;
            }
        });

        return box;
    }
}
