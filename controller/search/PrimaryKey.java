package controller.search;

import java.net.URL;
import java.util.ResourceBundle;

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
    private ListView<?> listView;

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
        chaveChoice.setValue("Buscar Departamento");
        
        registerButton.setOnAction(Event -> {
            getCodeTypes();
        });

    }

    public int getCodeTypes(){
        System.out.println(chaveChoice.getSelectionModel().getSelectedIndex());
        return chaveChoice.getSelectionModel().getSelectedIndex();
    }

}
