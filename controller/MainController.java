package controller;

import dao.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainController implements Initializable {

  @FXML
  private TextField loginField;

  @FXML
  private Button loginButton;

  @FXML
  private PasswordField passwordField;

  @FXML
  private ImageView passwordVisible;

  @FXML
  private ImageView passwordInvisible;

  @FXML
  private TextField passwordVisibleField;

  @FXML
  private Label errorLabel;
  
  //These are used for changing the scenes
  private Stage stage;
  private Scene scene;
  private Parent root;
  private boolean usingPasswordVisible = false;
  public static String loginGeral;


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

      passwordVisible.setOnMouseClicked(Event -> {
        passwordVisible.setVisible(false);
        passwordInvisible.setVisible(true);
        
        usingPasswordVisible = false;
        passwordField.setText(passwordVisibleField.getText());
        passwordVisibleField.setVisible(false);
        passwordField.setVisible(true);

      });

      passwordInvisible.setOnMouseClicked(Event -> {
        passwordInvisible.setVisible(false);
        passwordVisible.setVisible(true);

        usingPasswordVisible = true;
        passwordVisibleField.setText(passwordField.getText());

        passwordField.setVisible(false);
        passwordVisibleField.setVisible(true);

      });
      
      //change the scene when the button is clicked
      loginButton.setOnAction(Event -> {
        String login =  loginField.getText();
                loginGeral = login;
        String password = usingPasswordVisible ? passwordVisibleField.getText() : passwordField.getText();
        
        try {
          if(password.length() > 0 && UserDao.loginUser(login, password)){
            switchToMenu(Event);
          }else{
            passwordField.setText("");
            passwordVisibleField.setText("");
            passwordField.setStyle("-fx-background-radius: 100; -fx-border-radius: 100; -fx-border-color: red; -fx-border-width: 1;");
            passwordVisibleField.setStyle(passwordField.getStyle());
            loginField.setStyle(passwordField.getStyle());
            errorLabel.setVisible(true);
          }

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


    public void fazerNada(){
      System.out.println("Fazendo nada");
    }

}
