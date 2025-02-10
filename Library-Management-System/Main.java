import java.util.ArrayList;
import java.util.Scanner;

class Library {

    private String bookName;
    private String author;
    private String assignedTo;

    public Library(String bookName, String author, String assignedTo) {
        this.bookName = bookName;
        this.author = author;
        this.assignedTo = assignedTo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return " Book Name: " + bookName + ", Author: " + author + ", Assigned To: " + assignedTo;
    }
}

public class Main {
    public static ArrayList<Library> library = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Select 1 to Add Book");
            System.out.println("Select 2 to View Book");
            System.out.println("Select 3 to Update Book");
            System.out.println("Select 4 to Delete Book");
            System.out.println("Select 5 to  Exit");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid number has been entered");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBook();
                case 3 -> updateBook();
                case 4 -> deleteBook();
                case 5 -> {
                    System.out.println("Hope your querries have been solved");
                    return;
                }

                default -> System.out.println("Invalid operation entered");
            }
        }
    }

    public static void addBook() {
        System.out.println("Enter a book to add");
        String bookName = scanner.nextLine();

        System.out.println("Enter author name");
        String author = scanner.nextLine();

        System.out.println("Enter to whom book is assigned to");
        String assignedTo = scanner.nextLine();
        scanner.nextLine();

        library.add(new Library(bookName, author, assignedTo));
        System.out.println("New book has been added");
    }

    public static void viewBook() {
        if (library.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }

        System.out.println("\n which book you want to view");
        for (int i = 0; i < library.size(); i++) {
            System.out.println((i + 1) + "." + library.get(i));
        }
    }

    public static void updateBook() {
        System.out.println("Enter the book number you want to udpate");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= library.size()) {
            System.out.println("Invalid Index Number");
            return;
        }

        Library book = library.get(index);

        System.out.println("\n Name of the book you want to update to (Leave blank to keep it empty)");
        String bookName = scanner.nextLine();
        if (!bookName.isEmpty()) {
            book.setBookName(bookName);
        }

        System.out.println("\n Enter Author Name (Leave blank to keep it empty)");
        String author = scanner.nextLine();
        if (!author.isEmpty()) {
            book.setAuthor(author);
        }

        System.out.println("Enter the name to whom book issued to (Leave blank if its empty)");
        String assignedTo = scanner.nextLine();
        if (!assignedTo.isEmpty()) {
            book.setAssignedTo(assignedTo);
        }

        System.out.println("Library updated successfuly");
    }

    public static void deleteBook() {
        System.out.println("Enter the book number you want to delete");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= library.size()) {
            System.out.println("Invalid Index number");
            return;
        }

        library.remove(index);
        System.out.println("Book Deleted Succesfully");
    }
}