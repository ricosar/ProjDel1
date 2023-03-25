package projectfinal;
//*Max Matthews, Sarah Rico */


//All of our imports
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.ComboBox;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GameList {
     //adding a game to the database
    private void addGame(ComboBox playerRetrieve, ComboBox consoleRetrieve, ComboBox genreRetrieve,
     ComboBox languageRetrieve, ComboBox ageRetrieve, ComboBox priceRetrieve, ComboBox playTimeRetrieve, 
     ComboBox additionalGenreRetrieve, ComboBox typeRetrieve, ComboBox vrRetrieve) {

        //retrieves the name, company, date, console, and stock.
        String name = nameInput.getText();
        String company = companyInput.getText();
        LocalDate date = dateInput.getValue();
        String stock = stockInput.getText();
        String employee = employeeInput.getText();

        //retrieving values from comboboxes.
        String player = (String) playerRetrieve.getValue();
    
        String console = (String) consoleRetrieve.getValue();

        String genre = (String) genreRetrieve.getValue();
        
        String language = (String) languageRetrieve.getValue();

        String age = (String) ageRetrieve.getValue();

        String price = (String) priceRetrieve.getValue();

        String play = (String) playTimeRetrieve.getValue();

        String genre2 = (String) additionalGenreRetrieve.getValue();

        String type = (String) typeRetrieve.getValue();

        String vr = (String) vrRetrieve.getValue();

        //initalizes a game class object.
        Game game = new Game(name, genre, company, date, console, stock, player, language, employee, age, price, 
        play, genre2, type, vr);
    
        // Adds the game to the gameList.
        gameList.add(game);
    
        // Clears it so new values can be added.
        nameInput.clear();
        companyInput.clear();
        dateInput.setValue(null);
    
        // Calls updateGameList method.
        updateGameList();
    
        try {
            // create a PrintWriter object with a filename of "games.txt" to append to the file
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("games.txt", true)));
    
            // write the game information to the file
            pw.println(game.toString());
    
            // close the PrintWriter object
            pw.close();
    
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
    

    // Deleting a game method (programming for the delete button)
    private void deleteGame() {

        // if the selected game is not null, prompt the user if they'd like to delete the game.
        String selectedGameName = gameListView.getSelectionModel().getSelectedItem();

        if (selectedGameName != null) {
            // Create confirmation alert
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Delete the game?",
             ButtonType.YES, ButtonType.CANCEL);
            confirmation.showAndWait();
    
            // If the user clicked yes, delete the game
            if (confirmation.getResult() == ButtonType.YES) {
                for (Game game : gameList) {
                    if (game.getTitle().equals(selectedGameName)) {
                        gameList.remove(game);
                        updateGameList();
                        break;
                    }
                }
            }
        }
    }

    public void editGame() {
    // Get the selected game from the list
    String selectedGameNames = gameListView.getSelectionModel().getSelectedItem();

    if (selectedGameNames != null) {
             // Create a new stage for editing the game
    Stage editStage = new Stage();
    editStage.setTitle("Edit Game");

    //creating gridpane
    GridPane addGrid = new GridPane();


    Label nameLabel = new Label("Title");
        TextField nameSearch = new TextField();
     

    //Company
    Label companyLabel = new Label("Company:");
    TextField companySearch = new TextField();
    

    //Date of release
    Label dateLabel = new Label("Release Date:");
    TextField dateSearch = new TextField();

    //Items in stock
    Label stockLabel = new Label("# in stock:");
    TextField stockSearch = new TextField();

     //adding the rows and formatting them.
     addGrid.addRow(0, nameLabel, nameSearch);
     addGrid.addRow(1, companyLabel, companySearch);
     addGrid.addRow(2, dateLabel, dateSearch ); 
     addGrid.addRow(3, stockLabel, stockSearch);
    

    // Create a VBox to hold the labels, text fields, and buttons
    VBox vbox = new VBox(10, nameLabel, nameSearch, companyLabel, companySearch, 
    dateLabel, dateSearch, stockLabel, stockSearch);
    vbox.setPadding(new Insets(10));

    // Create a new scene for the editing stage
    Scene editScene = new Scene(vbox);

    // Set the scene and show the editing stage
    editStage.setScene(editScene);
    editStage.showAndWait();
    }else{
       // If no game is selected, display an error message and return
       Alert alert = new Alert(AlertType.ERROR);
       alert.setTitle("Error");
       alert.setHeaderText("No game selected");
       alert.setContentText("Please select a game to edit.");
       alert.showAndWait();
     
    }
    }
        
   
    //method to search for a game in search bar
    private void searchGame(String name) {
        if (name == null || name.trim().isEmpty()) {
            
            // If no search term is entered, show an alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Results");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a game title.");
            alert.showAndWait();
        } else {
            // Perform the search by looping through an ArrayList of matchingGames to see if there is a match.
            ArrayList<Game> matchingGames = new ArrayList<>();
            for (Game game : gameList) {
                if (game.getTitle().toLowerCase().contains(name.toLowerCase())) {
                    matchingGames.add(game);
                }
            }

            // If matching games is not empty (the ArrayList of matchingGames)
            if (!matchingGames.isEmpty()) {

            //  this code creates a ListView of Game objects, and sets each cell in the list to display the title of the Game object.
                ListView<Game> matchingGamesListView = new ListView<>();
                matchingGamesListView.getItems().addAll(matchingGames);

            // how each cell should be displayed.
                matchingGamesListView.setCellFactory(param -> new ListCell<Game>() {
                    
                    //Overriding updateItem method..
                    @Override
                    protected void updateItem(Game item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null || item.getTitle() == null) {
                            setText(null);
                        } else {
                            setText(item.getTitle());
                        }
                    }
                });
        
                // Set up the selection event handler for the ListView
                matchingGamesListView.setOnMouseClicked(event -> {
                    Game selectedGame = matchingGamesListView.getSelectionModel().getSelectedItem();
                    if (selectedGame != null) {
                        // Create a new Stage for the game details window
                        Stage gameDetailsStage = new Stage();
                        gameDetailsStage.setTitle(selectedGame.getTitle() + " Details");
        
                        // Create a VBox to hold the game details
                        VBox gameDetailsLayout = new VBox(10,
                                new Label("Employee Name: " + selectedGame.getEmployeeName()),
                                new Label("Name: " + selectedGame.getTitle()),
                                new Label("Company: " + selectedGame.getCompany()),
                                new Label("Release Year: " + selectedGame.getReleaseDate()),
                                new Label("Amount in Stock: " + selectedGame.getStock()),
                                new Label("Genre: " + selectedGame.getGenre()),
                                new Label("Console: " + selectedGame.getConsoles()),
                                new Label("Amount of Languages supported: " + selectedGame.getlanguageSupported()),
                                new Label("Age range: " + selectedGame.getAgeRange()),
                                new Label("Price: " + selectedGame.getPrice()),
                                new Label("Play time: " + selectedGame.getPlayTime()),
                                new Label("Type of copy: " + selectedGame.getType()),
                                new Label("Vr support: " + selectedGame.getVrSupport())
                        );
                        gameDetailsLayout.setAlignment(Pos.CENTER);
        
                        // Set the scene for the game details window
                        Scene gameDetailsScene = new Scene(gameDetailsLayout, 500, 400);
                        gameDetailsStage.setScene(gameDetailsScene);
                        gameDetailsStage.showAndWait();
                    }
                });
        
                // Create a new Stage for the search results window
                Stage popupStage = new Stage();
                popupStage.initModality(Modality.APPLICATION_MODAL);
                popupStage.setTitle("Search Results");
        
                // Create a VBox to hold the ListView and a "Close" button
                VBox popupLayout = new VBox(10, new Label("Search Results:"), matchingGamesListView, new Button("Close"));
                popupLayout.setAlignment(Pos.CENTER);
        
                // Set the scene for the search results window
                Scene popupScene = new Scene(popupLayout, 500, 400);
                popupStage.setScene(popupScene);
        
                // Set up the event handler for the Close button
                Button closeButton = (Button) popupScene.lookup(".button");
                closeButton.setOnAction(event -> popupStage.close());
        
                popupStage.showAndWait();

            } else {
                // If no matching games were found, show an alert
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Search Results");
                alert.setHeaderText(null);
                alert.setContentText("No matching games found.");
                alert.showAndWait();
            }
        }
    }

    // Updates the gamelist box
    private void updateGameList() {
        // Sort the game list by alphabetical order 
        Collections.sort(gameList, Comparator.comparing(Game::getTitle));
    
        List<String> gameNames = new ArrayList<>();
        for (Game game : gameList) {
            gameNames.add(game.getTitle());
        }
        gameListView.getItems().setAll(gameNames);
    }
   

    public static void main(String[] args) {
        launch(args);
    }
}
