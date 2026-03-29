package module1;

/*
 * Christopher Villarreal
 * Module 1 Assignment 3
 *
 * Purpose of this Code:
 *      This JavaFX program displays four random card images from a deck of 52 cards.
 *      The images are stored in resources/cards folder. Pressing the Refresh button
 *      allows the user to display four new random cards.
 *
 * Code References:
 *      - GeekForGeeks - getResourceAsStream() method - (https://www.geeksforgeeks.org/java/class-getresourceasstream-method-in-java-with-examples/)
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Villarreal_Mod1_3 extends Application {

    // An array that holds the 4 images to be displayed
    private final ImageView[] cardViews = new ImageView[4];

    @Override
    public void start(Stage primaryStage) {

        HBox cardBox = new HBox(10);
        cardBox.setAlignment(Pos.CENTER);

        // Create the 4 empty ImageViews utilizing the hbox
        for (int i = 0; i < 4; i++) {
            cardViews[i] = new ImageView();
            cardViews[i].setFitWidth(100);
            cardViews[i].setFitHeight(140);
            cardViews[i].setPreserveRatio(true);
            cardBox.getChildren().add(cardViews[i]);
        }

        Button refreshButton = new Button("Refresh");

        refreshButton.setOnAction(e -> displayRandomCards());

        // Main layout
        VBox mainLayout = new VBox(15);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(20));
        mainLayout.getChildren().addAll(cardBox, refreshButton);

        // Show the first 4 cards when program starts
        displayRandomCards();

        Scene scene = new Scene(mainLayout, 500, 250);
        primaryStage.setTitle("Module 1.3 - Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*
     * This method selects 4 unique random card numbers from 1 to 52
     * and displays the corresponding images in the ImageViews.
     */
    private void displayRandomCards() {
        List<Integer> deck = new ArrayList<>();

        // Add card numbers 1 through 52 to the deck
        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }

        Collections.shuffle(deck);

        // Display the first 4 shuffled cards
        for (int i = 0; i < 4; i++) {
            int cardNumber = deck.get(i);

            // Utilized from GeeksForGeeks and used IntelliJ's suggestion
            // to handle the potential null value from getResourceAsStream
            Image cardImage = new Image(
                    Objects.requireNonNull(getClass().getResourceAsStream("/cards/" + cardNumber + ".png"))
            );

            cardViews[i].setImage(cardImage);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}