/**
 *  @Authors 
 *    : Lucas Pedrosa
 *    : Tacio Patez
 *    : Matheus Spinolla
 *    : Gabriel de Souza
 *    
 *
 * 
 * 
 *  Name: Principal.java 
 *
 *  Principal.java class is the main class from the physical layer
 *  simulation, it should be used
 *  to extend the Application method and use it to launch javaFX
 *  application
 * 
 *
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Principal extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  private FXMLLoader loader;
  private Parent root;
  private static Scene scene;

  /*
   * The principal class will handle the lauch of the javaFX
   * application.
   * For the interface it extends the Application abstract class
   * 
   * The Application will:
   * Construct a instance of Application class
   * Calls the Init and start methods
   * Wait for the Application to finish
   * 
   */

  @Override
  public void start(Stage primaryStage) throws Exception {
    try {
      loader = new FXMLLoader(getClass().getResource("/view/main_view.fxml"));
      root = loader.load();
      scene = new Scene(root);

      scene.getStylesheets().add(getClass().getResource("css/background.css").toExternalForm());

      primaryStage.getIcons().add(new Image("img/icon.png"));
      primaryStage.setResizable(false);
      primaryStage.setTitle("");
      primaryStage.setScene(scene);
      primaryStage.sizeToScene();
      primaryStage.show();

    } catch (Exception e) {
      System.out.println("arranca por la derecha el genio del futbol mundial");
      System.out.println(e.getMessage());
    }
  }

}