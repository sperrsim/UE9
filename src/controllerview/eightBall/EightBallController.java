package controllerview.eightBall;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Answer;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Simon Sperr
 * @version 2020.1.1, 02.12.2020
 **/
public class EightBallController implements Initializable {

  @FXML
  private TextField question_txt;
  @FXML
  private Label answer_lbl;
  private Answer answer;

  private String myData = "";

  public void ask()
  {
    String question = question_txt.getText();
    answer_lbl.setText(answer.getRandomAnswer(question));
  }

  public static void show(Stage stage, String greeting) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(EightBallController.class.getResource("eightBallView.fxml"));
      Parent root = fxmlLoader.load();
      
      //send data to MainController
      EightBallController ctrl = fxmlLoader.getController();
      ctrl.setMyData(greeting);
      
      stage.setTitle("Magic8Ball");
      stage.setScene(new Scene(root, 500, 500));
      stage.show();
    }
    catch (Exception e) {
      System.err.println("Something wrong with eightBallView.fxml: " + e.getMessage());
      e.printStackTrace(System.err);
    }
  }
  
  public void setMyData(String myData) {
    this.myData = myData;
    System.out.println("(MainController) Data received: " + this.myData);
  }
  
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    answer = new Answer();
  }
}
