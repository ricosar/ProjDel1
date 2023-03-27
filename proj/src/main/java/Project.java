
/* Sarah Rico */


//All of my imports
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


//public class extends Application
public class Project extends Application {

    //creates the gameList array.
    ObservableList<Game> gameList = FXCollections.observableArrayList();


    //listview to retrieve values.
    private ListView<String> gameListView;

    @Override
    public void start(Stage primaryStage){

        //institate GameList class
        GameList list = new GameList();

        //Creating a GridPane
        GridPane gridPane = new GridPane();

        //Created a new label for the search results.
        Label searchResultLabel = new Label();

        //A ListView is a UI control that displays a list of items in a vertical scrollable list. 
        gameListView = new ListView<>();

        //setting the distance between buttons.
        gridPane.setVgap(20);
        gridPane.setHgap(20);

        //Add button that points the event to the addGame method.
        Button addButton = new Button("Add");
        addButton.setOnAction(event -> list.addGame(gameList, gameListView));
    

        //Delete button that points the event to the deleteGame method.
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> list.deleteGame(gameList, gameListView));

        //Edit button that points the event to the editGame method.
        Button editButton = new Button("Edit");
        editButton.setOnAction(event -> list.editGame(gameList, gameListView));

         //Exit button event that exits the program.
        Button closeButton = new Button("Exit");
        closeButton.setOnAction(event -> {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Exit the application?",
             ButtonType.YES, ButtonType.CANCEL);
             confirmation.showAndWait();

             if(confirmation.getResult() == ButtonType.YES){
                primaryStage.close();
             } 
        });
        
        /* Search button is created. The event is pointed to the searchgame method. 
        The action also passes getText as a parameter.
        */
        Label searchLabel = new Label("Search:");
        TextField searchInput = new TextField();

        Button searchButton = new Button("Search");
        searchButton.setOnAction(event -> list.searchGame(searchInput.getText(), gameList, gameListView));
    

        //text to welcome the employee :)
        Text welcome = new Text(20, 20, "Welcome to the database, Gamestop employee!");
        welcome.setFont(Font.font("Courier", FontWeight.BOLD, 
            FontPosture.ITALIC, 15));
       
    
        //adds the add and delete button to the grid and positions them.
        gridPane.add(addButton, 0, 13);
        gridPane.add(deleteButton, 1, 13);
        gridPane.add(editButton, 2, 13);
        gridPane.add(closeButton, 1, 16);

        //creates Vbox for labels to be vertical.
        VBox searchBox = new VBox(10, welcome, searchLabel, searchInput, searchButton, searchResultLabel);

        //aligns the searchbox in the center.
        searchBox.setAlignment(Pos.CENTER);

        //creates a VBox for the gameList. 
        VBox gameListLayout = new VBox(10, new Label("Game List"), gameListView);
        gameListLayout.setAlignment(Pos.CENTER_LEFT);

        //creates a HBox for the layout of everything. 
        HBox layout = new HBox(20, gridPane, gameListLayout, searchBox);
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
        Scene scene = new Scene(layout, 1100, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game Database");
        primaryStage.show();
        }
   
    
    public static void main(String[] args) {
        launch(args);
    }

}
