package hh.swd20.kirjakauppa.tehtC24;

import static org.assertj.core.api.Assertions.assertThat;

import hh.swd20.kirjakauppa.tehtC24.domain.Book;
import hh.swd20.kirjakauppa.tehtC24.domain.BookRepository;
import hh.swd20.kirjakauppa.tehtC24.domain.Category;
import hh.swd20.kirjakauppa.tehtC24.domain.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByBookNameShouldReturnBook() {
        List<Book> books = bookRepository.findByTitle("How to code");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("How to code");
    }

    @Test
    public void createNewBook() {
        Category literature = new Category("Literature");
        categoryRepository.save(literature);

        Book book = new Book("Moby Dick", "Herman Melville", literature, "1851", "978-1503280786", 12.95);

        bookRepository.save(book);
        assertThat(bookRepository.findByTitle("Moby Dick").get(0)).isEqualTo(book);
    }

    @Test
    public void deleteBook() {
        Category literature = new Category("Literature");
        categoryRepository.save(literature);

        Book book = new Book("Moby Dick", "Herman Melville", literature, "1851", "978-1503280786", 12.95);

        bookRepository.save(book);
        assertThat(bookRepository.findByTitle("Moby Dick").get(0)).isEqualTo(book);

        bookRepository.delete(book);
        assertThat(bookRepository.findByTitle("Moby Dick")).isEmpty();
    }

}