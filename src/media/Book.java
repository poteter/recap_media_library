package media;
public class Book implements MediaFunctions {
    private long isbn;
    private String title;
    private String fname;
    private String lname;
    private long pageCount;
    private String genre;

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String showDetails() {

        String details = "\nISBN       : " + this.isbn +
                         "\nTitle      : " + this.title +
                         "\nAuthor     : " + this.fname + " " + this.lname +
                         "\nPage Count : " + this.pageCount +
                         "\nGenre      : " + this.genre;
        return details;
    }
}
