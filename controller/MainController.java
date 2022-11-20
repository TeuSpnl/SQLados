package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainController implements Initializable {

  @FXML
  private Button loginButton;

  //These are used for changing the scenes
  private Stage stage;
  private Scene scene;
  private Parent root;


  /* (non-Javadoc)
   * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
   */
  @Override
    public void initialize(URL location, ResourceBundle resources) {
      
      /*
       * LOGIN BUTTON METHODS ****************************************************
       * 
       */

      //change the colour of the button when the mouse is over it
      loginButton.setOnMouseEntered(Event -> {
        loginButton.setStyle("-fx-background-color: #77ff00;-fx-background-radius: 100;");
      });

      //change the colour of the button when the mouse is over it
      loginButton.setOnMouseExited(Event -> {
        loginButton.setStyle("-fx-background-color: #00FF00;-fx-background-radius: 100;");
      });

      //change the scene when the button is clicked
      loginButton.setOnAction(Event -> {
        try {
          switchToMenu(Event);
        } catch (Exception e) {
          System.out.println("Cant login in, try being a better programmer");
        }
      });

    }


    public void switchToMenu(ActionEvent event) {
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu_view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
      } catch (Exception e) {
        // TODO: handle exception
      }
    }

}
