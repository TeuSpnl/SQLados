package controller.register;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class User implements Initializable{

    @FXML
    private TextField nameField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField departmentField;

    @FXML
    private DatePicker datePanel;

    @FXML
    private TextField CPFfield;

    @FXML
    private Button registerButton;

    @FXML
    private BorderPane statusPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //register the user
        registerButton.setOnAction(Event -> {
            String name = nameField.getText().toUpperCase();
            String login = loginField.getText().toUpperCase();
            String password = passwordField.getText().toUpperCase();
            int department = Integer.parseInt(departmentField.getText());
            Date birth = Date.valueOf(datePanel.getValue().toString());
            Long cpf = Long.parseLong(CPFfield.getText());
            
            AnchorPane status = null;

            try {
              dao.UserDao.register(login, password, name, department, birth, cpf);
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
