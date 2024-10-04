package com.plurasight;

public class Book {
    // Instance variables
    private int id;
    private String isbn, title, checkOutTo;
    private boolean isCheckedOut;

    // Constructor
    public Book(int id, String isbn, String title, String checkOutTo, boolean isCheckedOut) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.checkOutTo = checkOutTo;
        this.isCheckedOut = isCheckedOut;
    }

    //Method to display details for available books
    public void displayAvailableBooks(){
        System.out.println("Book ID: "+ getId());
        System.out.println("Book ISBN: " +getIsbn());
        System.out.println("Book Title: " + getTitle());
        System.out.println("---------------");
    }

    //Method to display details for checked out books
    public void displayCheckedOutBooks(){
        System.out.println("Book ID: "+ getId());
        System.out.println("Book ISBN: " +getIsbn());
        System.out.println("Book Title: " + getTitle());
        System.out.println("Checked out with: " + getCheckOutTo());
        System.out.println("---------------");
    }

    //Method to handle check out process
    public void checkOut(String name, String title){
        if (!this.isCheckedOut){
            this.isCheckedOut = true;
            this.checkOutTo = name;
            System.out.println("---------------");
            System.out.printf("""
                    %s has been checked out by %s.
                    Returning to main menu.....
                    """
                    , title, name);
        }
    }

    // Method to handle check in process
    public void checkIn(int id){
        if(this.isCheckedOut){
            this.isCheckedOut = false;
            this.checkOutTo = "";
            System.out.printf("""
                    ID #%d has been checked in. Thank you!
                    """, id);
        }
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCheckOutTo(String checkOutTo) {
        this.checkOutTo = checkOutTo;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getCheckOutTo() {
        return checkOutTo;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }
}



