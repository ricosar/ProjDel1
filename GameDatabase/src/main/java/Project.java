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

//public class extends Application
public class Project extends Application {

//creates the gameList array.
ObservableList<Game> gameList = FXCollections.observableArrayList();


//private datafields initalized to be used in the program.
    private TextField nameInput;
    private TextField companyInput;
    private TextField employeeInput;
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

        //Employee name
        Label employeeLabel = new Label("Employee name:");
        employeeInput = new TextField();



       // Spinner<Game> stockSpinner = new Spinner<>(0.0,99.99,0.0);

       
  
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
        Label genreLabel = new Label("Genre:");
        ComboBox<String> genreComboBox = new ComboBox<>();
        genreComboBox.getItems().addAll("Horror", "Action", "Mystery", "Platformer", "FPS",
        "RPG", "Puzzle", "Simulation");
        genreComboBox.setPromptText("Select Genre");

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
         typeComboBox.getItems().addAll("Physical copies", "Digital copies");
         typeComboBox.setPromptText("Type");

        //vr support
        Label vrLabel = new Label("VR support:");
        ComboBox<String> vrComboBox = new ComboBox<>();
        vrComboBox.getItems().addAll("Yes", "No");
        vrComboBox.setPromptText("VR?");


        //Add button that points the event to the addGame method.
                Button addButton = new Button("Add");
                addButton.setOnAction(event -> addGame(playerComboBox,  consoleComboBox,
                 genreComboBox, languageComboBox, ageComboBox, priceComboBox, playComboBox, additionalGenreComboBox,
                 typeComboBox, vrComboBox));
    

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
        

         //text to welcome the employee :)
        Text welcome = new Text(20, 20, "Welcome to the database, Gamestop employee!");
        welcome.setFont(Font.font("Courier", FontWeight.BOLD, 
          FontPosture.ITALIC, 15));
       
        

        //adding the rows and formatting them.
        addGrid.addRow(1, employeeLabel, employeeInput);
        addGrid.addRow(2, nameLabel, nameInput);
        addGrid.addRow(3, companyLabel, companyInput);
        addGrid.addRow(4, dateLabel, dateInput); 
        addGrid.addRow(5, stockLabel, stockInput);
        addGrid.addRow(6, genreLabel, genreComboBox);
        addGrid.addRow(7, consoleLabel, consoleComboBox);
        addGrid.addRow(8, playerLabel, playerComboBox);
        addGrid.addRow(9, languageLabel, languageComboBox);
        addGrid.addRow(10, ageLabel, ageComboBox);
        addGrid.addRow(11, priceLabel, priceComboBox);
        addGrid.addRow(12, playLabel, playComboBox);
        addGrid.addRow(13, additionalGenreLabel, additionalGenreComboBox);
        addGrid.addRow(14, typeLabel, typeComboBox);
        addGrid.addRow(15, vrLabel, vrComboBox);
       
    
        //adds the add and delete button to the grid and positions them.
        addGrid.add(addButton, 0, 17);
        addGrid.add(deleteButton, 1, 17);
        addGrid.add(editButton, 2, 17);

     

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
        Scene scene = new Scene(layout, 1400, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game Database");
        primaryStage.show();
}