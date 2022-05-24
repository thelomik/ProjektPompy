package com.pompy.projektpompy;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import lombok.Data;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
public class Tools {


    private static String path = "zapis.json";


    protected static void saveToJason(TextField textField){
        ArrayList<String> test = new ArrayList<>();
        test.add("Price for:");
        test.add(textField.getText());

       try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(test);
        out.write(jsonString);
        System.out.println("write");
    } catch (Exception e) {
        e.printStackTrace();
    }

    }

    protected static void switchColor(ComboBox comboBoxTlo,AnchorPane anchorPane){
        Region content = (Region) anchorPane.lookup(".content");


            String value = comboBoxTlo.getValue().toString();


            switch (value){
                case "dark" : {
                    anchorPane.setStyle("-fx-background-color: #2f4f4f;");
                    break;
                }
                case "light":{
                    anchorPane.setStyle("-fx-background-color: white;");
                    break;
                }
                }
            }





    }


