package controller.register;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Department implements Initializable {

  @FXML
  private TextField nameField;

  @FXML
  private Button registerButton;

  @FXML
  private TextField entitledField;

  @FXML
  private AnchorPane test1;

  @FXML
  private ImageView okImage;

  @FXML
  private BorderPane statusPane;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    // register the equipment
    registerButton.setOnAction(Event -> {
      String name = nameField.getText().toUpperCase();
      String respon = entitledField.getText().toUpperCase();
      AnchorPane status = null;

      try {
        dao.DepartmentDao.register(name, respon);

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
