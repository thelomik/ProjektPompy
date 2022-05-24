package com.pompy.projektpompy;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.Data;

import java.io.IOException;
import java.util.LinkedList;

@Data
public class HelloController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    @FXML
    private TextField textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textFieldSum, textFieldPrice,textBoxHidden;
    @FXML
    private ComboBox comboBox,comboBox2,comboBoxTlo;
    @FXML
    private MenuItem menuItemAbout,saveMenuItem;
    Tools tools = new Tools();
    @FXML private LinkedList<Label> labelList = new LinkedList<>();

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
    protected void sumPumps() {
        if (textFieldPrice.getText() != "") {
            String value = textBoxHidden.getText().trim();
            double sum = 0;
            double kwhPrice = Double.parseDouble(textFieldPrice.getText().trim());

            switch (value){
                case "1":{

                    if (checkBox1.isSelected() && textField1.getText() != "" && textField2.getText() != "") {
                        sum += Double.parseDouble(textField1.getText().trim()) * (Double.parseDouble(textField2.getText().trim()))/1000;
                    }
                    if (checkBox2.isSelected() && textField3.getText() != "" && textField4.getText() != "") {
                        sum += Double.parseDouble(textField3.getText().trim()) * (Double.parseDouble(textField4.getText().trim()))/1000;
                    }
                    if (checkBox3.isSelected() && textField5.getText() != "" && textField6.getText() != "") {
                        sum += Double.parseDouble(textField5.getText().trim()) * (Double.parseDouble(textField6.getText().trim()))/1000;
                    }
                    if (checkBox4.isSelected() && textField7.getText() != "" && textField8.getText() != "") {
                        sum += Double.parseDouble(textField7.getText().trim()) * (Double.parseDouble(textField8.getText().trim()))/1000;
                    }
                    textFieldSum.setText(String.valueOf(Math.round(sum * kwhPrice * 100.0) / 100.0));
                    break;
                }
                case "7":{
                    if (checkBox1.isSelected() && textField1.getText() != "" && textField2.getText() != "") {
                        sum += (Double.parseDouble(textField1.getText().trim()) * (Double.parseDouble(textField2.getText().trim()))/1000)*7;
                    }
                    if (checkBox2.isSelected() && textField3.getText() != "" && textField4.getText() != "") {
                        sum += (Double.parseDouble(textField3.getText().trim()) * (Double.parseDouble(textField4.getText().trim()))/1000)*7;
                    }
                    if (checkBox3.isSelected() && textField5.getText() != "" && textField6.getText() != "") {
                        sum += (Double.parseDouble(textField5.getText().trim()) * (Double.parseDouble(textField6.getText().trim()))/1000)*7;
                    }
                    if (checkBox4.isSelected() && textField7.getText() != "" && textField8.getText() != "") {
                        sum += (Double.parseDouble(textField7.getText().trim()) * (Double.parseDouble(textField8.getText().trim()))/1000)*7;
                    }
                    break;
                }
                case "28":{
                    if (checkBox1.isSelected() && textField1.getText() != "" && textField2.getText() != "") {
                        sum += (Double.parseDouble(textField1.getText().trim()) * (Double.parseDouble(textField2.getText().trim()))/1000)*28;
                    }
                    if (checkBox2.isSelected() && textField3.getText() != "" && textField4.getText() != "") {
                        sum += (Double.parseDouble(textField3.getText().trim()) * (Double.parseDouble(textField4.getText().trim()))/1000)*28;
                    }
                    if (checkBox3.isSelected() && textField5.getText() != "" && textField6.getText() != "") {
                        sum += (Double.parseDouble(textField5.getText().trim()) * (Double.parseDouble(textField6.getText().trim()))/1000)*28;
                    }
                    if (checkBox4.isSelected() && textField7.getText() != "" && textField8.getText() != "") {
                        sum += (Double.parseDouble(textField7.getText().trim()) * (Double.parseDouble(textField8.getText().trim()))/1000)*28;
                    }
                    break;
                }
            }

            textFieldSum.setText(String.valueOf(Math.round(sum * kwhPrice * 100.0) / 100.0));

        }
    }

    @FXML
    protected void aboutInfo() {
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
    protected void daily() {
        int daily = 1;
        int weekly = 7;
        int monthly = 4 * weekly;

        String value = (String) comboBox2.getValue();

        switch (value) {

            case "Daily": {

                textBoxHidden.setText(String.valueOf(daily));
                break;
            }
            case "Weekly": {

                textBoxHidden.setText(String.valueOf(weekly));
                break;
            }

            case "Monthly": {

                textBoxHidden.setText(String.valueOf(monthly));
                break;
            }

        }
        sumPumps();


    }

    @FXML
    protected void setColor(){
      tools.switchColor(comboBoxTlo,anchorPane);
    }


    @FXML
    private void save(){

        tools.saveToJason(textFieldSum);
    }
}