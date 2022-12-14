package controller.register;

import java.net.URL;
import java.util.ResourceBundle;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ServiceOrder implements Initializable {

    @FXML
    private TextField typeField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField departmentField;

    @FXML
    private TextField codigoDoConvenioField;

    @FXML
    private TextField medicoRequisitanteField;

    @FXML
    private TextField registroDoPacienteField;

    @FXML
    private BorderPane statusPane;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //register the patient
        registerButton.setOnAction(Event -> {
            int patient = Integer.parseInt(registroDoPacienteField.getText());
            int doctor = Integer.parseInt(medicoRequisitanteField.getText());
            int dep = Integer.parseInt(departmentField.getText());
            String type = typeField.getText().toUpperCase();
            String user = MainController.loginGeral.toUpperCase();
            int insurance = Integer.parseInt(codigoDoConvenioField.getText());

            AnchorPane status = null;

            try {

                dao.OrderOfServiceDao.register(patient, doctor, dep, type, user, insurance);
                
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
