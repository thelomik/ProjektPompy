package com.pompy.projektpompy;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class HelloController {
    @FXML
    private Label welcomeText;

    private Calculate calculate = new Calculate();
    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    @FXML
    private TextField textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8,textFieldCalculate;

    @FXML
    protected void onChecboxActive() {

        if (checkBox1.isSelected() == true) {
            textField1.setEditable(true);
            textField2.setEditable(true);
        } else{
            textField1.setEditable(false);
        textField2.setEditable(false);
    }
        if (checkBox2.isSelected() == true) {
            textField3.setEditable(true);
            textField4.setEditable(true);
        }
       else {
            textField3.setEditable(false);
            textField4.setEditable(false);
        }

        if (checkBox3.isSelected() == true) {
            textField5.setEditable(true);
            textField6.setEditable(true);
        }
        else {
            textField5.setEditable(false);
            textField6.setEditable(false);
        }

        if (checkBox4.isSelected() == true) {
            textField7.setEditable(true);
            textField8.setEditable(true);
        }
        else {
            textField7.setEditable(false);
            textField8.setEditable(false);
        }
    }

    @FXML
    protected void onActionButton(){

        int va = calculate();

        textFieldCalculate.setText(String.valueOf(va));
    }

    public Integer calculate(){
        int value3 = 0;
        if (checkBox1.isSelected()){
            int value1  = Integer.parseInt(textField1.getText().trim());
            int value2 = Integer.parseInt(textField2.getText().trim());
            value3 = value1 * value2 ;

        }
        else {
            System.out.println("TEST");
        }

        return value3;
    }
}