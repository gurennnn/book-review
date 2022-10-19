package models;

public enum BookSample {
    Candide(
            new Book("Candide", "Voltaire", 1759, Book.Genre.NOVEL, Book.Category.PHILOSOPHY)
    ),
    ThePerfume(
            new Book("The Perfume", "Patrick Süskind", 1985, Book.Genre.NOVEL, Book.Category.MYSTERY)
    ), TheSupplication(
            new Book("Voices From Chernobyl", "Svetlana Alexievich", 1997, Book.Genre.NOVEL, Book.Category.HISTORY)
    );

    private Book book;

    private BookSample(Book book) {
        this.book = book;
    }
}
