package com.georgiancollege.week11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    private ImageView imageView;

    @FXML
    private ListView<Movie> listView;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button getDetailsButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getDetailsButton.setVisible(false);
        errorLabel.setVisible(false);
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldMovie, newMovie) -> {
                    try {
                        getDetailsButton.setVisible(true);
                        imageView.setImage(new Image(newMovie.getPoster()));
                    } catch (Exception e){
                        imageView.setImage(new Image("https://www.pngplay.com/wp-content/uploads/12/Bugs-Bunny-No-PNG-Photo-Image.png"));
                    }
                });
    }

    @FXML
    void showMovies(ActionEvent event) {
        listView.getItems().clear();
        String searchText = searchTextField.getText();
        ApiResponse apiResponse = ApiUtility.getDataFromApiQuick(searchText);

        if(apiResponse.getSearch() == null){
            errorLabel.setVisible(true);
            errorLabel.setText("No Movie Found!");
        } else{
            errorLabel.setVisible(false);
            listView.getItems().addAll(apiResponse.getSearch());
        }
    }

    @FXML
    void getDetailsButton_onClick(ActionEvent event) {
        String selectedMovieID = listView.getSelectionModel().getSelectedItem().getImdbID();
        System.out.println("Movie ID from the List View (From First Scene): " + selectedMovieID);
    }
}
