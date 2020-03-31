package hh.swd20.kirjakauppa.tehtC24.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    public List<Book> findByTitle (String title);

}
