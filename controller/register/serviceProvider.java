package controller.register;
import dao.ServiceProviderDao;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ServiceProvider implements Initializable{

    @FXML
    private TextField nameField;

    @FXML
    private TextField codeField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField CPFField;

    @FXML
    private TextField conselhoField;

    @FXML
    private TextField tipoField;

    @FXML
    private TextField ufField;

    public void initialize(URL location, ResourceBundle resources) {

        //register the user
        registerButton.setOnAction(Event -> {
            String name = nameField.getText();
            int code = Integer.parseInt(codeField.getText());
            Long cpf = Long.parseLong(CPFField.getText());
            String council = conselhoField.getText();
            String type = tipoField.getText();
            String uf = ufField.getText();
    
            try {
                dao.ServiceProviderDao.register(code, name, cpf, council, type, uf);
            } catch (Exception e) {
              System.out.println("Try being a better programmer");
            }
        });
    }

}