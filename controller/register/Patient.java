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

public class Patient implements Initializable{

    @FXML
    private TextField nameField;

    @FXML
    private TextField CPFfield;

    @FXML
    private Button registerButton;

    @FXML
    private DatePicker birthField;

    @FXML
    private TextField telefoneField;

    @FXML
    private TextField codigoConvenioField;

    @FXML
    private BorderPane statusPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //register the patient
        registerButton.setOnAction(Event -> {
            String name = nameField.getText().toUpperCase();
            long cpf = Long.parseLong(CPFfield.getText());
            Date birth = Date.valueOf(birthField.getValue().toString());
            long phone = Long.parseLong(telefoneField.getText());
            int insuranceCode = Integer.parseInt(codigoConvenioField.getText());
            
            AnchorPane status = null;
            try {
                dao.PatientDao.register(name, birth, cpf, insuranceCode, phone);
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
