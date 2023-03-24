
//*Max Matthews, Sarah Rico */


//All of our imports
import javafx.application.Application;
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

//public class extends Application
public class Project extends Application {

//creates the gameList array.
private ArrayList<Game> gameList = new ArrayList<>();
ListView<Game> gameLists = new ListView<>();


//private datafields initalized to be used in the program.
    private TextField nameInput;
    private TextField companyInput;
    private TextField stockInput;
    private DatePicker dateInput;
    private Label searchResultLabel;
    private ListView<String> gameListView;

    @Override
    public void start(Stage primaryStage){
        // Create UI components and labels for the application

        GameList list = new GameList();

        //Game name
        Label nameLabel = new Label("Game Name:");
        nameInput = new TextField();

        //Company
        Label companyLabel = new Label("Company:");
        companyInput = new TextField();

        //Date of release
        Label dateLabel = new Label("Release Date:");
        dateInput = new DatePicker();

        //Items in stock
        Label stockLabel = new Label("# in stock:");
        stockInput = new TextField();

       // Spinner<Game> stockSpinner = new Spinner<>(0.0,99.99,0.0);

       
    //Add button that points the event to the addGame method.
        Button addButton = new Button("Add");
        addButton.setOnAction(event -> addGame());

    //Delete button that points the event to the deleteGame method.
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> deleteGame());

        Button editButton = new Button("Edit");
        editButton.setOnAction(event -> editGame());
            

    /* Search button is created. The event is pointed to the searchgame method. 
    The action also passes getText as a parameter.
    */
        Label searchLabel = new Label("Search:");
        TextField searchInput = new TextField();
        Button searchButton = new Button("Search");
        searchButton.setOnAction(event -> searchGame(searchInput.getText()));


    
    //  Created a new label for the search results.
        searchResultLabel = new Label();

   // A ListView is a UI control that displays a list of items in a vertical scrollable list. 
        gameListView = new ListView<>();

        // Add components to layout by adding it to a GridPane.
        GridPane addGrid = new GridPane();

        //setting the distance between buttons.
        addGrid.setVgap(20);
        addGrid.setHgap(20);

        // Genre
        Label releaseLabel = new Label("Genre:");
        ComboBox<String> releaseComboBox = new ComboBox<>();
        releaseComboBox.getItems().addAll("Horror", "Action", "Mystery", "Platformer", "FPS",
        "RPG", "Puzzle", "Simulation");
        releaseComboBox.setPromptText("Select Genre");

        //Consoles
        Label consoleLabel = new Label("Console:");
        ComboBox<String> consoleComboBox = new ComboBox<>();
        consoleComboBox.getItems().addAll("Playstation", "Xbox", "Nintendo Switch");
        consoleComboBox.setPromptText("Select Console");

         //Number of players
         Label playerLabel = new Label("Number of Players:");
         ComboBox<String> playerComboBox = new ComboBox<>();
         playerComboBox.getItems().addAll("1", "2", "3", "4", "5+");
         playerComboBox.setPromptText("players");


         //text to welcome the employee :)
        Text welcome = new Text(20, 20, "Welcome to the database, Gamestop employee!");
        welcome.setFont(Font.font("Courier", FontWeight.BOLD, 
          FontPosture.ITALIC, 15));
       
        

        //adding the rows and formatting them.
        addGrid.addRow(0, nameLabel, nameInput);
        addGrid.addRow(1, companyLabel, companyInput);
        addGrid.addRow(2, dateLabel, dateInput); 
        addGrid.addRow(3, stockLabel, stockInput);
        addGrid.addRow(4, releaseLabel, releaseComboBox);
        addGrid.addRow(5, consoleLabel, consoleComboBox);
        addGrid.addRow(6, playerLabel, playerComboBox);
       
    
        //adds the add and delete button to the grid and positions them.
        addGrid.add(addButton, 0, 10);
        addGrid.add(deleteButton, 1, 10);
        addGrid.add(editButton, 2, 10);

     

        //creates Vbox for labels to be vertical.
        VBox searchBox = new VBox(10, welcome, searchLabel, searchInput, searchButton, searchResultLabel);

        //aligns the searchbox in the center.
        searchBox.setAlignment(Pos.CENTER);

        //creates a VBox for the gameList. 
        VBox gameListLayout = new VBox(10, new Label("Game List"), gameListView);
        gameListLayout.setAlignment(Pos.CENTER_LEFT);

        //creates a HBox for the layout of everything. 
        HBox layout = new HBox(20, addGrid, gameListLayout, searchBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        //creates the game controller image.
        ImageView imageView = new ImageView("image/game.gif");

        // Set the size of the imageView.
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);

        // Add the imageView to the HBox layout
        layout.getChildren().add(imageView);

        // Create scene and show stage
        Scene scene = new Scene(layout, 1200, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game Database");
        primaryStage.show();
}

    //adding a game to the database
    private void addGame() {

        //retrieves the name, company, date, console, and stock.
        String name = nameInput.getText();
        String company = companyInput.getText();
        LocalDate date = dateInput.getValue();
        String stock = stockInput.getText();
        // String console = consoleComboBox.getText();
        //etc...
    
        //initalizes a game class object.
        Game game = new Game(name, company, company, date, "", stock, "");
    
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
    VBox vbox = new VBox(10, nameLabel, nameSearch, companyLabel, companySearch, dateLabel, dateSearch, stockLabel, stockSearch);
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
                                new Label("Name: " + selectedGame.getTitle()),
                                new Label("Company: " + selectedGame.getCompany()),
                                new Label("Release Year: " + selectedGame.getReleaseDate()),
                                new Label("Amount in Stock: " + selectedGame.getStock()),
                                new Label("Genre: " + selectedGame.getGenre()),
                                new Label("Console: " + selectedGame.getConsoles())
                        );
                        gameDetailsLayout.setAlignment(Pos.CENTER);
        
                        // Set the scene for the game details window
                        Scene gameDetailsScene = new Scene(gameDetailsLayout, 400, 300);
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
                Scene popupScene = new Scene(popupLayout, 400, 300);
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
