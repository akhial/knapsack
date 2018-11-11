package com.knapsack;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

class Item {

    private int id;
    private int weight;
    private int value;
    private boolean toggle = true;
    private boolean taken = false;
    private boolean lock = false;

    Item(int id, int weight, int value) {
        this.id = id;
        this.weight = weight;
        this.value = value;
    }

    int getWeight() {
        return weight;
    }

    int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }

    void setValue(int value) {
        this.value = value;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public void lock() {
        lock = true;
    }

    Node show() {
        VBox box = new VBox();
        StackPane pane = new StackPane();

        Rectangle r = new Rectangle(30, 30);

        r.setId("item");
        if(taken)
            r.setId("taken");

        Label wl = new Label(String.valueOf(weight));
        Label vl = new Label(String.valueOf(value));
        Label id = new Label(String.valueOf(this.id));

        wl.setId("item-label");
        vl.setId("item-label");
        if(taken) {
            wl.setId("item-taken");
            vl.setId("item-taken");
        }

        VBox labelBox = new VBox();
        labelBox.getChildren().addAll(wl, vl);

        pane.getChildren().add(r);
        pane.getChildren().add(labelBox);

        TextField w = new TextField();
        TextField v = new TextField();

        w.setId("info-input");
        v.setId("info-input");

        w.textProperty().addListener((o, oldValue, newValue) -> {
            try {
                weight = Integer.parseInt(newValue);
                wl.setText(newValue);
            } catch(NumberFormatException nfe) {
                weight = 0;
                wl.setText("0");
            }
        });

        v.textProperty().addListener((o, oldValue, newValue) -> {
            try {
                value = Integer.parseInt(newValue);
                vl.setText(newValue);
            } catch(NumberFormatException nfe) {
                value = 0;
                vl.setText("0");
            }
        });

        w.setPrefSize(25, 25);
        v.setPrefSize(25, 25);

        VBox vBox = new VBox();
        vBox.getChildren().add(w);
        vBox.getChildren().add(v);

        box.getChildren().add(id);
        box.getChildren().add(pane);

        if(!lock) {
            pane.setOnMouseClicked(event -> {
                if(toggle) {
                    box.getChildren().add(vBox);
                    toggle = !toggle;
                } else {
                    box.getChildren().remove(2);
                    toggle = !toggle;
                }
            });
        }

        return box;
    }
}
