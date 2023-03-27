
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameList{


    //adding a game to the database
    public void addGame(ObservableList<Game> gameList, ListView<String> gameListView) {

        Stage addStage = new Stage();

        // Add components to layout by adding it to a GridPane.
        GridPane addGrid = new GridPane();

        //setting the distance between buttons.
        addGrid.setVgap(20);
        addGrid.setHgap(20);

        //Game name
        Label nameLabel = new Label("Game Name:");
        TextField nameInput = new TextField();

        //Company
        Label companyLabel = new Label("Company:");
        TextField companyInput = new TextField();

        //Date of release
        Label dateLabel = new Label("Release Date:");
        DatePicker dateInput = new DatePicker();

        //Employee name
        Label employeeLabel = new Label("Employee name:");
        TextField employeeInput = new TextField();
    
        //setting the distance between buttons.
        addGrid.setVgap(20);
        addGrid.setHgap(20);
               
        //Genre
        Label genreLabel = new Label("Genre:");
        ComboBox<String> genreComboBox = new ComboBox<>();
        genreComboBox.getItems().addAll("Horror", "Action", "Mystery", "Platformer", "FPS",
        "RPG", "Puzzle", "Simulation");
        genreComboBox.setPromptText("Select Genre");

        Label stockLabel = new Label("Items in stock:");
        ComboBox<String> stockComboBox = new ComboBox<>();
        stockComboBox.getItems().addAll("Under 10", "10 to 20", "20 to 50", "50 to 100", "100+");
        stockComboBox.setPromptText("Stock");

        //Consoles
        Label consoleLabel = new Label("Console:");
        ComboBox<String> consoleComboBox = new ComboBox<>();
        consoleComboBox.getItems().addAll("Playstation", "Xbox", "Nintendo Switch");
        consoleComboBox.setPromptText("Select Console");
  
        //Number of players
        Label playerLabel = new Label("Number of Players:");
        ComboBox<String> playerComboBox = new ComboBox<>();
        playerComboBox.getItems().addAll("1", "2", "3", "4", "5+");
        playerComboBox.setPromptText("Players");
  
        //Languages the game supports
        Label languageLabel = new Label("Languages Supported:");
        ComboBox<String> languageComboBox = new ComboBox<>();
        languageComboBox.getItems().addAll("1", "2", "3", "4", "5+");
        languageComboBox.setPromptText("Languages");
  
        //Age range
        Label ageLabel = new Label("Age range:");
        ComboBox<String> ageComboBox = new ComboBox<>();
        ageComboBox.getItems().addAll("Everyone", "Teen (13+)", "Mature (17+)", "Adults only (+18)");
        ageComboBox.setPromptText("Age");
  
        //Price of game
        Label priceLabel = new Label("Price:");
        ComboBox<String> priceComboBox = new ComboBox<>();
        priceComboBox.getItems().addAll("under $10", "under $20", "under $50", "under $100", "over $100");
        priceComboBox.setPromptText("$");
  
        //Play time
        Label playLabel = new Label("Play Time:");
        ComboBox<String> playComboBox = new ComboBox<>();
        playComboBox.getItems().addAll("Under 20 hours", "Over 20 hours", "Over 100 hours");
        playComboBox.setPromptText("Hours");
        
        //more genres
        Label additionalGenreLabel = new Label("Additional genres:");
        ComboBox<String> additionalGenreComboBox = new ComboBox<>();
        additionalGenreComboBox.getItems().addAll("Sports", "Racing", "Strategy", "Fighting", 
        "Rhythm");
        additionalGenreComboBox.setPromptText("Genres");

        //type
        Label typeLabel = new Label("Type of copy:");
        ComboBox<String> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll("Physical copies", 
        "Digital copies");
        typeComboBox.setPromptText("Type");

        //vr support
        Label vrLabel = new Label("VR support:");
        ComboBox<String> vrComboBox = new ComboBox<>();
        vrComboBox.getItems().addAll("Yes", "No");
        vrComboBox.setPromptText("VR?");

          
        //Creating Hboxes to properly place the label and inputs for each datafield
        HBox hbox1 = new HBox(10, employeeLabel, employeeInput);
        addGrid.addRow(1, hbox1);
        
        HBox hbox2 = new HBox(10, nameLabel, nameInput);
        addGrid.addRow(2, hbox2);
        
        HBox hbox3 = new HBox(10, companyLabel, companyInput);
        addGrid.addRow(3, hbox3);
        
        HBox hbox4 = new HBox(10, dateLabel, dateInput);
        addGrid.addRow(4, hbox4);
        
        HBox hbox5 = new HBox(10, stockLabel, stockComboBox);
        addGrid.addRow(5, hbox5);
        
        HBox hbox6 = new HBox(10, genreLabel, genreComboBox);
        HBox hbox7 = new HBox(10, consoleLabel, consoleComboBox);
        addGrid.addRow(6, hbox6, hbox7);
        
        HBox hbox8 = new HBox(10, playerLabel, playerComboBox);
        HBox hbox9 = new HBox(10, languageLabel, languageComboBox);
        addGrid.addRow(7, hbox8, hbox9);
        
        HBox hbox10 = new HBox(10, ageLabel, ageComboBox);
        HBox hbox11 = new HBox(10, priceLabel, priceComboBox);
        addGrid.addRow(8, hbox10, hbox11);
        
        HBox hbox12 = new HBox(10, playLabel, playComboBox);
        HBox hbox13 = new HBox(10, additionalGenreLabel,
         additionalGenreComboBox);
        addGrid.addRow(9, hbox12, hbox13);
        
        HBox hbox14 = new HBox(10, typeLabel, typeComboBox);
        HBox hbox15 = new HBox(10, vrLabel, vrComboBox);
        addGrid.addRow(10, hbox14, hbox15);
        
        //aligns the first hbox to the centre
        hbox1.setAlignment(Pos.CENTER);

        //set padding for Hboxes to be in the middle
        hbox1.setPadding(new Insets(10, 10, 10, 10));

        hbox2.setAlignment(Pos.CENTER);
        hbox2.setPadding(new Insets(10, 10, 10, 10));

        hbox3.setAlignment(Pos.CENTER);
        hbox3.setPadding(new Insets(10, 10, 10, 10));

        hbox4.setAlignment(Pos.CENTER);
        hbox4.setPadding(new Insets(10, 10, 10, 10));

        hbox5.setAlignment(Pos.CENTER);
        hbox5.setPadding(new Insets(10, 10, 10, 10));

        hbox6.setAlignment(Pos.CENTER);
        hbox6.setPadding(new Insets(10, 10, 10, 10));

        hbox7.setAlignment(Pos.CENTER);
        hbox7.setPadding(new Insets(10, 10, 10, 10));

        hbox8.setAlignment(Pos.CENTER);
        hbox8.setPadding(new Insets(10, 10, 10, 10));

        hbox9.setAlignment(Pos.CENTER);
        hbox9.setPadding(new Insets(10, 10, 10, 10));

        hbox10.setAlignment(Pos.CENTER);
        hbox10.setPadding(new Insets(10, 10, 10, 10));

        hbox11.setAlignment(Pos.CENTER);
        hbox11.setPadding(new Insets(10, 10, 10, 10));

        hbox12.setAlignment(Pos.CENTER);
        hbox12.setPadding(new Insets(10, 10, 10, 10));

        hbox13.setAlignment(Pos.CENTER);
        hbox13.setPadding(new Insets(10, 10, 10, 10));

        hbox14.setAlignment(Pos.CENTER);
        hbox14.setPadding(new Insets(10, 10, 10, 10));

        hbox15.setAlignment(Pos.CENTER);
        hbox15.setPadding(new Insets(10, 10, 10, 10));
  
        //creating the save button
        Button addButton = new Button("Save");

        //Cancel button
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(event -> {
        
            //Close the editing stage
            addStage.close();
        });

        //setting the buttons
        addGrid.add(addButton, 2, 3);
        addGrid.add(cancelButton, 3, 3);
    
        //when the add button is pressed, an event is invoked.
        addButton.setOnAction(event -> {
        
        //retrieves the name, company, date, console, and stock.
        String name = nameInput.getText();
        String company = companyInput.getText();
        LocalDate date = dateInput.getValue();
        String employee = employeeInput.getText();
        
    
        //retrieving values from comboboxes.
        String stock = (String) stockComboBox.getValue();

        String player = (String) playerComboBox.getValue();
    
        String console = (String) consoleComboBox.getValue();

        String genre = (String) genreComboBox.getValue();
        
        String language = (String) languageComboBox.getValue();

        String age = (String) ageComboBox.getValue();

        String price = (String) priceComboBox.getValue();

        String play = (String) playComboBox.getValue();

        String genre2 = (String) additionalGenreComboBox.getValue();

        String type = (String) typeComboBox.getValue();

        String vr = (String) vrComboBox.getValue();

        //initalizes a game class object.
        Game game = new Game(name, genre, company, date, console, stock, player, language, employee, age, price, 
        play, genre2, type, vr);
    
        // Adds the game to the gameList.
        gameList.add(game);
    
        // Clears it so new values can be added.
        nameInput.clear();
        companyInput.clear();
        dateInput.setValue(null);
        addStage.close();

        // Calls updateGameList method.
        updateGameList(gameList, gameListView);
    
        try {
            // create a RandomAccessFile object with a filename of "games.txt" and mode "rw" (read and write)
            RandomAccessFile raf = new RandomAccessFile("games.txt", "rw");
        
            // seek to the end of the file to append to it
            raf.seek(raf.length());
        
            // write the game information to the file
            raf.writeUTF(game.toString());
        
            // close the RandomAccessFile object
            raf.close();
        
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
              
        });

         // Set the scene for the addStage
        Scene addScene = new Scene(addGrid, 700, 700);
        addStage.setScene(addScene);

        // Show the addStage
        addStage.show();
    }
    

    public void deleteGame(ObservableList<Game> gameList, ListView<String> gameListView) {
        // if the selected game is not null, prompt the user if they'd like to delete the game.
        String selectedGameName = gameListView.getSelectionModel().getSelectedItem();
    
        if (selectedGameName != null) {
            // Create confirmation alert
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Delete the game?",
             ButtonType.YES, ButtonType.CANCEL);
            confirmation.showAndWait();
    
            // If the user clicked yes, delete the game
            if (confirmation.getResult() == ButtonType.YES) {
                Game gameToDelete = null;
                for (Game game : gameList) {
                    if (game.getTitle().equals(selectedGameName)) {
                        gameToDelete = game;
                        break;
                    }
                }
                if (gameToDelete != null) {
                    gameList.remove(gameToDelete);
                    updateGameList(gameList, gameListView);
    
                    try {
                        // create a File object with the filename of "games.txt"
                        File file = new File("games.txt");
                    
                        // delete the file if it exists
                        if (file.exists()) {
                            file.delete();
                        }
                    
                        // create a new file with the same filename
                        file.createNewFile();
                    
                        // create a RandomAccessFile object with the same filename and mode "rw" (read and write)
                        RandomAccessFile raf = new RandomAccessFile(file, "rw");
                    
                        // write the game information to the file
                        raf.writeUTF(gameList.toString());
                    
                        // close the RandomAccessFile object
                        raf.close();
                    
                    } catch (IOException e) {
                        System.out.println("Error writing to file.");
                    }
                }
            }
        }
    }

    
    //edit game method
    public void editGame(ObservableList<Game> gameList, ListView<String> gameListView) {

        // Get the selected game from the list
        String selectedGameName = gameListView.getSelectionModel().getSelectedItem();
    
        //if the name is not null, proceed.
        if (selectedGameName != null) {

            // Retrieve the selected game object from the inventory
            Game selectedGame = null;
            for (Game game : gameList) {
                if (game.getTitle().equals(selectedGameName)) {
                    selectedGame = game;
                    break;
                }
            }

              // Create a new stage for editing the game
            Stage editStage = new Stage();
            editStage.setTitle("Edit Game");
    
            // Add components to layout by adding it to a GridPane.
            GridPane addGrid = new GridPane();

            //setting the distance between buttons.
            addGrid.setVgap(20);
            addGrid.setHgap(20);

            //Game name
            Label nameLabel = new Label("Game Name:");
            TextField nameInput = new TextField(selectedGame.getTitle());
    
            //Company
            Label companyLabel = new Label("Company:");
            TextField companyInput = new TextField(selectedGame.getCompany());
    
            //Date of release
            Label dateLabel = new Label("Release Date:");
            DatePicker dateInput = new DatePicker(selectedGame.getReleaseDate());
    
    
            //Employee name
            Label employeeLabel = new Label("Employee name:");
            TextField employeeInput = new TextField(selectedGame.getEmployeeName());
            
            //setting the distance between buttons.
            addGrid.setVgap(20);
            addGrid.setHgap(20);
               
            //Genre
            Label genreLabel = new Label("Genre:");
            ComboBox<String> genreComboBox = new ComboBox<>();
            genreComboBox.getItems().addAll("Horror", "Action", "Mystery", "Platformer", "FPS",
            "RPG", "Puzzle", "Simulation");
            genreComboBox.setPromptText("Select Genre");
            //Setting the prompt text in edit
            genreComboBox.setPromptText(selectedGame.getGenre());

            //Stock
            Label stockLabel = new Label("Items in stock:");
            ComboBox<String> stockComboBox = new ComboBox<>();
            stockComboBox.getItems().addAll("Under 10", "10 to 20", "20 to 50", "50 to 100", "100+");
            stockComboBox.setPromptText("Stock");
            //Setting the prompt text in edit
            stockComboBox.setPromptText(selectedGame.getStock());
    
            //Consoles
            Label consoleLabel = new Label("Console:");
            ComboBox<String> consoleComboBox = new ComboBox<>();
            consoleComboBox.getItems().addAll("Playstation", "Xbox", "Nintendo Switch");
            consoleComboBox.setPromptText("Select Console");
            //Setting the prompt text in edit
            consoleComboBox.setPromptText(selectedGame.getConsoles());

            //Number of players
            Label playerLabel = new Label("Number of Players:");
            ComboBox<String> playerComboBox = new ComboBox<>();
            playerComboBox.getItems().addAll("1", "2", "3", "4", "5+");
            playerComboBox.setPromptText("Players");
            //Setting the prompt text in edit
            playerComboBox.setPromptText(selectedGame.getNumberOfPlayers());
    

            //Languages the game supports
            Label languageLabel = new Label("Languages Supported:");
            ComboBox<String> languageComboBox = new ComboBox<>();
            languageComboBox.getItems().addAll("1", "2", "3", "4", "5+");
            languageComboBox.setPromptText("Languages");
            //Setting the prompt text in edit
            languageComboBox.setPromptText(selectedGame.getlanguageSupported()); 
    

            //Age range
            Label ageLabel = new Label("Age range:");
            ComboBox<String> ageComboBox = new ComboBox<>();
            ageComboBox.getItems().addAll("Everyone", "Teen (13+)", "Mature (17+)", "Adults only (+18)");
            ageComboBox.setPromptText("Age");
            //Setting the prompt text in edit
            ageComboBox.setPromptText(selectedGame.getAgeRange());
    

            //Price of game
            Label priceLabel = new Label("Price:");
            ComboBox<String> priceComboBox = new ComboBox<>();
            priceComboBox.getItems().addAll("under $10", "under $20", "under $50", "under $100", "over $100");
            priceComboBox.setPromptText("$");
            //Setting the prompt text in edit
            priceComboBox.setPromptText(selectedGame.getPrice());
    
            //Play time
            Label playLabel = new Label("Play Time:");
            ComboBox<String> playComboBox = new ComboBox<>();
            playComboBox.getItems().addAll("Under 20 hours", "Over 20 hours", "Over 100 hours");
            playComboBox.setPromptText("Hours");
            //Setting the prompt text in edit
            playComboBox.setPromptText(selectedGame.getPlayTime());
            
            //more genres
            Label additionalGenreLabel = new Label("Additional genres:");
            ComboBox<String> additionalGenreComboBox = new ComboBox<>();
            additionalGenreComboBox.getItems().addAll("Sports", "Racing", "Strategy", "Fighting", 
            "Rhythm");
            additionalGenreComboBox.setPromptText("Genres");
            //Setting the prompt text in edit
            additionalGenreComboBox.setPromptText(selectedGame.getAdditionalGenre());
    
            //type
            Label typeLabel = new Label("Type of copy:");
            ComboBox<String> typeComboBox = new ComboBox<>();
            typeComboBox.getItems().addAll("Physical copies", "Digital copies");
            typeComboBox.setPromptText("Type");
            //Setting the prompt text in edit
            typeComboBox.setPromptText(selectedGame.getType());
    
            //vr support
            Label vrLabel = new Label("VR support:");
            ComboBox<String> vrComboBox = new ComboBox<>();
            vrComboBox.getItems().addAll("Yes", "No");
            vrComboBox.setPromptText("VR?");
            //Setting the prompt text in edit
            vrComboBox.setPromptText(selectedGame.getVrSupport());

          
            //Creating the Hboxes for the input and labels for the datafields.
            HBox hbox1 = new HBox(10, employeeLabel, employeeInput);
            addGrid.addRow(1, hbox1);
            
            HBox hbox2 = new HBox(10, nameLabel, nameInput);
            addGrid.addRow(2, hbox2);
            
            HBox hbox3 = new HBox(10, companyLabel, companyInput);
            addGrid.addRow(3, hbox3);
            
            HBox hbox4 = new HBox(10, dateLabel, dateInput);
            addGrid.addRow(4, hbox4);
            
            HBox hbox5 = new HBox(10, stockLabel, stockComboBox);
            addGrid.addRow(5, hbox5);
            
            HBox hbox6 = new HBox(10, genreLabel, genreComboBox);
            HBox hbox7 = new HBox(10, consoleLabel, consoleComboBox);
            addGrid.addRow(6, hbox6, hbox7);
            
            HBox hbox8 = new HBox(10, playerLabel, playerComboBox);
            HBox hbox9 = new HBox(10, languageLabel, languageComboBox);
            addGrid.addRow(7, hbox8, hbox9);
            
            HBox hbox10 = new HBox(10, ageLabel, ageComboBox);
            HBox hbox11 = new HBox(10, priceLabel, priceComboBox);
            addGrid.addRow(8, hbox10, hbox11);
            
            HBox hbox12 = new HBox(10, playLabel, playComboBox);
            HBox hbox13 = new HBox(10, additionalGenreLabel, additionalGenreComboBox);
            addGrid.addRow(9, hbox12, hbox13);
            
            HBox hbox14 = new HBox(10, typeLabel, typeComboBox);
            HBox hbox15 = new HBox(10, vrLabel, vrComboBox);
            addGrid.addRow(10, hbox14, hbox15);
            
            hbox1.setAlignment(Pos.CENTER);

            //set padding for middle
            hbox1.setPadding(new Insets(10, 10, 10, 10));

            hbox2.setAlignment(Pos.CENTER);
            hbox2.setPadding(new Insets(10, 10, 10, 10));

            hbox3.setAlignment(Pos.CENTER);
            hbox3.setPadding(new Insets(10, 10, 10, 10));

            hbox4.setAlignment(Pos.CENTER);
            hbox4.setPadding(new Insets(10, 10, 10, 10));

            hbox5.setAlignment(Pos.CENTER);
            hbox5.setPadding(new Insets(10, 10, 10, 10));

            hbox6.setAlignment(Pos.CENTER);
            hbox6.setPadding(new Insets(10, 10, 10, 10));

            hbox7.setAlignment(Pos.CENTER);
            hbox7.setPadding(new Insets(10, 10, 10, 10));

            hbox8.setAlignment(Pos.CENTER);
            hbox8.setPadding(new Insets(10, 10, 10, 10));

            hbox9.setAlignment(Pos.CENTER);
            hbox9.setPadding(new Insets(10, 10, 10, 10));

            hbox10.setAlignment(Pos.CENTER);
            hbox10.setPadding(new Insets(10, 10, 10, 10));

            hbox11.setAlignment(Pos.CENTER);
            hbox11.setPadding(new Insets(10, 10, 10, 10));

            hbox12.setAlignment(Pos.CENTER);
            hbox12.setPadding(new Insets(10, 10, 10, 10));

            hbox13.setAlignment(Pos.CENTER);
            hbox13.setPadding(new Insets(10, 10, 10, 10));

            hbox14.setAlignment(Pos.CENTER);
            hbox14.setPadding(new Insets(10, 10, 10, 10));

            hbox15.setAlignment(Pos.CENTER);
            hbox15.setPadding(new Insets(10, 10, 10, 10));
  
            //For cancel button function
            Button cancelButton = new Button("Cancel");
            cancelButton.setOnAction(event -> {

                // Close the editing stage
                editStage.close();
            });
    
            //Create the Save button
            Button saveButton = new Button("Save");
            saveButton.setOnAction(event -> {
            
            //Get the edited values from the text fields
            String name = nameInput.getText();
            String company = companyInput.getText();
            LocalDate date = dateInput.getValue();
            String employee = employeeInput.getText();

            //Retrieving values from comboboxes.
            String stock = (String) stockComboBox.getValue();

            String player = (String) playerComboBox.getValue();
        
            String console = (String) consoleComboBox.getValue();

            String genre = (String) genreComboBox.getValue();
            
            String language = (String) languageComboBox.getValue();

            String age = (String) ageComboBox.getValue();

            String price = (String) priceComboBox.getValue();

            String play = (String) playComboBox.getValue();

            String genre2 = (String) additionalGenreComboBox.getValue();

            String type = (String) typeComboBox.getValue();

            String vr = (String) vrComboBox.getValue();
            

            //initalizes a game class object.
            Game game = new Game(name, genre, company, date, console, stock, player, language, employee, age, price, 
            play, genre2, type, vr);

           //uploading to file
           try {
            // create a File object with the filename of "games.txt"
            File file = new File("games.txt");
        
            // delete the file if it exists
            if (file.exists()) {
                file.delete();
            }
        
            // create a new file with the same filename
            file.createNewFile();
        
            // create a RandomAccessFile object with the same filename and mode "rw" (read and write)
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
        
            // write the game information to the file
            raf.writeUTF(game.toString());
        
            // close the RandomAccessFile object
            raf.close();
        
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
        
        
        
          
        
            //adds the game
            gameList.add(game);


        //removes the previous filed game.
            for (Game games : gameList) {
                if (games.getTitle().equals(selectedGameName)) {
                    gameList.remove(games);
                    updateGameList(gameList, gameListView);
                    break;
                }
            }
                // Close the editing stage
                editStage.close();
            });
    
            // Add the Save button to the VBox
            addGrid.add(saveButton, 2, 3);
            addGrid.add(cancelButton, 3, 3);
    
    
            // Create a new scene for the editing stage
            Scene editScene = new Scene(addGrid, 700, 700);
    
            // Set the scene and show the editing stage
            editStage.setScene(editScene);
            editStage.showAndWait();
        } else {
            // If no game is selected, display an error message and return
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No game selected");
            alert.setContentText("Please select a game to edit.");
            alert.showAndWait();
        }
    }
   


    //method to search for a game in search bar
    public void searchGame(String name, ObservableList<Game> gameList, ListView<String> gameListView) {

        //if nothing is searched.
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

            //If matching games is not empty (the ArrayList of matchingGames)
            if (!matchingGames.isEmpty()) {

                //a ListView of Game objects, and sets each cell in the list to display the title of the Game object.
                ListView<Game> matchingGamesListView = new ListView<>();
                matchingGamesListView.getItems().addAll(matchingGames);

                //How each cell should be displayed.
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
                            new Label("Employee Name: " +
                            (selectedGame.getEmployeeName() == null || selectedGame.getEmployeeName().isEmpty() ? "Not available" :
                            selectedGame.getEmployeeName())),

                            new Label("Game Name: " +
                            (selectedGame.getTitle() == null || selectedGame.getTitle().isEmpty() ? "Not available" :
                            selectedGame.getTitle())),

                            new Label("Company: " +
                            (selectedGame.getCompany() == null || selectedGame.getCompany().isEmpty() ? "Not available" :
                            selectedGame.getCompany())),

                            new Label("Release Year: " +
                            (selectedGame.getReleaseDate() == null ? "Not available" :
                            selectedGame.getReleaseDate())),

                            new Label("Amount in Stock: " +
                            (selectedGame.getStock() == null || selectedGame.getStock().isEmpty() ? "Not available" :
                             selectedGame.getStock())),

                             new Label("Genre: " +
                            (selectedGame.getGenre() == null || selectedGame.getGenre().isEmpty() ? "Not available" :
                            selectedGame.getGenre())),

                            new Label("Console: " +
                            (selectedGame.getConsoles() == null || selectedGame.getConsoles().isEmpty() ? "Not available" :
                             selectedGame.getConsoles())),

                            new Label("Amount of Languages supported: " +
                            (selectedGame.getlanguageSupported() == null || selectedGame.getlanguageSupported().isEmpty() ? "Not available" :
                            selectedGame.getlanguageSupported())),

                            new Label("Age range: " +
                            (selectedGame.getAgeRange() == null || selectedGame.getAgeRange().isEmpty() ? "Not available" :
                             selectedGame.getAgeRange())),
                            
                             new Label("Price: " +
                            (selectedGame.getPrice() == null || selectedGame.getPrice().isEmpty() ? "Not available" :
                            selectedGame.getPrice())),
                            
                            new Label("Play time: " +
                            (selectedGame.getPlayTime() == null || selectedGame.getPlayTime().isEmpty() ? "Not available" :
                             selectedGame.getPlayTime())),
                            
                            new Label("Type of copy: " +
                            (selectedGame.getType() == null || selectedGame.getType().isEmpty() ? "Not available" :
                            selectedGame.getType())),
                               
                            new Label("Vr support: " +
                            (selectedGame.getVrSupport() == null || selectedGame.getVrSupport().isEmpty() ? "Not available" :
                             selectedGame.getVrSupport()))
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
                VBox popupLayout = new VBox(10, new Label("Search Results:"),
                 matchingGamesListView, new Button("Close"));
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

    //Updates the gamelist box
    public void updateGameList(ObservableList<Game> gameList, ListView<String> gameListView) {
        //Sort the game list by alphabetical order 
        Collections.sort(gameList, Comparator.comparing(Game::getTitle));
    
        //For every gmae in the list, sort it.
        List<String> gameNames = new ArrayList<>();
        for (Game game : gameList) {
            gameNames.add(game.getTitle());
        }
        gameListView.getItems().setAll(gameNames);
    }
}
