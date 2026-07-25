package Problems;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 1. Book Entity with an internal waiting list
class Book {
    private String id;
    private String title;
    private boolean isBorrowed;
    // Each book tracks its own queue of waiting users
    private Queue<User> waitingQueue;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.isBorrowed = false;
        this.waitingQueue = new LinkedList<>(); 
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isBorrowed() { return isBorrowed; }

    public void setBorrowed(boolean status) { this.isBorrowed = status; }

    // Queue Operations
    public void addToQueue(User user) {
        waitingQueue.add(user);
    }

    public User getNextInQueue() {
        return waitingQueue.poll(); // Retrieves and removes the head of the queue
    }

    public boolean hasWaitingUsers() {
        return !waitingQueue.isEmpty();
    }
}

// 2. User Entity
class User {
    private String userId;
    private String name;
    private List<Book> borrowedBooks;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getUserId() { return userId; }
    public String getName() { return name; };
    
    public void addAsset(Book book) { borrowedBooks.add(book); }
    public void removeAsset(Book book) { borrowedBooks.remove(book); }
}

// 3. Orchestrator Class handling the Borrow and Return logic
class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void addUser(User user) { users.add(user); }

    // Method A: Borrow Logic with Queue Fallback
    public void processBorrow(String userId, String bookId) {
        User user = users.stream().filter(u -> u.getUserId().equals(userId)).findFirst().orElse(null);
        Book book = books.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);

        if (user == null || book == null) return;

        if (!book.isBorrowed()) {
            // Book is free, assign it directly
            book.setBorrowed(true);
            user.addAsset(book);
            System.out.println(user.getUserId() + " (" + user.getName() + ")"+ "successfully borrowed " + book.getTitle());
        } else {
            // Book is taken, push user to that book's queue
            book.addToQueue(user);
            System.out.println(book.getTitle() + " is busy. " + user.getUserId() + " (" + user.getName() + ")" + " added to the waiting queue.");
        }
    }

    // Method B: Return Logic with Automatic Assignment
    public void processReturn(String userId, String bookId) {
        User user = users.stream().filter(u -> u.getUserId().equals(userId)).findFirst().orElse(null);
        Book book = books.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);

        if (user == null || book == null) return;

        // Step 1: Remove the book from the current user's profile
        user.removeAsset(book);

        // Step 2: Check if someone else is waiting for this exact book
        if (book.hasWaitingUsers()) {
            User nextUser = book.getNextInQueue();
            // Directly transfer ownership to the next person without making the book "free"
            nextUser.addAsset(book);
            System.out.println("--- System Automation: " + book.getTitle() + " directly assigned to next waiting user: " + nextUser.getUserId());
        } else {
            // No one is waiting, make it available for everyone
            book.setBorrowed(false);
            System.out.println(book.getTitle() + " is now back on the empty shelf.");
        }
    }
}

// Main Execution
public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("B1", "Effective Java"));
        library.addUser(new User("U1", "Smita"));

        library.processBorrow("U1", "B1");
    }
}