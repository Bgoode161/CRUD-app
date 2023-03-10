package org.bgoode.library_app.dao;

import org.bgoode.library_app.models.Book;
import org.bgoode.library_app.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Null;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
       return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
     return jdbcTemplate.query("SELECT * FROM Person WHERE id=?",
                new BeanPropertyRowMapper<>(Person.class), id).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person (name, birth_date) VALUES(?, ?)",
                person.getName(), person.getBirthDate());
    }
    public void update(Person person, int id) {
        jdbcTemplate.update("UPDATE Person SET name=?, birth_date=? WHERE id=?",
                person.getName(), person.getBirthDate(), id);
    }
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    public List<Book> getBooksByPersonId(int id) {
       return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?", new BeanPropertyRowMapper<>(Book.class), id);
    }


}
