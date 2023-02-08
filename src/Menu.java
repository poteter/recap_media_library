import media.Book;
import media.Game;
import media.Movie;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    /**
     * Menus to be used in run()
     */
    public void mainMenu(){
        System.out.println();
        System.out.println("1 - Search all media");
        System.out.println("2 - Search specific media");
        System.out.println("3 - Display entire library");
        System.out.println("4 - Register new media");
        System.out.println("5 - Remove media");
        System.out.println("6 - Exit");
        System.out.println();
    }

    public void mediaMenu(){
        System.out.println("1 - Book");
        System.out.println("2 - Movie");
        System.out.println("3 - Game");
        System.out.println();
    }

    public void bookMenu(){
        System.out.println("Search for book by...");
        System.out.println("1 - Title");
        System.out.println("2 - ISBN");
        System.out.println("3 - Author");
        System.out.println("4 - Genre");
        System.out.println();
    }

    public void movieMenu(){
        System.out.println("Search for movie by...");
        System.out.println("1 - Title");
        System.out.println("2 - Director");
        System.out.println("3 - Genre");
        System.out.println();
    }

    public void gameMenu(){
        System.out.println("Search for game by...");
        System.out.println("1 - Title");
        System.out.println("2 - Studio");
        System.out.println("3 - Genre");
        System.out.println("4 - Category");
        System.out.println();
    }

    /**
     * keeps the main menu running until keepRunning is false
     */
    public void run(){
        DBHandler dbHandler = new DBHandler();
        Scanner scanner = new Scanner(System.in);
        String input;

        Boolean keepRunning = true;
        while (keepRunning){
            mainMenu();
            input = scanner.nextLine();
            String choice = "";
            switch (input){
                /**
                 * search all media in database
                 * find every instance of the user input in the title columns
                 */
                case "1":{
                    System.out.println("Enter Title");
                    choice = input;
                    input = scanner.nextLine();

                    for (Book book : dbHandler.searchBooks(choice, input)){
                        System.out.println(book.showDetails());
                    }
                    for (Movie movie : dbHandler.searchMovies(choice, input)){
                        System.out.println(movie.showDetails());
                    }
                    for (Game game : dbHandler.searchGames(choice, input)){
                        System.out.println(game.showDetails());
                    }
                    break;
                }
                /**
                 * search in specific media table
                 */
                case "2":{
                    mediaMenu();
                    input = scanner.nextLine();
                    switch (input){
                        case "1":{
                            bookMenu();
                            input = scanner.nextLine();
                            switch (input){
                                case "1":{
                                    System.out.println("Enter Title");
                                    choice = input;
                                    input = scanner.nextLine();
                                    break;
                                }
                                case "2":{
                                    System.out.println("Enter ISBN");
                                    choice = input;
                                    input = scanner.nextLine();
                                    break;
                                }
                                case "3":{
                                    System.out.println("Enter Author");
                                    choice = input;
                                    input = scanner.nextLine();
                                    break;
                                }
                                case "4":{
                                    System.out.println("Enter Genre");
                                    choice = input;
                                    input = scanner.nextLine();
                                    break;
                                }
                            }
                            ArrayList<Book> books = dbHandler.searchBooks(choice, input);
                            for (Book book : books){
                                System.out.println(book.showDetails());
                            }

                            break;
                        }
                        case "2":{
                            movieMenu();
                            input = scanner.nextLine();

                            switch (input){
                                case "1":{
                                    System.out.println("Enter Title");
                                    choice = input;
                                    input = scanner.nextLine();
                                    break;
                                }
                                case "2":{
                                    System.out.println("Enter Director");
                                    choice = input;
                                    input = scanner.nextLine();
                                    break;
                                }
                                case "3":{
                                    System.out.println("Enter Genre");
                                    choice = input;
                                    input = scanner.nextLine();
                                    break;
                                }
                            }
                            ArrayList<Movie> movies = dbHandler.searchMovies(choice, input);
                            for (Movie movie : movies){
                                System.out.println(movie.showDetails());
                            }
                            break;
                        }
                        case "3":{
                            gameMenu();
                            input = scanner.nextLine();
                            switch (input){
                                case "1":{
                                    System.out.println("Enter Title");
                                    choice = input;
                                    input = scanner.nextLine();
                                    break;
                                }
                                case "2":{
                                    System.out.println("Enter Studio");
                                    choice = input;
                                    input = scanner.nextLine();
                                    break;
                                }
                                case "3":{
                                    System.out.println("Enter Genre");
                                    choice = input;
                                    input = scanner.nextLine();
                                    break;
                                }
                                case "4":{
                                    System.out.println("Enter Category");
                                    choice = input;
                                    input = scanner.nextLine();
                                    break;
                                }
                            }
                            ArrayList<Game> games = dbHandler.searchGames(choice, input);
                            for (Game game : games){
                                System.out.println(game.showDetails());
                            }
                            break;
                        }
                    }
                    break;
                }
                /**
                 * prints the content of every media table to terminal
                 */
                case "3":{
                    ArrayList<Book> books = dbHandler.getAllBooks();
                    for (Book book : books){
                        System.out.println(book.showDetails());
                    }
                    ArrayList<Movie> movies = dbHandler.getAllMovies();
                    for (Movie movie : movies){
                        System.out.println(movie.showDetails());
                    }
                    ArrayList<Game> games = dbHandler.getAllGames();
                    for (Game game : games){
                        System.out.println(game.showDetails());
                    }
                    break;
                }
                /**
                 * insert new row to specific media table
                 * if author, genre, category of director is not listed in database
                 * insert into their corresponding table
                 * author and director name must consist of first and last name
                 * input is split by space and placed in array
                 * in the case of long names, they are to be inserted in this manner " J.R.R. Tolkien "
                 */
                case "4":{
                    mediaMenu();
                    input = scanner.nextLine();

                    switch (input){
                        case "1":{
                            System.out.println("Enter Title");
                            String title = scanner.nextLine();
                            System.out.println("Enter Author");
                            System.out.println("If name is longer than first and last name");
                            System.out.println("format the name like the following example:");
                            System.out.println("J.R.R. Tolkien");
                            String author = scanner.nextLine();
                            System.out.println("Enter Page Count");
                            long pageCount = Long.parseLong(scanner.nextLine());
                            System.out.println("Enter Genre");
                            String genre = scanner.nextLine();
                            String[] authorName = author.split("\\s+");

                            if(dbHandler.getAuthorId(authorName[0], authorName[1]) == 0){
                                dbHandler.addAuthor(authorName[0], authorName[1]);
                            }

                            if(dbHandler.getGenreId(genre) == 0){
                                dbHandler.addGenre(genre);
                            }

                            dbHandler.addBook(title, dbHandler.getAuthorId(authorName[0], authorName[1]), pageCount, dbHandler.getGenreId(genre));
                            break;
                        }
                        case "2":{
                            System.out.println("Enter Title");
                            String title = scanner.nextLine();
                            System.out.println("Enter Director");
                            System.out.println("If name is longer than first and last name");
                            System.out.println("format the name like the following example:");
                            System.out.println("J.R.R. Tolkien");
                            String director = scanner.nextLine();
                            System.out.println("Enter Genre");
                            String genre = scanner.nextLine();
                            System.out.println("Enter Run Time");
                            long runtime = Long.parseLong(scanner.nextLine());
                            String[] directorName = director.split("\\s+");

                            if(dbHandler.getGenreId(genre) == 0){
                                dbHandler.addGenre(genre);
                            }

                            if(dbHandler.getDirectorId(directorName[0], directorName[1]) == 0){
                                dbHandler.addDirector(directorName[0], directorName[1]);
                            }

                            dbHandler.addMovie(title, dbHandler.getDirectorId(directorName[0], directorName[1]), runtime, dbHandler.getGenreId(genre));
                            break;
                        }
                        case "3":{
                            System.out.println("Enter Title");
                            String title = scanner.nextLine();
                            System.out.println("Enter Studio");
                            String studio = scanner.nextLine();
                            System.out.println("Enter Genre");
                            String genre = scanner.nextLine();
                            System.out.println("Enter Category");
                            String category = scanner.nextLine();

                            if(dbHandler.getGenreId(genre) == 0){
                                dbHandler.addGenre(genre);
                            }

                            if(dbHandler.getStudioId(studio) == 0){
                                dbHandler.addStudio(studio);
                            }

                            if(dbHandler.getCategoryId(category) == 0){
                                dbHandler.addCategory(category);
                            }

                            dbHandler.addGame(title, dbHandler.getStudioId(studio), dbHandler.getGenreId(genre), dbHandler.getCategoryId(category));
                            break;
                        }
                    }
                    break;
                }
                /**
                 * delete row from specific table based on ISBN, movie id or game id
                 */
                case "5":{
                    mediaMenu();
                    input = scanner.nextLine();
                    switch (input){
                        case "1":{
                            System.out.println("Enter ISBN");
                            long isbn = Long.parseLong(scanner.nextLine());
                            dbHandler.removeBook(isbn);
                            break;
                        }
                        case "2":{
                            System.out.println("Enter Movie id");
                            long movieId = Long.parseLong(scanner.nextLine());
                            dbHandler.removeMovie(movieId);
                            break;
                        }
                        case "3":{
                            System.out.println("Enter Game id");
                            long gameId = Long.parseLong(scanner.nextLine());
                            dbHandler.removeGame(gameId);
                            break;
                        }
                    }
                    break;
                }
                /**
                 * ends program
                 * closes scanner
                 */
                case "6":{
                    keepRunning = false;
                    scanner.close();
                    break;
                }
            }
        }
    }
}
