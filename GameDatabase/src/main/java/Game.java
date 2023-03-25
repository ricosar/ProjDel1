package projectfinal;
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
    private String languageSupported;
    private String employeeName;
    private String ageRange;
    private String price;
    private String playTime;
    private String additionalGenre;
    private String type;
    private String vrSupport;



    // Constructor that passes all the parameters.
    public Game(String title, String genre, String company, LocalDate releaseDate, String consoles, String stock, 
    String numberOfPlayers, String languageSupported, String employeeName, String ageRange, String price, 
    String playTime, String additionalGenre, String type, String vrSupport) {

        this.title = title;
        this.genre = genre;
        this.company = company;
        this.releaseDate = releaseDate;
       this.numberOfPlayers = numberOfPlayers;
        this.stock = stock;
        this.consoles = consoles;
        this.languageSupported = languageSupported;
        this.employeeName = employeeName;
        this.ageRange = ageRange;
        this.price = price;
        this.playTime = playTime;
        this.additionalGenre = additionalGenre;
        this.type = type;
        this.vrSupport = vrSupport;
    
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

     // Getter for language
       public String getlanguageSupported() {
        return languageSupported;
    }

    // Setter the language
    public void setLanguageSupported(String languageSupported) {
        this.languageSupported = languageSupported;
    }

    //getter for employee name
    public String getEmployeeName(){
        return employeeName;
    }

    //setter for employee name
    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }

    //getter for age range
    public String getAgeRange(){
        return ageRange;
    }

    //setter for age range
    public void setAgeRange(String ageRange){
        this.ageRange = ageRange;
    }

    // Getter for price
    public String getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(String price) {
        this.price = price;
    }

    // Getter for play time
    public String getPlayTime() {
        return playTime;
    }

    // Setter for play time
    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

      // Getter for genre 2
      public String getAdditionalGenre() {
        return additionalGenre;
    }

    // Setter for genre 2
    public void setAdditionalGenre(String additionalGenre) {
        this.additionalGenre = additionalGenre;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Setter for type
    public void setType(String type) {
        this.type = type;
    }

    // Getter for vr support
    public String getVrSupport() {
        return vrSupport;
    }

    // Setter for vr support
    public void setVrSupport(String vrSupport) {
        this.vrSupport = vrSupport;
    }


    // String representation
    @Override
    public String toString() {
        return title + " (" + getCompany() + ")";
    }
}
