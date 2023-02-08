package media;

public class Movie implements MediaFunctions {
    private long id;
    private String title;
    private String fname;
    private String lname;
    private long runTime;
    private String genre;

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

    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    public long getRunTime() {
        return runTime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String showDetails() {
        String details = "\nMovie id   : " + this.id +
                         "\nTitle      : " + this.title +
                         "\nDirector   : " + this.fname + " " + this.lname +
                         "\nRun time   : " + this.runTime +
                         "\nGenre      : " + this.genre;
        return details;
    }
}
