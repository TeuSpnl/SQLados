package controller.register;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
            
    
            try {
                dao.UserDao.register(login, password, name, department, birth, cpf);
            } catch (Exception e) {
              System.out.println("Try being a better programmer");
            }
          });
    }

}
