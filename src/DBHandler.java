import media.Book;
import media.Game;
import media.Movie;

import java.sql.*;
import java.util.ArrayList;

/**
 * methods for interacting with database, establishing and closing connection
 */
public class DBHandler {
    public DBHandler(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/medialibrary",
                    "root",
                    "1548from5Kaal"
            );
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void addBook(String title, long authorid, long pageCount, long genreid){
        try(Connection connection = getConnection()){
            String sql = "INSERT INTO book(title, authorid, pagecount, genreid) " +
                         "VALUES(?, ?, ?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setLong(2, authorid);
            stmt.setLong(3, pageCount);
            stmt.setLong(4, genreid);

            stmt.executeUpdate();
            closeDbConnection(connection);
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void addMovie(String title, long directorId, long runTime, long genreId){
        try(Connection connection = getConnection()){
            String sql = "INSERT INTO movie(title, directorid, runtime, genreid) " +
                         "VALUES(?, ?, ?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setLong(2, directorId);
            stmt.setLong(3, runTime);
            stmt.setLong(4, genreId);

            stmt.executeUpdate();
            closeDbConnection(connection);
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }

    }

    public void addGame(String title, long studioId, long genreId, long categoryId){
        try(Connection connection = getConnection()){
            String sql = "INSERT INTO game(title, studioid, genreid, categoryid) " +
                         "VALUES(?, ?, ?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setLong(2, studioId);
            stmt.setLong(3, genreId);
            stmt.setLong(4, categoryId);

            stmt.executeUpdate();
            closeDbConnection(connection);
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void addAuthor(String fname, String lname){
        try(Connection connection = getConnection()){
            String sql = "INSERT INTO author(fname, lname) " +
                         "VALUES(?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, fname);
            stmt.setString(2, lname);
            stmt.executeUpdate();
            closeDbConnection(connection);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void addDirector(String fname, String lname){
        try(Connection connection = getConnection()){
            String sql = "INSERT INTO director(fname, lname) " +
                         "VALUES(?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, fname);
            stmt.setString(2, lname);
            stmt.executeUpdate();
            closeDbConnection(connection);
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void addGenre(String genre){
        try(Connection connection = getConnection()){
            String sql = "INSERT INTO genre(gname) " +
                         "VALUES(?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, genre);
            stmt.executeUpdate();
            closeDbConnection(connection);
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void addCategory(String category){
        try(Connection connection = getConnection()){
            String sql = "INSERT INTO category(cname) " +
                         "VALUES(?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, category);
            stmt.executeUpdate();
            closeDbConnection(connection);
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }

    }

    public void addStudio(String studio){
        try(Connection connection = getConnection()){
            String sql = "INSERT INTO studio(sname) " +
                         "VALUES(?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, studio);
            stmt.executeUpdate();
            closeDbConnection(connection);
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void removeBook(long isbn){
        try(Connection connection = getConnection()){
            String sql = "DELETE FROM book " +
                         "WHERE isbn = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, isbn);
            stmt.executeUpdate();
            closeDbConnection(connection);
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void removeMovie(long id){
        try(Connection connection = getConnection()){
            String sql = "DELETE FROM movie " +
                    "WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            closeDbConnection(connection);
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void removeGame(long id){
        try(Connection connection = getConnection()){
            String sql = "DELETE FROM game " +
                    "WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            closeDbConnection(connection);
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public long getGenreId(String genre){
        long genreid = 0;

        try(Connection connection = getConnection()){
            String sql = "SELECT id " +
                         "FROM genre " +
                         "WHERE gname = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, genre);

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                genreid = resultSet.getLong("id");
            }
            return genreid;
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return 0;
    }

    public long getCategoryId(String category){
        long categoryId = 0;

        try(Connection connection = getConnection()){
            String sql = "SELECT id " +
                         "FROM category " +
                         "WHERE cname = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, category);
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                categoryId = resultSet.getLong("id");
            }

            closeDbConnection(connection);
            return categoryId;
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return 0;
    }

    public long getStudioId(String studio){
        long studioId = 0;

        try(Connection connection = getConnection()){
            String sql = "SELECT id " +
                         "FROM studio " +
                         "WHERE sname = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, studio);
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                studioId = resultSet.getLong("id");
            }
            closeDbConnection(connection);
            return studioId;
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return 0;
    }

    public long getDirectorId(String fname, String lname){
        long directorId = 0;
        String sql = "SELECT id " +
                     "FROM director " +
                     "WHERE fname = ? " +
                     "AND lname = ?";

        try(Connection connection = getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, fname);
            stmt.setString(2, lname);
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                directorId = resultSet.getLong("id");
            }
            closeDbConnection(connection);
            return directorId;
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Book> searchBooks(String choice, String input){
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT b.isbn, b.title, b.pagecount, b.authorid, b.genreid, a.fname, a.lname, g.gname " +
                     "FROM book as b " +
                     "LEFT JOIN author as a " +
                     "ON b.authorid = a.id " +
                     "LEFT JOIN genre as g " +
                     "ON b.genreid = g.id ";
        String sqlCmd = "";

        switch (choice) {
            case "1" -> {
                sqlCmd = "b.title";
            }
            case "2" -> {
                sqlCmd = "b.isbn";
            }
            case "3" -> {
                sqlCmd = "b.authorid";
            }
            case "4" -> {
                sqlCmd = "b.genreid";
            }
        }

        if (choice.equals("1")){
            sql = sql + "WHERE " + sqlCmd + " LIKE ?";
        }
        else {
            sql = sql + " WHERE " + sqlCmd + " = ?";
        }

        try(Connection connection = getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            switch (choice) {
                case "1" -> {
                    stmt.setString(1, "%" + input + "%");
                }
                case "2" -> {
                    stmt.setLong(1, Long.parseLong(input));
                }
                case "3" -> {
                    String[] authorName = input.split("\\s+");
                    stmt.setLong(1, getAuthorId(authorName[0], authorName[1]));
                }
                case "4" -> {
                    stmt.setLong(1, getGenreId(input));
                }
            }

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                long isbnRes = resultSet.getLong("isbn");
                String title = resultSet.getString("title");
                long pageCount = resultSet.getLong("pagecount");
                String fname = resultSet.getString("fname");
                String lname = resultSet.getString("lname");
                String genre = resultSet.getString("gname");

                Book book = new Book();
                book.setIsbn(isbnRes);
                book.setTitle(title);
                book.setPageCount(pageCount);
                book.setFname(fname);
                book.setLname(lname);
                book.setGenre(genre);

                books.add(book);
            }

            closeDbConnection(connection);
            return books;
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    public ArrayList<Movie> searchMovies(String choice, String input){
        ArrayList<Movie> movies = new ArrayList<>();
        String sql = "SELECT m.id, m.title, m.runtime, d.fname, d.lname, g.gname " +
                     "FROM movie AS m " +
                     "LEFT JOIN director AS d " +
                     "ON m.directorid = d.id " +
                     "LEFT JOIN genre AS g " +
                     "ON m.genreid = g.id";
        String sqlCmd = "";

        switch (choice) {
            case "1" -> {
                sqlCmd = "m.title";
            }
            case "2" -> {
                sqlCmd = "m.directorid";
            }
            case "3" -> {
                sqlCmd = "m.genreid";
            }
        }

        if (choice.equals("1")) {
            sql = sql + " WHERE " + sqlCmd + " LIKE ?";
        }
        else {
            sql = sql + " WHERE " + sqlCmd + " = ?";
        }

        try(Connection connection = getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            switch (choice) {
                case "1" -> {
                    stmt.setString(1, "%" + input + "%");
                }
                case "2" -> {
                    String[] name = input.split("\\s+");
                    stmt.setLong(1, getDirectorId(name[0], name[1]));
                }
                case "3" -> {
                    stmt.setLong(1, getGenreId(input));
                }
            }

            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                Movie movie = new Movie();

                movie.setId(resultSet.getLong("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setFname(resultSet.getString("fname"));
                movie.setLname(resultSet.getString("lname"));
                movie.setRunTime(resultSet.getLong("runtime"));
                movie.setGenre(resultSet.getString("gname"));

                movies.add(movie);
            }

            closeDbConnection(connection);
            return movies;
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    public ArrayList<Game> searchGames(String choice, String input){
        ArrayList<Game> games = new ArrayList<>();
        String sql = "SELECT g.id, g.title, g.studioid, g.genreid, g.categoryid, s.sname, ge.gname, c.cname " +
                     "FROM game AS g " +
                     "LEFT JOIN studio AS s " +
                     "ON g.studioid = s.id " +
                     "LEFT JOIN genre AS ge " +
                     "ON g.genreid = ge.id " +
                     "LEFT JOIN category AS c " +
                     "ON g.categoryid = c.id";
        String sqlCmd = "";

        switch (choice) {
            case "1" -> {
                sqlCmd = "g.title";
            }
            case "2" -> {
                sqlCmd = "g.studioid";
            }
            case "3" -> {
                sqlCmd = "g.genreid";
            }
            case "4" -> {
                sqlCmd = "g.categoryid";
            }
        }

        if (choice.equals("1")){
            sql = sql + " WHERE " + sqlCmd + " LIKE ?";
        }
        else {
            sql = sql + " WHERE " + sqlCmd + " = ?";
        }

        try(Connection connection = getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            switch (choice) {
                case "1" -> {
                    stmt.setString(1, "%" + input + "%");
                }
                case "2" -> {
                    stmt.setLong(1, getStudioId(input));
                }
                case "3" -> {
                    stmt.setLong(1, getGenreId(input));
                }
                case "4" -> {
                    stmt.setLong(1, getCategoryId(input));
                }
            }

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Game game = new Game();

                game.setId(resultSet.getLong("id"));
                game.setTitle(resultSet.getString("title"));
                game.setStudio(resultSet.getString("sname"));
                game.setGenre(resultSet.getString("gname"));
                game.setCategory(resultSet.getString("cname"));

                games.add(game);
            }

            closeDbConnection(connection);
            return games;
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    public ArrayList<Book> getAllBooks(){
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT b.isbn, b.title, b.pagecount, a.fname, a.lname, g.gname " +
                     "FROM book as b " +
                     "LEFT JOIN author as a " +
                     "ON b.authorid = a.id " +
                     "LEFT JOIN genre as g " +
                     "ON b.genreid = g.id";

        try(Connection connection = getConnection()){
            Statement stmt = getConnection().createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()){
                long isbn = resultSet.getLong("isbn");
                String title = resultSet.getString("title");
                long pageCount = resultSet.getLong("pagecount");
                String fname = resultSet.getString("fname");
                String lname = resultSet.getString("lname");
                String genre = resultSet.getString("gname");

                Book book = new Book();
                book.setIsbn(isbn);
                book.setTitle(title);
                book.setPageCount(pageCount);
                book.setFname(fname);
                book.setLname(lname);
                book.setGenre(genre);

                books.add(book);
            }
            closeDbConnection(connection);
            return books;
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    public ArrayList<Movie> getAllMovies(){
        ArrayList<Movie> movies = new ArrayList<>();
        try(Connection connection = getConnection()){
            String sql = "SELECT m.id, m.title, m.runtime, d.fname, d.lname, g.gname " +
                         "FROM movie AS m " +
                         "LEFT JOIN director AS d " +
                         "ON m.directorid = d.id " +
                         "LEFT JOIN genre AS g " +
                         "ON m.genreid = g.id";

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()){
                Movie movie = new Movie();
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                long runTime = resultSet.getLong("runtime");
                String fname = resultSet.getString("fname");
                String lname = resultSet.getString("lname");
                String genre = resultSet.getString("gname");

                movie.setId(id);
                movie.setTitle(title);
                movie.setRunTime(runTime);
                movie.setFname(fname);
                movie.setLname(lname);
                movie.setGenre(genre);

                movies.add(movie);
            }
            closeDbConnection(connection);
            return movies;
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    public ArrayList<Game> getAllGames(){
        ArrayList<Game> games = new ArrayList<>();
        try(Connection connection = getConnection()){
            String sql = "SELECT g.id, g.title, s.sname, ge.gname, c.cname " +
                         "FROM game AS g " +
                         "LEFT JOIN studio AS s " +
                         "ON g.studioid = s.id " +
                         "LEFT JOIN genre AS ge " +
                         "ON g.genreid = ge.id " +
                         "LEFT JOIN category AS c " +
                         "ON g.categoryid = c.id";

            Statement stmt = getConnection().createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()){
                Game game = new Game();

                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String studio = resultSet.getString("sname");
                String genre = resultSet.getString("gname");
                String category = resultSet.getString("cname");

                game.setId(id);
                game.setTitle(title);
                game.setStudio(studio);
                game.setGenre(genre);
                game.setCategory(category);

                games.add(game);
            }
            closeDbConnection(connection);
            return games;
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    public long getAuthorId(String fname, String lname){
        long authorId = 0;
        try(Connection connection = getConnection()){
            String sql = "SELECT id " +
                         "FROM author " +
                         "WHERE fname = " + "?" +
                         "AND lname = " + "?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, fname);
            stmt.setString(2, lname);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                authorId = resultSet.getLong("id");
            }
            closeDbConnection(connection);
            return authorId;
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return 0;
    }

    public void closeDbConnection(Connection connection){
        try {
            connection.close();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
