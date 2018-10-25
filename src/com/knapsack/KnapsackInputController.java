package com.knapsack;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import javax.swing.*;

public class KnapsackInputController extends Controller {

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
            controller.setup();

        } catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer des nombres!", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    void setup() {
        weightField.setText(String.valueOf(knapsack.getW()));
        numberField.setText(String.valueOf(knapsack.getN()));
    }
}
