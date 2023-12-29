import java.util.*;

class Book {
    private String title;
    private Set<String> genres;

    public Book(String title, String... genres) {
        this.title = title;
        this.genres = new HashSet<>(Arrays.asList(genres));
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return title;
    }
}

class User {
    private String username;
    private Set<Book> readBooks;

    public User(String username) {
        this.username = username;
        this.readBooks = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public Set<Book> getReadBooks() {
        return readBooks;
    }

    public void readBook(Book book) {
        readBooks.add(book);
    }
}

class RecommendationSystem {
    private List<User> users;
    private List<Book> books;

    public RecommendationSystem() {
        users = new ArrayList<>();
        books = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> recommendBooks(User user) {
        Map<Book, Integer> bookScores = new HashMap<>();

        // Calculate scores based on books read by other users
        for (User otherUser : users) {
            if (!otherUser.equals(user)) {
                for (Book book : otherUser.getReadBooks()) {
                    if (!user.getReadBooks().contains(book)) {
                        bookScores.put(book, bookScores.getOrDefault(book, 0) + 1);
                    }
                }
            }
        }

        // Sort books by score in descending order
        List<Book> recommendedBooks = new ArrayList<>(bookScores.keySet());
        recommendedBooks.sort(Comparator.comparingInt(bookScores::get).reversed());//todo mhk: search for all kinds of sorts in java

        return recommendedBooks;
    }
}

public class BookRecommendationSystem {
    public static void main(String[] args) {
        // Create books
        Book book1 = new Book("The Great Gatsby", "Fiction", "Classic");
        Book book2 = new Book("To Kill a Mockingbird", "Fiction", "Drama");
        Book book3 = new Book("1984", "Dystopian", "Classic");
        Book book4 = new Book("The Hitchhiker's Guide to the Galaxy", "Science Fiction", "Humor");
        Book book5 = new Book("The Catcher in the Rye", "Fiction", "Coming-of-age");

        // Create users
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");

        // Users read books
        user1.readBook(book1);
        user1.readBook(book2);
        user2.readBook(book2);
        user2.readBook(book3);
        user2.readBook(book4);
        user3.readBook(book1);
        user3.readBook(book3);
        user3.readBook(book5);

        // Create a recommendation system
        RecommendationSystem recommendationSystem = new RecommendationSystem();
        recommendationSystem.addUser(user1);
        recommendationSystem.addUser(user2);
        recommendationSystem.addUser(user3);
        recommendationSystem.addBook(book1);
        recommendationSystem.addBook(book2);
        recommendationSystem.addBook(book3);
        recommendationSystem.addBook(book4);
        recommendationSystem.addBook(book5);

        // Get book recommendations for users
        List<Book> recommendationsForUser1 = recommendationSystem.recommendBooks(user1);
        List<Book> recommendationsForUser2 = recommendationSystem.recommendBooks(user2);
        List<Book> recommendationsForUser3 = recommendationSystem.recommendBooks(user3);

        // Display recommendations
        System.out.println("Recommendations for " + user1.getUsername() + ": " + recommendationsForUser1);
        System.out.println("Recommendations for " + user2.getUsername() + ": " + recommendationsForUser2);
        System.out.println("Recommendations for " + user3.getUsername() + ": " + recommendationsForUser3);
    }
}