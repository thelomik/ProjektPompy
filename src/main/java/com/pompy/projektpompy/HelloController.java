package com.pompy.projektpompy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {
    @FXML
    private Label welcomeText;

    private Calculate calculate = new Calculate();
    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    @FXML
    private TextField textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textFieldCalculate, textFieldPrice;
    @FXML
    private ComboBox comboBox;
    @FXML
    private MenuItem menuItemAbout;

    @FXML
    protected void onChecboxActive() {

        if (checkBox1.isSelected() == true) {
            textField1.setEditable(true);
            textField2.setEditable(true);
        } else {
            textField1.setEditable(false);
            textField2.setEditable(false);
        }
        if (checkBox2.isSelected() == true) {
            textField3.setEditable(true);
            textField4.setEditable(true);
        } else {
            textField3.setEditable(false);
            textField4.setEditable(false);
        }

        if (checkBox3.isSelected() == true) {
            textField5.setEditable(true);
            textField6.setEditable(true);
        } else {
            textField5.setEditable(false);
            textField6.setEditable(false);
        }

        if (checkBox4.isSelected() == true) {
            textField7.setEditable(true);
            textField8.setEditable(true);
        } else {
            textField7.setEditable(false);
            textField8.setEditable(false);
        }
    }

    @FXML
    protected void onActionButton() {

        int va = calculate();

        textFieldCalculate.setText(String.valueOf(va));
    }

    public Integer calculate() {
        int value3 = 0;
        if (checkBox1.isSelected()) {
            int value1 = Integer.parseInt(textField1.getText().trim());
            int value2 = Integer.parseInt(textField2.getText().trim());
            value3 = value1 * value2;

        } else {
            System.out.println("TEST");
        }

        return value3;
    }

    @FXML
    public void aboutInfo(){


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


    }
}