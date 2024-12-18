package org.example;

public record Book(String title, String author, int yearPublished) {
    public int getYearPublished() {
        return yearPublished;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return  title;
    }

    // This is your working class.
    
}
