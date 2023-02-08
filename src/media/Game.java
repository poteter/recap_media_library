package media;

public class Game implements MediaFunctions {
    private long id;
    private String title;
    private String studio;
    private String genre;
    private String category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String showDetails() {
        String details = "\nGame id    : " + this.id +
                         "\nTitle      : " + this.title +
                         "\nStudio     : " + this.studio +
                         "\nGenre      : " + this.genre +
                         "\ncategory   : " + this.category;
        return details;
    }
}
