package controller.search;

import java.net.URL;
import java.util.ResourceBundle;

import dao.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryKey implements Initializable{

    @FXML
    private TextField codeField;

    @FXML
    private Button registerButton;

    @FXML
    private ListView<String> listView;

    @FXML
    private ChoiceBox<String> chaveChoice;

    private ObservableList<String> codeTypes = FXCollections.observableArrayList(
        "Buscar Usuario", //0
        "Buscar Setor",//1
        "Buscar Equipamento", //2
        "Buscar Convenio", //3
        "Buscar Paciente", //4
        "Buscar Prestador", //5
        "Buscar Ordem"); //6

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        chaveChoice.setItems(codeTypes);
        chaveChoice.setValue("Buscar Usuario");

        
        registerButton.setOnAction(Event -> {

            String arg = codeField.getText();
            listView.getItems().clear();
            int codeType = getCodeTypes();

            switch(codeType) {
                case 0:
                    System.out.println("Buscar Usuario");
                    model.User u = UserDao.getUser(arg);
                    listView.getItems().addAll(u.userToString());
                    break;
                case 1:
                    System.out.println("Buscar Setor");
                    model.Department d = dao.DepartmentDao.getDepartment(Integer.parseInt(arg));
                    listView.getItems().addAll(d.departmentToString());
                    break;
                case 2:
                    System.out.println("Buscar Equipamento");
                    model.Equipment e = dao.EquipmentDao.getEquipment(Integer.parseInt(arg));
                    listView.getItems().addAll(e.equipmentToString());
                    break;
                case 3:
                    System.out.println("Buscar Convenio");
                    model.Insurance c = dao.InsuranceDao.getInsurance(Integer.parseInt(arg));
                    listView.getItems().addAll(c.insuranceToString());
                    break;
                case 4:
                    System.out.println("Buscar Paciente");
                    model.Patient p = dao.PatientDao.getPatient(Integer.parseInt(arg));
                    listView.getItems().addAll(p.patientToString());
                    break;
                case 5:
                    System.out.println("Buscar Prestador");
                    model.ServiceProvider pr = dao.ServiceProviderDao.getPSV(Integer.parseInt(arg));
                    listView.getItems().addAll(pr.serviceProviderToString());
                    break;
                case 6:
                    System.out.println("Buscar Ordem");
                    model.OrderOfService o = dao.OrderOfServiceDao.getOS(Integer.parseInt(arg));
                    listView.getItems().addAll(o.orderOfServiceToString());
                    break;
            }
        });

    }

    public int getCodeTypes(){
        System.out.println(chaveChoice.getSelectionModel().getSelectedIndex());
        return chaveChoice.getSelectionModel().getSelectedIndex();
    }

}
