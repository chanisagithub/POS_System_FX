package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class LoginFormController {
    public TextField txtusername;
    public TextField txtpassword;

    public void btnLogin(ActionEvent actionEvent) {
        System.out.println(txtusername.getText());
        System.out.println(txtpassword.getText());
    }
}
