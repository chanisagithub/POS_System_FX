import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {
    @Override
    public void start(Stage mainStage) throws IOException {
        Parent parent= FXMLLoader.load(this.getClass().getResource("./view/AddItemForm.fxml"));
        Scene scene=new Scene(parent);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
