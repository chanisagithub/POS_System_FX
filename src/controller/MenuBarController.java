package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lombok.SneakyThrows;
import util.ObjectPasser;

import java.awt.*;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MenuBarController implements Initializable {
    public Label txtUserFullName;
    public Label lblDate;

    public Label lblTime;

    public LocalTime currentTime;

    public AnchorPane playgroundAnchorpane;

    @SneakyThrows
    @Override
    public void initialize(URL Location, ResourceBundle resources){
        txtUserFullName.setText(ObjectPasser.userFullName);

        URL resource = getClass().getResource("/view/Dashboard.fxml");
        Parent load = FXMLLoader.load(resource);
        playgroundAnchorpane.getChildren().clear();
        playgroundAnchorpane.getChildren().add(load);
    }

    public void startClock(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,e->{
            currentTime = LocalTime.now();
            lblTime.setText(currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
        }),new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
