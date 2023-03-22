//*Max Matthews, Sarah Rico */


//All of our imports
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//public class extends Application
public class Project extends Application {

//creates the gameList array.
    private ArrayList<Game> gameList = new ArrayList<>();


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

        //Genres
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

    //Add button that points the event to the addGame method.
        Button addButton = new Button("Add");
        addButton.setOnAction(event -> addGame());

    //Delete button that points the event to the deleteGame method.
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> deleteGame());
    

    /* Search button is created. The event is pointed to the searchgame method. 
    The action also passes getText as a parameter.
    */
        Label searchLabel = new Label("Search:");
        TextField searchInput = new TextField();
        Button searchButton = new Button("Search");
        searchButton.setOnAction(event -> searchGame(searchInput.getText()));


    /*
    Created a new label for the search results.

    A ListView is a UI control that displays a list of items
    in a vertical scrollable list. We will use this to store the games in.

    */
        searchResultLabel = new Label();
        gameListView = new ListView<>();

        
        // Add components to layout by adding it to a GridPane.
        GridPane addGrid = new GridPane();

        //setting the distance between buttons.
        addGrid.setVgap(10);
        addGrid.setHgap(10);

        //adding the rows and formatting them.
        addGrid.addRow(0, nameLabel, nameInput);
        addGrid.addRow(1, companyLabel, companyInput);
        addGrid.addRow(2, dateLabel, dateInput);
        addGrid.addRow(3, releaseLabel, releaseComboBox);
        addGrid.addRow(4, consoleLabel, consoleComboBox);
        addGrid.addRow(5, stockLabel, stockInput);

        //adds the add and delete button to the grid and positions them.
        addGrid.add(addButton, 0, 8);
        addGrid.add(deleteButton, 1, 8);

        //creates Vbox for labels to be vertical.
        VBox searchBox = new VBox(10, searchLabel, searchInput, searchButton, searchResultLabel);

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
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        // Add the imageView to the HBox layout
        layout.getChildren().add(imageView);


        // Create scene and show stage
        Scene scene = new Scene(layout, 900, 400);
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
        String console = stockInput.getValue();
        //etc...

        //initalizes a game class object.
        Game game = new Game(name, company, company, date, 0);

        // Adds the game to the gameList.
        gameList.add(game);

        // Clears it so new values can be added.
        nameInput.clear();
        companyInput.clear();
        dateInput.setValue(null);

        // Calls updateGameList method.
        updateGameList();
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
                //how each cell should be displayed.
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
                                new Label("Release Year: " + selectedGame.getReleaseDate())
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

// Game class
class Game {

    // Data fields
    private String title;
    private String genre;
    private String company;
    private LocalDate releaseDate;
    private List<String> consoles;
    private int stock;

    // Constructor that passes all the parameters.
    public Game(String title, String genre, String company, LocalDate releaseDate, int stock) {
        this.title = title;
        this.genre = genre;
        this.company = company;
        this.releaseDate = releaseDate;
        this.stock = stock;
        this.consoles = new ArrayList<>();
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter the title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for genre
    public String getGenre() {
        return genre;
    }

    // Setter the genre
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Getter for company
    public String getCompany() {
        return company;
    }

     // Setter the company
    public void setCompany(String company) {
        this.company = company;
    }

    // Getter for release date
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

      // Setter the release date
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    // Getter for consoles (returns Arraylist)
    public List<String> getConsoles() {
        return consoles;
    }

    // Setter the consoles (adds a console to the ArrayList)
    public void addConsole(String console) {
        consoles.add(console);
    }

    // Setter the consoles (removes a console from the ArrayList)
    public void removeConsole(String console) {
        consoles.remove(console);
    }

    // Getter for stock
    public int getStock() {
        return stock;
    }

     // Setter for stock
    public void setStock(int stock) {
        this.stock = stock;
    }

    // String representation
    @Override
    public String toString() {
        return title + " (" + releaseDate.getYear() + ")";
    }
}