package org.bgoode.library_app.dao;

import org.bgoode.library_app.models.Book;
import org.bgoode.library_app.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }
    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?",
                new BeanPropertyRowMapper<>(Book.class), id).stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(title, author, year) VALUES (?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getYear());
    }
    public void update(Book book, int id) {
        jdbcTemplate.update("UPDATE Book SET title=?, author=?, year=? WHERE id=?",
                book.getTitle(), book.getAuthor(), book.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }
    public Optional<Person> getBookOwnerById(int id) {
      return jdbcTemplate.query("SELECT Person. * FROM Book JOIN Person ON Book.person_id=person.id WHERE book.id=?",
              new BeanPropertyRowMapper<>(Person.class), id).stream().findAny();
    }
    public void release(int id) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", null, id);
    }

    public void assign(int ownerId, int id) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", ownerId, id);
    }

}
