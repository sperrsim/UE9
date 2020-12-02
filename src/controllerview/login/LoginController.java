package controllerview.login;

import controllerview.eightBall.EightBallController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Simon Sperr
 * @version 2020.1.1, 02.12.2020
 **/
public class LoginController implements Initializable {
  private Stage stage;
  
  public static void show(Stage stage) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("loginView.fxml"));
      Parent root = fxmlLoader.load();
      
      //get controller which is connected to this fxml file
      LoginController ctrl = fxmlLoader.getController();
      ctrl.stage = stage;
      
      stage.setTitle("Welcome");
      stage.setScene(new Scene(root, 400, 400));
      stage.show();
    }
    catch (IOException e) {
      System.err.println("Something wrong with loginView.fxml: " + e.getMessage());
      e.printStackTrace(System.err);
    }
  }
  
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }
  
  @FXML
  private void next() {
    //navigate from welcome screen to main screen
    System.out.println("Navigation started ...");
   
    EightBallController.show(new Stage(),"Hello from Welcome Controller!");
    stage.close();
    }
}
