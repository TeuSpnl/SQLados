package controller.register;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Insurance implements Initializable{

    @FXML
    private TextField nameField;

    @FXML
    private Button registerButton;

    @FXML
    private BorderPane statusPane;


    //qualquer coisa
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //register the insurance
        registerButton.setOnAction(Event -> {
            String name = nameField.getText().toUpperCase();
  
            try {
                dao.InsuranceDao.register(name);
            } catch (Exception e) {
              System.out.println("Try being a better programmer");
            }
          });
    }
}
