
import java.time.LocalDate;




// Game class
public class Game {

    // Data fields
    private String title;
    private String genre;
    private String company;
    private LocalDate releaseDate;
    private String stock;
    private String consoles;
    private String numberOfPlayers;
    //private String player age groups;
    private LocalDate dateOfEntry;
    private String employeeName;
    private boolean crossPlatformAbility;
    private boolean LanguagesSupported;
    private double gameLength;
    //is it multiplayer?
    //DLC available?
   



    // Constructor that passes all the parameters.
    public Game(String title, String genre, String company, LocalDate releaseDate, String consoles, String stock, 
    String numberOfPlayers) {
        this.title = title;
        this.genre = genre;
        this.company = company;
        this.releaseDate = releaseDate;
       this.numberOfPlayers = numberOfPlayers;
        this.stock = stock;
        this.consoles = consoles;
    
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

    // Getter for consoles
    public String getConsoles() {
        return consoles;
    }

    // Setter for consoles
    public void setConsoles(String consoles) {
        this.consoles = consoles;
    }

    // Getter for stock
    public String getStock() {
        return stock;
    }

     // Setter for stock
    public void setStock(String stock) {
        this.stock = stock;
    }

       // Getter for number
  public String getNumberOfPlayers() {
        return numberOfPlayers;
    }

    // Setter the number
    public void setNumberOfPlayers(String numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    // String representation
    @Override
    public String toString() {
        return title + " (" + getCompany() + ")";
    }
}