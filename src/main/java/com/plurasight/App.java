package com.plurasight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Array for books with a size of 20.
        Book[] books = new Book[20];

        // Preload 6 books into array
        books[0] = new Book(1, "9780061120084", "To Kill a Mockingbird", null, false);
        books[1] = new Book(2, "9780141439518", "Pride and Prejudice", "John Doe", true);
        books[2] = new Book(3, "9780743273565", "The Great Gatsby", null, false);
        books[3] = new Book(4, "9780451524935", "1984", "Jane Smith", true);
        books[4] = new Book(5, "9780316769174", "The Catcher in the Rye", null, false);
        books[5] = new Book(6, "9780062315007", "The Alchemist", "Bob Johnson", true);

        // Main function control
        while (true) {
            displayCommands();
            int command = Integer.parseInt(keyboard.nextLine());
            System.out.println("---------------");
            switch (command) {
                case 1:
                    displayAvailableBooks(books, keyboard);
                    System.out.println("---------------");
                    break;
                case 2:
                    displayCheckedOutBooks(books, keyboard);
                    System.out.println("---------------");
                    break;
                case 3:
                    System.out.println("Thank you for visiting your local library, Goodbye!");
                    System.exit(0);
            }
        }


    }

    // Display main menu commands
    public static void displayCommands() {
        System.out.print("""
                 Welcome to the Neigborhood Library!
                 Please select an option listed below:
                \s
                 1 - Show Available Books
                 2 - Show Checked Out Books
                 3 - Exit -This will terminate the program
                \s
                 Please enter command:\s""");
    }

    // Method to display available books, with the option for user to check out a book
    public static void displayAvailableBooks(Book[] books, Scanner keyboard) {
        String userName = "", userBookSelection ="";

        //List books that are available
        System.out.println("Available Books Listed Below: \n");
        for (Book book : books) {

            if (!(book == null) && !book.isCheckedOut()) {
                book.displayAvailableBooks();
            }
        }

        // Take user input
        System.out.print("Would you like to check out a book? (yes or no): ");
        String userResponse = keyboard.nextLine();

        if (userResponse.equalsIgnoreCase("yes")) {
            System.out.print("Please enter the book title you would like to check out: ");
             userBookSelection = keyboard.nextLine().toLowerCase();

            System.out.print("Please enter the name of the person checking the book out: ");
             userName = keyboard.nextLine().toLowerCase();
        } else {
            System.out.println("Returning to main menu.....");
        }

        // Check out functionality
        for (Book book : books) {
            if (!(book == null) && book.getTitle().equalsIgnoreCase(userBookSelection) && !book.isCheckedOut()) {
                    book.checkOut(userName, userBookSelection);
                }
        }
    }

    // Method to display checked out books, with the option for user to check in a book
    public static void  displayCheckedOutBooks (Book[] books, Scanner keyboard){
        System.out.println("Checked Out Books Listed Below: \n");
        for (Book book : books) {

            // List books that are checked out
            if (!(book == null) && book.isCheckedOut()) {
                book.displayCheckedOutBooks();
            }
        }

        //User input
        System.out.print("Would you like to check in a book? (c for check in or x for main menu): ");
        String userResponse = keyboard.nextLine().toLowerCase();

        //Based on user input, this switch statement will control whether the check in process begins or not
        switch (userResponse){
            case "c":
                System.out.print("Please enter the book ID you are checking in: ");
                int bookID = Integer.parseInt(keyboard.nextLine());
                for (Book book: books){
                    if (!(book == null)){
                        if (book.getId() == bookID && book.isCheckedOut()){
                            book.checkIn(bookID);
                        }
                    }
                }
                break;
            case "x":
                System.out.println("""
                    Returning to main menu.....
                    -----------------""");
                break;
        }

    }


}