package com.georgiancollege.week11.Utilities;

import com.georgiancollege.week11.Main;
import com.georgiancollege.week11.Controllers.MovieDetailsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    public static void changeScene(ActionEvent event, String fxmlFile, String id) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        if(!id.equals("-1")){
            MovieDetailsController controller = fxmlLoader.getController();
            controller.displayMovieDetails(id);
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
