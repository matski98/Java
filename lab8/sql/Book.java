package sql;

public class Book {
    private final String isbn;
    private final String author;
    private final String title;
    private final String year;

    public Book(String _isbn, String _title, String _author, String _year){
        isbn = _isbn;
        author = _author;
        title = _title;
        year = _year;
    }
    public String getIsbn(){

        return isbn;
    }
    public String getAuthor()
    {

        return author;
    }
    public String getTitle(){

        return title;
    }

    public String getYear() {

        return year;
    }
}
