//*Max Matthews, Sarah Rico */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Project extends Application {

    private List<Game> gameList = new ArrayList<>();

    private TextField nameInput;
    private TextField companyInput;
    private DatePicker dateInput;
    private Label searchResultLabel;
    private ListView<String> gameListView;

    @Override
    public void start(Stage primaryStage){
        // Create UI components and labels for the application
        Label nameLabel = new Label("Name:");
        nameInput = new TextField();
        Label companyLabel = new Label("Company:");
        companyInput = new TextField();
        Label dateLabel = new Label("Date:");
        dateInput = new DatePicker();
        Button addButton = new Button("Add");
        addButton.setOnAction(event -> addGame());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> deleteGame());
        Label searchLabel = new Label("Search:");
        TextField searchInput = new TextField();
        Button searchButton = new Button("Search");

        searchButton.setOnAction(event -> searchGame(searchInput.getText()));
        searchResultLabel = new Label();
        gameListView = new ListView<>();

        
        // Add components to layout
        GridPane addGrid = new GridPane();
        addGrid.setVgap(10);
        addGrid.setHgap(10);
        addGrid.addRow(0, nameLabel, nameInput);
        addGrid.addRow(1, companyLabel, companyInput);
        addGrid.addRow(2, dateLabel, dateInput);
        addGrid.add(addButton, 0, 3);
        addGrid.add(deleteButton, 1, 3);

        VBox searchBox = new VBox(10, searchLabel, searchInput, searchButton, searchResultLabel);
        
        searchBox.setAlignment(Pos.CENTER);
        VBox gameListLayout = new VBox(10, new Label("Game List"), gameListView);
        gameListLayout.setAlignment(Pos.CENTER_LEFT);
        HBox layout = new HBox(20, addGrid, gameListLayout, searchBox);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        // Create scene and show stage
        Scene scene = new Scene(layout, 800, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game Database");
        primaryStage.show();
    }

    //adding a game to the database
    private void addGame() {
        String name = nameInput.getText();
        String company = companyInput.getText();
        LocalDate date = dateInput.getValue();
        Game game = new Game(name, company, date);
        gameList.add(game);
        nameInput.clear();
        companyInput.clear();
        dateInput.setValue(null);
        updateGameList();
    }

    //deleting a game method (programming for button)
    private void deleteGame() {
        String selectedGameName = gameListView.getSelectionModel().getSelectedItem();
        if (selectedGameName != null) {
            for (Game game : gameList) {
                if (game.getName().equals(selectedGameName)) {
                    gameList.remove(game);
                    updateGameList();
                    break;
                }
            }
        }
    }

    //method to search for a game in search bar
    private void searchGame(String name) {
        for (Game game : gameList) {
            if (game.getName().equals(name)) {
                searchResultLabel.setText("Name: " + game.getName() +
                        "\nCompany: " + game.getCompany() +
                        "\nDate: " + game.getDate());
            }
        }
        searchResultLabel.setText("No matching game found."); //if no game was found
    }

    //updates the gamelist box
    private void updateGameList() {
        // Sort the game list by name
        Collections.sort(gameList, Comparator.comparing(Game::getName));
    
        List<String> gameNames = new ArrayList<>();
        for (Game game : gameList) {
            gameNames.add(game.getName());
        }
        gameListView.getItems().setAll(gameNames);
    }
   

    public static void main(String[] args) {
        launch(args);
    }

}

//game class
class Game {

    //datafields
    private String name;
    private String company;
    private LocalDate date;

    //game constructor
    public Game(String name, String company, LocalDate date) {
        this.name = name;
        this.company = company;
        this.date = date;
    }

    //getters and setters for datafields
    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public LocalDate getDate() {
        return date;
    }

}


