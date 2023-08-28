package controller;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lombok.SneakyThrows;
import util.ObjectPasser;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MenuBarController implements Initializable {
    public Label txtUserFullName;
    public Label lblTime;
    public Label lblDate;

    public LocalTime currentTime;
    public AnchorPane playgroundAnchorpane;
    public Button btnDashboard;

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtUserFullName.setText(ObjectPasser.userFullName);
        startClock();

        URL resourse = getClass().getResource("/view/Dashboard.fxml");
        Parent load = null;
        try {
            load = FXMLLoader.load(resourse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        playgroundAnchorpane.getChildren().clear();
        playgroundAnchorpane.getChildren().add(load);

    }

    private void startClock(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,e->{
        currentTime = LocalTime.now();
        lblTime.setText(currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
        }), new KeyFrame(Duration.seconds(1)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    public void addItemOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/AddItemForm.fxml");
        Parent load = FXMLLoader.load(resource);
        playgroundAnchorpane.getChildren().clear();
        playgroundAnchorpane.getChildren().add(load);
    }


    public void dashboardOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/Dashboard.fxml");
        Parent load = FXMLLoader.load(resource);
        playgroundAnchorpane.getChildren().clear();
        playgroundAnchorpane.getChildren().add(load);
    }
}
