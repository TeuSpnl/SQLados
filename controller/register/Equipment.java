package controller.register;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Equipment implements Initializable{

    @FXML
    private TextField nameField;

    @FXML
    private TextField codeField;

    @FXML
    private DatePicker datePanel;

    @FXML
    private Button registerButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //register the equipment
        registerButton.setOnAction(Event -> {
            String name = nameField.getText().toUpperCase();
            int strCode = Integer.parseInt(codeField.getText());
  
            try {
                dao.EquipmentDao.register(name,strCode);
            } catch (Exception e) {
              System.out.println("Try being a better programmer");
            }
          });
    }

}
