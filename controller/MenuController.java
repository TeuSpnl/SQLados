
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.Action;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MenuController implements Initializable {

  @FXML
  private BorderPane borderPane;

  @FXML
  private Button menuButton;

  @FXML
  private Button cadastrarButton;

  @FXML
  private Button pesquisarButton;

  @FXML
  private AnchorPane menuSlider;

  @FXML
  private AnchorPane cadastrarSideBar;

  @FXML
  private Button cadastrarUsuarioButton;

  @FXML
  private Button cadastrarEquipamento;

  @FXML
  private Button cadastrarSetor;

  @FXML
  private Button cadastrarOrdem;

  @FXML
  private Button cadastrarPaciente;

  @FXML
  private Button cadastrarPrestador;

  @FXML
  private Button cadastrarConvenio;

  @FXML
  private AnchorPane pesquisarSideBar;

  @FXML
  private AnchorPane fatherPane;


  private boolean sidebarOpen = false;

  private boolean sideBarSearch = false;
  private boolean sidebarLog = false;

  private String panelValue = "";

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    /*
     * MENU BUTTON METHODS ****************************************************
     */
    menuSlider.setTranslateX(-200);

    pesquisarButton.setOnAction(Event -> {
      
      cadastrarSideBar.setVisible(false);
      pesquisarSideBar.setVisible(true);

      if(!sideBarSearch && sidebarOpen){
        sideBarSearch = true;
        sidebarLog = false;
        return;
      }

      if (sidebarOpen) {
        closeSidebar();
      } else {
        openSidebar();
      }
      sidebarOpen = !sidebarOpen;
    });

    cadastrarButton.setOnAction(Event -> {

      cadastrarSideBar.setVisible(true);
      pesquisarSideBar.setVisible(false);

      if(!sidebarLog && sidebarOpen){
        sidebarLog = true;
        sideBarSearch = false;
        return;
      }
      if (sidebarOpen) {
        closeSidebar();
      } else {
        openSidebar();
      }
      sidebarOpen = !sidebarOpen;
    });

    cadastrarUsuarioButton.setOnAction(event -> {
      setCenter("/view/register/user_view.fxml");
    });

    cadastrarEquipamento.setOnAction(event -> {
      setCenter("/view/register/equipment_view.fxml");
    });

    cadastrarSetor.setOnAction(event -> {
      setCenter("/view/register/department_view.fxml");
    });

    cadastrarOrdem.setOnAction(event -> {
      setCenter("/view/register/serviceOrder_view.fxml");
    });

    cadastrarPaciente.setOnAction(event -> {
      setCenter("/view/register/patient_view.fxml");
    });

    cadastrarPrestador.setOnAction(event -> {
      setCenter("/view/register/serviceProvider_view.fxml");
    });

    cadastrarConvenio.setOnAction(event -> {
      setCenter("/view/register/insurance_view.fxml");
    });





  }

  private void openSidebar() {
    TranslateTransition slide = new TranslateTransition();
    slide.setDuration(javafx.util.Duration.seconds(0.3));
    slide.setNode(menuSlider);
    slide.setToX(0);
    slide.play();
    menuSlider.setTranslateX(-200);
    slide.setOnFinished((ActionEvent e) -> {
    });
  }

  private void closeSidebar() {
    TranslateTransition slide = new TranslateTransition();
    slide.setDuration(javafx.util.Duration.seconds(0.3));
    slide.setNode(menuSlider);
    slide.setToX(-200);
    slide.play();
    menuSlider.setTranslateX(0);
    slide.setOnFinished((ActionEvent e) -> {
    });
  }

  private void setCenter(String value){
    try {
      AnchorPane view = FXMLLoader.load(getClass().getResource(value));
      borderPane.setCenter(view);

    } catch (Exception e) {

    }

  }

}
