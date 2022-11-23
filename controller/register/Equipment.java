package controller.register;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Equipment implements Initializable{

    @FXML
    private TextField nameField;

    @FXML
    private TextField codeField;

    @FXML
    private DatePicker datePanel;

    @FXML
    private Button registerButton;

    @FXML
    private BorderPane statusPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //register the equipment
        registerButton.setOnAction(Event -> {
            String name = nameField.getText().toUpperCase();
            int strCode = Integer.parseInt(codeField.getText());
  
            AnchorPane status = null;

            try {
              dao.EquipmentDao.register(name,strCode);

              try {
                status = FXMLLoader.load(getClass().getResource("/view/vanilla/ok.fxml"));
              } catch (Exception c) {
                System.out.println("Board could not be displayed");
              }

            } catch (Exception e) {
              System.out.println("Try being a better programmer");

              try {
                status = FXMLLoader.load(getClass().getResource("/view/vanilla/erro.fxml"));
              } catch (Exception c) {
                System.out.println("Board could not be displayed");
              }
            }

            
            statusPane.setCenter(status);
          });
    }

}
