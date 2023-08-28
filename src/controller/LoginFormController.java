package controller;

import bo.BOFactory;
import bo.custom.LoginBO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.ObjectPasser;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public TextField txtusername;
    public TextField txtpassword;

    LoginBO loginBO = (LoginBO) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.LOGIN);
    public void btnLogin(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {

        String username= txtusername.getText();
        String password= txtpassword.getText();

        Boolean result = loginBO.checkPassword(username,password);
        if (Boolean.TRUE.equals(result)){
            String userFullName = loginBO.getUserFullName(username);
            ObjectPasser.userFullName = userFullName;
            Parent load = FXMLLoader.load(getClass().getResource("../view/MenuBar.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Point Of Sale System");
            stage.show();
            Stage loginStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            loginStage.close();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Login Failed");
            alert.show();
        }
    }
}
