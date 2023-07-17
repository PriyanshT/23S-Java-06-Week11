package com.georgiancollege.week11.Controllers;

import com.georgiancollege.week11.Models.MovieDetails;
import com.georgiancollege.week11.Models.Rating;
import com.georgiancollege.week11.Utilities.ApiUtility;
import com.georgiancollege.week11.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class MovieDetailsController {

    @FXML
    private ListView<String> actorListView;

    @FXML
    private Label dateReleasedLabel;

    @FXML
    private Label directorLabel;

    @FXML
    private Label genreLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private ListView<Rating> ratingsListView;

    @FXML
    private Label runtimeLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private Label writerLabel;

    @FXML
    private Label yearLabel;

    public void displayMovieDetails(String movieID){
        System.out.println("Movie ID from the Scene Change (From Second Scene): " + movieID);
        MovieDetails movieDetails = ApiUtility.getMovieDetailsFromApi(movieID);
        System.out.println(movieDetails);

        // fill labels for left side of the view
        titleLabel.setText(movieDetails.getTitle());
        yearLabel.setText(movieDetails.getYear());
        dateReleasedLabel.setText(movieDetails.getReleaseDate());
        runtimeLabel.setText(movieDetails.getRuntime());
        genreLabel.setText(movieDetails.getGenre());
        directorLabel.setText(movieDetails.getDirector());
        writerLabel.setText(movieDetails.getWriter());

        // fill image view for center of the view
        try {
            imageView.setImage(new Image(movieDetails.getPoster()));
        } catch (Exception e){
            imageView.setImage(new Image("https://www.pngplay.com/wp-content/uploads/12/Bugs-Bunny-No-PNG-Photo-Image.png"));
        }

        // fill list view for right side of the view
        String[] actorsArray = movieDetails.getActors().split(", ");
        actorListView.getItems().addAll(actorsArray);

        ratingsListView.getItems().addAll(movieDetails.getRating());
    }

    @FXML
    void goBack_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "search-view.fxml", "-1");
    }
}
