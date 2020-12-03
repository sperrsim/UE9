package controllerview.login;

import controllerview.eightBall.EightBallController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Login;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Simon Sperr
 * @version 2020.1.1, 02.12.2020
 **/
public class LoginController implements Initializable {
  private Stage stage;

  private ArrayList<Login> validLogins;

  @FXML
  private TextField username_txt;
  @FXML
  private TextField passwd_txt;
  @FXML
  private Label incorrect_lbl;

  
  public static void show(Stage stage) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("loginView.fxml"));
      Parent root = fxmlLoader.load();
      
      //get controller which is connected to this fxml file
      LoginController ctrl = fxmlLoader.getController();
      ctrl.stage = stage;
      
      stage.setTitle("Login");
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
    validLogins = new ArrayList<Login>();
    validLogins.add(new Login("Admin", "Admin"));
    validLogins.add(new Login("username", "password"));
    validLogins.add(new Login("schueler", "schueler"));
    validLogins.add(new Login("sperrsim", "password"));
  }
  
  @FXML
  private void checkLogin() {
    String username = username_txt.getText();
    String password = passwd_txt.getText();

    Login login = new Login(username, password);

    if(validLogins.contains(login))
    {
      //navigate from welcome screen to main screen
      System.out.println("Navigation started ...");

      EightBallController.show(new Stage(),"Login successfull!");
      stage.close();
    }
    else
    {
      incorrect_lbl.setVisible(true);
    }
    }
}
