package main;

import controllerview.login.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Simon Sperr
 * @version 2020.1.1, 02.12.2020
 **/
public class TheMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        LoginController.show(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
