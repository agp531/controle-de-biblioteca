package ifpr.web.controledebiblioteca.domains.models;


import ifpr.web.controledebiblioteca.domains.enums.BookStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private String name;


    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;

    @Enumerated(value = EnumType.STRING)
    private BookStatus bookStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(date, book.date) && Objects.equals(author, book.author) && bookStatus == book.bookStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, author, bookStatus);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", author=" + author +
                ", bookStatus=" + bookStatus +
                '}';
    }
}
