package io.github.mac9p.webApp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();


    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Author() {
    }

    public String toString() {
        return "Author(id=" + this.getId() +
                ", firstName=" + this.getFirstName() +
                ", lastName=" + this.getLastName() +
                ", books=" + this.getBooks() + ")";
    }
}
