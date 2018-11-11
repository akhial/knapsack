package com.knapsack;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class KnapsackInputController extends Controller {

    @FXML
    StackPane topLevel;

    @FXML
    JFXTextField weightField;

    @FXML
    JFXTextField numberField;

    @FXML
    JFXButton goButton;

    public void onGoButton() {
        int w, n;
        try {
            w = Integer.parseInt(weightField.getText());
            n = Integer.parseInt(numberField.getText());
            if(n <= 0 || w <= 0) {
                throw new IllegalStateException("Veuillez entrer des nombres strictement positifs!");
            }
            knapsack.setW(w);
            knapsack.setN(n);

            Controller controller = mainScreen.setScene("/KnapsackView.fxml");
            controller.setKnapsack(knapsack);
            controller.setMainScreen(mainScreen);
            controller.setup();

        } catch(NumberFormatException nfe) {
            err("Veuillez entrer des nombres!");
        } catch(Exception e) {
            err(e.getMessage());
        }
    }

    @Override
    void setup() {
        weightField.setText(String.valueOf(knapsack.getW()));
        numberField.setText(String.valueOf(knapsack.getN()));
    }

    private void err(String message) {
        JFXDialog dialog = new JFXDialog();

        Label content = new Label(message);
        content.setPadding(new Insets(30, 30, 30, 30));
        dialog.setContent(content);
        dialog.show(topLevel);
    }
}
