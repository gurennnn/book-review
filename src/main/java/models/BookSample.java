package models;

public enum BookSample {
    Candide(
            new Book("Candide", "Voltaire", 1759, Book.Genre.NOVEL, Book.Category.PHILOSOPHY)
    ), ThePerfume(
            new Book("The Perfume", "Patrick Süskind", 1985, Book.Genre.NOVEL, Book.Category.MYSTERY)
    ), TheSupplication(
            new Book("Voices From Chernobyl", "Svetlana Alexievich", 1997, Book.Genre.NOVEL, Book.Category.HISTORY)
    ), TheAlchemist (
            new Book("The Alchemist", "Paulo Coelho", 1988, Book.Genre.NOVEL, Book.Category.PHILOSOPHY)
    );

    // field
    private final Book book;

    // constructor
    BookSample(Book book) {
        this.book = book;
    }

    // Book getter
    public Book getBook() {
        return book;
    }
}
