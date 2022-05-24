package com.pompy.projektpompy;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {
    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    @FXML
    private TextField textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textFieldSum, textFieldPrice;
    @FXML
    private ComboBox comboBox;
    @FXML
    private MenuItem menuItemAbout;

    @FXML
    protected void onCheckboxActive() {
        if (checkBox1.isSelected()) {
            textField1.setEditable(true);
            textField2.setEditable(true);
        } else {
            textField1.setEditable(false);
            textField2.setEditable(false);
        }
        if (checkBox2.isSelected()) {
            textField3.setEditable(true);
            textField4.setEditable(true);
        } else {
            textField3.setEditable(false);
            textField4.setEditable(false);
        }

        if (checkBox3.isSelected()) {
            textField5.setEditable(true);
            textField6.setEditable(true);
        } else {
            textField5.setEditable(false);
            textField6.setEditable(false);
        }

        if (checkBox4.isSelected()) {
            textField7.setEditable(true);
            textField8.setEditable(true);
        } else {
            textField7.setEditable(false);
            textField8.setEditable(false);
        }
    }

    @FXML
    protected void priceOfKwh() {
        double price1 = 0.63;
        double price2 = 0.64;
        double price3 = 0.70;

        String value = (String) comboBox.getValue();

        switch (value) {
            case "Zachodnio-pomorskie": {
                textFieldPrice.setText(String.valueOf(price1));
                break;
            }
            case "Pomorskie": {
                textFieldPrice.setText(String.valueOf(price2));
                break;
            }
            case "Wielkopolskie": {
                textFieldPrice.setText(String.valueOf(price3));
                break;
            }
        }
        sumPumps();
    }

    @FXML
    public void sumPumps() {
        if (textFieldPrice.getText() != "") {
            double sum = 0;
            double kwhPrice = Double.parseDouble(textFieldPrice.getText().trim());
            if (checkBox1.isSelected() && textField1.getText() != "" && textField2.getText() != "") {
                sum += Double.parseDouble(textField1.getText().trim()) * Double.parseDouble(textField2.getText().trim());
            }
            if (checkBox2.isSelected() && textField3.getText() != "" && textField4.getText() != "") {
                sum += Double.parseDouble(textField3.getText().trim()) * Double.parseDouble(textField4.getText().trim());
            }
            if (checkBox3.isSelected() && textField5.getText() != "" && textField6.getText() != "") {
                sum += Double.parseDouble(textField5.getText().trim()) * Double.parseDouble(textField6.getText().trim());
            }
            if (checkBox4.isSelected() && textField7.getText() != "" && textField8.getText() != "") {
                sum += Double.parseDouble(textField7.getText().trim()) * Double.parseDouble(textField8.getText().trim());
            }
            textFieldSum.setText(String.valueOf(Math.round(sum * kwhPrice*100.0)/100.0));
        }
    }

    @FXML
    public void aboutInfo() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("about-view.fxml"));
        /*
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
         */
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(scene);
        stage.show();
    }
}