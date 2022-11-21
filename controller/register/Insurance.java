package controller.register;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Insurance implements Initializable{

    @FXML
    private TextField nameField;

    @FXML
    private TextField codeField;

    @FXML
    private Button registerButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //register the user
        registerButton.setOnAction(Event -> {
            String name = nameField.getText();
  
            try {
                dao.InsuranceDao.register(name);
            } catch (Exception e) {
              System.out.println("Try being a better programmer");
            }
          });
    }
}