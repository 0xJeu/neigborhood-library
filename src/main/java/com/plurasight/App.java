package com.plurasight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Book[] books = new Book[20];

        int bookCount = 0;

        // Preload 6 books into array
        books[0] = new Book(1, "9780061120084", "To Kill a Mockingbird", null, false);
        books[1] = new Book(2, "9780141439518", "Pride and Prejudice", "John Doe", true);
        books[2] = new Book(3, "9780743273565", "The Great Gatsby", null, false);
        books[3] = new Book(4, "9780451524935", "1984", "Jane Smith", true);
        books[4] = new Book(5, "9780316769174", "The Catcher in the Rye", null, false);
        books[5] = new Book(6, "9780062315007", "The Alchemist", "Bob Johnson", true);

        bookCount = 6;

        while (true) {
            displayCommands();
            int command = Integer.parseInt(keyboard.nextLine());
            System.out.println("---------------");
            switch (command) {
                case 1:
                    displayAvailableBooks(books, keyboard);
                    break;
                case 2:
                    displayCheckedOutBooks(books, keyboard);
//                    System.out.println("Feature coming soon! \n");
                    break;
                case 3:
                    System.out.println("Thank you for visiting your local library, Goodbye!");
                    System.exit(0);
            }
        }


    }

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

    public static void displayAvailableBooks(Book[] books, Scanner keyboard) {
        String userName = "", userBookSelection ="";

        System.out.println("Available Books Listed Below: \n");
        for (Book book : books) {

            if (!(book == null) && !book.isCheckedOut()) {
                book.displayAvailableBooks();
            }
        }

        System.out.print("Would you like to check out a book? (yes or no): ");
        String userResponse = keyboard.nextLine();

        if (userResponse.equalsIgnoreCase("yes")) {
            System.out.print("Please enter the book title you would like to check out: ");
             userBookSelection = keyboard.nextLine().toLowerCase();

            System.out.print("Please enter the name of the person checking the book out: ");
             userName = keyboard.nextLine().toLowerCase();
        }

        for (Book book : books) {
            if (!(book == null) && book.getTitle().equalsIgnoreCase(userBookSelection) && !book.isCheckedOut()) {
                    book.checkOut(userName, userBookSelection);
                }
        }
    }

    public static void  displayCheckedOutBooks (Book[] books, Scanner keyboard){
        System.out.println("Checked Out Books Listed Below: \n");
        for (Book book : books) {

            if (!(book == null) && book.isCheckedOut()) {
                book.displayAvailableBooks();
            }
        }
    }

}